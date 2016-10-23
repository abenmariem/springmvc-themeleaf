-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Dim 23 Octobre 2016 à 21:18
-- Version du serveur :  10.1.16-MariaDB
-- Version de PHP :  5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `db_springmvc_themeleaf`
--

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `id` bigint(20) NOT NULL,
  `date_naissance` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `etudiant`
--

INSERT INTO `etudiant` (`id`, `date_naissance`, `email`, `nom`, `photo`, `prenom`) VALUES
(6, '1987-06-16 00:00:00', 'mohamed@gmail.com', 'mohamed', 'mohamed.jpg', 'Ben mohamed'),
(7, '1987-06-16 00:00:00', 'ali@gmail.com', 'ali', 'ali.jpg', 'Ben ali'),
(8, '1987-06-16 00:00:00', 'saleh@gmail.com', 'saleh', 'saleh.jpg', 'Ben saleh'),
(9, '1987-06-16 00:00:00', 'mohamed@gmail.com', 'mohamed', 'mohamed.jpg', 'Ben mohamed'),
(10, '1987-06-16 00:00:00', 'ali@gmail.com', 'ali', 'ali.jpg', 'Ben ali'),
(12, '1987-06-16 00:00:00', 'mohamed@gmail.com', 'mohamed', 'mohamed.jpg', 'Ben mohamed'),
(13, '2016-10-28 00:00:00', 'aaa@gmai.com', 'aaaaa', '', NULL),
(14, '2016-10-20 00:00:00', 'abdou@gmail.com', 'abdou', 'img1.jpg', NULL),
(15, '2016-10-14 00:00:00', 'abdou@gmail.com', 'abderrahmen', 'img2.jpg', NULL);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `etudiant`
--
ALTER TABLE `etudiant`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
