#!/bin/bash
cd `dirname $0`

wrk -c100 -t8 -d10s -s ./iterative.lua  "http://$1" --timeout 10s  -- $2 $3 $4