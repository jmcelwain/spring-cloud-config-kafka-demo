#!/usr/bin/env bash

# install jars
mvn clean install

# builder containers
docker-compose build --no-cache

# start services
docker-compose up -d

# wait for postgres
./wait-for-it.sh localhost:5462 -- echo "postgres started"

# create database
docker-compose exec postgres createdb -U postgres configdb