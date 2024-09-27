create table IF NOT EXISTS PRODUTOS (
        id integer primary key AUTO_INCREMENT,
        NOME VARCHAR(30) NOT NULL ,
        PRECO DECIMAL (10,2) NOT NULL
);