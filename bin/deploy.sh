#!/bin/sh
docker-compose -f docker-compose.yml -f compose/prod.yml config > docker-compose.prod.yml
docker stack deploy -c docker-compose.prod.yml mjolnir
