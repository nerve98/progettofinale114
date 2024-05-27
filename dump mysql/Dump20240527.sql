CREATE DATABASE  IF NOT EXISTS `progettofinale` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `progettofinale`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: progettofinale
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `abbigliamento`
--

DROP TABLE IF EXISTS `abbigliamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abbigliamento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nomeAbbigliamento` varchar(255) DEFAULT NULL,
  `coloreAbbigliamento` varchar(255) DEFAULT NULL,
  `protezione` tinyint(1) DEFAULT NULL,
  `materiale` varchar(255) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `prezzo` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abbigliamento`
--

LOCK TABLES `abbigliamento` WRITE;
/*!40000 ALTER TABLE `abbigliamento` DISABLE KEYS */;
INSERT INTO `abbigliamento` VALUES (1,'Giacca Ducati corse-C6','Rosso',1,'100% poliestere','Ducati',720),(2,'Giacca in pelle-Company C4','nero/rosso',0,'Pelle bovina Moto-AR/Fodera fissa Tech Frame con inserti in tessuto 3D-Bubble','ducati',399),(3,'Giacca ducati desert C1','Bianco/argento/rosso',1,'Polyester/lana','Ducati',370),(4,'Stivali Moto Estivi Racing NEXUS 2 AIR','Nero/ Bianco/ Lava Rosso',1,'gomma/microfibra/tessuto D-Stone','Dainese',189.9),(5,'Stivali Moto Racing in Pelle 2.0 RACE-X EVO ',' Nero/ Bianco',1,'gomma/vera pelle/plastica','Berik',219),(6,'Stivali Bassi Moto Touring Alpinestars NEW LAND Drystar ','Nero',1,'membrana GORE-TEX/ tessuto','Honda',214.5),(7,'Pantaloni Moto In Pelle Racing RR PRO 2  ','Nero/rosso',1,'pelle bovina/nylon','Spidi ',455.91),(8,'Pantaloni Moto Donna Estivo  M-NJORD PT ','Grigio Chiaro/Blu Rosso',0,'Hard mesh + Poliestere ripstop + Mesh 4-way stretch','Ixon',305.99),(9,'Pantaloni da Donna Omologati Moto Pmj SPRING','deep black',0,'Stretch CORDURAÂ® Single Layer Technology','PMJ',170.1),(10,' Guanti Moto Racing In Pelle 2.0 195106 Pista','Bianco/Nero/Rosso fluo',1,'Pelle Bovina ','Berik',149),(11,'Guanti Moto in Pelle Custom FLORIDA','marrone',0,'Pelle','GMS',42.95),(12,'Guanti Moto Cross Enduro Mayhem Crank 2 Multi','Nero/multicolor',0,'tessuto/silicone','Oneal',34.99),(13,'Tuta Moto Intera in Pelle  GP FORCE CHASER','Rosso/Giallo/Fluo',1,'pelle/tessuto/nylon','alpinestars',925.95),(14,'Sottocasco Moto Tecnico CONFORT AIR','nero',0,'polyester','IXS',4.9),(15,'Sottotuta Moto Racing Estivo Tecnico STXL R BT ','Carbone/ Nero',0,'Tessuto BreezyTouch','Sixs',114.9),(16,'Tuta Antipioggia 2 Pezzi TWISTER RAIN','fluo/nero/giallo',0,'polyester','Hevik',49.9);
/*!40000 ALTER TABLE `abbigliamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `casco`
--

