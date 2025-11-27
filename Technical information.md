## Technical information

To compile the application, create a new docker container and put it on docker HUB

First the old docker image can be removed:

```
docker image ls
docker image rm carlosbetiol/xmlcomprasparaguai:tag
```

Create new:

```
./mvnw clean package -Pdocker -Dmaven.test.skip=true
```

docker tag xmlcomprasparaguai:new_version carlosbetiol/xmlcomprasparaguai:new_version
docker tag xmlcomprasparaguai:new_version carlosbetiol/xmlcomprasparaguai:latest

docker push carlosbetiol/xmlcomprasparaguai:new_version

docker push carlosbetiol/xmlcomprasparaguai:latest

```

Other informations how to use the docker container:

https://hub.docker.com/repository/docker/carlosbetiol/xmlcomprasparaguai

To upload a README.md to docker hub repository was used this reference for docker pushrm plugin:

https://github.com/christian-korneck/docker-pushrm

docker-compose.yml

version: "3.9"

networks:
  xmlcomprasparaguai_network:
    driver: bridge

services:
  xmlcomprasparaguai:
    image: carlosbetiol/xmlcomprasparaguai:latest
    security_opt:
      - seccomp:unconfined
    deploy:
      resources:
        limits:
          memory: 512M  # O limite hard do Docker
        reservations:
          memory: 256M  # O quanto ele garante reservar
    environment:
      HOST: "xx"
      DATABASE: "xx"
      USER: "xx"
      PASSWORD: "xx"
      TABLE_NAME: "xx"
      SERVER_PORT: "8443"
      OWNER_TITLE: "xx"
      OWNER_URL: "xx"
      OWNER_DESCRIPTION: "xx"
      WHITELIST: "xxx.xxx.xxx.xxx xxx.xxx.xxx.xxx/xx"
      JAVA_TOOL_OPTIONS: "-XX:MaxRAMPercentage=75.0"
    expose:
      - "8443"
    networks:
      - xmlcomprasparaguai_network
