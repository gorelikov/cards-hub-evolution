#!/bin/bash
D=$(dirname $BASH_SOURCE)
source $D/.functions

COUNT=$(docker-compose -f $D/env/docker-compose.yml ps -q | wc -l)

if [ $COUNT -eq 0 ]; then
  no_status
  _yellowb "Not running 😞"
  exit 1
fi

MONGO_PORT=$(docker-compose -f $D/env/docker-compose.yml ps | grep env_mongo | cut -d ':' -f2 | sed 's/-.*//')

echo "mongo port    : $(_green $MONGO_PORT)"
