##Universidade Federal da Paraíba
####Departamento de Ciências Exatas

<br>Projeto referente à disciplina de Projeto Avançado de Software</br>

<p> Esta API foi construída, inicialmente, com a IDE Intellij, podendo ser executada
a partir de outras IDEs que sejam compatíveis com a linguagem Java, a exemplo do Eclipse
ou até mesmo por editores de texto, como o VS Code e afins.</p>
<p>Para executar a API é necessário possuir instalado as seguintes ferramentas:</p>
<p>* Java versão 11 ;</p>
<p>* Maven</p>
<p>* Postgres;</p>
<p>* DBeaver</p>
<p>* Postman</p>
<p>Depois de instalado, vamos a execução.</p>

 **Inicializando o projeto**
 <p>Para inicializar o projeto, baixe os arquivos do repositório do github
 em seu dispositivo e importe o projeto em sua IDE ou editor de texto de preferência.</p>

**Criando a conexão com o banco de dados** 
<p>Para iniciar a conexão com o banco de dados abra o DBeaver e crie
 uma nova conexão do banco de dados, utilizando o postgres, com o nome da base de dados "systemoutjpa", usuario "postgres" e senha "postgres".
 Depois de configurado, vamos abrir o postman para testar a API.</p>
 
 **Execute o projeto**
 <p>Execute o projeto a partir da sua IDE no pacote: `com.ufpb.triggerdev.systemoutproject` </p>
 
 **Testando a API com o postman**
 <p>Abra o postman digite a url: http://localhost:8080</p>
 <p>1-O endpoint `/usuarios` lista todos os usuário que estejam cadastrados no banco.
 Caso não exista nada, ele retorna uma lista vazia no formato JSON.
 Faça utilizando um GET.</p>
 
 
 
 
 






