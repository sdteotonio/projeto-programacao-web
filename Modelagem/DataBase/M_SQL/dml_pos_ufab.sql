--
-- Dumping data for table `perfil`
--
USE `db_biblioteca_ufab`;

LOCK TABLES `perfil` WRITE;

INSERT INTO `perfil` VALUES (1,'ADMINISTRADOR'),(2,'ALUNO');

UNLOCK TABLES;

--
-- Dumping data for table `tipocurso`
--

LOCK TABLES `tipocurso` WRITE;

INSERT INTO `tipocurso` VALUES (1,'Graduação'),(2,'Pós-Graduação');

UNLOCK TABLES;


LOCK TABLES `usuario` WRITE;

INSERT INTO `usuario` VALUES ('11772699454','2018-01-20 00:00:00','1996-10-10 00:00:00','Endereco Teste Adm','83 9 93162731','Brasileiro','Sergio Davi Marinho','38698399','teste',1);

UNLOCK TABLES;

INSERT INTO `administrador` (`usuario_cpf`) VALUES ('11772699454');
