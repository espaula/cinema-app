-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: cinema
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ator`
--

DROP TABLE IF EXISTS `ator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ator` (
  `idator` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary Key Tabela Ator',
  `nome_ator` varchar(45) NOT NULL COMMENT 'Nome do ator',
  `idade_ator` char(4) NOT NULL,
  PRIMARY KEY (`idator`),
  CONSTRAINT `fk_ator_escala` FOREIGN KEY (`idator`) REFERENCES `escala` (`id_ator_escala`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ator`
--

LOCK TABLES `ator` WRITE;
/*!40000 ALTER TABLE `ator` DISABLE KEYS */;
/*!40000 ALTER TABLE `ator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escala`
--

DROP TABLE IF EXISTS `escala`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `escala` (
  `idescala` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary Key Escala',
  `id_filme_escala` int(11) NOT NULL COMMENT 'Foreign Key tabela de filmes',
  `id_ator_escala` int(11) NOT NULL COMMENT 'Foreign Key tabela de atores',
  PRIMARY KEY (`idescala`),
  KEY `idx_id_filme_escala` (`id_filme_escala`),
  KEY `idx_id_ator_escala` (`id_ator_escala`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabela de escala de atores';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escala`
--

LOCK TABLES `escala` WRITE;
/*!40000 ALTER TABLE `escala` DISABLE KEYS */;
/*!40000 ALTER TABLE `escala` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `filme`
--

DROP TABLE IF EXISTS `filme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `filme` (
  `idFilme` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary Key Tabela Filme',
  `nome_filme` varchar(45) NOT NULL COMMENT 'Nome do Filme Produzido',
  `ano_producao` char(4) NOT NULL COMMENT 'Ano de Produção do Filme',
  PRIMARY KEY (`idFilme`),
  CONSTRAINT `fk_filme_escala` FOREIGN KEY (`idFilme`) REFERENCES `escala` (`id_filme_escala`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabela de Filmes Produzidos ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filme`
--

LOCK TABLES `filme` WRITE;
/*!40000 ALTER TABLE `filme` DISABLE KEYS */;
/*!40000 ALTER TABLE `filme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtora`
--

DROP TABLE IF EXISTS `produtora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produtora` (
  `idprodutora` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key Tabela Produtora',
  `produtora_nome` varchar(45) NOT NULL COMMENT 'Nome Produtora',
  PRIMARY KEY (`idprodutora`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabela de Cadastro das Produtoras';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtora`
--

LOCK TABLES `produtora` WRITE;
/*!40000 ALTER TABLE `produtora` DISABLE KEYS */;
/*!40000 ALTER TABLE `produtora` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-26 20:15:08
