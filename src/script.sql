create table IF NOT EXISTS endereco
(
 id integer NOT NULL AUTO_INCREMENT,
 rua varchar(255), 
 numero integer,
 CEP varchar(8), 
 complemento varchar(255),
 primary key (id)
 );



create table IF NOT EXISTS login
(
 id integer NOT NULL AUTO_INCREMENT,
 usuario varchar(255),
 senha varchar(255),
 primary key (id)
);

create table IF NOT EXISTS pessoa
(
 id integer NOT NULL AUTO_INCREMENT,
 nome varchar(255),
 sobrenome varchar(255),
 telefone varchar(10),
 celular varchar(11),
 enderecoID integer,
 loginID integer,
 primary key (id),
 foreign key (loginID) references login(id),
 foreign key (enderecoID) references endereco(id)
);

create table IF NOT EXISTS cliente
(
 id integer NOT NULL AUTO_INCREMENT,
 pessoaID integer,
 CPF varchar(11),
 primary key (id),
 foreign key (pessoaID) references pessoa(id)
 );

create table IF NOT EXISTS vendedor
( 
 id integer NOT NULL AUTO_INCREMENT,
 pessoaID integer,
 CNPJ varchar(20),
 primary key (id),
 foreign key (pessoaID) references pessoa(id)
);


create table IF NOT EXISTS companhia_aerea
( 
 id integer NOT NULL AUTO_INCREMENT,
 nome varchar(255),
 primary key (id)
);


create table IF NOT EXISTS aviao
( 
 id integer NOT NULL AUTO_INCREMENT,
 capacidade integer,
 fabricante varchar(255),
 modelo varchar(255),
 companhiaID integer,
 primary key (id),
 foreign key (companhiaID) references companhia_aerea(id)
);


create table IF NOT EXISTS aeroporto
( 
 id integer NOT NULL AUTO_INCREMENT,
 nome varchar(255),
 cidade varchar(255),
 pais varchar(255),
 primary key (id)
);

create table IF NOT EXISTS rota
( 
 id integer NOT NULL AUTO_INCREMENT,
 origemID integer,
 destinoID integer,
 primary key (id),
 foreign key (origemID) references aeroporto(id),
 foreign key (destinoID) references aeroporto(id)
);

create table IF NOT EXISTS voo
( 
 id integer NOT NULL AUTO_INCREMENT,
 dataPartida datetime,
 dataChegada datetime,
 assentosLivres integer,
 rotaID integer,
 aviaoID integer,
 primary key (id),
 foreign key (aviaoID) references aviao(id),
 foreign key (rotaID) references rota(id)
);

create table IF NOT EXISTS passagem
( 
 id integer NOT NULL AUTO_INCREMENT,
 numAssento varchar(10),
 vooID integer,
 primary key (id),
 foreign key (vooID) references voo(id)
);

create table IF NOT EXISTS conexao
( 
 id integer NOT NULL AUTO_INCREMENT,
 preco float,
 primary key (id)
);

create table IF NOT EXISTS link_conexao
(
 id integer NOT NULL AUTO_INCREMENT,
 ordenacao integer,
 conexaoID integer NOT NULL,
 passagemID integer NOT NULL,
 primary key (id),
 foreign key (passagemID) references passagem(id),
 foreign key (conexaoID) references conexao(id)
);

create table IF NOT EXISTS negociacao
(
 id integer NOT NULL AUTO_INCREMENT,
 data datetime,
 total float,
 status boolean,
 clienteID integer NOT NULL,
 vendedorID integer,
 primary key (id),
 foreign key (clienteID) references cliente(id),
 foreign key (vendedorID) references vendedor(id)
);

create table IF NOT EXISTS itens -- - link de negociação com conexoes
( 
 id integer NOT NULL AUTO_INCREMENT,
 conexaoID integer,
 negociacaoID integer,
 foreign key (conexaoID) references conexao(id),
 foreign key (negociacaoID) references negociacao(id),
 primary key (id)
);
