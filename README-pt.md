# API comprasparaguai.com.br






## Desenvolvedor

[<img src="https://avatars.githubusercontent.com/carlosbetiol" width=115><br><sub>Carlos Betiol</sub>](https://github.com/carlosbetiol)

Linkedin: https://www.linkedin.com/in/carlosbetiol/



[To english version click here](https://github.com/carlosbetiol/xmlcomprasparaguai/README.md)




> Status do Projeto: Concluido :heavy_check_mark:



## Tópicos

* [Escopo e objetivo](#Escopo-e-objetivo)

* [Dados técnicos](#Dados-técnicos)

* [Dependências](#Dependências)

* [Banco de dados](#Banco-de-dados)

* [Compilação e execução](#Compilação-e-execução)

* [Docker container](#Docker-container)

* [Métodos](#Métodos)

* [Respostas](#respostas)

* [Exemplo de resposta](#Exemplo-de-resposta)

* [Referências utilizadas](#Referências-utilizadas)

  

## Escopo e objetivo

Disponibilizar um recurso **XML** para ser utilizado pelo site https://www.comprasparaguai.com.br contendo dados da empresa contratante e seus produtos, incluindo preços, disponibilidades de estoque, URLs do produto, URLs de imagens e outros dados necessários conforme a estrutura especificada pelo site.

Este projeto foi desenvolvido em Java com Spring Framework e pode ser clonado e reutilizado por desenvolvedores que queiram utilizar recursos de segurança para seus dados ao integrar suas empresas com o comprasparaguai.com.br.



## Dados técnicos

Este programa foi desenvolvido utilizando a IDE Intellij e codificado segundo técnicas da modelagem DDD de construções de aplicações.

Foi utilizado o JAVA 16, porém pode ser modificado para utilizar qualquer versão a partir do JAVA 11. Para isto será necessário modificar o POM.XML. 

Maven foi o gerenciador de pacotes utilizado para o projeto.

Todos os parâmetros como: dados de conexão com o banco de dados, porta a ser utilizada, whitelist de endereços de IP, dentre outros, deverão ser enviados como variáveis de ambiente.



## Dependências

- Spring boot starter web
- MySQL connector Java (v8.0.25)
- Jackson dataformat XML
- Dockerfile maven plugin
- Spring boot starter security
- Spring boot starter data JPA (hibernate incluido)



## Banco de dados

O projeto foi preparado para conexão com banco de dados **MySQL** versão 5.6 utilizando o dialeto MySQL5Dialect, entretanto ele funcionará para conexão em versões mais atuais do MySQL, sendo necessário para isto, mudar dialeto no application.properties para org.hibernate.dialect.MySQL8Dialect.

Será necessário utilizar uma tabela no banco de dados cujo nome deve ser identificado pelo conteúdo da variável de ambiente **TABLE_NAME**. Também poderá ser utilizado uma **VIEW** do banco de dados caso haja necessidade de transformação direta de dados através de **SELECT**.

A estrutura de dados deve ser como segue:

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
   primary key (id_image,product_code) using btree,
) engine = InnoDB;
```

A chave primária é composta pelos campos **id_image** e **product_code** sendo que no primeiro pode ser armazenado um id sequencial e no segundo o código do produto no sistema da empresa. Caso não haja repetição de código então no **id_image** pode ser armazenado o valor **1** para todas as linhas. Abaixo um dicionário de dados:

- id_image - Compõe a chave primária da tabela, pode ser uma numeração sequencial ou 1.
- product_code - Compõe a chave primária e refere-se ao código do produto no sistema da empresa.
- image_url - URL completa da imagem do produto no site da empresa (deve ser https).
- price - Preço do produto no tipo alfanumérico, exemplo: 235.00 USD.
- availability - Disponibilidade do produto podendo ser "disponível" ou "indisponível".
- brand - Marca do produto.
- product_name - Nome do produto.
- url_web - URL completa da página do produto no site da empresa.
- description_short - Um breve descritivo textual do produto.



## Compilação e execução

Na pasta do projeto, utilizar para compilação e geração do artefato:

```
./mvwn clean package
```

Para execução serão necessárias definições das variáveis de ambiente antes da chamada do artefato executável (exemplos em linux):

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

O projeto está disponível em formato de container com todas as dependências necessárias, inclusive a aplicação tomcat para ser utilizado via Docker em https://hub.docker.com/repository/docker/carlosbetiol/xmlcomprasparaguai .

Caso seja necessário gerar outro container Docker depois de alguma modificação em código, o arquivo POM.XML na raíz do projeto deve ser alterado buscando e substituindo a linha abaixo para o repositório desejado no Docker HUB:

```
<repository>carlosbetiol/xmlcomprasparaguai</repository>
```

Uma nova compilação é necessária com a geração do novo container Docker, utilizando o profile adequado:

```
./mvnw clean package -Pdocker
```



## Métodos

Requisições para a API devem seguir os padrões:

| Método | Descrição                        |
| ------ | -------------------------------- |
| GET    | Retorna os dados no formato XML. |



## Respostas

| Código | Descrição                         |
| ------ | --------------------------------- |
| 200    | Requisição executada com sucesso. |
| 403    | Acesso proibido                   |



## Exemplo de resposta

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



## Referências utilizadas

Para utilização do Spring Security na criação do Whitelist com o objetivo de permitir chamadas realizadas somente de hosts autorizados, foram utilizadas as seguintes referências.

- https://www.geekyhacker.com/2019/12/10/spring-boot-security-restrict-requests-to-ip-address-range/
- https://www.baeldung.com/spring-security-whitelist-ip-range
- https://codetinkering.com/spring-forwarded-headers-example/

Para nomeação dinâmica da tabela do banco de dados no JPA Hibernate foi utilzada a estratégia **PhysicalNamingStrategy** onde o nome é enviado através de variável de ambiente que é adquirido através de um Bean de config do Spring e repassado a uma classe filha de **PhysicalNamingStrategyStandardImpl** segundo as seguintes referências:

- https://thorben-janssen.com/naming-strategies-in-hibernate-5/
- https://www.baeldung.com/hibernate-field-naming-spring-boot

Para expor o container docker para a internet foi necessário instalar um container Nginx configurado para proxy reverso. Foi necessário também instalar o Certbot para geração do certificado Let's Encrypt. Instruções de como configurar um proxy reverso utilizando https estão referenciadas em:

- https://stackify.com/how-to-configure-https-for-an-nginx-docker-container/




------

[<img src="https://avatars.githubusercontent.com/carlosbetiol" width=115><br><sub>Carlos Betiol</sub>](https://github.com/carlosbetiol)

Linkedin: https://www.linkedin.com/in/carlosbetiol/

