#!/usr/bin/env bash

java -cp /home/"$USER"/.m2/repository/com/h2database/h2/1.4.200/h2-1.4.200.jar \
    org.h2.tools.Server \
    -tcpPort 9002 \
    -web -webAllowOthers \
    -tcp -tcpAllowOthers \
    -ifNotExists \
    -baseDir ~/.becoming