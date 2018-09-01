#!/usr/bin/env bash
git pull
mvn clean install -Dmaven.test.skip=true -Ppro
docker build -t antelope .
docker stop antelope
docker run -d -p  80:80 --rm --net my-net --name antelope --net my-net antelope