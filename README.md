# Dependencies

```
# OSX:
brew cask install docker
brew install docker-compose
brew install kafka
```

# Run
```
# install jars
mvn clean install
 
# builder containers
docker-compose build
 
# start services
docker-compose up
 
# create database
docker-compose exec postgres createdb -U postgres configdb
```
