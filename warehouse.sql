-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Φιλοξενητής: 127.0.0.1
-- Χρόνος δημιουργίας: 02 Ιαν 2015 στις 12:05:15
-- Έκδοση διακομιστή: 5.6.21
-- Έκδοση PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Βάση δεδομένων: `warehouse`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `buy`
--

CREATE TABLE IF NOT EXISTS `buy` (
`bid` int(11) NOT NULL,
  `bname` varchar(40) NOT NULL,
  `bquant` int(11) NOT NULL,
  `bdate` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Άδειασμα δεδομένων του πίνακα `buy`
--

INSERT INTO `buy` (`bid`, `bname`, `bquant`, `bdate`) VALUES
(1, 'DVD Verdatim', 50, '2015-01-02'),
(2, 'KINGSTON DATA TRAVELER 8GB USB', 3, '2015-01-02'),
(3, 'KINGSTON DATATRAVELER G4 8GB U', 3, '2015-01-02'),
(4, 'VERBATIM 97761 MICRO PLUS 8GB ', 4, '2015-01-02'),
(5, 'CD Verdatim ', 50, '2015-01-02'),
(6, 'MICROSOFT MOUSE', 10, '2015-01-02');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `prods`
--

CREATE TABLE IF NOT EXISTS `prods` (
`pid` int(11) NOT NULL,
  `pname` varchar(40) NOT NULL,
  `pquant` int(11) NOT NULL,
  `pdate` date NOT NULL,
  `pprice` float NOT NULL,
  `pfpa` float NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Άδειασμα δεδομένων του πίνακα `prods`
--

INSERT INTO `prods` (`pid`, `pname`, `pquant`, `pdate`, `pprice`, `pfpa`) VALUES
(8, 'DVD Verdatim', 100, '2015-01-02', 0.6, 0.738),
(9, 'KINGSTON DATA TRAVELER 8GB USB', 23, '2015-01-02', 3.3, 4.059),
(10, 'KINGSTON DATATRAVELER G4 8GB U', 31, '2015-01-02', 4, 4.92),
(11, 'VERBATIM 97761 MICRO PLUS 8GB ', 36, '2015-01-02', 4.2, 5.166),
(12, 'VERBATIM 98695 SLIDER 8GB USB2', 15, '2015-01-02', 4.6, 5.658),
(14, 'Melania CANON Black ', 10, '2015-01-02', 12, 14.76),
(15, 'KINGSTON SDC4/4GB', 30, '2015-01-02', 2.48, 3.0504),
(16, 'VERBATIM 43967 MICROSDHC 8GB', 15, '2015-01-02', 4.1, 5.043),
(17, 'TOSHIBA 500GB USB 3.0 Black', 6, '2015-01-02', 44.5, 54.735),
(18, 'GENIUS XSCROLL PS/2   ', 10, '2015-01-02', 3.68, 4.5264),
(19, 'COMPUTER TRAVEL KIT', 10, '2015-01-02', 7.9, 9.717),
(20, 'MODECOM MC-M9 OPTICAL MOUSE ', 5, '2015-01-02', 4.4, 5.412),
(21, 'MICROSOFT MOUSE', 10, '2015-01-02', 4.2, 5.166);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `sell`
--

CREATE TABLE IF NOT EXISTS `sell` (
`sid` int(11) NOT NULL,
  `sname` varchar(40) NOT NULL,
  `squant` int(11) NOT NULL,
  `stype` varchar(3) NOT NULL,
  `sdate` date NOT NULL,
  `sprice` float NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Άδειασμα δεδομένων του πίνακα `sell`
--

INSERT INTO `sell` (`sid`, `sname`, `squant`, `stype`, `sdate`, `sprice`) VALUES
(3, 'TOSHIBA 500GB USB 3.0 Black', 2, 'a_l', '2015-01-02', 108);

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `buy`
--
ALTER TABLE `buy`
 ADD PRIMARY KEY (`bid`);

--
-- Ευρετήρια για πίνακα `prods`
--
ALTER TABLE `prods`
 ADD PRIMARY KEY (`pid`);

--
-- Ευρετήρια για πίνακα `sell`
--
ALTER TABLE `sell`
 ADD PRIMARY KEY (`sid`);

--
-- AUTO_INCREMENT για άχρηστους πίνακες
--

--
-- AUTO_INCREMENT για πίνακα `buy`
--
ALTER TABLE `buy`
MODIFY `bid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT για πίνακα `prods`
--
ALTER TABLE `prods`
MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT για πίνακα `sell`
--
ALTER TABLE `sell`
MODIFY `sid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
