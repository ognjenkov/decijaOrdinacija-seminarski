/*
SQLyog Community v13.3.0 (64 bit)
MySQL - 10.4.24-MariaDB : Database - decijaordinacija
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`decijaordinacija` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `decijaordinacija`;

/*Table structure for table `dete` */

DROP TABLE IF EXISTS `dete`;

CREATE TABLE `dete` (
  `idDete` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(50) NOT NULL,
  `datumRodjenja` date NOT NULL,
  PRIMARY KEY (`idDete`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `doktor` */

DROP TABLE IF EXISTS `doktor`;

CREATE TABLE `doktor` (
  `idDoktor` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `sifra` varchar(50) NOT NULL,
  PRIMARY KEY (`idDoktor`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `drsp` */

DROP TABLE IF EXISTS `drsp`;

CREATE TABLE `drsp` (
  `idDoktor` int(10) unsigned NOT NULL,
  `idSpecijalizacija` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idDoktor`,`idSpecijalizacija`),
  KEY `idSpecijalizacija` (`idSpecijalizacija`),
  CONSTRAINT `drsp_ibfk_1` FOREIGN KEY (`idDoktor`) REFERENCES `doktor` (`idDoktor`),
  CONSTRAINT `drsp_ibfk_2` FOREIGN KEY (`idSpecijalizacija`) REFERENCES `specijalizacija` (`idSpecijalizacija`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Table structure for table `lek` */

DROP TABLE IF EXISTS `lek`;

CREATE TABLE `lek` (
  `idLek` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) NOT NULL,
  `proizvodjac` varchar(50) NOT NULL,
  `aktivniSastojak` varchar(50) NOT NULL,
  `farmaceutskaGrupa` varchar(50) NOT NULL,
  PRIMARY KEY (`idLek`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `predskolskodete` */

DROP TABLE IF EXISTS `predskolskodete`;

CREATE TABLE `predskolskodete` (
  `idDete` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `grupa` varchar(50) NOT NULL,
  PRIMARY KEY (`idDete`),
  CONSTRAINT `predskolskodete_ibfk_1` FOREIGN KEY (`idDete`) REFERENCES `dete` (`idDete`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `recept` */

DROP TABLE IF EXISTS `recept`;

CREATE TABLE `recept` (
  `idRecept` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idDoktor` int(10) unsigned NOT NULL,
  `idDete` int(10) unsigned NOT NULL,
  `datumIzdavanja` date NOT NULL,
  `dijagnoza` varchar(50) NOT NULL,
  PRIMARY KEY (`idRecept`,`idDoktor`,`idDete`),
  KEY `idDoktor` (`idDoktor`),
  KEY `idDete` (`idDete`),
  CONSTRAINT `recept_ibfk_1` FOREIGN KEY (`idDoktor`) REFERENCES `doktor` (`idDoktor`),
  CONSTRAINT `recept_ibfk_2` FOREIGN KEY (`idDete`) REFERENCES `dete` (`idDete`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `skolskodete` */

DROP TABLE IF EXISTS `skolskodete`;

CREATE TABLE `skolskodete` (
  `idDete` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `odeljenje` varchar(50) NOT NULL,
  `razred` varchar(50) NOT NULL,
  PRIMARY KEY (`idDete`),
  CONSTRAINT `fk1` FOREIGN KEY (`idDete`) REFERENCES `dete` (`idDete`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `specijalizacija` */

DROP TABLE IF EXISTS `specijalizacija`;

CREATE TABLE `specijalizacija` (
  `idSpecijalizacija` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) NOT NULL,
  PRIMARY KEY (`idSpecijalizacija`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `stavkarecepta` */

DROP TABLE IF EXISTS `stavkarecepta`;

CREATE TABLE `stavkarecepta` (
  `idRecept` int(10) unsigned NOT NULL,
  `rb` int(10) unsigned NOT NULL,
  `idLek` int(10) unsigned NOT NULL,
  `terapija` varchar(500) NOT NULL,
  `zakljucak` varchar(500) NOT NULL,
  PRIMARY KEY (`idRecept`,`rb`,`idLek`),
  KEY `rb` (`rb`),
  KEY `idLek` (`idLek`),
  CONSTRAINT `stavkarecepta_ibfk_1` FOREIGN KEY (`idRecept`) REFERENCES `recept` (`idRecept`),
  CONSTRAINT `stavkarecepta_ibfk_2` FOREIGN KEY (`idLek`) REFERENCES `lek` (`idLek`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
