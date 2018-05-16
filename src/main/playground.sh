#!/bin/bash
if [ $# -eq 1 ] || [ $# -eq 2 ]; then
        filename=`ls /opt/quizzer | grep .jar | tr -s ' ' | cut -d ' ' -f9`
        app="/opt/quizzer/$filename"
        db="/usr/sbin/mysqld"
        log="/opt/quizzer/log.txt"

        case $1 in
                start)
                        running="false"
                        for x in `ps -aux | grep quizzer | tr -s ' ' | cut -d ' ' -f15`; do
                                if [ $x == $app ]; then
                                        running="true"
                                fi
                        done

                        if [ $running == "false" ]; then
                                echo The application is starting
                                nohup java -Xmx1024M -Xms256M -jar $app &> $log &
                        else
                                echo The app is already running. Please stop it before starting.
                        fi
                        ;;

                stop)
                        myPID=-1
                        y=-1
                        for x in `ps -aux | grep quizzer | tr -s ' ' | cut -d ' ' -f2,15`; do
                                if [ $x == $app ]; then
                                        myPID=$y
                                fi
                                y=$x
                        done
                        if [ $myPID -ne -1 ]; then
                                echo Stopping process with PID $myPID.
                                kill $myPID
                        else
                                echo Process was not found, the application is most likely already stopped.
                        fi
                        ;;

                status)
                        case $2 in
                                db)
                                        active="false"
                                        for x in `ps -aux | grep mysqld | tr -s ' ' | cut -d ' ' -f11`; do
                                                if [ $x == $db ]; then
                                                        active="true"
                                                fi
                                        done
                                        echo Showing db status:
                                        if [ $active == "true" ]; then
                                                echo The database is active.
                                        else
                                                echo Database is down.
                                        fi
                                        ;;
                                app)
                                        active="false"
                                        for x in `ps -aux | grep quizzer | tr -s ' ' | cut -d ' ' -f15`; do
                                                if [ $x == $app ]; then
                                                        active="true"
                                                fi
                                        done
                                        echo Showing app status:
                                        if [ $active == "true" ]; then
                                                echo The app is up and running.
                                        else
                                                echo The app is down.
                                        fi
                                        ;;
                                '')
                                        dbActive="false"
                                        appActive="false"

                                        for x in `ps -aux | grep mysqld | tr -s ' ' | cut -d ' ' -f11`; do
                                                if [ $x == $db ]; then
                                                        dbActive="true"
                                                fi
                                        done

                                        for x in `ps -aux | grep quizzer | tr -s ' ' | cut -d ' ' -f15`; do
                                                if [ $x == $app ]; then
                                                        appActive="true"
                                                fi
                                        done

                                        echo Showing db and app status:

                                        if [ $appActive == "true" ]; then
                                                echo The app is up and running.
                                        else
                                                echo The app is down.
                                        fi

                                        if [ $dbActive == "true" ]; then
                                                echo The database is active.
                                        else
                                                echo Database is down.
                                        fi
                                        ;;
                                *)
                                        echo Incorrect argument. You can request to see the status of either the app or the db.
                        esac
                        ;;
                *)
                        echo Incorrect argument. The correct synthax is /playground.sh start/stop/status [app/db].
                        ;;
        esac
else
        echo Incorrect number of arguments. The correct synthax is /playground.sh start/stop/status [app/db].
fi 