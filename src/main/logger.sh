#!/bin/bash
logfile="/opt/quizzer/log.txt"
if [ ! -f $logfile ]; then
  echo "log file not found $logfile"
  exit 1
fi
timestamp=`date +"%d-%m-%Y"`
newlogfile=logfile.$timestamp
cp $logfile /opt/quizzer/logs/$newlogfile
cat /dev/null > $logfile
