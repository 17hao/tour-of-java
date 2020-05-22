#!/bin/bash

./gradlew makeHadoopJar
cp /Users/17hao/JetBrains/java-tour/build/libs/hadoop-job-1.0.0.jar /Users/17hao

PREFIX="xyz.shiqihao.hadoop"
hadoop "$PREFIX.$1" ${@:2}