# API comprasparaguai.com.br






## Developer

[<img src="https://avatars.githubusercontent.com/carlosbetiol" width=115><br><sub>Carlos Betiol</sub>](https://github.com/carlosbetiol)

Linkedin: https://www.linkedin.com/in/carlosbetiol/

Email: carlos@betiol.dev



[Para versão em português clique aqui](README-pt.md)





> Project Status: Finished :heavy_check_mark:



## Tópicos

* [Scope and goal](#Scope-and-goal)

* [Technical data](#Technical-data)

* [Dependences](#Dependences)

* [Database](#Database)

* [Compile and run](#Compile-and-run)

* [Docker container](#Docker-container)

* [Methods](#Methods)

* [Results](#results)

* [Sample result](#Sample-result)

* [References](#References)

  

## Scope and goal

Provide a **XML** resource to be used by the website https://www.comprasparaguai.com.br containing data on the contracting company and its products, including prices, stock availability, product URLs, image URLs and other data required according to the structure specified by the site. 

This project was developed in Java with Spring Framework and can be cloned and reused by developers who want to use security features for their data when integrating their companies with comprasparaguai.com.br. 



## Technical data

This application was developed using the IntelliJ IDE and coded according to DDD modeling techniques for application constructions. 

JAVA 16 was used, but it can be modified to use any version from JAVA 11. For this it will be necessary to modify the POM.XML. 

Maven was the package manager used for the project. 

All parameters such as: database connection data, port to be used, IP address whitelist, among others, must be sent as environment variables. 



## Dependences

- Spring boot starter web
- MySQL connector Java (v8.0.25)
- Jackson dataformat XML
- Dockerfile maven plugin
- Spring boot starter security
- Spring boot starter data JPA (hibernate incluido)



## Database

The project was prepared for connection to database **MySQL** version 5.6 using the MySQL5Dialect dialect, however it will work for connection in more recent versions of MySQL, being necessary for this, change dialect in application.properties to org.hibernate. dialect.MySQL8Dialect. 

It will be necessary to use a table in the database whose name must be identified by the contents of the environment variable **TABLE_NAME**. A **VIEW** of the database can also be used if there is a need for direct data transformation through **SELECT** statement. 

The data structure should be as follows: 

```
create table custom_table_name (
   id_image int(11) not null,
   product_code varchar(14) not null,
   image_url varchar(255) not null default '',
   price varchar(20) not null default '',
   availability varchar(30) not null default '',
   brand varchar(50) not null default '',
   product_name varchar(255) not null default '',
   url_web varchar(255) not null default '',
   description_short text,
   primary key (id_image,product_code) using btree
) engine InnoDB;
```

The primary key is composed of the **id_image** and **product_code** fields, in the first one a sequential id can be stored and in the second the product code in the company's system. If there is no product code duplication then in **id_image** the value **1** can be stored for all lines. Below is a data dictionary: 

- id_image - Composes the primary key of the table, it can be a sequential numbering or 1. 
- product_code - Makes up the primary key and refers to the product code in the company's system. 
- image_url - The URL of product image on company website (must be https). 
- price - Product price in alphanumeric type, example: 235.00 USD. 
- availability - Product availability can be "em estoque" or "indisponível". 
- brand - Product brand.
- product_name - Product name.
- url_web - The URL of the product page on the company's website. 
- description_short - A brief textual description of the product. 



## Compile and run

In the project folder, use for compilation and generation of the artifact: 

```
./mvwn clean package
```

For execution it will be necessary to define the environment variables before calling the executable artifact (examples in linux): 

```
export HOST="ip_database_host"
export DATABASE="database_name"
export USER="database_username"
export PASSWORD="database_user_password"
export TABLE_NAME="table_or_view_name"
export SERVER_PORT="8080"
export OWNER_TITLE="Your_Company_name"
export OWNER_URL="Your_Company_site"
export OWNER_DESCRIPTION="Your_Company_phrase"
export WHITELIST="127.0.0.1 192.168.1.0/24 45.171.130.80"
java -jar ./target/xmlcomprasparaguai-1.0.0.jar 
```



## Docker container

The project is available in container format with all necessary dependencies, including the tomcat application to be used via Docker at https://hub.docker.com/repository/docker/carlosbetiol/xmlcomprasparaguai . 

If it is necessary to generate another Docker container after some code modification, the POM.XML file at the root of the project must be changed by searching and replacing the line below for the desired repository in the Docker HUB: 

```
<repository>carlosbetiol/xmlcomprasparaguai</repository>
```

A new build is needed with the generation of the new Docker container, using the appropriate profile: 

```
./mvnw clean package -Pdocker
```



## Methods

Requests for the API must follow the standards: 

| Method | Description                 |
| ------ | --------------------------- |
| GET    | Returns data in XML format. |



## Results

| Code | Description                    |
| ---- | ------------------------------ |
| 200  | Request executed successfully. |
| 403  | Forbiden.                      |



## Sample result

```
<rss version="2.0">
    <channel>
        <title>Roma Shopping</title>
        <link>https://www.romapy.com</link>
        <description>A loja completa.</description>
        <item>
            <description>Os suprimentos originais da Lexmark são projetados para funcionar melhor com as impressoras Lexmark, proporcionando excelente qualidade de impressão da primeira à última página. 
</description>
            <codigo>100012</codigo>
            <link>https://www.romapy.com/4723-toner-lexmark-34018hl-black---34018hl.html</link>
            <link_imagem>https://www.romapy.com/img/p/1/5/3/6/6/15366.jpg</link_imagem>
            <preco>116.00 USD</preco>
            <disponibilidade>indisponivel</disponibilidade>
            <marca>Lexmark</marca>
            <title>TONER LEXMARK 34018HL BLACK - 34018HL</title>
        </item>
        <item>
            <description>Os suprimentos originais da Lexmark são projetados para funcionar melhor com as impressoras Lexmark, proporcionando excelente qualidade de impressão da primeira à última página. 
</description>
            <codigo>100012</codigo>
            <link>https://www.romapy.com/4723-toner-lexmark-34018hl-black---34018hl.html</link>
            <link_imagem>https://www.romapy.com/img/p/1/5/3/6/7/15367.jpg</link_imagem>
            <preco>116.00 USD</preco>
            <disponibilidade>indisponivel</disponibilidade>
            <marca>Lexmark</marca>
            <title>TONER LEXMARK 34018HL BLACK - 34018HL</title>
        </item>
        <item>
            <description>Os suprimentos originais da Lexmark são projetados para funcionar melhor com as impressoras Lexmark, proporcionando excelente qualidade de impressão da primeira à última página. 
</description>
            <codigo>100023</codigo>
            <link>https://www.romapy.com/4724-toner-lexmark-w84020h-black---w84020h.html</link>
            <link_imagem>https://www.romapy.com/img/p/1/5/3/7/1/15371.jpg</link_imagem>
            <preco>190.00 USD</preco>
            <disponibilidade>indisponivel</disponibilidade>
            <marca>Lexmark</marca>
            <title>TONER LEXMARK W84020H BLACK - W84020H</title>
        </item>
    </channel>
</rss>
```



## References

To use Spring Security in creating the Whitelist in order to allow calls made only from authorized hosts, the following references were used. 

- https://www.geekyhacker.com/2019/12/10/spring-boot-security-restrict-requests-to-ip-address-range/
- https://www.baeldung.com/spring-security-whitelist-ip-range
- https://codetinkering.com/spring-forwarded-headers-example/

For dynamic naming of the database table in JPA Hibernate was used the strategy **PhysicalNamingStrategy** where the name is sent through an environment variable that is acquired through a Spring Config Bean and passed on to a child class of * *PhysicalNamingStrategyStandardImpl** according to the following references: 

- https://thorben-janssen.com/naming-strategies-in-hibernate-5/
- https://www.baeldung.com/hibernate-field-naming-spring-boot

To expose the docker container to the internet it was necessary to install an Nginx container configured for reverse proxy. It was also necessary to install Certbot to generate the Let's Encrypt certificate. Instructions on how to set up a reverse proxy using https are referenced in: 

- https://stackify.com/how-to-configure-https-for-an-nginx-docker-container/




------

[<img src="https://avatars.githubusercontent.com/carlosbetiol" width=115><br><sub>Carlos Betiol</sub>](https://github.com/carlosbetiol)

Linkedin: https://www.linkedin.com/in/carlosbetiol/

Email: carlos@betiol.dev

