#!/bin/bash
set -euo pipefail

ENV_FILE="../.env"
COMPOSE_FILE="docker/docker-compose.prod.yaml"

echo "*** PULLING CODE ***"
git fetch origin master
git checkout master
git reset --hard origin/master

echo "*** DEPLOYING ***"
docker compose \
  -f "$COMPOSE_FILE" \
  --env-file "$ENV_FILE" \
  up -d --build --remove-orphans