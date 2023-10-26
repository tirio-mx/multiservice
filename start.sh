source .env 

while read -r line; do
  if [[ $line =~ ^[A-Za-z_]+= ]]; then
    varName=${line%%=*}
    export $varName
  fi 
done < .env

java -Dspring.profiles.active=prod -jar lib/multiservice-0.1.2.jar
