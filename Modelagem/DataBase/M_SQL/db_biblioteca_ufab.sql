/* RelacionalBibliotecaUFAB: */
CREATE DATABASE IF NOT EXISTS db_biblioteca_ufab;
USE db_biblioteca_ufab;

CREATE TABLE Usuario (
    matricula varchar (30) PRIMARY KEY,
    nome varchar (50),
    senha text,
    data_nascimento datetime,
    data_cadastro datetime,
    FK_Perfil_cod int
);

CREATE TABLE Perfil (
    cod int PRIMARY KEY,
    nome varchar (20)
);

CREATE TABLE Permissao (
    tag varchar (5) PRIMARY KEY,
    nome varchar (30)
);

CREATE TABLE Item (
    cod int PRIMARY KEY,
    titulo varchar (30),
    quant_max_locacao int,
    FK_TipoItem_cod int
);

CREATE TABLE Livro (
    isbn varchar (30),
    autor text,
    editora varchar (30),
    ano_publicacao datetime,
    edicao varchar (30),
    nmr_pagina int,
    area varchar (30),
    tema text,
    FK_Item_cod int PRIMARY KEY
);

CREATE TABLE Revista (
    editora varchar (30),
    data_publicacao datetime,
    edicao varchar (30),
    nmr_pagina int,
    FK_Item_cod int PRIMARY KEY
);

CREATE TABLE Jornal (
    data datetime,
    edicao varchar (30),
    FK_Item_cod int PRIMARY KEY
);

CREATE TABLE AnaisCongresso (
    autor varchar (50),
    nome_congresso varchar (50),
    ano_publicacao datetime,
    local varchar (50),
    FK_Item_cod int PRIMARY KEY,
    FK_TipoAnaisCongresso_cod int
);

CREATE TABLE TipoItem (
    cod int PRIMARY KEY,
    nome varchar (50)
);

CREATE TABLE TrabalhoConclusao (
    autor varchar (50),
    orientador varchar (50),
    ano_defesa datetime,
    local varchar (50),
    FK_Item_cod int PRIMARY KEY,
    FK_TipoTrabalhoConclusao_cod int
);

CREATE TABLE MidiaDigital (
    data_gravacao datetime,
    FK_Item_cod int PRIMARY KEY,
    FK_TipoMidiaDigital_cod int
);

CREATE TABLE TipoAnaisCongresso (
    cod int PRIMARY KEY,
    nome varchar (20)
);

CREATE TABLE TipoTrabalhoConclusao (
    cod int PRIMARY KEY,
    nome varchar (20)
);

CREATE TABLE TipoMidiaDigital (
    cod int PRIMARY KEY,
    nome varchar (20)
);

CREATE TABLE Aluno (
    matricula varchar (30) PRIMARY KEY,
    cpf int (14),
    rg int (10),
    naturalidade varchar (30),
    nome_completo varchar (50),
    nome_mae varchar (50),
    endereco varchar (50),
    fone varchar (50),
    senha text
);

CREATE TABLE Curso (
    cod int PRIMARY KEY,
    nome varchar (50),
    area varchar (50),
    FK_TipoCurso_cod int
);

CREATE TABLE Ano (
    cod int,
    ano_letivo int (4),
    abv int (2),
    periodo int (1),
    PRIMARY KEY (cod, periodo)
);

CREATE TABLE TipoCurso (
    cod int PRIMARY KEY,
    nome varchar (20)
);

CREATE TABLE Agrega (
    FK_Perfil_cod int,
    FK_Permissao_tag varchar (5)
);

CREATE TABLE Emprestimo (
    FK_Aluno_matricula varchar (30),
    FK_Item_cod int,
    data_locacao datetime,
    data_entrega datetime,
    quant_renovacao int,
    emprestado int
);

CREATE TABLE Alocacao (
    FK_Curso_cod int,
    FK_Aluno_matricula varchar (30),
    FK_Ano_cod int,
    FK_Ano_periodo int (1)
);
 
ALTER TABLE Usuario ADD CONSTRAINT FK_Usuario_1
    FOREIGN KEY (FK_Perfil_cod)
    REFERENCES Perfil (cod)
    ON DELETE RESTRICT ON UPDATE CASCADE;
 
ALTER TABLE Item ADD CONSTRAINT FK_Item_1
    FOREIGN KEY (FK_TipoItem_cod)
    REFERENCES TipoItem (cod)
    ON DELETE RESTRICT ON UPDATE CASCADE;
 
