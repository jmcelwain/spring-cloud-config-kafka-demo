#!/usr/bin/env bash

function cleanup () {
    exit 0
}

trap cleanup SIGINT SIGTERM

echo "publishing messages to topic 'messages'"
while true
do
    echo "{\"message_id\": $RANDOM }" |  kafka-console-producer --broker-list localhost:9092 --topic messages
    wait $!
done