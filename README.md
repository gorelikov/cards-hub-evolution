# Cards Hub evolution
## About
Repository for experiments with reactive application.
Mostly for Project Reactor implementation and Spring 5.

Tags on this repo represents steps of evolution from simple sync system to it's reactive version.

## How to build
`./gradlew clean build`

## For Intellij idea users
This project needs enabled annotation processor cause of lombok dependency

## How to run/test
Use `./tools/test_cli`  and checks for the available commands

## How to load
`./tools/load/loader.sh pre_load` for client loading and simple instructions. <br>
Than run loader, e.g.:`./tools/test_cli load 1000 10s` - 1000 connections during 10s

## Additional instructions
Firstly create environment by running `./tools/test_cli env`,<br>
than fill mongo with records by running `./tools/test_cli mongo_fill` (run it couple of times)

You can check different steps of application evolution by checking out one of the tags:
* step0 or sync
* step1 or async_servlet
* step2 or mono_first_try
* step3 or schedulers
* step4 or async_client
* step5 or reactive_mongo
* step6