ALTER TABLE Livro ADD CONSTRAINT FK_Livro_1
    FOREIGN KEY (FK_Item_cod)
    REFERENCES Item (cod)
    ON DELETE RESTRICT ON UPDATE CASCADE;
 
ALTER TABLE Revista ADD CONSTRAINT FK_Revista_1
    FOREIGN KEY (FK_Item_cod)
    REFERENCES Item (cod)
    ON DELETE RESTRICT ON UPDATE CASCADE;
 
ALTER TABLE Jornal ADD CONSTRAINT FK_Jornal_1
    FOREIGN KEY (FK_Item_cod)
    REFERENCES Item (cod)
    ON DELETE RESTRICT ON UPDATE CASCADE;
 
ALTER TABLE AnaisCongresso ADD CONSTRAINT FK_AnaisCongresso_1
    FOREIGN KEY (FK_Item_cod)
    REFERENCES Item (cod)
    ON DELETE RESTRICT ON UPDATE CASCADE;
 
ALTER TABLE AnaisCongresso ADD CONSTRAINT FK_AnaisCongresso_2
    FOREIGN KEY (FK_TipoAnaisCongresso_cod)
    REFERENCES TipoAnaisCongresso (cod)
    ON DELETE RESTRICT ON UPDATE CASCADE;
 
ALTER TABLE TrabalhoConclusao ADD CONSTRAINT FK_TrabalhoConclusao_1
    FOREIGN KEY (FK_Item_cod)
    REFERENCES Item (cod)
    ON DELETE RESTRICT ON UPDATE CASCADE;
 
ALTER TABLE TrabalhoConclusao ADD CONSTRAINT FK_TrabalhoConclusao_2
    FOREIGN KEY (FK_TipoTrabalhoConclusao_cod)
    REFERENCES TipoTrabalhoConclusao (cod)
    ON DELETE RESTRICT ON UPDATE CASCADE;
 
ALTER TABLE MidiaDigital ADD CONSTRAINT FK_MidiaDigital_1
    FOREIGN KEY (FK_Item_cod)
    REFERENCES Item (cod)
    ON DELETE RESTRICT ON UPDATE CASCADE;
 
ALTER TABLE MidiaDigital ADD CONSTRAINT FK_MidiaDigital_2
    FOREIGN KEY (FK_TipoMidiaDigital_cod)
    REFERENCES TipoMidiaDigital (cod)
    ON DELETE RESTRICT ON UPDATE CASCADE;
 
ALTER TABLE Curso ADD CONSTRAINT FK_Curso_1
    FOREIGN KEY (FK_TipoCurso_cod)
    REFERENCES TipoCurso (cod)
    ON DELETE RESTRICT ON UPDATE CASCADE;
 
ALTER TABLE Agrega ADD CONSTRAINT FK_Agrega_0
    FOREIGN KEY (FK_Perfil_cod)
    REFERENCES Perfil (cod)
    ON DELETE RESTRICT ON UPDATE CASCADE;
 
ALTER TABLE Agrega ADD CONSTRAINT FK_Agrega_1
    FOREIGN KEY (FK_Permissao_tag)
    REFERENCES Permissao (tag)
    ON DELETE RESTRICT ON UPDATE CASCADE;
 
ALTER TABLE Emprestimo ADD CONSTRAINT FK_Emprestimo_Aluno
    FOREIGN KEY (FK_Aluno_matricula)
    REFERENCES Aluno (matricula)
    ON DELETE RESTRICT ON UPDATE CASCADE;
 
ALTER TABLE Emprestimo ADD CONSTRAINT  FK_Emprestimo_Item
    FOREIGN KEY (FK_Item_cod)
    REFERENCES Item (cod)
    ON DELETE RESTRICT ON UPDATE CASCADE;
 
ALTER TABLE Alocacao ADD CONSTRAINT FK_Alocacao_0
    FOREIGN KEY (FK_Curso_cod)
    REFERENCES Curso (cod)
    ON DELETE RESTRICT ON UPDATE NO ACTION;
 
ALTER TABLE Alocacao ADD CONSTRAINT FK_Alocacao_1
    FOREIGN KEY (FK_Aluno_matricula)
    REFERENCES Aluno (matricula)
    ON DELETE RESTRICT ON UPDATE NO ACTION;
 
ALTER TABLE Alocacao ADD CONSTRAINT FK_Alocacao_2
    FOREIGN KEY (FK_Ano_cod, FK_Ano_periodo)
    REFERENCES Ano (cod, periodo)
    ON DELETE RESTRICT ON UPDATE RESTRICT;