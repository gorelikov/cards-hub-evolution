# Cards Hub evolution (JokerConf2017 demo)
## About
Repository for experiments with simple reactive system.
Mostly base on Spring 5/Project Reactor.

Tags on this repo represents the steps of evolution from simple sync system to it's reactive version.

## How to build
`./gradlew clean build`

## For Intellij idea users
This project needs enabled annotation processor cause of lombok dependency

## How to run/test
Run `./tools/test_cli` and check for the available commands

## How to load
`./tools/load/loader.sh pre_load` for client loading and simple instructions. <br>
Than run loader, e.g.:`./tools/test_cli load 100 10s` - 100 connections during 10s <br>
[Source code](https://github.com/gorelikov/rx-loader "rx-loader") for loading tool.

## Additional instructions
Firstly create environment by running `./tools/test_cli env`,<br>
than fill mongo with records by running `./tools/test_cli mongo_fill` (run it couple of times)

## Simple execution example
* `./tools/test_cli env_start`
* `./tools/test_cli mongo_fill`
* `./tools/load/loader.sh pre_load`
* checkout one of the steps
* run `./tools/test_cli clean_boot`
* `./tools/test_cli load 100 10s`

You can check different steps of application evolution by checking out one of the tags:
* step0 or sync
* step1 or async_servlet
* step2 or mono_first_try
* step3 or schedulers
* step4 or async_client
* step5 or reactive_mongo
* step6
