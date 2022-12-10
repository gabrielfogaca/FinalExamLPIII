/* Exclui o banco de dados */
DROP DATABASE IF EXISTS InfoMil;

/* Cria o banco de dados */
create database InfoMil;

USE InfoMil;

/* Exclui as tabelas */
/*DROP TABLE tipo_cliente;
DROP TABLE cliente;
DROP TABLE VENDEDOR;
DROP TABLE GRUPO;
DROP TABLE ITEM;
DROP TABLE VENDA;
DROP TABLE item_venda;
DROP TABLE usuario;*/


/* Cria tabela de tipo_cliente */
CREATE TABLE tipo_cliente (
	id_tipo_cliente    INT 	NOT NULL	auto_increment,
	descr_tipo_cliente  VARCHAR(30),
PRIMARY KEY(id_tipo_cliente));

/* Cria tabela de usuario */
CREATE TABLE usuario (
	id_usuario   INT 	NOT NULL	auto_increment,
	login  CHAR(30) NOT NULL,
    senha VARCHAR(30) NOT NULL,
PRIMARY KEY(id_usuario),
UNIQUE KEY(login));

/* Cria tabela de cliente      */
CREATE TABLE CLIENTE (
	id_cliente        INT 	NOT NULL	auto_increment,
	nome_cliente        CHAR(30),
	id_tipo_cliente    INT	NOT NULL,
PRIMARY KEY(id_cliente),
FOREIGN KEY(id_tipo_cliente)
	references tipo_cliente(id_tipo_cliente)
	on update no action
	on delete restrict);

/* Cria tabela de VENDEDOR     */
CREATE TABLE VENDEDOR (
	id_vendedor       INT 	NOT NULL	auto_increment,
	nome_vendedor       CHAR(30),
	pc_comissao      decimal(5,2),
PRIMARY KEY(id_vendedor));

/* Cria tabela ITEM de estoque */
CREATE TABLE ITEM (
	id_item   INT  		NOT NULL  auto_increment,
	nome_item   char(40) 	not null,
	preco    decimal(9,2),
	qtde_estoque   INT,
PRIMARY KEY(id_item));

/* Cria tabela de Notas fiscais de venda */
CREATE TABLE VENDA (
	id_venda    INT 	NOT NULL	auto_increment,
    id_cliente INT NOT NULL,
    id_vendedor INT NOT NULL,
	nome_vendedor varchar(50) 	not null,
	nome_cliente   varchar(50) 	not null,
    nome_item varchar(50) not null,
	vl_total_venda    decimal(9,2),
PRIMARY KEY(id_venda),
FOREIGN KEY(id_cliente) 
        references CLIENTE(id_cliente)
	on update restrict
	on delete restrict,
FOREIGN KEY(id_vendedor) 
        references VENDEDOR(id_vendedor)
	on update restrict
	on delete restrict);

/* Cria tabela de Itens das Notas fiscais */
CREATE TABLE item_venda (
	id_venda    INT 	NOT NULL auto_increment,
 	id_item   INT  	NOT NULL,
	qtde  INT 	not null,
	valor  decimal(9,2),
PRIMARY KEY(id_venda,id_item),
FOREIGN KEY(id_item) 
        references ITEM(id_ITEM)
	on update restrict
	on delete restrict);

/* grupo 1 informatica */
insert into item values(1,'SSD Kingston 240GB',179.99,20);
insert into item values(2,'i7 9700kf',849.99,10);
insert into item values(3,'Placa Mae b450 steel',799.00,17);
insert into item values(4,'ASUS RTX 3060 12GB',2899.99,6);
insert into item values(5,'WD 480gb nvme',433.50,7);
insert into item values(6,'i7 12700k',1679.90,3);
insert into item values(7,'AMD 5600x',1349.50,3);
insert into item values(8,'Gabinete Aerials RGB',245.55,2);
insert into item values(9,'Monitor Gamer Samsung 27" 144Hz ',1879.3,5);
insert into item values(10,'PlayStation 5',1299,8);
insert into item values(11,'Memoria Ram 2x8gb 3200mhz',566,3);
insert into item values(12,'Fonte 850 plus bronze',545,4);

insert into tipo_cliente values (1,'Pessoa Fisica');
insert into tipo_cliente values (2,'Pessoa Juridica');


insert into cliente values (1,'Eduardo Motta',1);
insert into cliente values (2,'Lucas Mercedes',1);
insert into cliente values (3,'Bernardo Uhklith',2);
insert into cliente values (4,'Adriana Flickthy',1);
insert into cliente values (5,'Aline Liros',2);

insert into usuario values(1,'admin', 'admin');

insert into vendedor values (1,'Joao',5.00);
insert into vendedor values (2,'Bruninho',10.00);
insert into vendedor values (3,'Fogaca',8.00);



