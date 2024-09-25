-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: bhdb
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area` (
  `id` int NOT NULL AUTO_INCREMENT,
  `city` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `district` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES (1,'TP HCM','Quận 1'),(2,'TP HCM','Quận 2'),(3,'TP HCM','Quận 3'),(4,'TP HCM','Quận 4'),(5,'TP HCM','Quận 5'),(6,'TP HCM','Quận 6'),(7,'TP HCM','Quận 7'),(8,'TP HCM','Quận 8'),(9,'TP HCM','Quận 9'),(10,'TP HCM','Quận 10'),(11,'TP HCM','Quận 11'),(12,'TP HCM','Quận 12'),(13,'TP HCM','Quận Bình Tân'),(14,'TP HCM','Quận Bình Thạnh'),(15,'TP HCM','Quận Gò Vấp'),(16,'TP HCM','Quận Phú Nhuận'),(17,'TP HCM','Quận Tân Bình'),(18,'TP HCM','Quận Tân Phú'),(19,'TP HCM','Quận Thủ Đức'),(20,'TP HCM','Huyện Bình Chánh'),(21,'TP HCM','Huyện Cần Giờ'),(22,'TP HCM','Huyện Củ Chi'),(23,'TP HCM','Huyện Hóc Môn'),(24,'TP HCM','Huyện Nhà Bè'),(25,'Hà Nội','Quận Ba Đình'),(26,'Hà Nội','Quận Hoàn Kiếm'),(27,'Hà Nội','Quận Tây Hồ'),(28,'Hà Nội','Quận Long Biên'),(29,'Hà Nội','Quận Cầu Giấy'),(30,'Hà Nội','Quận Đống Đa'),(31,'Hà Nội','Quận Hai Bà Trưng'),(32,'Hà Nội','Quận Hoàng Mai'),(33,'Hà Nội','Quận Thanh Xuân'),(34,'Hà Nội','Huyện Sóc Sơn'),(35,'Hà Nội','Huyện Đông Anh'),(36,'Hà Nội','Huyện Gia Lâm'),(37,'Hà Nội','Huyện Thanh Trì'),(38,'Hà Nội','Huyện Mê Linh'),(39,'Hà Nội','Huyện Hoài Đức'),(40,'Hà Nội','Huyện Đan Phượng'),(41,'Hà Nội','Huyện Phúc Thọ'),(42,'Hà Nội','Huyện Thạch Thất'),(43,'Hà Nội','Huyện Quốc Oai'),(44,'Hà Nội','Huyện Chương Mỹ'),(45,'Hà Nội','Huyện Thanh Oai'),(46,'Hà Nội','Huyện Thường Tín'),(47,'Hà Nội','Huyện Phú Xuyên'),(48,'Hà Nội','Huyện Ứng Hòa');
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `post_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `post_id` (`post_id`),
  KEY `comment_ibfk_2_idx` (`user_id`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`) ON DELETE CASCADE,
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,'ádasd','2024-06-20 23:38:11',3,6),(2,'Trọ đẹp còn không ','2024-06-20 23:38:12',3,6),(3,'ABC','2024-06-20 23:38:20',3,6),(4,'ABC','2024-06-20 23:38:21',3,6),(5,'ABC','2024-06-20 23:38:22',3,6),(6,'adsasd','2024-06-20 23:38:23',3,6),(7,'ádasd','2024-06-20 23:38:42',3,6),(8,'adssad','2024-06-20 23:38:50',3,6),(9,'adsadsad','2024-06-20 23:38:51',3,6),(10,'ádsadas','2024-06-20 23:38:54',3,6),(11,'Bạn còn cần thuê trọ không?','2024-06-21 11:02:18',16,7);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_post`
--

DROP TABLE IF EXISTS `customer_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_post` (
  `id` int NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `customer_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_post_ibfk_2` (`customer_id`),
  CONSTRAINT `customer_post_ibfk_1` FOREIGN KEY (`id`) REFERENCES `post` (`id`) ON DELETE CASCADE,
  CONSTRAINT `customer_post_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_post`
--

LOCK TABLES `customer_post` WRITE;
/*!40000 ALTER TABLE `customer_post` DISABLE KEYS */;
INSERT INTO `customer_post` VALUES (9,'123 Nguyễn Trãi, Phường 2, Quận 5, TP. Hồ Chí Minh',7),(10,'456 Lê Văn Sỹ, Phường 13, Quận 3, TP. Hồ Chí Minh',7),(12,'789 Cách Mạng Tháng Tám, Phường 5, Quận 10, TP. Hồ Chí Minh',8),(14,'1011 Hùng Vương, Phường 9, Quận 5, TP. Hồ Chí Minh',7),(16,'200 Nguyễn Trãi, Phường Thanh Xuân Trung, Quận Thanh Xuân, TP. Hà Nội',8),(18,'300 Lê Văn Lương, Phường Nhân Chính, Quận Thanh Xuân, TP. Hà Nội',8),(20,'1617 Cách Mạng Tháng Tám, Phường 10, Quận 3, TP. Hồ Chí Minh',8),(22,'1819 Lý Thường Kiệt, Phường 14, Quận 10, TP. Hồ Chí Minh',9),(24,'2021 Nguyễn Trãi, Phường 1, Quận 5, TP. Hồ Chí Minh',7),(26,'100 Hoàng Quốc Việt, Phường Nghĩa Tân, Quận Cầu Giấy, TP. Hà Nội',10);
/*!40000 ALTER TABLE `customer_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `id` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `customers_ibfk_1` FOREIGN KEY (`id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (6),(7),(8),(9),(10),(19),(29);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `follow`
--

DROP TABLE IF EXISTS `follow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `follow` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int DEFAULT NULL,
  `lessor_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `lessor_id` (`lessor_id`),
  KEY `follow_ibfk_1` (`customer_id`),
  CONSTRAINT `follow_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`) ON DELETE CASCADE,
  CONSTRAINT `follow_ibfk_2` FOREIGN KEY (`lessor_id`) REFERENCES `lessor` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follow`
--

LOCK TABLES `follow` WRITE;
/*!40000 ALTER TABLE `follow` DISABLE KEYS */;
INSERT INTO `follow` VALUES (21,6,3);
/*!40000 ALTER TABLE `follow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `images`
--

DROP TABLE IF EXISTS `images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `images` (
  `id` int NOT NULL AUTO_INCREMENT,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `lessor_id` int DEFAULT NULL,
  `post_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_images_lessor` (`lessor_id`),
  KEY `FK_images_post` (`post_id`),
  CONSTRAINT `FK_images_lessor` FOREIGN KEY (`lessor_id`) REFERENCES `lessor` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_images_post` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `images`
--

LOCK TABLES `images` WRITE;
/*!40000 ALTER TABLE `images` DISABLE KEYS */;
INSERT INTO `images` VALUES (1,'https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327212/BoardingHouse/Images_BH/yi2hfk7srphw4lzt7jgs.jpg',11,NULL),(2,'https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327212/BoardingHouse/Images_BH/yi2hfk7srphw4lzt7jgs.jpg',11,NULL),(3,'https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327212/BoardingHouse/Images_BH/yi2hfk7srphw4lzt7jgs.jpg',11,3),(4,'https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327212/BoardingHouse/Images_BH/yi2hfk7srphw4lzt7jgs.jpg',3,NULL),(5,'https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327212/BoardingHouse/Images_BH/yi2hfk7srphw4lzt7jgs.jpg',3,NULL),(6,'https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327212/BoardingHouse/Images_BH/yi2hfk7srphw4lzt7jgs.jpg',3,NULL),(7,'https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327212/BoardingHouse/Images_BH/ptbjaozt1bovgj4z5zxm.jpg',NULL,7),(8,'https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327212/BoardingHouse/Images_BH/w1umtsqhoobxbdlay8wv.jpg',NULL,8),(9,'https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327212/BoardingHouse/Images_BH/ptbjaozt1bovgj4z5zxm.jpg',NULL,17),(10,'https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327212/BoardingHouse/Images_BH/w1umtsqhoobxbdlay8wv.jpg',NULL,19),(11,'https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327212/BoardingHouse/Images_BH/w1umtsqhoobxbdlay8wv.jpg',NULL,21),(12,'https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327212/BoardingHouse/Images_BH/ptbjaozt1bovgj4z5zxm.jpg',NULL,23),(13,'https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327212/BoardingHouse/Images_BH/w1umtsqhoobxbdlay8wv.jpg',NULL,25),(14,'https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327212/BoardingHouse/Images_BH/ptbjaozt1bovgj4z5zxm.jpg',12,NULL),(15,'https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327212/BoardingHouse/Images_BH/w1umtsqhoobxbdlay8wv.jpg',12,NULL),(16,'https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327212/BoardingHouse/Images_BH/ptbjaozt1bovgj4z5zxm.jpg',12,NULL),(17,'https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327212/BoardingHouse/Images_BH/w1umtsqhoobxbdlay8wv.jpg',13,NULL),(18,'https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327212/BoardingHouse/Images_BH/ptbjaozt1bovgj4z5zxm.jpg',13,NULL),(19,'https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327212/BoardingHouse/Images_BH/ptbjaozt1bovgj4z5zxm.jpg',13,NULL),(20,'https://res.cloudinary.com/dsbkju7j9/image/upload/v1718986334/igdaefrviuvu6mj3jts7.png',48,NULL),(21,'https://res.cloudinary.com/dsbkju7j9/image/upload/v1718986336/zzpaesarjtuu9zrz1llv.png',48,NULL),(22,'https://res.cloudinary.com/dsbkju7j9/image/upload/v1718986338/ufsdkmfx2cojrcybkm8s.png',48,NULL);
/*!40000 ALTER TABLE `images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lessor`
--

DROP TABLE IF EXISTS `lessor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lessor` (
  `id` int NOT NULL,
  `CCCD` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `lessor_ibfk_1` FOREIGN KEY (`id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lessor`
--

LOCK TABLES `lessor` WRITE;
/*!40000 ALTER TABLE `lessor` DISABLE KEYS */;
INSERT INTO `lessor` VALUES (3,'1231'),(11,'1123123'),(12,'12312'),(13,'123112'),(14,'1321231'),(15,'1231443543'),(47,'091231031123'),(48,'09412030023'),(49,'0941231241123');
/*!40000 ALTER TABLE `lessor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lessor_post`
--

DROP TABLE IF EXISTS `lessor_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lessor_post` (
  `id` int NOT NULL,
  `price` float NOT NULL,
  `longitude` decimal(10,6) DEFAULT NULL,
  `latitude` decimal(10,6) DEFAULT NULL,
  `quantity` int NOT NULL,
  `area_id` int DEFAULT NULL,
  `location` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `lessor_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `lessor_post_ibfk_2` (`lessor_id`),
  KEY `FK_area_id` (`area_id`),
  CONSTRAINT `FK_area_id` FOREIGN KEY (`area_id`) REFERENCES `area` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `lessor_post_ibfk_1` FOREIGN KEY (`id`) REFERENCES `post` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `lessor_post_ibfk_2` FOREIGN KEY (`lessor_id`) REFERENCES `lessor` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lessor_post`
--

LOCK TABLES `lessor_post` WRITE;
/*!40000 ALTER TABLE `lessor_post` DISABLE KEYS */;
INSERT INTO `lessor_post` VALUES (3,2000000,106.708300,10.769100,5,48,'CMT8',3),(7,2500000,106.690894,10.763918,2,1,'Nguyễn Trãi',11),(8,1800000,106.687678,10.772647,3,26,'Trần Hưng Đạo',12),(11,3000000,106.673595,10.767858,1,39,'Lê Văn Lương',13),(13,2200000,106.683264,10.757055,4,4,'Nguyễn Văn Cừ',14),(15,3500000,108.229534,16.059334,2,5,'Hàm Nghi',15),(17,2800000,105.854307,21.027764,3,6,'Trần Hưng Đạo',13),(19,1500000,106.691844,10.764982,1,1,'Nguyễn Trãi',11),(21,4000000,106.688528,10.773587,2,26,'Trần Hưng Đạo',12),(23,2000000,106.674445,10.768708,3,30,'Lê Văn Lương',15),(25,2700000,106.684114,10.758005,4,4,'Nguyễn Văn Cừ',14);
/*!40000 ALTER TABLE `lessor_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,'Nhà trọ CMT8','Nhà trọ nhiều tiện nghi gần các trung tâm thương mại','2024-04-30 22:39:41'),(2,'Nhà trọ NHT','Gần trường đại học TDT với OU','2024-04-30 22:39:41'),(3,'Nhà trọ LVL','Gần OU ','2024-04-30 22:39:41'),(4,'Cần tìm trọ rẻ','Tìm trọ cho sinh viên giá rẻ khu vực gần đại học Mở','2024-04-30 22:39:41'),(5,'Tìm trọ gần trường','Tìm trọ cho sinh viên khu vực gần đại học Mở và Tôn Đức Thắng yêu cầu an ninh, sạch, ở được 3 người','2024-04-30 22:39:41'),(6,'Tìm trọ an ninh ','Cần tìm khu vực an ninh, giờ giấc tự do, thuận tiền đi qua các quận ','2024-04-30 22:39:41'),(7,'Cho thuê trọ gần Đại học Bách Khoa','Phòng trọ khép kín, đầy đủ tiện nghi, gần Đại học Bách Khoa','2024-04-30 23:39:34'),(8,'Cho thuê phòng trọ giá rẻ','Phòng trọ sạch sẽ, thoáng mát','2024-04-30 23:39:34'),(9,'Tìm người ở ghép','Tìm người ở ghép chung phòng','2024-04-30 23:39:34'),(10,'Cần tìm phòng trọ gần chợ','Cần tìm phòng trọ gần chợ, giá dưới 2 triệu/tháng','2024-04-30 23:39:34'),(11,'Cho thuê phòng trọ cao cấp','Phòng trọ cao cấp, đầy đủ tiện nghi','2024-04-30 23:39:34'),(12,'Tìm người share phòng','Tìm người share phòng','2024-04-30 23:39:34'),(13,'Cho thuê phòng trọ gần trường học','Phòng trọ gần trường học','2024-04-30 23:39:34'),(14,'Cần tìm phòng trọ giá rẻ','Cần tìm phòng trọ giá rẻ, dưới 1 triệu/tháng','2024-04-30 23:39:34'),(15,'Cho thuê phòng trọ khép kín','Phòng trọ khép kín, đầy đủ tiện nghi','2024-04-30 23:39:34'),(16,'Tìm người ở ghép chung phòng','Tìm người ở ghép chung phòng','2024-04-30 23:39:34'),(17,'Cho thuê phòng trọ gần trung tâm','Phòng trọ gần trung tâm','2024-04-30 23:39:34'),(18,'Cần tìm phòng trọ rộng rãi','Cần tìm phòng trọ rộng rãi, giá dưới 2.5 triệu/tháng','2024-04-30 23:39:34'),(19,'Cho thuê phòng trọ đầy đủ nội thất','Phòng trọ đầy đủ nội thất','2024-04-30 23:39:34'),(20,'Tìm người share phòng giá rẻ','Tìm người share phòng giá rẻ, dưới 1 triệu/người','2024-04-30 23:39:34'),(21,'Cho thuê phòng trọ gần công viên','Phòng trọ gần công viên','2024-04-30 23:39:34'),(22,'Cần tìm phòng trọ yên tĩnh','Cần tìm phòng trọ yên tĩnh, giá dưới 1.8 triệu/tháng','2024-04-30 23:39:34'),(23,'Cho thuê phòng trọ có ban công','Phòng trọ có ban công','2024-04-30 23:39:34'),(24,'Tìm người ở ghép chung nhà','Tìm người ở ghép chung nhà','2024-04-30 23:39:34'),(25,'Cho thuê phòng trọ có chỗ để xe','Phòng trọ có chỗ để xe','2024-04-30 23:39:34'),(26,'Cần tìm phòng trọ thoáng mát','Cần tìm phòng trọ thoáng mát, giá dưới 1.6 triệu/tháng','2024-04-30 23:39:34');
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `first_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `role` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `isActived` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (3,'tonghiep11','$2a$12$lmLeox857119Kz6oRzwtbO1WbHhWcKdxx9mBkCVtGVdbTeV2y1z7a','Hiep','Trinh','https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327228/BoardingHouse/Image_avt/iwluu8bmrfben6oryra2.webp','2022-05-27 22:17:55','tonghiep22@gmail.com','724/44 Lê Văn Lương','0212345678','ROLE_LESSOR',1),(6,'tonghiep1','$2a$12$/M.nLCmqIfBJ0cVzJnAGfe2qsbIxUVtXtEa3zagTaUFZDJI/6Qv3G','Tông','Hiệp 1','https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327343/BoardingHouse/Image_avt/yuq6gjzqjnol8fsnqynb.jpg','2022-06-30 23:28:37','tonghiep22@gmail.com','724/44 Lê Văn Lương','0312345678','ROLE_USER',0),(7,'tonghiep2','$2a$12$/M.nLCmqIfBJ0cVzJnAGfe2qsbIxUVtXtEa3zagTaUFZDJI/6Qv3G','Tông','Hiệp 2','https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327227/BoardingHouse/Image_avt/fly0xp3n6dpveqxh4wpv.jpg','2024-04-29 23:28:37','tonghiep25@gmail.com','724/44 Lê Văn Lương','0412345678','ROLE_USER',0),(8,'tonghiep3','$2a$12$/M.nLCmqIfBJ0cVzJnAGfe2qsbIxUVtXtEa3zagTaUFZDJI/6Qv3G','Tông','Hiệp 3','https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327227/BoardingHouse/Image_avt/fly0xp3n6dpveqxh4wpv.jpg','2024-05-20 23:28:37','tonghiep25@gmail.com','724/44 Lê Văn Lương','05123456789','ROLE_USER',0),(9,'tonghiep4','$2a$12$/M.nLCmqIfBJ0cVzJnAGfe2qsbIxUVtXtEa3zagTaUFZDJI/6Qv3G','Tông','Hiệp 4','https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327227/BoardingHouse/Image_avt/fly0xp3n6dpveqxh4wpv.jpg','2024-04-10 23:28:37','tonghiep666@gmail.com','724/44 Lê Văn Lương, Phước Kiển, Nhà Bè','06123456789','ROLE_USER',0),(10,'tonghiep5','$2a$12$/M.nLCmqIfBJ0cVzJnAGfe2qsbIxUVtXtEa3zagTaUFZDJI/6Qv3G','Tông','Hiệp 5','https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327227/BoardingHouse/Image_avt/fly0xp3n6dpveqxh4wpv.jpg','2024-03-12 23:28:37','tonghiep666@gmail.com','724/44 Lê Văn Lương, Phước Kiển, Nhà Bè','07123456789','ROLE_USER',0),(11,'tonghiep6','$2a$12$/M.nLCmqIfBJ0cVzJnAGfe2qsbIxUVtXtEa3zagTaUFZDJI/6Qv3G','Tông','Hiệp 6','https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327227/BoardingHouse/Image_avt/fly0xp3n6dpveqxh4wpv.jpg','2024-01-21 23:28:37','hiepdata30tb@gmail.com','172 Nguyễn Văn Công , Phường 3, Gò Vấp','0812345678','ROLE_LESSOR',1),(12,'tonghiep7','$2a$12$/M.nLCmqIfBJ0cVzJnAGfe2qsbIxUVtXtEa3zagTaUFZDJI/6Qv3G','Tông','Hiệp 7','https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327228/BoardingHouse/Image_avt/ofzsonzveqtoiwhtsuds.jpg','2023-04-10 23:28:37','2151050138hiep@ou.edu.vn','174 Nguyễn Văn Công , Phường 3, Gò Vấp','09123456789','ROLE_LESSOR',0),(13,'tonghiep8','$2a$12$/M.nLCmqIfBJ0cVzJnAGfe2qsbIxUVtXtEa3zagTaUFZDJI/6Qv3G','Tông','Hiệp 8','https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327228/BoardingHouse/Image_avt/iwluu8bmrfben6oryra2.webp','2023-03-19 23:28:37','tonghiep666@gmail.com','176 Nguyễn Văn Công , Phường 3, Gò Vấp','1012345678','ROLE_LESSOR',0),(14,'tonghiep9','$2a$12$/M.nLCmqIfBJ0cVzJnAGfe2qsbIxUVtXtEa3zagTaUFZDJI/6Qv3G','Tông','Hiệp 9','https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327228/BoardingHouse/Image_avt/ofzsonzveqtoiwhtsuds.jpg','2022-01-22 23:28:37','2151050138hiep@ou.edu.vn','100 Cộng Hòa, Tân Bình','11123456789','ROLE_LESSOR',0),(15,'tonghiep10','$2a$12$/M.nLCmqIfBJ0cVzJnAGfe2qsbIxUVtXtEa3zagTaUFZDJI/6Qv3G','Tông','Hiệp 10','https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327228/BoardingHouse/Image_avt/ofzsonzveqtoiwhtsuds.jpg','2024-02-15 23:28:37','hiepdata30tb@gmail.com','103 Cộng Hòa, Tân Bình','1212345678','ROLE_LESSOR',0),(16,'hiep','$2a$12$lmLeox857119Kz6oRzwtbO1WbHhWcKdxx9mBkCVtGVdbTeV2y1z7a','Hiep','Admin','https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327228/BoardingHouse/Image_avt/ofzsonzveqtoiwhtsuds.jpg','2024-09-15 23:28:37','2151050138hiep@ou.edu.vn','Khu dân cư Nhơn Đức, Nhà Bè','0383876057','ROLE_ADMIN',1),(18,'tonghiep123','$2a$12$lmLeox857119Kz6oRzwtbO1WbHhWcKdxx9mBkCVtGVdbTeV2y1z7a','hiep','z','https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327228/BoardingHouse/Image_avt/ofzsonzveqtoiwhtsuds.jpg','2024-06-19 11:50:00','2151050138hiep@ou.edu.vn','100 Cộng Hòa, Tân Bình','0383876040','ROLE_LESSOR',0),(19,'tonghiep12','$2a$12$/M.nLCmqIfBJ0cVzJnAGfe2qsbIxUVtXtEa3zagTaUFZDJI/6Qv3G','hiep','trinhac','https://res.cloudinary.com/dsbkju7j9/image/upload/v1715327228/BoardingHouse/Image_avt/ofzsonzveqtoiwhtsuds.jpg','2024-06-19 16:12:24','tonghiep666@gmail.com','100 Cộng Hòa, Tân Bình','11123456789','ROLE_USER',0),(29,'tonghiepaf','$2a$10$haaFClbvC/0Bgv8BNSqJN.3XRbq0qGdRgSVn0fj/0y8WLyBk0ofFi','Trịnh','Hiệp','https://res.cloudinary.com/dsbkju7j9/image/upload/v1718975064/oadih26vospsp72eiift.png','2024-06-21 20:04:22','tonghiep212@gmail.com','724/44 LÊ VĂN LƯƠNG','0383876052','ROLE_USER',0),(47,'tonghiepab','$2a$10$Rb78P1G4jFAG.VmtrIcj6Ov1BF2Sbzxjb8uVhwvhf0OVi0C/EUvRO','Trịnh','Hiệp11','https://res.cloudinary.com/dsbkju7j9/image/upload/v1718986170/nziozngvm6ucwijsbtwd.png','2024-06-21 23:09:28','tonghiep22@gmail.com','724/44 LÊ VĂN LƯƠNG','0383876058','ROLE_LESSOR',0),(48,'hiepabc','$2a$10$cLLIlEwW2nRHnpcB4NJgJex.ZsiqxnvrOWpXeEuHH9AwSm8CN1eKG','Trịnh','Hiệp121','https://res.cloudinary.com/dsbkju7j9/image/upload/v1718986333/usbgaq9ohpik55sythb4.png','2024-06-21 23:12:11','tonghiep22@gmail.com','724/44 LÊ VĂN LƯƠNG','0383876058','ROLE_LESSOR',0),(49,'tonghiepvcst','$2a$10$b.aNhvXHlOqlLK8Jny7KW.uflD3arvZ9uohIwdxFV6S9kFM3POMp6','Trịnh','Hiệpvcst','https://res.cloudinary.com/dsbkju7j9/image/upload/v1718986600/axxoong7ywjq4nxqq1za.png','2024-06-21 23:16:38','tonghiep22@gmail.com','724/44 LÊ VĂN LƯƠNG','0383876058','ROLE_LESSOR',0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-21 23:24:13
