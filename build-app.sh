#!/bin/bash
./gradlew build
rm -rf build/multiservice
mkdir -p build/multiservice/lib
mkdir -p build/multiservice/data/db
mkdir -p build/multiservice/data/responses

mv build/libs/* build/multiservice/lib
cp .env build/multiservice
cp start.sh build/multiservice
cp data/db/* build/multiservice/data/db
cd build
tar cvfz multiservice.tgz multiservice

