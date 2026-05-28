# KaleduSenelioSveikinimas.lt

## Local Development

Run the local Docker Compose environment from the project root:

```bash
sudo docker compose --env-file .env -f docker/docker-compose.local.yaml up
```

Run it in the background:

```bash
sudo docker compose --env-file .env -f docker/docker-compose.local.yaml up -d
```

Stop the environment:

```bash
sudo docker compose --env-file .env -f docker/docker-compose.local.yaml down
```
