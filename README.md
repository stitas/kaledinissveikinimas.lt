# KaledinisSveikinimas.lt

WebApp for AI santa christmas greeting generation

Take a look at [KaledinisSveikinimas.lt](https://kaledinissveikinimas.lt/).

TypeScript/SvelteKit + Kotlin/Spring Boot + PostgreSQL

Hosted on small virtual private server with auto deploy on push configured using github actions 

## Local Development

Run the local Docker Compose environment from the project root:

```bash
sudo docker compose --env-file .env.local -f docker/docker-compose.local.yaml up
```