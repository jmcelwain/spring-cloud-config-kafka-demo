# Dependencies

```
# OSX:
brew cask install docker
brew install docker-compose
brew install kafka
```

# Run
```
#!/usr/bin/env bash

# install jars
mvn clean install -DskipTests

# builder containers
docker-compose build --no-cache

# start services
docker-compose up -d

# wait for postgres
./wait-for-it.sh localhost:5462 -- echo "postgres started"

# create database
docker-compose exec postgres createdb -U postgres configdb
```
