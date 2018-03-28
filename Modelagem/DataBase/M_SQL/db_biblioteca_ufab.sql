/* RelacionalBibliotecaUFAB: */
CREATE DATABASE IF NOT EXISTS db_biblioteca_ufab;
USE db_biblioteca_ufab;

CREATE TABLE IF NOT EXISTS Usuario (
    matricula VARCHAR(30) PRIMARY KEY,
    nome VARCHAR(50),
    senha TEXT,
    data_nascimento DATETIME,
    data_cadastro DATETIME,
    FK_Perfil_cod INT
);

CREATE TABLE IF NOT EXISTS Perfil (
    cod INT PRIMARY KEY,
    nome VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS Permissao (
    tag VARCHAR(5) PRIMARY KEY,
    nome VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS Item (
    cod INT PRIMARY KEY,
    titulo VARCHAR(100) UNIQUE,
    quant_max_locacao INT,
    FK_TipoItem_cod INT
);

CREATE TABLE IF NOT EXISTS Livro (
    isbn VARCHAR(30),
    autor TEXT,
    editora VARCHAR(30),
    ano_publicacao DATETIME,
    edicao VARCHAR(30),
    nmr_pagina INT,
    area VARCHAR(30),
    tema TEXT,
    FK_Item_cod INT PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS Revista (
    editora VARCHAR(30),
    data_publicacao DATETIME,
    edicao VARCHAR(30),
    nmr_pagina INT,
    FK_Item_cod INT PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS Jornal (
    data DATETIME,
    edicao VARCHAR(30),
    FK_Item_cod INT PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS AnaisCongresso (
    autor VARCHAR(50),
    nome_congresso VARCHAR(50),
    ano_publicacao DATETIME,
    local VARCHAR(50),
    FK_Item_cod INT PRIMARY KEY,
    FK_TipoAnaisCongresso_cod INT
);

CREATE TABLE IF NOT EXISTS TipoItem (
    cod INT PRIMARY KEY,
    nome VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS TrabalhoConclusao (
    autor VARCHAR(50),
    orientador VARCHAR(50),
    ano_defesa DATETIME,
    local VARCHAR(50),
    FK_Item_cod INT PRIMARY KEY,
    FK_TipoTrabalhoConclusao_cod INT
);

CREATE TABLE IF NOT EXISTS MidiaDigital (
    data_gravacao DATETIME,
    FK_Item_cod INT PRIMARY KEY,
    FK_TipoMidiaDigital_cod INT
);

CREATE TABLE IF NOT EXISTS TipoAnaisCongresso (
    cod INT PRIMARY KEY,
    nome VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS TipoTrabalhoConclusao (
    cod INT PRIMARY KEY,
    nome VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS TipoMidiaDigital (
    cod INT PRIMARY KEY,
    nome VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS Aluno (
    matricula VARCHAR(30) PRIMARY KEY,
    cpf INT(14),
    rg INT(10),
    naturalidade VARCHAR(30),
    nome_completo VARCHAR(50),
    nome_mae VARCHAR(50),
    endereco VARCHAR(50),
    fone VARCHAR(50),
    senha TEXT
);

CREATE TABLE IF NOT EXISTS Curso (
    cod INT PRIMARY KEY,
    nome VARCHAR(50) UNIQUE,
    area VARCHAR(50),
    FK_TipoCurso_cod INT
);

CREATE TABLE IF NOT EXISTS Ano (
    cod INT,
    ano_letivo INT(4),
    abv INT(2),
    periodo INT(1),
    PRIMARY KEY (cod, periodo)
);

CREATE TABLE IF NOT EXISTS TipoCurso (
    cod INT PRIMARY KEY,
    nome VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS Agrega (
    FK_Perfil_cod INT,
    FK_Permissao_tag VARCHAR(5)
);

CREATE TABLE IF NOT EXISTS Emprestimo (
    FK_Aluno_matricula VARCHAR(30),
    FK_Item_cod INT,
    data_locacao DATETIME,
    data_entrega DATETIME,
    quant_renovacao INT,
    emprestado INT
);

CREATE TABLE IF NOT EXISTS Alocacao (
    FK_Curso_cod INT,
    FK_Aluno_matricula VARCHAR(30),
    FK_Ano_cod INT,
    FK_Ano_periodo INT(1)
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