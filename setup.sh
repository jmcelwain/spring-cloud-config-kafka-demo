#!/usr/bin/env bash

# install jars
mvn clean install

# builder containers
docker-compose build --no-cache

# start services
docker-compose up

# create database
docker-compose exec postgres createdb -U postgres configdb