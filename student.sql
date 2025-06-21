/*
SQLyog Ultimate v8.71 
MySQL - 8.0.13 : Database - student
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`student` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE `student`;

/*Table structure for table `enterprises` */

DROP TABLE IF EXISTS `enterprises`;

CREATE TABLE `enterprises` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `contact_info` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `enterprises` */

/*Table structure for table `studentinformation` */

DROP TABLE IF EXISTS `studentinformation`;

CREATE TABLE `studentinformation` (
  `stuid` int(11) NOT NULL AUTO_INCREMENT,
  `stuname` varchar(11) DEFAULT NULL,
  `stusex` varchar(2) DEFAULT NULL,
  `stuage` int(11) DEFAULT NULL,
  `stuphone` varchar(11) DEFAULT NULL,
  `imgpath` varchar(255) DEFAULT NULL,
  `grade` float DEFAULT NULL,
  `credit` float DEFAULT NULL,
  `gradepoint` float DEFAULT NULL,
  PRIMARY KEY (`stuid`)
) ENGINE=InnoDB AUTO_INCREMENT=1016 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `studentinformation` */

insert  into `studentinformation`(`stuid`,`stuname`,`stusex`,`stuage`,`stuphone`,`imgpath`,`grade`,`credit`,`gradepoint`) values (1001,'张三','男',18,'12345678910',NULL,70,2,1),(1002,'李四','男',19,'13612344321',NULL,85.5,2,2.55),(1003,'王五','女',19,'13912345678',NULL,80,2,2),(1004,'赵六','男',18,'12345678910',NULL,NULL,NULL,NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uname` varchar(20) NOT NULL,
  `upassword` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user` */

insert  into `user`(`uname`,`upassword`) values ('admin','123456'),('root','root'),('张三','654321');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
