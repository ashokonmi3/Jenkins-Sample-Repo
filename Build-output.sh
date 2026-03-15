#!/bin/bash

LOGFILE=build.log

echo "Jenkins Build Started" > $LOGFILE
date >> $LOGFILE

echo "System Information" >> $LOGFILE
hostname >> $LOGFILE
whoami >> $LOGFILE

echo "Listing Files" >> $LOGFILE
ls -l >> $LOGFILE

echo "Build Completed" >> $LOGFILE
