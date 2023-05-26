include .env

.PHONY: up

up:
	docker-compose up -d

.PHONY: down

down:
	docker-compose down --remove-orphans --rmi all

.PHONY: logs

logs:
	docker-compose logs -f

.PHONY: stop

stop:
	docker-compose stop

.PHONY: star

start:
	docker-compose start

.PHONY: loggin

loggin:
	docker exec -it rentx /bin/bash

.PHONY: force

force:
	docker-compose up --force-recreate -d

.PHONY: ip

ip:
	docker inspect --format='{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' vxtel_db vxtel vxtel-front