DROP TABLE IF EXISTS `casco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `casco` (
  `id` int NOT NULL AUTO_INCREMENT,
  `modello` varchar(255) DEFAULT NULL,
  `nomeCasco` varchar(255) DEFAULT NULL,
  `visieraOscurata` tinyint(1) DEFAULT NULL,
  `coloreCasco` varchar(255) DEFAULT NULL,
  `prezzo` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `casco`
--

LOCK TABLES `casco` WRITE;
/*!40000 ALTER TABLE `casco` DISABLE KEYS */;
INSERT INTO `casco` VALUES (1,'AGV Pista GP RR','Corsa',1,'Nero Opaco',899),(2,'Shoei X-Fourteen','Racin',1,'Rosso',799),(3,'Arai RX-7V','Supreme',1,'Blu Metallizzato',999),(4,'Shark Race-R Pro','Speeder',1,'Bianco Perlato',749),(5,'Shoei NXR 2 Nocturne TC-4','Touring',0,'Nero-Rosa',699),(6,'AGV K6','Sportivo',0,'Nero Opaco',499),(7,'X-803 Rs U.c. Hot Lap 015','Stealth',1,'Grigio carbone',999),(8,'Scorpion Exo-R1 Air','Fury',1,'Nero-Arancione',599),(9,'LS2 FF805 Thunder','Thunderbolt',1,'Argento',449),(10,'JORMUNGANDR','Ruroc',1,'Joker - nero',539);
/*!40000 ALTER TABLE `casco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `immagini`
--

DROP TABLE IF EXISTS `immagini`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `immagini` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `url` varchar(1000) DEFAULT NULL,
  `idMoto` int DEFAULT NULL,
  `idCasco` int DEFAULT NULL,
  `idAbbigliamento` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idAbbigliamento` (`idAbbigliamento`),
  KEY `idCasco` (`idCasco`),
  KEY `idMoto` (`idMoto`),
  CONSTRAINT `immagini_ibfk_1` FOREIGN KEY (`idAbbigliamento`) REFERENCES `abbigliamento` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `immagini_ibfk_2` FOREIGN KEY (`idCasco`) REFERENCES `casco` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `immagini_ibfk_3` FOREIGN KEY (`idMoto`) REFERENCES `moto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `immagini`
--

