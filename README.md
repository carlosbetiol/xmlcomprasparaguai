# API comprasparaguai.com.br






## Desenvolvedor

[<img src="https://avatars.githubusercontent.com/carlosbetiol" width=115><br><sub>Carlos Betiol</sub>](https://github.com/carlosbetiol)



> Status do Projeto: Concluido :heavy_check_mark:



## Tópicos





## Escopo e objetivo

Disponibilizar um recurso **XML** para ser utilizado pelo site https://www.comprasparaguai.com.br contendo dados da empresa contratante e seus produtos, incluindo preços, disponibilidades de estoque, URLs do produto, URLs de imagens e outros dados necessários conforme a estrutura especificada pelo site.

Este projeto foi desenvolvido em Java com Spring Framework e pode ser clonado e reutilizado por desenvolvedores que queiram utilizar recursos de segurança para seus dados ao integrar suas empresas com o comprasparaguai.com.br.



## Dados técnicos

Este programa foi desenvolvido utilizando a IDE Intellij e codificado segundo técnicas da modelagem DDD de construções de aplicações.

Foi utilizado o JAVA 16, porém pode ser modificado para utilizar qualquer versão a partir do JAVA 11. Para isto será necessário modificar o POM.XML. 

Maven foi o gerenciador de pacotes utilizado para o projeto.

Todos os parâmetros como: dados de conexão com o banco de dados, porta a ser utilizada, whitelist de endereços de IP, dentre outros, deverão ser enviados como variáveis de ambiente.



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

