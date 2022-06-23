CRUD - Produtos

Utilize o PhpMyAdmin do Wamp Server/ XAMPP, crie o banco de dados com a seguinte estrutura antes de rodar o programa:

database: mercado

CREATE TABLE produto
(
codigo INT PRIMARY KEY AUTO_INCREMENT,
nomeProduto CHAR (80) NOT NULL
valor double NOT NULL
quantidade int NOT NULL
);