LOCK TABLES `immagini` WRITE;
/*!40000 ALTER TABLE `immagini` DISABLE KEYS */;
INSERT INTO `immagini` VALUES (1,'fotoProva','https://shop.ducati.com/media/catalog/product/cache/d737c4e9011f92407994a498031f753a/f/8/f8b0b020f0775dee79c831048e0689bf_16.jpg',NULL,NULL,1),(2,'fotoProva','https://shop.ducati.com/media/catalog/product/cache/d737c4e9011f92407994a498031f753a/2/c/2c4d3fee402740d278d1e156150f9ced.jpg',NULL,NULL,2),(3,'fotoProva','https://shop-ps.pogliani.com/52506-large_default/giacca-moto-da-uomo-edizione-limitata-originale-ducati-desert-c1-9810739.jpg',NULL,NULL,3),(4,'fotoProva','https://data.outletmoto.eu/imgprodotto/stivali-moto-estivi-racing-dainese-nexus-2-air-nero-bianco-lava-rosso_218737.jpg',NULL,NULL,4),(5,'foto','https://data.outletmoto.eu/imgprodotto/stivali-moto-racing-in-pelle-berik-2-0-race-x-evo-nero-nero-bianco_206138.jpg',NULL,NULL,5),(6,'foto','https://data.outletmoto.eu/imgprodotto/stivali-bassi-moto-touring-alpinestars-new-land-honda-drystar-nero_87740.jpg',NULL,NULL,6),(7,'foto','https://data.outletmoto.eu/imgprodotto/pantaloni-moto-in-pelle-racing-spidi-rr-pro-2-nero-rosso_97201.jpg',NULL,NULL,7),(8,'foto','https://data.outletmoto.eu/imgprodotto/pantaloni-moto-donna-estivo-ixon-m-njord-pt-l-grigio-chiaro-blu-rosso_219488.jpg',NULL,NULL,8),(9,'foto','https://data.outletmoto.eu/imgprodotto/pantaloni-da-donna-omologati-moto-pmj-spring-deep-black_230814.jpg',NULL,NULL,9),(10,'foto','https://data.outletmoto.eu/imgprodotto/guanti-moto-racing-in-pelle-berik-2-0-195106-pista-bianco-nero-rosso-fluo-certificato_207687.jpg',NULL,NULL,10),(11,'foto','https://data.outletmoto.eu/imgprodotto/guanti-moto-in-pelle-custom-gms-florida-marrone_137137.jpg',NULL,NULL,11),(12,'foto','https://data.outletmoto.eu/imgprodotto/guanti-moto-cross-enduro-oneal-mayhem-crank-2-multi_125522.jpg',NULL,NULL,12),(13,'foto','https://data.outletmoto.eu/imgprodotto/tuta-moto-intera-in-pelle-alpinestars-gp-force-chaser-1pc-fluo-rosso-bianco-nero_187828.jpg',NULL,NULL,13),(14,'foto','https://data.outletmoto.eu/imgprodotto/sottocasco-moto-tecnico-ixs-confort-air-nero_69434.jpg',NULL,NULL,14),(15,'foto','https://data.outletmoto.eu/imgprodotto/sottotuta-moto-racing-estivo-tecnico-sixs-stxl-r-bt-carbon-underwear-nero_127898.jpg',NULL,NULL,15),(16,'foto','https://data.outletmoto.eu/imgprodotto/tuta-antipioggia-2-pezzi-hevik-twister-rain-fluo-nero-giallo_241491.jpg',NULL,NULL,16),(17,'panigale 1','https://images.ctfassets.net/x7j9qwvpvr5s/4EJScwcBYLLxRmkQDOcgxH/9559c88116f87ed010401bc8c701c927/Panigale-MY22-Dinamica-33-Gallery-906x510-V02.jpg?fm=webp&q=90',1,NULL,NULL),(18,'panigale 2','https://images.ctfassets.net/x7j9qwvpvr5s/01MIxB7oOoqssOSRuwGlDR/c1bb62cea93c34427bc56fdfb377a235/Panigale-MY22-Dinamica-55-Gallery-906x510-V02.jpg?fm=webp&q=90',1,NULL,NULL),(19,'panigale 3','https://images.ctfassets.net/x7j9qwvpvr5s/30rkOpYRNZ1Qg5J0MNNqzH/0ea2cd6cbe95be068e57ad308e0a22ea/Panigale-MY22-Dinamica-35-Gallery-906x510-V02.jpg?fm=webp&q=90',1,NULL,NULL),(20,'h2r 1','https://www.designisthis.com/blog/images/uploads/2015/10/kawasaki-ninja-h2r-supercharged-motorcycle.jpg',2,NULL,NULL),(21,'h2r 2','https://www.procycles.com.au/cdn/shop/files/c83b76a5-5a35-4fea-b65f-a846f2e53b41.jpg?v=1688709671&width=1445',2,NULL,NULL),(22,'h2r 3','https://cdn.motori.it/l-Y5e_1kBHtOFZslailE24asMyU=/960x640/smart/https://www.motori.it/wp-content/uploads/2017/10/bg_17_ZX1000YHF_GY3_42595-1-fx2.jpg',2,NULL,NULL),(23,'s1k  1','https://www.wheelsmag.it/wp-content/uploads/2020/09/P90400311-highRes.jpg',3,NULL,NULL),(24,'s1k 2','https://images5.1000ps.net/images_bikekat/2023/7-BMW/3723-S_1000_RR/018-638000714150063814-bmw-s-1000-rr.jpg',3,NULL,NULL),(25,'s1k 3','https://img.remediosdigitales.com/ae053d/nueva-bmw-s-1000-rr-2023011/840_560.jpeg',3,NULL,NULL),(26,'r1 1','https://cdn2.yamaha-motor.eu/prod/product-assets/2024/YZF1000R1/2024-Yamaha-YZF1000R1-EU-Icon_Blue-Static-0499-01.jpg',4,NULL,NULL),(27,'r1 2','https://img1.motorradonline.de/Yamaha-R1-2023-GYTR-169FullWidth-e023d524-1934037.jpg',4,NULL,NULL),(28,'r1 3','https://cdn-listino.inmoto.it/2023/12/14/2024_YAM_YZF_1000_R1_EU_DPBMC_ACT_003_03_preview_max_Width_1500_max_Height_1500_ppi_300_quality_100_1ce396625e.jpg',4,NULL,NULL),(29,'rs 660 1','https://www.actumoto.ch/wp-content/uploads/2023/07/Aprilia_RS660_Extrema_foto_snap_shot17_actumoto.jpg',5,NULL,NULL),(30,'rs 660 2','https://cdn.motorhaber.com.tr/img/18/1716-b-2024-aprilia-rs-660-extrema-1716.jpg',5,NULL,NULL),(31,'rs 660 3','https://cdn-fastly.motorcycle.com/media/marketing_photos/2023/12/22/88159/social-44597479.jpg?size=1200x628',5,NULL,NULL),(32,'bn 1','https://i.ibb.co/jLyLNbM/MG-0369.jpg',6,NULL,NULL),(33,'bn 2','https://i.ibb.co/fGbr4S5/MG-0410.jpg',6,NULL,NULL),(34,'bn 3','https://i.ibb.co/jkVrLmK/MG-0300.jpg',6,NULL,NULL),(35,'casco AGV PISTA','https://www.motostorm.it/images/products/large/caschi_integrali/hjc_rpha1_neromatt.jpg',NULL,1,NULL),(36,'casco Shoei X-Fourteen','https://images.motocard.com/eyJidWNrZXQiOiJtb3RvY2FyZCIsImtleSI6InByb2R1Y3RzL2ltYWdlcy8yMDAyMi9zaG9laS1ueHJfMl9yZWQtMC1NLTIwMDIyMTI5MjkuanBnIiwiZWRpdHMiOnsid2VicCI6eyJxdWFsaXR5Ijo4NX0sImpwZWciOnsicXVhbGl0eSI6OTF9LCJyZXNpemUiOnsid2lkdGgiOjExMDAsImhlaWdodCI6MTEwMCwiZml0IjoiY292ZXIifX0sInYiOiJkNDFkOGNkOThmMDBiMjA0ZTk4MDA5OThlY2Y4NDI3ZSJ9',NULL,2,NULL),(37,'casco arai rx-7v ','https://images.motocard.com/eyJidWNrZXQiOiJtb3RvY2FyZCIsImtleSI6InByb2R1Y3RzL2ltYWdlcy8yMDEyNy9oamMtcnBoYV8xMl9ibHVlX21hdHRfMTI4NTM1MDUtMS1NLTIwMTI3NDQ3MjkuanBnIiwiZWRpdHMiOnsid2VicCI6eyJxdWFsaXR5Ijo4NX0sImpwZWciOnsicXVhbGl0eSI6OTF9LCJyZXNpemUiOnsid2lkdGgiOjExMDAsImhlaWdodCI6MTEwMCwiZml0IjoiY292ZXIifX0sInYiOiJkNDFkOGNkOThmMDBiMjA0ZTk4MDA5OThlY2Y4NDI3ZSJ9',NULL,3,NULL),(38,'casco Shark Race-R Pro ','https://data.outletmoto.eu/imgprodotto/casco-moto-integrale-shark-race-r-pro-bianco_16756_zoom.jpg',NULL,4,NULL),(39,'casco NXR 2 Nocturne TC-4','https://images.motocard.com/eyJidWNrZXQiOiJtb3RvY2FyZCIsImtleSI6InByb2R1Y3RzL2ltYWdlcy8yMDAyMi9zaG9laS1ueHJfMl9ub2N0dXJuZV90Y183LTAtTS0yMDAyMjEyOTY0LmpwZyIsImVkaXRzIjp7IndlYnAiOnsicXVhbGl0eSI6ODV9LCJqcGVnIjp7InF1YWxpdHkiOjkxfSwicmVzaXplIjp7IndpZHRoIjo1NTAsImhlaWdodCI6NTUwLCJmaXQiOiJjb3ZlciJ9fSwidiI6ImQ0MWQ4Y2Q5OGYwMGIyMDRlOTgwMDk5OGVjZjg0MjdlIn0=',NULL,5,NULL),(40,'casco agv k6','https://www.motostorm.it/images/products/large/caschi_integrali/shoei_nxr_2_neromatt.jpg',NULL,6,NULL),(41,'casco X-803 Rs U.c. Hot Lap 015 ','https://www.fuorigiriweb.it/images/variante/650x/X803RS-UC-HOT-LAP-Carbon-15_ml.jpg',NULL,7,NULL),(42,'casco Scorpion Exo-R1 Air','https://www.tradeinn.com/f/14054/140546435/scorpion-casco-integrale-exo-1400-evo-ii-air-luma.jpg',NULL,8,NULL),(43,'casco LS2 FF327 Challenger','https://cdn.motoabbigliamento.it/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/c/a/casco_integrale_ls2_ff805_thunder_c_volt_in_carbonio_nero_lucido_grigio.jpg',NULL,9,NULL),(44,'ruroc joker','https://www.ruroc.com/media/catalog/product/j/o/jormungandr_3_1.jpg?optimize=high&fit=bounds&height=&width=&canvas=:',NULL,10,NULL);
/*!40000 ALTER TABLE `immagini` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `moto`
--

DROP TABLE IF EXISTS `moto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `moto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cilindrata` int DEFAULT NULL,
  `potenzaCV` int DEFAULT NULL,
  `potenzaKV` int DEFAULT NULL,
  `elettronico` tinyint(1) DEFAULT NULL,
  `capacitaSerbatoio` int DEFAULT NULL,
  `peso` double DEFAULT NULL,
  `altezzaSella` double DEFAULT NULL,
  `trasmissioneM` tinyint(1) DEFAULT NULL,
  `annoProduzione` int DEFAULT NULL,
  `consumo` double DEFAULT NULL,
  `prezzo` double DEFAULT NULL,
  `euro` varchar(10) DEFAULT NULL,
  `nomeMotore` varchar(50) DEFAULT NULL,
  `marca` varchar(50) DEFAULT NULL,
  `tipoMoto` enum('sportiva','cross','scooter') DEFAULT NULL,
  `coloreMoto` varchar(255) DEFAULT NULL,
  `targa` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moto`
--

LOCK TABLES `moto` WRITE;
/*!40000 ALTER TABLE `moto` DISABLE KEYS */;
INSERT INTO `moto` VALUES (1,1100,228,158,1,17,192,85,1,2024,7.6,26300,'Euro5',' Panigale-V4','Ducati','sportiva','rosso-Ducati','GA114MG'),(2,998,310,228,1,17,216,83,1,2023,15,56000,'Euro5','H2R','Kawasaki','sportiva','Nera - Verde','CP85411'),(3,999,210,154,1,16,210,82,1,2024,6.4,26000,'Euro5','S-1000-RR','BMW','sportiva','Light White/M Motorsport','FJ27234'),(4,998,200,147,1,17,201,85,1,2022,6.8,20700,'Euro5','YZF-R1','Yamaha','sportiva','Icon Blue','EW28354'),(5,659,100,74,1,15,180,82,1,2024,4.9,13500,'Euro5','RS 660','Aprilia','sportiva','CHECKERED FLAG','rs66096'),(6,125,11,8,1,14,142,78,1,2020,1.7,2700,'Euro5','bn','benelli','sportiva','bianca - rossa','TJ93854');
/*!40000 ALTER TABLE `moto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `numeroCellulare` varchar(10) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `cognome` varchar(50) DEFAULT NULL,
  `dataNascita` date DEFAULT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (1,'admin','admin','3478596104','admin.114@gmail.com','pino','pane','2000-03-09',1),(2,'user','user','3241562489','user.114@gmail.com','gio','ele','1998-09-01',0),(3,'michelone','pippo',NULL,'michele@gmail.com','michele','bonafede','2003-04-08',0);
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-27 17:50:51
