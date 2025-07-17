-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: solidarizacao
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cadastrodoacao`
--

DROP TABLE IF EXISTS `cadastrodoacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cadastrodoacao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `cep` varchar(20) DEFAULT NULL,
  `rua` varchar(255) DEFAULT NULL,
  `numero` varchar(20) DEFAULT NULL,
  `complemento` varchar(100) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mensagem` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cadastrodoacao`
--

LOCK TABLES `cadastrodoacao` WRITE;
/*!40000 ALTER TABLE `cadastrodoacao` DISABLE KEYS */;
INSERT INTO `cadastrodoacao` VALUES (1,'Ana Paula Silva','01001-000','Rua das Flores','123','Apto 12','Centro','São Paulo','SP','(11) 98345-6721','ana.silva92@gmail.com',NULL),(2,'João Pedro Lima','20040-010','Av. Atlântica','456','Bloco B','Copacabana','Rio de Janeiro','RJ','(21) 97412-3345','joao.lima88@yahoo.com.br',NULL),(3,'Mariana Oliveira Costa','30130-010','Rua da Bahia','789','Sala 5','Funcionários','Belo Horizonte','MG','(31) 98765-1234','mariana.costa@hotmail.com',NULL),(4,'Carlos Henrique Souza','60060-000','Av. Beira Mar','1010','Casa','Meireles','Fortaleza','CE','(85) 99642-7789','carlos.hsouza@gmail.com',NULL),(5,'Fernanda Rocha Mendes','80010-000','Rua XV de Novembro','202','Cobertura','Centro','Curitiba','PR','(41) 98831-2456','fernanda.mendes@outlook.com',NULL);
/*!40000 ALTER TABLE `cadastrodoacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `campanhas`
--

DROP TABLE IF EXISTS `campanhas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `campanhas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) DEFAULT NULL,
  `email_usuario` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campanhas`
--

LOCK TABLES `campanhas` WRITE;
/*!40000 ALTER TABLE `campanhas` DISABLE KEYS */;
/*!40000 ALTER TABLE `campanhas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doacoes`
--

DROP TABLE IF EXISTS `doacoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doacoes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_doador` int DEFAULT NULL,
  `roupas` int DEFAULT '0',
  `calcados` int DEFAULT '0',
  `livros` int DEFAULT '0',
  `brinquedos` int DEFAULT '0',
  `alimentos` int DEFAULT '0',
  `outro_item` varchar(100) DEFAULT NULL,
  `outro_qtd` int DEFAULT '0',
  `campanha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_doador` (`id_doador`),
  CONSTRAINT `doacoes_ibfk_1` FOREIGN KEY (`id_doador`) REFERENCES `cadastrodoacao` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doacoes`
--

LOCK TABLES `doacoes` WRITE;
/*!40000 ALTER TABLE `doacoes` DISABLE KEYS */;
INSERT INTO `doacoes` VALUES (1,1,5,0,0,0,3,'Cobertores',2,'Inverno Solidário 2025'),(2,2,0,2,3,0,4,NULL,NULL,'Doe Esperança RJ'),(3,3,3,0,0,4,0,NULL,NULL,'Natal para Todos'),(4,4,0,2,0,3,5,'Máscaras',10,'Fortaleza Solidária'),(5,5,2,1,5,0,0,NULL,NULL,'Educar é Cuidar');
/*!40000 ALTER TABLE `doacoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitacao_caixa`
--

DROP TABLE IF EXISTS `solicitacao_caixa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `solicitacao_caixa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `cep` varchar(9) NOT NULL,
  `rua` varchar(255) NOT NULL,
  `numero` int NOT NULL,
  `complemento` varchar(255) NOT NULL,
  `bairro` varchar(255) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `rede` varchar(255) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `quantidade_caixas` int NOT NULL,
  `itens_coleta` text,
  `outro_produto` varchar(255) DEFAULT NULL,
  `observacao` text,
  `data_solicitacao` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `campanha` varchar(255) DEFAULT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_fim` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitacao_caixa`
--

LOCK TABLES `solicitacao_caixa` WRITE;
/*!40000 ALTER TABLE `solicitacao_caixa` DISABLE KEYS */;
INSERT INTO `solicitacao_caixa` VALUES (1,'Ana Paula Silva','01001-000','Rua das Flores',123,'Apto 12','Centro','São Paulo','SP','Erion','(11) 98345-6721','ana.silva92@gmail.com',52,'Roupas, Alimentos','Cobertores','Solicitação urgente para famílias carentes','2025-07-09 03:00:00','Inverno Solidário 2025','2025-07-01','2025-08-15'),(2,'João Pedro Lima','20040-010','Av. Atlântica',456,'Bloco B','Copacabana','Rio de Janeiro','RJ','LOcal','88997926696','joao.lima88@yahoo.com.br',63,'Calçados, Livros, Alimentos','','','2025-07-05 17:00:33','Doe Esperança RJ','2025-08-05','2025-09-20'),(3,'Mariana Oliveira Costa','30130-010','Rua da Bahia',789,'Sala 5','Funcionários','Belo Horizonte','MG','Uece mombaca','88997926696','mariana.costa@hotmail.com',40,'Brinquedos, Roupas','','','2025-07-08 19:47:18','Natal para Todos','2025-11-01','2025-12-25'),(4,'Carlos Henrique Souza','60060-000','Av. Beira Mar',1010,'Casa','Meireles','Fortaleza','CE','Uece mombaca','88997926696','carlos.hsouza@gmail.com',69,'Calçados, Brinquedos, Alimentos','','','2025-07-08 19:50:46','Fortaleza Solidária','2025-02-12','2025-03-30'),(5,'Fernanda Rocha Mendes','80010-000','Rua XV de Novembro',202,'Cobertura','Centro','Curitiba','PR','Uece mombaca','88997926696','fernanda.mendes@outlook.com',35,'Livros, Roupas, Calçados','','','2025-07-08 19:52:07','Educar é Cuidar','2025-05-20','2025-07-01');
/*!40000 ALTER TABLE `solicitacao_caixa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Ana Paula Silva','ana.silva92@gmail.com','123456','(11) 98345-6721','São Paulo','SP'),(2,'João Pedro Lima','joao.lima88@yahoo.com.br','123456','(21) 97412-3345','Rio de Janeiro','RJ'),(3,'Mariana Oliveira Costa','mariana.costa@hotmail.com','123456','(31) 98765-1234','Belo Horizonte','MG'),(4,'Carlos Henrique Souza','carlos.hsouza@gmail.com','123456','(85) 99642-7789','Fortaleza','CE'),(5,'Fernanda Rocha Mendes','fernanda.mendes@outlook.com','123456','(41) 98831-2456','Curitiba','PR');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'solidarizacao'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-16 21:08:48
