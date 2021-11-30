create database cadastro; 

use cadastro;

create table tb_usuarios (
	id bigint NOT NULL AUTO_INCREMENT,
	nome varchar(255) NOT NULL,
	usuario varchar(255) NOT NULL,
	senha varchar(255) NOT NULL,
	foto varchar(255),
    primary key (id)
);

create table tb_postagens (
    id bigint NOT NULL AUTO_INCREMENT,
	titulo varchar(256) NOT NULL,
    texto varchar(256) NOT NULL,
    data DATE NOT NULL,
    id_usuario bigint NOT NULL,
    id_tema bigint NOT NULL,
	primary key (id)
);

create table tb_temas (
    id bigint NOT NULL AUTO_INCREMENT,
	nome varchar(256) NOT NULL,
    descricao varchar(256) NOT NULL,
	primary key (id)
);

alter table `tb_postagens` ADD CONSTRAINT `id_usuario` FOREIGN KEY (`id`) REFERENCES `tb_usuarios`(`id`);

alter table `tb_postagens` ADD CONSTRAINT `id_tema` FOREIGN KEY (`id`) REFERENCES `tb_temas`(`id`);
