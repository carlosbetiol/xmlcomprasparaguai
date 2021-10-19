## Technical information

To compile the application, create a new docker container and put it on docker HUB

First the old docker image can be removed:

```
docker image ls
docker image rm carlosbetiol/xmlcomprasparaguai:tag
```

Create new:

```
./mvnw clean package -Pdocker

docker tag carlosbetiol/xmlcomprasparaguai:new_version carlosbetiol/xmlcomprasparaguai:latest

docker push carlosbetiol/xmlcomprasparaguai:new_version

docker push carlosbetiol/xmlcomprasparaguai:latest

```

Other informations how to use the docker container:

https://hub.docker.com/repository/docker/carlosbetiol/xmlcomprasparaguai

To upload a README.md to docker hub repository was used this reference for docker pushrm plugin:

https://github.com/christian-korneck/docker-pushrm

