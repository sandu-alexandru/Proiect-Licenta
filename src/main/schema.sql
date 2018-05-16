-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.24 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for quizzer
CREATE DATABASE IF NOT EXISTS `quizzer` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `quizzer`;
GRANT ALL ON quizzer.* TO 'quizzer'@'localhost' IDENTIFIED BY 'quizzer';

-- Dumping structure for table quizzer.user

-- ========================================== DDL =============================
DROP TABLE IF EXISTS user_attempts;
DROP TABLE IF EXISTS user;

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `domain` VARCHAR(50) NOT NULL,
  `first` VARCHAR(50) NOT NULL,
  `currentLevel` VARCHAR(50) NOT NULL,
  `last1` VARCHAR(50) NOT NULL,
  `last2` VARCHAR(50) NOT NULL,
  `last3` VARCHAR(50) NOT NULL,
  `accountNonExpired` INT NOT NULL DEFAULT 1,
  `accountNonLocked` INT NOT NULL DEFAULT 1,
  `credentialsNonExpired` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`)
);

/* create table user_attempts.sql */
CREATE TABLE `user_attempts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `attempts` int(2) NOT NULL,
  `lastModified` timestamp,
  `firstAttempt` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);


ALTER TABLE user_attempts ADD CONSTRAINT FK_user_usr_attempts FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE ON UPDATE CASCADE;


DROP TABLE IF EXISTS level1;
DROP TABLE IF EXISTS level2;
DROP TABLE IF EXISTS level3;
DROP TABLE IF EXISTS level4;
DROP TABLE IF EXISTS level5;
DROP TABLE IF EXISTS level6;
DROP TABLE IF EXISTS level7;

CREATE TABLE IF NOT EXISTS level1 (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` VARCHAR(50) NOT NULL,
  `question` VARCHAR(150) NOT NULL,
  `answer1` VARCHAR(150) NOT NULL,
  `answer2` VARCHAR(50) NOT NULL,
  `answer3` VARCHAR(50) NOT NULL,
  `correct` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS level2 (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` VARCHAR(50) NOT NULL,
  `question` VARCHAR(150) NOT NULL,
  `answer1` VARCHAR(150) NOT NULL,
  `answer2` VARCHAR(50) NOT NULL,
  `answer3` VARCHAR(50) NOT NULL,
  `correct` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS level3 (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` VARCHAR(50) NOT NULL,
  `question` VARCHAR(150) NOT NULL,
  `answer1` VARCHAR(150) NOT NULL,
  `answer2` VARCHAR(50) NOT NULL,
  `answer3` VARCHAR(50) NOT NULL,
  `correct` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS level4 (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` VARCHAR(50) NOT NULL,
  `question` VARCHAR(150) NOT NULL,
  `answer1` VARCHAR(150) NOT NULL,
  `answer2` VARCHAR(50) NOT NULL,
  `answer3` VARCHAR(50) NOT NULL,
  `correct` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS level5 (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` VARCHAR(50) NOT NULL,
  `question` VARCHAR(150) NOT NULL,
  `answer1` VARCHAR(150) NOT NULL,
  `answer2` VARCHAR(50) NOT NULL,
  `answer3` VARCHAR(50) NOT NULL,
  `correct` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS level6 (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` VARCHAR(50) NOT NULL,
  `question` VARCHAR(150) NOT NULL,
  `answer1` VARCHAR(150) NOT NULL,
  `answer2` VARCHAR(50) NOT NULL,
  `answer3` VARCHAR(50) NOT NULL,
  `correct` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS level7 (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` VARCHAR(50) NOT NULL,
  `question` VARCHAR(150) NOT NULL,
  `answer1` VARCHAR(150) NOT NULL,
  `answer2` VARCHAR(50) NOT NULL,
  `answer3` VARCHAR(50) NOT NULL,
  `correct` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS domain (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)
);

-- ========================================== DML =============================

insert into user values (10000, 'user', 'user', 'USER', 'ACTIVE','BIOLOGY','NO', '1', '0', '0', '0', 1, 1, 1);
insert into user values (10001, 'admin', 'admin', 'ADMIN', 'ACTIVE','BIOLOGY','NO', '2', '0', '0', '0', 1, 1, 1);
insert into user values (10003, 'player', 'player', 'ADMIN', 'ACTIVE','BIOLOGY','NO', '3', '0', '0', '0', 1, 1, 1);
insert into user values (10004, 'testing', 'testing8', 'USER', 'INACTIVE','GEOGRAPHY','NO', '1', '0', '0', '0', 1, 1, 1);

insert into domain values (1, 'BIOLOGY');
insert into domain values (2, 'HISTORY');
insert into domain values (3, 'GEOGRAPHY');

UPDATE user SET role="ADMIN" WHERE name="admin";
UPDATE user SET role="USER" WHERE name<>"admin";
UPDATE user SET status="INACTIVE" WHERE name="testing";
UPDATE user SET status="ACTIVE" WHERE name<>"testing";

-- TO GET QUESTIONS IN RANDOM ORDER WE USE
-- select * from table_name order by rand(), 1 limit the_limit

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
