#!/bin/bash

cd `dirname $0`


threads=8
light_connections=10
light_duration=5s
heavy_connections=1000 #haha heavy, cause of suffering mongo :(
heavy_duration=19s

COMMAND="${1: }"

case "$COMMAND" in
  pre_load)
    curl -L 'https://dl.bintray.com/gorelikov/maven/rx-loader-0.0.2.jar' -o ./rx-loader.jar
    java -jar ./rx-loader.jar
    ;;
  light_load)
  echo $2
    java -Dio.netty.leakDetection.level=disabled -jar ./rx-loader.jar --url=$2 \
     -t$threads -c$light_connections --duration=$light_duration -H userId:$3 -H longitude:$4 -H latitude:$5
    ;;
  heavy_load)
    java -Dio.netty.leakDetection.level=disabled -jar ./rx-loader.jar --url=$2 \
     -t$threads -c$heavy_connections --duration=$heavy_duration -H userId:$3 -H longitude:$4 -H latitude:$5
    ;;
  load)
    java -Dio.netty.leakDetection.level=disabled -jar ./rx-loader.jar --url=$2 \
     -t$threads -c$6 --duration=$7 -H userId:$3 -H longitude:$4 -H latitude:$5 ${@:8}
    ;;
  *)
    echo "use command [pre_load | load | light_load | heavy_load]"
  ;;
esac