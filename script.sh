#!/bin/bash
cd ~/LotMonitor
raspistill -w 640 -h 840 -n -t 10 -ifx emboss -o image.jpg
java -cp . ProcessImage
git add .
git commit -m "output"
git push origin master

