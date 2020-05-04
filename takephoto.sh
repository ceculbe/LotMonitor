#git pull
raspistill -w 640 -h 840 -n -t 10 -ifx emboss -o image.jpg
java -cp . ProcessImage
#git add image.jpg
#git add output.txt
#git commit -m "updated image"
#git push


