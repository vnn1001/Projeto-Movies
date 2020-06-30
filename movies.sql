create database movies;

use movies;

create table tbFilmes(
nome varchar(30),
genero varchar(30),
descricao varchar(100));

insert into tbFilmes(nome,genero,descricao) values ("Gente Grande","Comedia","Amigos se juntam no verão após a morte de seu treinador de basquete na época da escola");

select * from tbUsuario;