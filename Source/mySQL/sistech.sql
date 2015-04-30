-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: mysql.abdn.ac.uk:3306
-- Generation Time: Apr 30, 2015 at 02:48 PM
-- Server version: 5.5.21-log
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `t02hah14_sistech`
--

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE IF NOT EXISTS `messages` (
  `message_stream` bigint(8) NOT NULL,
  `s_uid` bigint(8) NOT NULL,
  `uid` bigint(8) NOT NULL,
  `message_number` bigint(8) NOT NULL AUTO_INCREMENT,
  `message_type` varchar(1) NOT NULL,
  `image_message_path` varchar(265) DEFAULT NULL,
  `typed_message_text` longtext,
  `message_time` time NOT NULL,
  `message_date` date NOT NULL,
  PRIMARY KEY (`message_number`,`message_stream`),
  UNIQUE KEY `message_number` (`message_number`),
  KEY `s_uid` (`s_uid`,`uid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COMMENT='Table to store message streams, images and text between ' AUTO_INCREMENT=62 ;

--
-- Dumping data for table `messages`
--

INSERT INTO `messages` (`message_stream`, `s_uid`, `uid`, `message_number`, `message_type`, `image_message_path`, `typed_message_text`, `message_time`, `message_date`) VALUES
(1, 1, 1, 34, 'I', 'images/120150401132143.jpg', NULL, '01:01:01', '2015-05-01'),
(1, 1, 1, 35, 'T', NULL, 'Hi Mum. How are you today?', '02:02:02', '2015-05-01'),
(1, 1, 1, 37, 'I', 'images/120150401133314.jpg', NULL, '01:01:01', '2015-05-01');

-- --------------------------------------------------------

--
-- Table structure for table `reminders`
--

CREATE TABLE IF NOT EXISTS `reminders` (
  `rem_table_key` bigint(10) NOT NULL AUTO_INCREMENT,
  `uid` bigint(8) NOT NULL,
  `reminder_date` date NOT NULL,
  `reminder_time_by` time NOT NULL,
  `reminder_text` longtext NOT NULL,
  `reminder_task_completed` smallint(1) NOT NULL,
  `s_uid` bigint(8) NOT NULL,
  PRIMARY KEY (`rem_table_key`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=60 ;

--
-- Dumping data for table `reminders`
--

INSERT INTO `reminders` (`rem_table_key`, `uid`, `reminder_date`, `reminder_time_by`, `reminder_text`, `reminder_task_completed`, `s_uid`) VALUES
(49, 1, '2015-05-01', '07:00:00', 'Take blue pill.', 0, 1),
(50, 1, '2015-05-01', '10:00:00', 'Take red pill.', 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `supporter`
--

CREATE TABLE IF NOT EXISTS `supporter` (
  `uname` varchar(30) CHARACTER SET utf8 COLLATE utf8_roman_ci NOT NULL COMMENT 'Username of Support Network Member',
  `uid` bigint(8) NOT NULL COMMENT 'Unique User ID of Support Network Member',
  `u_uid` bigint(8) NOT NULL COMMENT 'Key to Supported User table',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Details of Support Network Individual';

--
-- Dumping data for table `supporter`
--

INSERT INTO `supporter` (`uname`, `uid`, `u_uid`) VALUES
('John Smith, Joan''s son', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `uid` int(8) NOT NULL AUTO_INCREMENT COMMENT 'Unique user ID Supported Individual',
  `uname` varchar(50) CHARACTER SET utf8 COLLATE utf8_roman_ci NOT NULL COMMENT 'Username Supported Individual',
  `s_uid` int(8) NOT NULL COMMENT 'ID Support Network Member',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`uid`, `uname`, `s_uid`) VALUES
(1, 'Joan Smith', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
