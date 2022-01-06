CREATE TABLE usuario (
	id serial,
	login VARCHAR(255),
	senha VARCHAR(255),
	tipo char(1)
);

CREATE TABLE jogo (
	id serial,
	nome VARCHAR(255),
	desenvolvedor VARCHAR(255),
	categoria VARCHAR(255),
	ano integer
);