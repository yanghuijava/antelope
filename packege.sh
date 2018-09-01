#!/usr/bin/env bash
git pull
mvn clean install -Dmaven.test.skip=true -Ppro
echo "=================================mavne编译完成============================="
docker build -t antelope .
echo "=================================镜像打包完成==============================="
docker stop antelope
echo "=================================停止容器antelope=========================="
EXPOSE 80
docker run -d -p 80:80 --rm --net my-net --name antelope antelope
echo "=================================容器antelope启动完成=========================="