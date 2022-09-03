# Estoque Mercado

## Sobre
O Estoque Mercado é um CRUD de produtos desenvolvido em JAVA e mySQL.

## Como replicar em seu ambiente

Utilize o PhpMyAdmin do Wamp Server/ XAMPP, crie o banco de dados com a seguinte estrutura antes de rodar o programa:

database: mercado

> CREATE TABLE produto <br>
( <br>
codigo INT PRIMARY KEY AUTO_INCREMENT,  <br>
nomeProduto CHAR (80) NOT NULL  <br>
valor double NOT NULL <br>
quantidade int NOT NULL <br>
); <br>

A IDE utilizada para criá-lo foi o Netbeans, mas pode utilizar uma de sua preferência. 

