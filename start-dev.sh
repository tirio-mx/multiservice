#!/bin/bash

source .env 

while read -r line; do
  if [[ $line =~ ^[A-Za-z_]+= ]]; then
    varName=${line%%=*}
    export $varName
  fi 
done < .env

gradle bootRun --args='-Dspring.profiles.active=dev'
