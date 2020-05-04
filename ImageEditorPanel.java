import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;




@SuppressWarnings("serial")

public class ImageEditorPanel extends JPanel implements KeyListener{
    static int wp;
    static int bp;
    static BufferedImage imageIn;

 Color[][] imageArray;
 Color[][][] storedImages;
 int width;
 int height;
 int i = 1;
 public ImageEditorPanel() {
 try {
 imageIn = ImageIO.read(new File("imagep2.jpg")); // file name goes in quotes (with extension)
 } catch (final IOException e) {
     System.out.println(e);
 }
 imageArray = makeArray(imageIn);
 height = imageArray.length;
 width = imageArray[0].length;
 storedImages = new Color[10][height][width];
 storedImages[0] = imageArray;
 setPreferredSize(new Dimension(width, height));
 setBackground(Color.BLACK);
 addKeyListener(this);
}

public void paintComponent(final Graphics g) {
    for (int row = 0; row < height; row++) {
        for (int col = 0; col < width; col++) {
            g.setColor(imageArray[row][col]);
            g.fillRect(col, row, 1, 1);
        }
    }
}
//printing to outpout document
public void run() {
    repaint();
    System.out.println("Dark Pixels: " + countBlackPixels(imageArray));
    System.out.println("Light Pixels: " + countWhitePixels(imageArray));
    System.out.println("Light Pixels2: " + countWhitePixels2(imageArray));
  /*  System.out.println("Light Pixels: " + countWhitePixels3(imageArray));
    System.out.println("Light Pixels: " + countWhitePixels4(imageArray));
    System.out.println("Light Pixels: " + countWhitePixels5(imageArray));
    System.out.println("Light Pixels: " + countWhitePixels6(imageArray));
    System.out.println("Light Pixels: " + countWhitePixels7(imageArray));
*/


        try {
          File myObj = new File("output.txt");
          if (myObj.createNewFile()) {
            System.out.println("File created" + myObj.getName());
          } else {
            System.out.println("File already exists.");
          }
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
      }

      try {
            FileWriter myWriter = new FileWriter("output.txt");
            myWriter.write(String.valueOf(countWhitePixels(imageArray)));
            myWriter.write(String.valueOf(countWhitePixels2(imageArray)));
           /* myWriter.write(String.valueOf(countWhitePixels3(imageArray)));
            myWriter.write(String.valueOf(countWhitePixels4(imageArray)));
            myWriter.write(String.valueOf(countWhitePixels5(imageArray)));
            myWriter.write(String.valueOf(countWhitePixels6(imageArray)));
            myWriter.write(String.valueOf(countWhitePixels7(imageArray)));
            */
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }


 int g = 250;
int h = 50;

public int countWhitePixels(final Color[][] input) {
    int count = 0;
    for (int row = 380; row < 460; row++) {
        for (int col = 195; col < 245; col++) {
            if (input[row][col].getRed() > g && input[row][col].getGreen() > g && input[row][col].getBlue() > g) {
                count++;
            
            }
             // System.out.println("count1 " + String.valueOf(count));
        }
    

    
    }
     if (count > h)
        return 1; // place number here
    else
    return 0; 
    // return count;
}

public int countWhitePixels2(final Color[][] input) {
    int count = 0;
    for (int row = 388; row < 469; row++) {
        for (int col = 280; col < 340; col++) {
            if (input[row][col].getRed() > g && input[row][col].getGreen() > g && input[row][col].getBlue() > g) {
                count++;
            }
        }
    

    
    }
     if (count > h)
        return 1; // place number here
    else
    return 0; 
     // return count;
    
}




/*
public int countWhitePixels2(final Color[][] input) {
    int count = 0;
    for (int row = 170; row < 0; row++) {
        for (int col = 130; col < 354; col++) {
            if (input[row][col].getRed() < 127 && input[row][col].getGreen() < 127 && input[row][col].getBlue() < 127) {
                count++;
            }
        }
    

    
    }
    if (count > 16)
        return 0; // place number here
    else
    return 1;
    
}

public int countWhitePixels3(final Color[][] input) {
    int count = 0;
    for (int row = 80; row < 10; row++) {
        for (int col = 600; col < 80; col++) {
            if (input[row][col].getRed() < 127 && input[row][col].getGreen() < 127 && input[row][col].getBlue() < 127) {
                count++;
            }
        }
    

    
    }
    if (count > 16)
        return 0; // place number here
    else
    return 1;
    
}

public int countWhitePixels4(final Color[][] input) {
    int count = 0;
    for (int row = 55; row < 80; row++) {
        for (int col = 740; col < 780; col++) {
            if (input[row][col].getRed() < 127 && input[row][col].getGreen() < 127 && input[row][col].getBlue() < 127) {
                count++;
            }
        }
    

    
    }
    if (count > 16)
        return 0; // place number here
    else
    return 1;
    
}
public int countWhitePixels5(final Color[][] input) {
    int count = 0;
    for (int row = 77; row < 90; row++) {
        for (int col = 805; col < 840; col++) {
            if (input[row][col].getRed() < 127 && input[row][col].getGreen() < 127 && input[row][col].getBlue() < 127) {
                count++;
            }
        }
    

    
    }
    if (count > 16)
        return 0; // place number here
    else
    return 1;
    
}
public int countWhitePixels6(final Color[][] input) {
    int count = 0;
    for (int row = 108; row < 131; row++) {
        for (int col = 840; col < 877; col++) {
            if (input[row][col].getRed() < 127 && input[row][col].getGreen() < 127 && input[row][col].getBlue() < 127) {
                count++;
            }
        }
    

    
    }
    if (count > 16)
        return 0; // place number here
    else
    return 1;
    
}
public int countWhitePixels7(final Color[][] input) {
    int count = 0;
    for (int row = 142; row < 204; row++) {
        for (int col = 898; col < 942; col++) {
            if (input[row][col].getRed() < 127 && input[row][col].getGreen() < 127 && input[row][col].getBlue() < 127) {
                count++;
            }
        }
    

    
    }
    if (count > 16)
        return 0; // place number here
    else
    return 1;
    
}
*/








public int countBlackPixels(final Color[][] input) {
    final int inputHeight = input.length;
    final int inputWidth = input[0].length;
    int count = 0;
    for (int row = 0; row < inputHeight; row++) {
        for (int col = 0; col < inputWidth; col++) {
            if (input[row][col].getRed() < 127 && input[row][col].getGreen() < 127 && input[row][col].getBlue() < 127) {
                count++;
            }
        }
    }
    if (count > 16)
        return 1; // place number here
    else
        return 0;
}

public Color[][] makeArray(final BufferedImage image) {
    final int width = image.getWidth();
    final int height = image.getHeight();
    final Color[][] result = new Color[height][width];
    for (int row = 0; row < height; row++) {
        for (int col = 0; col < width; col++) {
            final Color c = new Color(image.getRGB(col, row), true);
            result[row][col] = c;
        }
    }
    return result;
}

public Color[][] flipHorizontal(final Color[][] input) {
    final int inputHeight = input.length;
    final int inputWidth = input[0].length;
    final Color[][] output = new Color[inputHeight][inputWidth];
    for (int row = 0; row < inputHeight; row++) {
        for (int col = 0; col < inputWidth; col++) {
            output[row][col] = input[row][inputWidth - col - 1];
        }
    }
    return output;
}

public Color[][] flipVertical(final Color[][] input) {
    final int inputHeight = input.length;
    final int inputWidth = input[0].length;
    final Color[][] output = new Color[inputHeight][inputWidth];
    for (int row = 0; row < inputHeight; row++) {
        for (int col = 0; col < inputWidth; col++) {
            output[row][col] = input[inputHeight - row - 1][col];
        }
    }
    return output;
}

public Color[][] grayscale(final Color[][] input) {
    final int inputHeight = input.length;
    final int inputWidth = input[0].length;
    final double redPercent = 0.299;
    final double greenPercent = 0.587;
    final double bluePercent = 0.114;
    final Color[][] output = new Color[inputHeight][inputWidth];
    for (int row = 0; row < inputHeight; row++) {
        for (int col = 0; col < inputWidth; col++) {
            final int red = input[row][col].getRed();
            final int green = input[row][col].getGreen();
            final int blue = input[row][col].getBlue();
            final int gray = (int) (red * redPercent + green * greenPercent + blue * bluePercent);
            output[row][col] = new Color(gray, gray, gray);
        }
    }
    return output;
}

public Color[][] blur(final Color[][] input, final int radius) {
    final int inputHeight = input.length;
    final int inputWidth = input[0].length;
    final Color[][] output = new Color[inputHeight][inputWidth];
    for (int row = 0; row < inputHeight; row++) {
        for (int col = 0; col < inputWidth; col++) {
            int red = 0;
            int green = 0;
            int blue = 0;
            int count = 0;
            for (int r = row - radius; r <= row + radius; r++) {
                for (int c = col - radius; c <= col + radius; c++) {
                    if (r >= 0 && r < inputHeight && c >= 0 && c < inputWidth) {
                        red += input[r][c].getRed();
                        green += input[r][c].getGreen();
                        blue += input[r][c].getBlue();
                        count++;
                    }
                }
            }
            output[row][col] = new Color(red / count, green / count, blue / count);
        }
    }
    return output;
}

// R' = F(R - 128) + 128
public Color[][] highContrast(final Color[][] input, final int factor) {
    final int inputHeight = input.length;
    final int inputWidth = input[0].length;
    final Color[][] output = new Color[inputHeight][inputWidth];
    for (int row = 0; row < inputHeight; row++) {
        for (int col = 0; col < inputWidth; col++) {
            final int red = truncateColor((factor * input[row][col].getRed() - 128) + 128);
            final int green = truncateColor((factor * input[row][col].getGreen() - 128) + 128);
            final int blue = truncateColor((factor * input[row][col].getBlue() - 128) + 128);
            output[row][col] = new Color(red, green, blue);
        }
    }
    return output;
}

public Color[][] brightness(final Color[][] input, final int factor) {
    final int inputHeight = input.length;
    final int inputWidth = input[0].length;
    final Color[][] output = new Color[inputHeight][inputWidth];
    for (int row = 0; row < inputHeight; row++) {
        for (int col = 0; col < inputWidth; col++) {
            final int red = truncateColor(input[row][col].getRed() * factor / 100);
            final int green = truncateColor(input[row][col].getGreen() * factor / 100);
            final int blue = truncateColor(input[row][col].getBlue() * factor / 100);
            output[row][col] = new Color(red, green, blue);
        }
    }
    return output;
}

public Color[][] edgeDetect(final Color[][] input) {
    final int inputHeight = input.length;
    final int inputWidth = input[0].length;
    final int radius = 2;
    final int range = 15;
    final Color[][] output = new Color[inputHeight][inputWidth];
    for (int row = 0; row < inputHeight; row++) {
        for (int col = 0; col < inputWidth; col++) {
            for (int r = row - radius; r <= row + radius; r++) {
                for (int c = col - radius; c <= col + radius; c++) {
                    if (r >= 0 && r < inputHeight && c >= 0 && c < inputWidth) {
                        final int red = input[r][c].getRed();
                        final int green = input[r][c].getGreen();
                        final int blue = input[r][c].getBlue();
                        if (red - input[row][col].getRed() > range)
                            output[row][col] = Color.BLACK;
                        else if (green - input[row][col].getGreen() > range)
                            output[row][col] = Color.BLACK;
                        else if (blue - input[row][col].getBlue() > range)
                            output[row][col] = Color.BLACK;
                    }
                }
            }
            if (output[row][col] == null)
                output[row][col] = input[row][col];
        }
    }
    return output;
}

public void storeImage(final Color[][] imageArray) {
    final int levels = 10;
    if (i < levels - 1) {
        storedImages[i] = imageArray;
        i++;
    } else {
        final Color[][][] newStoredImages = storedImages;
        for (int j = 0; j < levels - 1; j++) {
            newStoredImages[j] = storedImages[j + 1];
        }
        newStoredImages[levels - 1] = imageArray;
        storedImages = newStoredImages;
    }
}

public int truncateColor(final int rgb) {
    if (rgb > 255)
        return 255;
    if (rgb < 0)
        return 0;
    return rgb;
}

public void keyPressed(final KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_G) {
        imageArray = grayscale(imageArray);
        repaint();
        storeImage(imageArray);
    }
    if (e.getKeyCode() == KeyEvent.VK_L) {
        imageArray = blur(imageArray, 5);
        repaint();
        storeImage(imageArray);
    }
    if (e.getKeyCode() == KeyEvent.VK_H) {
        imageArray = flipHorizontal(imageArray);
        repaint();
        storeImage(imageArray);
    }
    if (e.getKeyCode() == KeyEvent.VK_V) {
        imageArray = flipVertical(imageArray);
        repaint();
        storeImage(imageArray);
    }
    if (e.getKeyCode() == KeyEvent.VK_C) {
        imageArray = highContrast(imageArray, 5);
        repaint();
        storeImage(imageArray);
    }

    if (e.getKeyCode() == KeyEvent.VK_B) {
        imageArray = brightness(imageArray, 50);
        repaint();
        storeImage(imageArray);
    }
    if (e.getKeyCode() == KeyEvent.VK_E) {
        imageArray = edgeDetect(imageArray);
        repaint();
        storeImage(imageArray);
    }
}

@Override
public void keyTyped(KeyEvent e) {
    // TODO Auto-generated method stub

}

@Override
public void keyReleased(KeyEvent e) {
    // TODO Auto-generated method stub

} 



}