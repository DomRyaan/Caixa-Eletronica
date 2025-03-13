# Sistema Bancário em Java

Este projeto é uma aplicação de sistema bancário desenvolvida em Java, utilizando JavaFX para a interface gráfica, Maven para gerenciamento de dependências, Scene Builder para construção das interfaces e um banco de dados relacional para persistência de dados. O objetivo principal é simular operações bancárias básicas, como autenticação, depósitos, saques e transferências.

## Funcionalidades

- **Autenticação:** Verifica se o cliente possui conta cadastrada no banco.
- **Depósito:** Funcionalidade para adicionar fundos à conta do cliente.
- **Saque:** Permite a retirada de fundos da conta, respeitando o saldo disponível.
- **Consulta de Saldo:** Exibe o saldo atual da conta.

## Tecnologias Utilizadas

- **Java:** Linguagem de programação principal do projeto.
- **JavaFX:** Biblioteca para construção de interfaces gráficas.
- **Scene Builder:** Ferramenta para criação de layouts de forma visual.
- **Maven:** Gerenciador de dependências e automação de build.
- **Banco de Dados:** Sistema de gerenciamento de banco de dados relacional para armazenar informações das contas e transações.

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- **JDK 11 ou superior:** Necessário para compilar e executar o código Java.
- **JavaFX:** Caso não esteja integrado ao JDK, é necessário adicionar as bibliotecas do JavaFX ao projeto.
- **Maven:** Para gerenciamento de dependências e construção do projeto.
- **Banco de Dados:** Um SGDB de sua preferência (por exemplo, MySQL, PostgreSQL) devidamente configurado.

## Configuração do Ambiente

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/DomRyaan/Caixa-Eletronica.git
   ```


2. **Importe o projeto em sua IDE de preferência:**

   - Se estiver utilizando o Eclipse, importe como um projeto Maven existente.
   - No IntelliJ IDEA, basta abrir o projeto que o Maven será reconhecido automaticamente.

3. **Configure as dependências do JavaFX:**

   Certifique-se de que as bibliotecas do JavaFX estão corretamente configuradas no `pom.xml` do Maven. Caso contrário, adicione as dependências necessárias.

4. **Configure o banco de dados:**

   - Crie um banco de dados no SGDB de sua preferência.
   - Atualize as configurações de conexão no arquivo de propriedades ou diretamente no código, conforme a implementação do projeto.
   - Execute os scripts SQL fornecidos na pasta `database` para criar as tabelas necessárias.

## Executando a Aplicação

Após configurar o ambiente:

1. **Compile o projeto utilizando o Maven:**

   ```bash
   mvn clean install
   ```


2. **Execute a aplicação:**

   - Pela IDE: Execute a classe principal que inicia a interface JavaFX.
   - Pelo terminal:

   ```bash
   mvn javafx:run
   ```


## Estrutura do Projeto

O projeto segue a seguinte estrutura de diretórios:


```
Caixa-Eletronica/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── exemplo/
│   │   │           ├── Main.java
│   │   │           ├── controllers/
│   │   │           └── models/
│   │   └── resources/
│   │       └── views/
│   │           ├── main.fxml
│   │           └── ...
├── pom.xml
└── README.md
```


- **`src/main/java/com/exemplo/`**: Contém as classes Java do projeto.
  - **`Main.java`**: Classe principal que inicia a aplicação.
  - **`controllers/`**: Pacote com as classes controladoras da interface.
  - **`models/`**: Pacote com as classes de modelo que representam as entidades do sistema.
- **`src/main/resources/views/`**: Contém os arquivos FXML das interfaces gráficas.
- **`pom.xml`**: Arquivo de configuração do Maven.
- **`README.md`**: Arquivo com informações e instruções sobre o projeto.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e enviar pull requests.

---

*Este projeto foi desenvolvido como parte de um desafio acadêmico para a criação de um sistema bancário utilizando Java e suas ferramentas associadas.* 
