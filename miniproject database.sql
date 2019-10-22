-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 20, 2019 at 11:43 AM
-- Server version: 5.5.39
-- PHP Version: 5.4.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `miniproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `L_name` varchar(30) DEFAULT NULL,
  `L_addr` varchar(30) DEFAULT NULL,
  `L_mob` int(10) DEFAULT NULL,
  `L_email` varchar(30) DEFAULT NULL,
  `L_username` varchar(30) NOT NULL,
  `L_password` varchar(30) NOT NULL,
  `Car_name` varchar(30) DEFAULT NULL,
  `Car_no` varchar(10) DEFAULT NULL,
  `Seats` int(2) DEFAULT NULL,
  `Fuel` varchar(20) DEFAULT NULL,
  `Cost` int(5) DEFAULT NULL,
  `Status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`L_name`, `L_addr`, `L_mob`, `L_email`, `L_username`, `L_password`, `Car_name`, `Car_no`, `Seats`, `Fuel`, `Cost`, `Status`) VALUES
('mrunal', 'ddsw', 321, 'sw@ssd', 'mkg1195', '1998', 'Audi', 'gj21', 7, 'Diesel', 50, 'approved'),
('mrunal', 'ddsw', 321, 'sw@ssd', 'mkg1195', '1998', 'Nissan', 'gj21', 7, 'Petrol', 50, 'approved'),
('mrunal', 'ddsw', 321, 'sw@ssd', 'mkg1195', '1998', 'Porsche', 'gj01', 9, 'Petrol', 50, 'approved'),
('mrunal', 'dssd', 2112, 'sc@dsd', 'mkg', '1998', 'Renault', 'gj01', 8, 'Petrol', 10, 'approved'),
('mrunal', 'dssd', 2112, 'sc@dsd', 'mkg', '1998', 'Volkswagen', 'mh15', 3, 'Petrol', 50, 'approved');

-- --------------------------------------------------------

--
-- Table structure for table `borrower`
--

CREATE TABLE IF NOT EXISTS `borrower` (
  `Name` varchar(20) NOT NULL,
  `Addr` varchar(30) NOT NULL,
  `Mob` int(10) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `borrower`
--

INSERT INTO `borrower` (`Name`, `Addr`, `Mob`, `Email`, `Username`, `Password`) VALUES
('ssc', 'sdds', 1211, 'sxs@sdsd', 'mkg1195', '1998'),
('fsf', 'rrr', 123, 'fss@sds', 'abc', 'abc'),
('tushar', 'ssd', 1312, 'wdw@dwd', 'champ', '96k'),
('sxs', 'ww', 1211, 'aa2@qsq', '96k', 'champ');

-- --------------------------------------------------------

--
-- Table structure for table `lender`
--

CREATE TABLE IF NOT EXISTS `lender` (
  `Name` varchar(20) NOT NULL,
  `Addr` varchar(20) NOT NULL,
  `Mob` int(10) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Username` varchar(10) NOT NULL,
  `Password` varchar(10) NOT NULL,
  `Car_name` varchar(20) DEFAULT NULL,
  `Car_no` varchar(10) DEFAULT NULL,
  `Seats` int(2) DEFAULT NULL,
  `Fuel` varchar(10) DEFAULT NULL,
  `Cost` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lender`
--

INSERT INTO `lender` (`Name`, `Addr`, `Mob`, `Email`, `Username`, `Password`, `Car_name`, `Car_no`, `Seats`, `Fuel`, `Cost`) VALUES
('mrunal', 'dssd', 2112, 'sc@dsd', 'mkg', '1998', NULL, NULL, -99, NULL, -99),
('mrunal', 'ddsw', 321, 'sw@ssd', 'mkg1195', '1998', NULL, NULL, -99, NULL, -99),
('mrunal', 'ddsw', 321, 'sw@ssd', 'mkg1195', '1998', 'MarutiSuzuki', 'mh15', 5, 'Petrol', 20),
('mrunal', 'dssd', 2112, 'sc@dsd', 'mkg', '1998', 'Jeep', 'mh16', 5, 'Petrol', 40),
('mrunal', 'dssd', 2112, 'sc@dsd', 'mkg', '1998', 'Hyundai', 'MH151234', 10, 'Diesel', 100),
('mrunal', 'dssd', 2112, 'sc@dsd', 'mkg', '1998', 'Lamborghini', 'Mh15sd420', 2, 'Petrol', 10000),
('mrunal', 'dssd', 2112, 'sc@dsd', 'mkg', '1998', 'RollsRoyce', 'mh15sw9999', 2, 'Diesel', 100),
('mrunal', 'dssd', 2112, 'sc@dsd', 'mkg', '1998', 'Ferrari', 'GJ15KK1998', 2, 'Petrol', 5000),
('mrunal', 'ddsw', 321, 'sw@ssd', 'mkg1195', '1998', 'Porsche', 'gj01', 9, 'Petrol', 50),
('mrunal', 'ddsw', 321, 'sw@ssd', 'mkg1195', '1998', 'Nissan', 'gj21', 7, 'Petrol', 50),
('mrunal', 'dssd', 2112, 'sc@dsd', 'mkg', '1998', 'Renault', 'gj01', 8, 'Petrol', 10),
('mrunal', 'dssd', 2112, 'sc@dsd', 'mkg', '1998', 'Volkswagen', 'mh15', 3, 'Petrol', 50);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
