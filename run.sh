#!/usr/bin/env sh

chmod +x dockerize.sh

./dockerize.sh

docker rm -f domino_application

docker-compose up