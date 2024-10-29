# Desafio Workshop

## 1. Descrição do Projeto
Esse projeto é uma API REST desenvolvida em Java utilizando Spring Boot, com banco de dados MySQL, e um front-end em HTML, CSS, e JavaScript. O sistema foi criado para gerenciar workshops e colaboradores, permitindo a criação, leitura, atualização e exclusão de dados relacionados.

### Tecnologias utilizadas:
- ![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white) ![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white) ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white) ![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white) ![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white) ![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black) ![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)

## 2. Como rodar o projeto localmente

Para rodar o projeto localmente, siga os passos abaixo:

### Passo 1: Clonar o repositório
```bash
git clone https://github.com/Daniel-Tavares-de-Lima/Desafio-Workshop.git
cd seu-repositorio
```

### Passo 2: Configurar o banco de dados Mysql
- Crie um banco de dados no MySQL com o nome workshopfast.
- No arquivo application.properties em src/main/resources, configure as credenciais de acesso ao MySQL:
  ```
  spring.application.name=workshop
  spring.output.ansi.enabled=ALWAYS
  spring.datasource.url=jdbc:mysql://localhost:3306/workshopfast
  spring.datasource.username=root
  spring.datasource.password=root
  spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialec
  spring.jpa.hibernate.ddl-auto=update
  ```

### Passo 3(Se necessário): Instale as dependências do projeto(SPRING BOOT)
- O arquivo para colocar as dependências se chama pom.xml
```
<dependencies>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>

		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>

		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	
	

		<!--VALIDAR OS DADOS DA NOSSA CLASSE-->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>

		<dependency>
			<groupId>javax.validation</groupId>
			<artifactId>validation-api</artifactId>
			<version>2.0.1.Final</version> <!-- Verifique a versão mais recente -->
		</dependency>

		<!--Lombok-->
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.18.24</version>
			<scope>provided</scope>
		</dependency>


		<!--DEPEDENCIA SWAGGER-->
		<dependency>
      		<groupId>org.springdoc</groupId>
      		<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
      		<version>2.6.0</version>
   		</dependency>


	</dependencies>
```

### Passo 4: Rodar o projeto
####(API)
- o arquivo principal se chama WorkshopApplication em src/main/java/com/workshopfast/workshop

####(FrontEnd)
- o arquivo se chama indexColaboradores em view
- ### Aviso! Na minha máquina a integração do frontend com o backend só aconteceu quando eu desativei todas as extensões do meu navegador.

### Passo 5: Acessar a documentação Swagger
Com o projeto em execução basta acessar: http://localhost:8080/swagger-ui/index.html#/


## 3. Pré-Requisitos
Versões instaladas na minha máquina
- Java: versão 22
- Mysql Workbench: versão 8.0
- Spring Boot: versão 2.5.4

## 4. Endpoints
### Colaboradores
- **GET /api/colaboradores** - Lista todos os colaboradores
- **POST /api/colaboradores** - Adiciona um novo colaborador
- **PUT /api/colaboradores/{id}** - Atualiza as informações de um colaborador
- **DELETE /api/colaboradores/{id}** - Remove um colaborador
### Workshops
- **GET /api/workshops** - Lista todos os workshops
- **POST /api/workshops** - Adiciona um novo workshop
- **PUT /api/workshops/{id}** - Atualiza as informações de um workshop
- DELETE /api/workshops/{id} - Remove um workshop
### Ata de Presença
- **GET /ata-de-presenca** - Lista todas as atas de presença.
- **GET /ata-de-presenca/{id}** - Busca uma ata de presença específica pelo ID.
- **DELETE /ata-de-presenca/{id}** - Remove uma ata de presença pelo ID.

## 5. Banco de Dados MER E MR
![DEMONSTRACION](https://github.com/Daniel-Tavares-de-Lima/Desafio-Workshop/blob/main/Modelo%20Relacional%20Projeto%20Workshop.png)

![DEMONSTRACION](https://github.com/Daniel-Tavares-de-Lima/Desafio-Workshop/blob/main/Modelo%20de%20Entidade%20Relacional%20Projeto%20Workshop.png)
