-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 06, 2022 at 09:04 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_styleku`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_barang`
--

CREATE TABLE `tb_barang` (
  `id_barang` int(11) NOT NULL,
  `username_seller` varchar(255) NOT NULL,
  `nama_toko` varchar(255) NOT NULL,
  `nama_brg` varchar(255) NOT NULL,
  `harga_brg` varchar(255) NOT NULL,
  `qty` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_barang`
--

INSERT INTO `tb_barang` (`id_barang`, `username_seller`, `nama_toko`, `nama_brg`, `harga_brg`, `qty`) VALUES
(1, 'tukangbakso', 'Tshirt Bakso Bulat', 'Baju Bakso', 'RP.150.000', '50');

-- --------------------------------------------------------

--
-- Table structure for table `tb_seller`
--

CREATE TABLE `tb_seller` (
  `id_seller` int(10) UNSIGNED NOT NULL,
  `username_seller` varchar(255) NOT NULL,
  `password_seller` varchar(255) NOT NULL,
  `email_seller` varchar(255) DEFAULT NULL,
  `nama_toko` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_seller`
--

INSERT INTO `tb_seller` (`id_seller`, `username_seller`, `password_seller`, `email_seller`, `nama_toko`) VALUES
(1, 'tukangbakso', 'genta123', 'genta@gmail.com', ''),
(2, 'ganteng', '123', 'gentaarya52@gmail.com', ''),
(3, 'anyo', '2', '111201911861@mhs.dinus.ac.id', ''),
(4, 'tukangbaksor', '456', '111201911861@mhs.dinus.ac.id', ''),
(5, 'tukangbakso5', 'genta123', 'gentaarya52@gmail.com', '');

-- --------------------------------------------------------

--
-- Table structure for table `tb_toko`
--

CREATE TABLE `tb_toko` (
  `id_toko` int(11) NOT NULL,
  `username_seller` varchar(255) NOT NULL,
  `nama_toko` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_toko`
--

INSERT INTO `tb_toko` (`id_toko`, `username_seller`, `nama_toko`) VALUES
(1, 'tukangbakso', 'Tshirt Bakso Bulat'),
(2, 'ganteng', 'Celana Distro');

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE `tb_user` (
  `id_user` int(10) UNSIGNED NOT NULL,
  `username_user` varchar(255) NOT NULL,
  `password_user` varchar(255) NOT NULL,
  `email_user` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_user`
--

INSERT INTO `tb_user` (`id_user`, `username_user`, `password_user`, `email_user`) VALUES
(6, 'genta56', 'genta456', 'genta@gmail.com'),
(8, 'mita', 'genta456', 'genta@gmail.com'),
(9, 'genta95', 'genta456', 'genta@gmail.com'),
(10, 'arya', 'genta', '111201911861@mhs.dinus.ac.id'),
(11, 'aryapratama', 'genta123', '111201911861@mhs.dinus.ac.id'),
(12, 'bapakkaulah', '19okt2001', 'mgentaarya@gmail.com'),
(13, 'testing', 'genta123', '111201911861@mhs.dinus.ac.id'),
(14, 'testingg', 'genta123', '111201911861@mhs.dinus.ac.id'),
(15, 'tegar', 'tegar123', 'tegar@yahoo.com'),
(16, 'ganteng', '123456', '111201911861@mhs.dinus.ac.id'),
(17, 'ivan', '123', '111201911861@mhs.dinus.ac.id'),
(18, 'gogi', '45', '111201911861@mhs.dinus.ac.id'),
(19, 'gogi2', '45', '111201911861@mhs.dinus.ac.id'),
(20, 'ros', '3232', '111201911861@mhs.dinus.ac.id'),
(21, 'tukangbaksos', 'genta123', 'genta@gmail.com'),
(22, 'mita5', '4544', '111201911861@mhs.dinus.ac.id'),
(23, 'robby', '456', 'gentaman34@gmail.com'),
(24, 'test', '123', '111201911861@mhs.dinus.ac.id'),
(25, 'contoh', '123', '111201911861@mhs.dinus.ac.id'),
(26, 'genta', '123', '111201911861@mhs.dinus.ac.id');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_barang`
--
ALTER TABLE `tb_barang`
  ADD PRIMARY KEY (`id_barang`,`username_seller`),
  ADD UNIQUE KEY `nama_seller` (`username_seller`);

--
-- Indexes for table `tb_seller`
--
ALTER TABLE `tb_seller`
  ADD PRIMARY KEY (`id_seller`,`username_seller`);

--
-- Indexes for table `tb_toko`
--
ALTER TABLE `tb_toko`
  ADD PRIMARY KEY (`id_toko`,`username_seller`),
  ADD UNIQUE KEY `username_seller` (`username_seller`);

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`id_user`,`username_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_barang`
--
ALTER TABLE `tb_barang`
  MODIFY `id_barang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tb_seller`
--
ALTER TABLE `tb_seller`
  MODIFY `id_seller` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tb_toko`
--
ALTER TABLE `tb_toko`
  MODIFY `id_toko` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tb_user`
--
ALTER TABLE `tb_user`
  MODIFY `id_user` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
