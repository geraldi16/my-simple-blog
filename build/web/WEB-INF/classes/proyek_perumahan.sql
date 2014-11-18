-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 06, 2014 at 11:15 AM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `proyek_perumahan`
--

-- --------------------------------------------------------

--
-- Table structure for table `tabel_byrperusahaan`
--

CREATE TABLE IF NOT EXISTS `tabel_byrperusahaan` (
  `idRumah` int(11) NOT NULL,
  `nomor` int(11) NOT NULL,
  `pembayaran` varchar(15) NOT NULL,
  `Jumlah` int(11) NOT NULL,
  `tanggal` varchar(15) NOT NULL,
  `bank` varchar(30) NOT NULL,
  `atas_nama` varchar(40) NOT NULL,
  `no_rek` varchar(20) NOT NULL,
  `isChecked` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_byrperusahaan`
--

INSERT INTO `tabel_byrperusahaan` (`idRumah`, `nomor`, `pembayaran`, `Jumlah`, `tanggal`, `bank`, `atas_nama`, `no_rek`, `isChecked`) VALUES
(1, 1, 'BHPTB', 1000, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 2, 'PPN', 509094, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 3, 'PPH', -999, '8-9-9', 'aaa', 'aaa', 'aaa', 0),
(1, 4, 'Notaris', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 5, 'Marketing Fee', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tabel_cash`
--

CREATE TABLE IF NOT EXISTS `tabel_cash` (
  `idRumah` int(11) NOT NULL,
  `nomor` int(11) NOT NULL,
  `pembayaran` varchar(30) NOT NULL,
  `Jumlah` int(11) NOT NULL,
  `tanggal` varchar(15) NOT NULL,
  `bank` varchar(20) NOT NULL,
  `atas_nama` varchar(30) NOT NULL,
  `no_rek` varchar(20) NOT NULL,
  `isChecked` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_cash`
--

INSERT INTO `tabel_cash` (`idRumah`, `nomor`, `pembayaran`, `Jumlah`, `tanggal`, `bank`, `atas_nama`, `no_rek`, `isChecked`) VALUES
(1, 1, 'Booking', 123000, 'aaa', 'aaa', 'geraldi', 'aaa', 0),
(1, 2, 'DP', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 3, 'Transfer 1', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 4, 'Transfer 2', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 5, 'Transfer 3', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tabel_harga`
--

CREATE TABLE IF NOT EXISTS `tabel_harga` (
  `idRumah` int(11) NOT NULL,
  `tipe_pembayaran` int(11) NOT NULL,
  `diskon1` int(11) NOT NULL,
  `diskon2` int(11) NOT NULL,
  `keterangan` varchar(100) NOT NULL,
  `tgl_book` varchar(15) NOT NULL,
  `total_diskon` int(11) NOT NULL,
  `nama_marketing` varchar(50) NOT NULL,
  PRIMARY KEY (`idRumah`),
  KEY `idRumah` (`idRumah`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_harga`
--

INSERT INTO `tabel_harga` (`idRumah`, `tipe_pembayaran`, `diskon1`, `diskon2`, `keterangan`, `tgl_book`, `total_diskon`, `nama_marketing`) VALUES
(1, 2, 0, 0, '', '', 0, ''),
(2, 1, 0, 0, '', '', 0, '');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_hargakavling`
--

CREATE TABLE IF NOT EXISTS `tabel_hargakavling` (
  `kavling` varchar(15) NOT NULL,
  `harga_lama` int(11) NOT NULL,
  `Tgl_update` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_hargakavling`
--

INSERT INTO `tabel_hargakavling` (`kavling`, `harga_lama`, `Tgl_update`) VALUES
('Ruko', 920000000, '01-06-2014'),
('Anggrek 1', 560000000, '27-05-2014'),
('Anggrek 2', 605000000, '1-1-1970'),
('Teratai 1', 655000000, '1-1-1970'),
('Teratai 2', 750000000, '1-1-1970'),
('Kamboja 1', 930000000, '01-06-2014'),
('Kamboja 2', 1020000000, '01-06-2014');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_history`
--

CREATE TABLE IF NOT EXISTS `tabel_history` (
  `pembeli` varchar(50) NOT NULL,
  `tanggal` varchar(20) NOT NULL,
  `booking` varchar(30) NOT NULL,
  `tipe_rumah` varchar(20) NOT NULL,
  `no_rumah` varchar(10) NOT NULL,
  `marketing` varchar(50) NOT NULL,
  `keterangan` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_history`
--

INSERT INTO `tabel_history` (`pembeli`, `tanggal`, `booking`, `tipe_rumah`, `no_rumah`, `marketing`, `keterangan`) VALUES
('geraldi', '06-06-2014', 'Rp 10.000.000', 'Ruko', 'KR-1', 'handy', 'data pembayaran KPR baru'),
('geraldi', '06-06-2014', 'Rp 10.000.000', 'Ruko', 'KR-1', 'handy', 'update data pembayaran KPR'),
('geraldi', '06-06-2014', 'Rp 10.000.000', 'Ruko', 'KR-1', 'handy', 'update data pembayaran KPR'),
('geraldi', '06-06-2014', 'Rp xxx.', 'Ruko', 'KR-1', 'handy', 'data harga dihapus'),
('geraldi', '06-06-2014', 'Rp 100.000', 'Ruko', 'KR-1', 'handy', 'data pembayaran KPR baru'),
('geraldi', '06-06-2014', 'Rp 100.000', 'Ruko', 'KR-1', 'handy', 'update data pembayaran KPR'),
('geraldi', '06-06-2014', 'Rp 100.000', 'Ruko', 'KR-1', 'handy', 'data pembayaran KPR dihapus'),
('geraldi', '06-06-2014', 'Rp ', 'Ruko', 'KR-1', 'handy', 'data pembayaran KPR baru'),
('geraldi', '06-06-2014', 'Rp 1500000', 'Ruko', 'KR-1', 'handy', 'update data pembayaran KPR'),
('geraldi', '06-06-2014', 'Rp 1.500.000', 'Ruko', 'KR-1', 'handy', 'update data pembayaran KPR'),
('geraldi', '06-06-2014', 'Rp 1.500.000', 'Ruko', 'KR-1', 'handy', 'data pembayaran KPR dihapus'),
('geraldi', '06-06-2014', 'Rp 34.234', 'Ruko', 'KR-1', 'geraldi', 'update data pembayaran Cash'),
('geraldi', '06-06-2014', 'Rp 34.234123', 'Ruko', 'KR-1', 'geraldi', 'update data pembayaran Cash'),
('geraldi', '06-06-2014', 'Rp 34.234.123', 'Ruko', 'KR-1', 'geraldi', 'update data pembayaran Cash'),
('geraldi', '06-06-2014', 'Rp 34.234.123', 'Ruko', 'KR-1', 'geraldi', 'update data pembayaran Cash'),
('geraldi', '06-06-2014', 'Rp 34.234.123', 'Ruko', 'KR-1', 'geraldi', 'data Cash dihapus'),
('geraldi', '06-06-2014', 'Rp xxx.', 'Ruko', 'KR-1', 'geraldi', 'data Pembeli dihapus'),
('geraldi angga', '06-06-2014', 'Rp 1000003', 'Ruko', 'KR-1', 'anthony', 'data pembayaran Cash baru'),
('geraldi angga', '06-06-2014', 'Rp 1.000.003', 'Ruko', 'KR-1', 'anthony', 'update data pembayaran Cash'),
('geraldi angga', '06-06-2014', 'Rp 1.000.003', 'Ruko', 'KR-1', 'anthony', 'update data pembayaran Cash'),
('geraldi angga', '06-06-2014', 'Rp 1.000.004', 'Ruko', 'KR-1', 'anthony', 'update data pembayaran Cash'),
('geraldi angga', '06-06-2014', 'Rp 1.000.004', 'Ruko', 'KR-1', 'anthony', 'data Cash dihapus'),
('geraldi angga', '06-06-2014', 'Rp 123000', 'Ruko', 'KR-1', 'anth', 'data pembayaran Cash baru'),
('geraldi angga', '06-06-2014', 'Rp 123.000', 'Ruko', 'KR-1', 'anth', 'update data pembayaran Cash'),
('geraldi angga', '06-06-2014', 'Rp 123.000', 'Ruko', 'KR-1', 'anth', 'update data pembayaran Cash'),
('geraldi angga', '06-06-2014', 'Rp 123.000', 'Ruko', 'KR-1', 'anth', 'update data pembayaran Cash'),
('geraldi angga', '06-06-2014', 'Rp 149', 'Ruko', 'KR-1', 'anth', 'data pembayaran KPR baru'),
('geraldi angga', '06-06-2014', 'Rp 149.', 'Ruko', 'KR-1', 'anth', 'update data pembayaran KPR'),
('geraldi angga', '06-06-2014', 'Rp 149.', 'Ruko', 'KR-1', 'anth', 'update data pembayaran KPR'),
('geraldi angga', '06-06-2014', 'Rp 149.', 'Ruko', 'KR-1', 'anth', 'update data pembayaran KPR'),
('geraldi angga', '06-06-2014', 'Rp 149.', 'Ruko', 'KR-1', 'anth', 'update data pembayaran KPR'),
('geraldi angga', '06-06-2014', 'Rp xxx.', 'Ruko', 'KR-1', 'anth', 'data harga dihapus'),
('geraldi angga', '06-06-2014', 'Rp 123000', 'Ruko', 'KR-1', '', 'data pembayaran SoftCash baru'),
('geraldi angga', '06-06-2014', 'Rp 123.000', 'Ruko', 'KR-1', '', 'update data pembayaran Soft Cash');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_kelebihantanah`
--

CREATE TABLE IF NOT EXISTS `tabel_kelebihantanah` (
  `idRumah` int(11) NOT NULL,
  `KelebihanTanah` int(11) NOT NULL,
  `HargaM` int(11) NOT NULL,
  `HargaKelebihan` int(11) NOT NULL,
  `HargaTotal` int(11) NOT NULL,
  PRIMARY KEY (`idRumah`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_kelebihantanah`
--

INSERT INTO `tabel_kelebihantanah` (`idRumah`, `KelebihanTanah`, `HargaM`, `HargaKelebihan`, `HargaTotal`) VALUES
(1, 0, 500000, 0, 920000000);

-- --------------------------------------------------------

--
-- Table structure for table `tabel_kpr`
--

CREATE TABLE IF NOT EXISTS `tabel_kpr` (
  `idRumah` int(11) NOT NULL,
  `no` int(11) NOT NULL,
  `pembayaran` varchar(15) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `tanggal` varchar(15) NOT NULL,
  `bank` varchar(30) NOT NULL,
  `atas_nama` varchar(40) NOT NULL,
  `no_rek` varchar(40) NOT NULL,
  `isChecked` tinyint(4) NOT NULL,
  `bank_acc` varchar(50) NOT NULL,
  `jumlah_acc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_kpr`
--

INSERT INTO `tabel_kpr` (`idRumah`, `no`, `pembayaran`, `jumlah`, `tanggal`, `bank`, `atas_nama`, `no_rek`, `isChecked`, `bank_acc`, `jumlah_acc`) VALUES
(2, 0, 'Booking', 149, 'aaa', 'aaa', 'aaa', 'aaa', 0, 'aaa', -999),
(2, 0, 'DP', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0, 'aaa', -999),
(2, 0, 'Akad Kredit', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0, 'aaa', -999),
(2, 0, 'Retensi', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0, 'aaa', -999);

-- --------------------------------------------------------

--
-- Table structure for table `tabel_pembeli`
--

CREATE TABLE IF NOT EXISTS `tabel_pembeli` (
  `idPembeli` int(11) NOT NULL AUTO_INCREMENT,
  `idRumah` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `noTelepon` varchar(20) NOT NULL,
  `ttl` varchar(50) NOT NULL,
  `pekerjaan` varchar(100) NOT NULL,
  `ktp` varchar(20) NOT NULL,
  PRIMARY KEY (`idPembeli`),
  UNIQUE KEY `IDpembeli` (`idPembeli`),
  KEY `IDpembeli_2` (`idPembeli`),
  KEY `IDpembeli_3` (`idPembeli`),
  KEY `IDpembeli_4` (`idPembeli`),
  KEY `IDpembeli_5` (`idPembeli`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `tabel_pembeli`
--

INSERT INTO `tabel_pembeli` (`idPembeli`, `idRumah`, `nama`, `alamat`, `noTelepon`, `ttl`, `pekerjaan`, `ktp`) VALUES
(5, 2, 'aklsd', 'fdka', 'dsakl', 'fdkj', 'fdl', 'dfskl'),
(7, 1, 'geraldi angga', 'jl wiraangun', '7283918', '31-10-1992', 'mahasiswa', '1920393049-130');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_rumah`
--

CREATE TABLE IF NOT EXISTS `tabel_rumah` (
  `idRumah` int(15) NOT NULL AUTO_INCREMENT,
  `tipeRumah` varchar(10) NOT NULL,
  `noRumah` varchar(10) NOT NULL,
  `LT` int(11) NOT NULL,
  `LTAwal` int(11) NOT NULL,
  `LB` int(11) NOT NULL,
  `HargaAwal` int(11) NOT NULL,
  `HargaNett` int(11) NOT NULL,
  `isBought` tinyint(4) NOT NULL,
  `isEdited` tinyint(4) NOT NULL,
  `isLocked` tinyint(4) NOT NULL,
  `idx_pembayaran` int(11) NOT NULL,
  PRIMARY KEY (`idRumah`),
  UNIQUE KEY `idRumah` (`idRumah`),
  KEY `idRumah_2` (`idRumah`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=285 ;

--
-- Dumping data for table `tabel_rumah`
--

INSERT INTO `tabel_rumah` (`idRumah`, `tipeRumah`, `noRumah`, `LT`, `LTAwal`, `LB`, `HargaAwal`, `HargaNett`, `isBought`, `isEdited`, `isLocked`, `idx_pembayaran`) VALUES
(1, 'Ruko', 'KR-1', 55, 55, 100, 920000000, 920000000, 1, 0, 0, 2),
(2, 'Ruko', 'KR-2', 55, 55, 100, 920000000, 920000000, 1, 0, 0, 3),
(3, 'Ruko', 'KR-3', 55, 55, 100, 920000000, 920000000, 0, 0, 1, 0),
(4, 'Ruko', 'KR-4', 55, 55, 100, 920000000, 920000000, 0, 0, 0, 0),
(5, 'Ruko', 'KR-5', 55, 55, 100, 920000000, 920000000, 0, 0, 0, 0),
(6, 'Ruko', 'KR-6', 55, 55, 100, 920000000, 920000000, 0, 0, 0, 0),
(7, 'Ruko', 'KR-7', 55, 55, 100, 920000000, 920000000, 0, 0, 0, 0),
(8, 'Ruko', 'KR-8', 55, 55, 100, 920000000, 920000000, 0, 0, 0, 0),
(9, 'Ruko', 'KR-9', 55, 55, 100, 920000000, 920000000, 0, 0, 0, 0),
(10, 'Ruko', 'KR-10', 55, 55, 100, 920000000, 920000000, 0, 0, 0, 0),
(11, 'Ruko', 'KR-11', 55, 55, 100, 920000000, 920000000, 0, 0, 0, 0),
(12, 'Ruko', 'KR-12', 55, 55, 100, 920000000, 920000000, 0, 0, 0, 0),
(13, 'Ruko', 'KR-14', 55, 55, 100, 920000000, 920000000, 0, 0, 0, 0),
(14, 'Ruko', 'KR-15', 55, 55, 100, 920000000, 920000000, 0, 0, 0, 0),
(15, 'Ruko', 'KR-16', 55, 55, 100, 920000000, 920000000, 0, 0, 0, 0),
(16, 'Ruko', 'KR-17', 55, 55, 100, 920000000, 920000000, 0, 0, 0, 0),
(17, 'Ruko', 'KR-18', 55, 55, 100, 920000000, 920000000, 0, 0, 0, 0),
(18, 'Teratai 2', 'KR-19', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(19, 'Teratai 2', 'KR-20', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(20, 'Teratai 2', 'KR-21', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(21, 'Teratai 2', 'KR-22', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(22, 'Teratai 2', 'KR-23', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(23, 'Teratai 2', 'KR-24', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(24, 'Kamboja 1', 'KR-25', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(25, 'Kamboja 1', 'KR-26', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(26, 'Kamboja 1', 'KR-27', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(27, 'Kamboja 1', 'KR-28', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(28, 'Kamboja 1', 'KR-29', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(29, 'Kamboja 1', 'KR-30', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(30, 'Kamboja 1', 'KR-31', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(31, 'Kamboja 1', 'KR-32', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(32, 'Kamboja 1', 'KR-33', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(33, 'Kamboja 1', 'KR-34', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(34, 'Kamboja 1', 'KR-35', 136, 136, 90, 930000000, 930000000, 0, 0, 1, 0),
(35, 'Kamboja 1', 'KR-36', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(36, 'Kamboja 1', 'KR-37', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(37, 'Kamboja 1', 'KR-38', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(38, 'Kamboja 1', 'KR-39', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(39, 'Kamboja 1', 'KR-40', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(40, 'Kamboja 1', 'KR-41', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(41, 'Kamboja 1', 'KR-42', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(42, 'Kamboja 1', 'KR-43', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(43, 'Kamboja 1', 'KR-44', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(44, 'Kamboja 1', 'KR-45', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(45, 'Kamboja 1', 'KR-46', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(46, 'Kamboja 1', 'KR-47', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(47, 'Kamboja 1', 'KR-48', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(48, 'Kamboja 1', 'KR-49', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(49, 'Kamboja 1', 'KR-50', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(50, 'Kamboja 1', 'KR-51', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(51, 'Kamboja 1', 'KR-52', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(52, 'Kamboja 2', 'KR-53', 153, 153, 104, 1020000000, 1020000000, 0, 0, 0, 0),
(53, 'Kamboja 2', 'KR-54', 153, 153, 104, 1020000000, 1020000000, 0, 0, 0, 0),
(54, 'Kamboja 2', 'KR-55', 153, 153, 104, 1020000000, 1020000000, 0, 0, 0, 0),
(55, 'Kamboja 2', 'KR-56', 153, 153, 104, 1020000000, 1020000000, 0, 0, 0, 0),
(56, 'Kamboja 2', 'KR-57', 153, 153, 104, 1020000000, 1020000000, 0, 0, 0, 0),
(57, 'Kamboja 2', 'KR-58', 153, 153, 104, 1020000000, 1020000000, 0, 0, 0, 0),
(58, 'Kamboja 2', 'KR-59', 153, 153, 104, 1020000000, 1020000000, 0, 0, 0, 0),
(59, 'Kamboja 2', 'KR-60', 153, 153, 104, 1020000000, 1020000000, 0, 0, 0, 0),
(60, 'Kamboja 2', 'KR-61', 153, 153, 104, 1020000000, 1020000000, 0, 0, 0, 0),
(61, 'Kamboja 1', 'KR-62', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(62, 'Kamboja 1', 'KR-63', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(63, 'Kamboja 1', 'KR-64', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(64, 'Kamboja 1', 'KR-65', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(65, 'Kamboja 1', 'KR-66', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(66, 'Kamboja 1', 'KR-67', 136, 136, 90, 930000000, 930000000, 0, 0, 0, 0),
(67, 'Teratai 1', 'KR-68', 105, 105, 50, 655000000, 655000000, 0, 0, 0, 0),
(68, 'Teratai 1', 'KR-69', 105, 105, 50, 655000000, 655000000, 0, 0, 0, 0),
(69, 'Teratai 1', 'KR-70', 105, 105, 50, 655000000, 655000000, 0, 0, 0, 0),
(70, 'Teratai 2', 'KR-71', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(71, 'Teratai 2', 'KR-72', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(72, 'Teratai 2', 'A-1', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(73, 'Teratai 2', 'A-2', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(74, 'Teratai 2', 'A-3', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(75, 'Teratai 2', 'A-4', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(76, 'Teratai 2', 'A-5', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(77, 'Teratai 2', 'A-6', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(78, 'Teratai 2', 'A-7', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(79, 'Teratai 2', 'A-8', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(80, 'Teratai 2', 'A-9', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(81, 'Teratai 2', 'A-10', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(82, 'Teratai 2', 'A-11', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(83, 'Teratai 2', 'A-12', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(84, 'Teratai 2', 'A-14', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(85, 'Teratai 2', 'A-15', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(86, 'Teratai 2', 'A-16', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(87, 'Teratai 2', 'A-17', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(88, 'Teratai 2', 'A-18', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(89, 'Teratai 2', 'A-19', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(90, 'Teratai 2', 'A-20', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(91, 'Teratai 2', 'A-21', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(92, 'Teratai 2', 'A-22', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(93, 'Teratai 2', 'A-23', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(94, 'Teratai 1', 'B-1', 105, 105, 50, 955000000, 955000000, 0, 0, 0, 0),
(95, 'Teratai 1', 'B-2', 105, 105, 50, 955000000, 955000000, 0, 0, 0, 0),
(96, 'Teratai 1', 'B-3', 105, 105, 50, 955000000, 955000000, 0, 0, 0, 0),
(97, 'Teratai 1', 'B-4', 105, 105, 50, 955000000, 955000000, 0, 0, 0, 0),
(98, 'Teratai 1', 'B-5', 105, 105, 50, 955000000, 955000000, 0, 0, 0, 0),
(99, 'Teratai 1', 'B-6', 105, 105, 50, 955000000, 955000000, 0, 0, 0, 0),
(100, 'Teratai 1', 'B-7', 105, 105, 50, 955000000, 955000000, 0, 0, 0, 0),
(101, 'Teratai 1', 'B-8', 105, 105, 50, 955000000, 955000000, 0, 0, 0, 0),
(102, 'Teratai 1', 'B-9', 105, 105, 50, 955000000, 955000000, 0, 0, 0, 0),
(103, 'Teratai 1', 'B-10', 105, 105, 50, 955000000, 955000000, 0, 0, 0, 0),
(104, 'Teratai 1', 'B-11', 105, 105, 50, 955000000, 955000000, 0, 0, 0, 0),
(105, 'Teratai 2', 'B-12', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(106, 'Teratai 2', 'B-14', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(107, 'Teratai 2', 'B-15', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(108, 'Teratai 2', 'B-16', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(109, 'Teratai 2', 'B-17', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(110, 'Teratai 2', 'B-18', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(111, 'Teratai 2', 'B-19', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(112, 'Teratai 2', 'B-20', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(113, 'Teratai 2', 'B-21', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(114, 'Teratai 2', 'B-22', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(115, 'Teratai 2', 'B-23', 120, 120, 60, 750000000, 750000000, 0, 0, 0, 0),
(116, 'Anggrek 1', 'C-1', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(117, 'Teratai 1', 'C-11', 105, 105, 50, 655000000, 655000000, 0, 0, 0, 0),
(118, 'Teratai 1', 'C-12', 105, 105, 50, 655000000, 655000000, 0, 0, 0, 0),
(119, 'Teratai 1', 'C-14', 105, 105, 50, 655000000, 655000000, 0, 0, 0, 0),
(120, 'Teratai 1', 'C-15', 105, 105, 50, 655000000, 655000000, 0, 0, 0, 0),
(121, 'Teratai 1', 'C-16', 105, 105, 50, 655000000, 655000000, 0, 0, 0, 0),
(122, 'Teratai 1', 'C-17', 105, 105, 50, 655000000, 655000000, 0, 0, 0, 0),
(123, 'Teratai 1', 'C-18', 105, 105, 50, 655000000, 655000000, 0, 0, 0, 0),
(124, 'Teratai 1', 'C-19', 105, 105, 50, 655000000, 655000000, 0, 0, 0, 0),
(125, 'Teratai 1', 'C-20', 105, 105, 50, 655000000, 655000000, 0, 0, 0, 0),
(126, 'Teratai 1', 'C-21', 105, 105, 50, 655000000, 655000000, 0, 0, 0, 0),
(127, 'Teratai 1', 'C-22', 105, 105, 50, 655000000, 655000000, 0, 0, 0, 0),
(128, 'Teratai 1', 'C-23', 105, 105, 50, 655000000, 655000000, 0, 0, 0, 0),
(129, 'Teratai 1', 'C-24', 105, 105, 50, 655000000, 655000000, 0, 0, 0, 0),
(130, 'Anggrek 2', 'C-25', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(131, 'Anggrek 2', 'C-26', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(132, 'Anggrek 2', 'C-27', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(133, 'Anggrek 1', 'C-28', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(134, 'Anggrek 1', 'C-29', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(135, 'Anggrek 2', 'D-1', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(136, 'Anggrek 2', 'D-2', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(137, 'Anggrek 2', 'D-3', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(138, 'Anggrek 2', 'D-4', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(139, 'Anggrek 2', 'D-5', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(140, 'Anggrek 2', 'D-6', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(141, 'Anggrek 2', 'D-7', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(142, 'Anggrek 2', 'D-8', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(143, 'Anggrek 2', 'D-9', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(144, 'Anggrek 2', 'D-10', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(145, 'Anggrek 2', 'D-11', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(146, 'Anggrek 2', 'D-12', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(147, 'Anggrek 2', 'D-14', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(148, 'Anggrek 2', 'D-15', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(149, 'Anggrek 2', 'D-16', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(150, 'Anggrek 2', 'D-17', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(151, 'Anggrek 2', 'D-18', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(152, 'Anggrek 2', 'D-19', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(153, 'Anggrek 2', 'D-20', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(154, 'Anggrek 2', 'D-21', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(155, 'Anggrek 2', 'D-22', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(156, 'Anggrek 2', 'D-23', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(157, 'Anggrek 2', 'D-24', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(158, 'Anggrek 2', 'D-25', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(159, 'Anggrek 2', 'D-26', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(160, 'Anggrek 2', 'D-27', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(161, 'Anggrek 2', 'D-28', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(162, 'Anggrek 2', 'D-29', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(163, 'Anggrek 2', 'D-30', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(164, 'Anggrek 2', 'D-31', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(165, 'Anggrek 2', 'D-32', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(166, 'Anggrek 2', 'D-33', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(167, 'Anggrek 1', 'D-34', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(168, 'Anggrek 1', 'D-35', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(169, 'Anggrek 1', 'D-36', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(170, 'Anggrek 1', 'D-37', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(171, 'Anggrek 1', 'D-38', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(172, 'Anggrek 2', 'D-39', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(173, 'Anggrek 2', 'D-40', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(174, 'Anggrek 2', 'D-41', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(175, 'Anggrek 2', 'D-42', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(176, 'Anggrek 2', 'D-43', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(177, 'Anggrek 2', 'D-44', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(178, 'Anggrek 2', 'D-45', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(179, 'Anggrek 2', 'D-46', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(180, 'Anggrek 1', 'D-47', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(181, 'Anggrek 1', 'D-48', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(182, 'Anggrek 1', 'D-49', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(183, 'Anggrek 1', 'D-50', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(184, 'Anggrek 1', 'D-51', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(185, 'Anggrek 1', 'D-52', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(186, 'Anggrek 1', 'D-53', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(187, 'Anggrek 1', 'D-54', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(188, 'Anggrek 1', 'D-55', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(189, 'Anggrek 1', 'D-56', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(190, 'Anggrek 1', 'D-57', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(191, 'Anggrek 2', 'D-58', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(192, 'Anggrek 2', 'D-59', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(193, 'Anggrek 2', 'D-60', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(194, 'Anggrek 2', 'D-61', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(195, 'Anggrek 2', 'D-62', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(196, 'Anggrek 2', 'D-63', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(197, 'Anggrek 1', 'D-64', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(198, 'Anggrek 1', 'D-65', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(199, 'Anggrek 1', 'D-66', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(200, 'Anggrek 1', 'D-67', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(201, 'Anggrek 1', 'D-68', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(202, 'Anggrek 1', 'D-69', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(203, 'Anggrek 1', 'D-70', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(204, 'Anggrek 1', 'D-71', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(205, 'Anggrek 1', 'D-72', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(206, 'Anggrek 1', 'D-73', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(207, 'Anggrek 1', 'D-74', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(208, 'Anggrek 1', 'D-75', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(209, 'Anggrek 1', 'D-76', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(210, 'Anggrek 1', 'D-77', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(211, 'Anggrek 1', 'D-78', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(212, 'Anggrek 1', 'D-79', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(213, 'Anggrek 1', 'D-80', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(214, 'Anggrek 1', 'D-81', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(215, 'Anggrek 1', 'D-82', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(216, 'Anggrek 1', 'D-83', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(217, 'Anggrek 1', 'D-84', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(218, 'Anggrek 1', 'D-85', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(219, 'Anggrek 1', 'D-86', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(220, 'Anggrek 1', 'D-87', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(221, 'Anggrek 1', 'D-88', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(222, 'Anggrek 1', 'D-89', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(223, 'Anggrek 1', 'D-90', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(224, 'Anggrek 1', 'D-91', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(225, 'Anggrek 1', 'D-92', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(226, 'Anggrek 1', 'D-93', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(227, 'Anggrek 1', 'D-94', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(228, 'Anggrek 1', 'D-95', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(229, 'Anggrek 1', 'D-96', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(230, 'Anggrek 1', 'D-96', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(231, 'Anggrek 1', 'D-97', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(232, 'Anggrek 1', 'D-98', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(233, 'Anggrek 1', 'D-99', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(234, 'Anggrek 1', 'D-100', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(235, 'Anggrek 1', 'D-101', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(236, 'Anggrek 1', 'D-102', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(237, 'Anggrek 1', 'D-103', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(238, 'Anggrek 1', 'D-104', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(239, 'Anggrek 1', 'D-105', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(240, 'Anggrek 1', 'D-106', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(241, 'Anggrek 1', 'D-109', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(242, 'Anggrek 1', 'D-108', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(243, 'Anggrek 1', 'D-109', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(244, 'Anggrek 1', 'D-110', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(245, 'Anggrek 1', 'D-111', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(246, 'Anggrek 1', 'D-112', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(247, 'Anggrek 1', 'D-113', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(248, 'Anggrek 1', 'D-114', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(249, 'Anggrek 1', 'D-115', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(250, 'Anggrek 1', 'D-116', 94, 94, 40, 560000000, 560000000, 0, 0, 0, 0),
(251, 'Anggrek 2', 'E-1', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(252, 'Anggrek 2', 'E-2', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(253, 'Anggrek 2', 'E-3', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(254, 'Anggrek 2', 'E-4', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(255, 'Anggrek 2', 'E-5', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(256, 'Anggrek 2', 'E-6', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(257, 'Anggrek 2', 'E-7', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(258, 'Anggrek 2', 'E-8', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(259, 'Anggrek 2', 'E-9', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(260, 'Anggrek 2', 'E-10', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(261, 'Anggrek 2', 'E-11', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(262, 'Anggrek 2', 'E-12', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(263, 'Anggrek 2', 'E-14', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(264, 'Anggrek 2', 'E-15', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(265, 'Anggrek 2', 'E-16', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(266, 'Anggrek 2', 'E-17', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(267, 'Anggrek 2', 'E-18', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(268, 'Anggrek 2', 'E-19', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(269, 'Anggrek 2', 'E-20', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(270, 'Anggrek 2', 'E-21', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(271, 'Anggrek 2', 'E-22', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(272, 'Anggrek 2', 'E-23', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(273, 'Anggrek 2', 'E-24', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(274, 'Anggrek 2', 'E-25', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(275, 'Anggrek 2', 'E-26', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(276, 'Anggrek 2', 'E-27', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(277, 'Anggrek 2', 'E-28', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(278, 'Anggrek 2', 'E-29', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(279, 'Anggrek 2', 'E-30', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(280, 'Anggrek 2', 'E-31', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(281, 'Anggrek 2', 'E-32', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(282, 'Anggrek 2', 'E-33', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(283, 'Anggrek 2', 'E-34', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0),
(284, 'Anggrek 2', 'E-35', 100, 100, 45, 605000000, 605000000, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tabel_softcash`
--

CREATE TABLE IF NOT EXISTS `tabel_softcash` (
  `idRumah` int(11) NOT NULL,
  `nomor` int(11) NOT NULL,
  `pembayaran` varchar(50) NOT NULL,
  `Jumlah` int(11) NOT NULL,
  `tanggal` varchar(20) NOT NULL,
  `bank` varchar(50) NOT NULL,
  `atas_nama` varchar(50) NOT NULL,
  `no_rek` varchar(20) NOT NULL,
  `isChecked` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_softcash`
--

INSERT INTO `tabel_softcash` (`idRumah`, `nomor`, `pembayaran`, `Jumlah`, `tanggal`, `bank`, `atas_nama`, `no_rek`, `isChecked`) VALUES
(1, 1, 'Booking', 123000, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 2, 'DP', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 3, 'Transfer 1', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 4, 'Transfer 2', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 5, 'Transfer 3', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 6, 'Transfer 4', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 7, 'Transfer 5', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 8, 'Transfer 6', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 9, 'Transfer 7', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 10, 'Transfer 8', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 11, 'Transfer 9', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 12, 'Transfer 10', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 13, 'Transfer 11', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 14, 'Transfer 12', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 15, 'Transfer 13', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 16, 'Transfer 14', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 17, 'Transfer 15', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 18, 'Transfer 16', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 19, 'Transfer 17', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 20, 'Transfer 18', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 21, 'Transfer 19', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0),
(1, 22, 'Transfer 20', -999, 'aaa', 'aaa', 'aaa', 'aaa', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tabel_user`
--

CREATE TABLE IF NOT EXISTS `tabel_user` (
  `userID` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `isOwner` tinyint(4) NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_user`
--

INSERT INTO `tabel_user` (`userID`, `password`, `isOwner`) VALUES
('abcd', 'owner', 1),
('def', 'pegawai', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
