## Docker container XML API to comprasparaguai.com.br

Information about the application, please visit the project github https://github.com/carlosbetiol/xmlcomprasparaguai .

This container brings the XML API application comprasparaguai.com.br easy to use. The simplest way to use this container is through docker-compose. 

Example file docker-compose.yml: 

```
version: "3.9"

networks:
  xmlcomprasparaguai_network:
    driver: bridge

services:
  xmlcomprasparaguai:
    image: carlosbetiol/xmlcomprasparaguai:latest
    environment:
      HOST: "IP or DNS name of the database MySQL host"
      DATABASE: "database name"
      USER: "database user name"
      PASSWORD: "database password"
      TABLE_NAME: "table name"
      SERVER_PORT: "8443"
      OWNER_TITLE: "Company name"
      OWNER_URL: "https://www.companyname.com"
      OWNER_DESCRIPTION: "The best of the world."
      WHITELIST: "127.0.0.1 45.175.137.80 192.168.1.0/24"
    expose:
      - "8443"
    networks:
      - xmlcomprasparaguai_network

```

After created the docker-compose file:

```
docker-compose up -d
```



To expose the API to the internet, considering a white list of IP addresses, it will be necessary to use a reverse proxy and a Let's Encrypt certificate can be added. 

Fell free to use this project.



[<img src="https://avatars.githubusercontent.com/carlosbetiol" width=115><br><sub>Carlos Betiol</sub>](https://github.com/carlosbetiol)

Linkedin: https://www.linkedin.com/in/carlosbetiol/

Email: carlos@betiol.dev

