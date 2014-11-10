-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Φιλοξενητής: 127.0.0.1
-- Χρόνος δημιουργίας: 10 Νοε 2014 στις 10:28:59
-- Έκδοση διακομιστή: 5.6.20
-- Έκδοση PHP: 5.5.15

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
  `bname` varchar(30) NOT NULL,
  `bquant` int(11) NOT NULL,
  `bdate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `prods`
--

CREATE TABLE IF NOT EXISTS `prods` (
`pid` int(11) NOT NULL,
  `pname` varchar(30) NOT NULL,
  `pquant` int(11) NOT NULL,
  `pdate` date NOT NULL,
  `ptype` varchar(3) NOT NULL,
  `pprice` int(11) NOT NULL,
  `pfpa` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Άδειασμα δεδομένων του πίνακα `prods`
--

INSERT INTO `prods` (`pid`, `pname`, `pquant`, `pdate`, `ptype`, `pprice`, `pfpa`) VALUES
(1, 'DVD Verdatim', 100, '2014-11-10', 'a_l', 100, 123),
(2, 'KINGSTON DATA TRAVELER 8GB USB', 50, '2014-11-10', 't_p', 100, 123),
(3, 'KINGSTON DATATRAVELER G4 8GB U', 60, '2014-11-10', 't_p', 100, 123),
(4, 'VERBATIM 97761 MICRO PLUS 8GB ', 300, '2014-11-12', 't_p', 100, 123),
(5, 'VERBATIM 98695 SLIDER 8GB USB2', 150, '2014-11-12', 't_p', 100, 123),
(6, 'CD Verdatim', 100, '2014-11-15', 'a_l', 100, 123),
(7, 'Melania CANON Black ', 20, '2014-11-16', 'a_l', 100, 123);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `sell`
--

CREATE TABLE IF NOT EXISTS `sell` (
`sid` int(11) NOT NULL,
  `sname` varchar(30) NOT NULL,
  `squant` int(11) NOT NULL,
  `sdate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
MODIFY `bid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT για πίνακα `prods`
--
ALTER TABLE `prods`
MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT για πίνακα `sell`
--
ALTER TABLE `sell`
MODIFY `sid` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
