-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.22


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema covidhospital
--

CREATE DATABASE IF NOT EXISTS covidhospital;
USE covidhospital;

--
-- Definition of table `covid_patients`
--

DROP TABLE IF EXISTS `covid_patients`;
CREATE TABLE `covid_patients` (
  `p_id` int(50) NOT NULL AUTO_INCREMENT,
  `p_first_name` varchar(50) NOT NULL,
  `p_last_name` varchar(50) NOT NULL,
  `p_email` varchar(50) DEFAULT NULL,
  `p_entry_date` date DEFAULT NULL,
  `p_covid_status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `covid_patients`
--

/*!40000 ALTER TABLE `covid_patients` DISABLE KEYS */;
INSERT INTO `covid_patients` (`p_id`,`p_first_name`,`p_last_name`,`p_email`,`p_entry_date`,`p_covid_status`) VALUES 
 (1,'Harry','Lahiri','harry@covid.com','2021-06-29',1),
 (2,'Amar','Patil','amar@gmail.com','2019-10-20',1),
 (17,'Cristiano','Ronaldo','cristiano@gmail.com','1990-12-10',1),
 (18,'Lionel','Messi','lionel@gmail.com','1990-10-14',0),
 (19,'Jeff','Bezos','jeff@amazon.com','2019-07-20',0);
/*!40000 ALTER TABLE `covid_patients` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
