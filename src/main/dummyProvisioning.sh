#!/bin/bash

if [ $# -eq 3 ]
then

  if [ $1 -eq $1 2> /dev/null ]; then
    validation1=1
  fi

  if [ $2 -eq $2 2> /dev/null ]; then
    validation2=1
  fi

  if [ $3 -eq $3 2> /dev/null ]; then
    validation3=1
  fi
  if [[ $validation1 -eq 1 && $validation2 -eq 1 && $validation3 -eq 1 ]]
  then

    locationsNumber=$1
    warehousesNumber=$2
    productsNumber=$3
    producerNumber=$(mysql quizzer -uroot -padminadmin -s -e "select count(*) from producer;")

    for (( i=1; i <= $locationsNumber; ++i ))
    do
      currentDate=$(date "+%D %H:%M:%S:%3N")
      mysql quizzer -uroot -padminadmin -e "insert into location values(id, 'Location $currentDate');"
      locations[i]=$(mysql quizzer -uroot -padminadmin -s -e "select id from location where name='Location $currentDate';")
    done

    for (( i=1; i <= $warehousesNumber; ++i ))
    do
      currentDate=$(date "+%D %H:%M:%S:%3N")
      randomLocation=$(shuf -i 1-$locationsNumber -n 1)
      mysql quizzer -uroot -padminadmin -e "insert into warehouse values(id, ${locations[$randomLocation]}, 'Dummy Warehouse $currentDate');"
      warehouses[i]=$(mysql quizzer -uroot -padminadmin -s -e "select id from warehouse where name='Dummy Warehouse $currentDate';")
    done

    for (( i=1; i <= $productsNumber; ++i ))
    do
      currentDate=$(date "+%D %H:%M:%S:%3N")
      randomQuantity=$(shuf -i 1-1000 -n 1)
      randomWarehouse=$(shuf -i 1-$warehousesNumber -n 1)
      randomProducer=$(shuf -i 1-$producerNumber -n 1)
      mysql quizzer -uroot -padminadmin -e "insert into product values(id, 'Dummy Phone $(date "+%H:%M:%S:%3N")', $randomProducer, ${warehouses[$randomWarehouse]}, $randomQuantity);"
    done

  else
    echo " Invalid syntax. All arguments should be numbers"
  fi
else
  echo " Incorrect number of arguments."
  echo " The correct synthax is ./dummyProvisioning.sh <locations> <warehouses> <products>"
  echo " (Arguments must be numbers)"
fi

