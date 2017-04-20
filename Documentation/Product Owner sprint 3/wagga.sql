-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Gegenereerd op: 19 apr 2017 om 22:13
-- Serverversie: 5.5.54
-- PHP-versie: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `wagga`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `damage_or_theft_car`
--

CREATE TABLE `damage_or_theft_car` (
  `damage_or_theft_car_id` int(11) NOT NULL,
  `percentage` float DEFAULT NULL,
  `hood_id` int(11) DEFAULT NULL,
  `year` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `damage_or_theft_car`
--

INSERT INTO `damage_or_theft_car` (`damage_or_theft_car_id`, `percentage`, `hood_id`, `year`) VALUES
(1, 20, 41, 2006),
(2, 13, 41, 2007),
(3, 17.7, 41, 2008),
(4, 14.2, 43, 2006),
(10, 21.5, 44, 2006),
(11, 16, 44, 2007),
(12, 23.7, 44, 2008),
(13, 25.3, 44, 2009),
(14, 21.4, 44, 2011),
(20, 19.8, 46, 2006),
(21, 19.1, 46, 2007),
(30, 15.4, 47, 2006),
(31, 8.4, 47, 2007),
(54, 0, 26, 2006),
(300, 17.9, 40, 2006),
(631, 24, 27, 2006),
(632, 21.9, 27, 2007),
(633, 20.1, 27, 2008),
(634, 28.5, 27, 2009),
(635, 17.2, 27, 2011),
(636, 19.4, 28, 2006),
(637, 21.3, 28, 2007),
(638, 15.8, 28, 2008),
(639, 22.5, 28, 2009),
(640, 25.9, 28, 2011),
(641, 16.3, 29, 2006),
(642, 15.8, 29, 2007),
(643, 20.7, 29, 2008),
(644, 18.3, 29, 2009),
(645, 16.9, 29, 2011),
(646, 24.5, 30, 2006),
(647, 21.6, 30, 2007),
(648, 18.6, 30, 2008),
(649, 23.6, 30, 2009),
(650, 24.1, 30, 2011),
(651, 13, 31, 2006),
(652, 10.7, 31, 2007),
(653, 8.8, 31, 2008),
(654, 21.5, 31, 2009),
(655, 17.1, 31, 2011),
(656, 25.1, 32, 2006),
(657, 29.4, 32, 2007),
(658, 26.3, 32, 2008),
(659, 24.3, 32, 2009),
(660, 18.4, 32, 2011),
(661, 21.2, 33, 2006),
(662, 19.7, 33, 2007),
(663, 21.5, 33, 2008),
(664, 23.1, 33, 2009),
(665, 20.6, 33, 2011),
(666, 13.8, 34, 2006),
(667, 10.6, 34, 2007),
(668, 5.4, 34, 2008),
(669, 17.2, 34, 2009),
(670, 13.1, 34, 2011),
(671, 12.3, 35, 2006),
(672, 12.3, 35, 2007),
(673, 13.7, 35, 2008),
(674, 14, 35, 2009),
(675, 14, 35, 2011),
(676, 10.8, 36, 2006),
(677, 13.1, 36, 2007),
(678, 16.1, 36, 2008),
(679, 7.1, 36, 2009),
(680, 11.3, 36, 2011),
(681, 9.4, 37, 2006),
(682, 8.3, 37, 2007),
(683, 13.4, 37, 2008),
(684, 9.4, 37, 2009),
(685, 8.4, 37, 2011),
(686, 5.4, 38, 2006),
(687, 5.3, 38, 2007),
(688, 4.7, 38, 2008),
(689, 9.1, 38, 2009),
(690, 11.5, 38, 2011),
(691, 6.2, 39, 2006),
(692, 11, 39, 2007),
(693, 11.1, 39, 2008),
(694, 4.5, 39, 2009),
(695, 11, 39, 2011),
(696, 13.6, 40, 2007),
(697, 13.9, 40, 2008),
(698, 12.2, 40, 2009),
(699, 16.7, 40, 2011),
(700, 24.3, 41, 2009),
(701, 16.7, 41, 2011),
(705, 14.1, 43, 2007),
(706, 25.5, 43, 2008),
(707, 22.7, 43, 2009),
(708, 20.3, 43, 2011),
(713, 23.8, 45, 2006),
(714, 28.4, 45, 2007),
(715, 22.8, 45, 2008),
(716, 26.2, 45, 2009),
(717, 24.2, 45, 2011),
(718, 16.6, 46, 2008),
(719, 18.1, 46, 2009),
(720, 25.6, 46, 2011),
(722, 11.9, 47, 2008),
(723, 9.3, 47, 2009),
(724, 19.2, 48, 2006),
(725, 14.4, 48, 2007),
(726, 21.7, 48, 2008),
(727, 14.8, 48, 2009),
(728, 16.6, 48, 2011),
(729, 21, 49, 2006),
(730, 21.4, 49, 2007),
(731, 20.1, 49, 2008),
(732, 25.2, 49, 2009),
(733, 25.4, 49, 2011),
(734, 25.9, 50, 2006),
(735, 28.3, 50, 2007),
(736, 27.8, 50, 2008),
(737, 32, 50, 2009),
(738, 27.5, 50, 2011),
(739, 20.1, 51, 2006),
(740, 22.1, 51, 2007),
(741, 29.8, 51, 2008),
(742, 21.4, 51, 2009),
(743, 26.3, 51, 2011),
(744, 23.4, 52, 2006),
(745, 10.6, 52, 2007),
(746, 15.8, 52, 2008),
(747, 14.3, 52, 2009),
(748, 8.8, 52, 2011),
(749, 25.7, 53, 2006),
(750, 24.1, 53, 2007),
(751, 20.3, 53, 2008),
(752, 23.8, 53, 2009),
(753, 18, 53, 2011),
(754, 11.9, 54, 2006),
(755, 18.4, 54, 2007),
(756, 22.5, 54, 2008),
(757, 18.9, 54, 2009),
(758, 23.4, 54, 2011),
(759, 10.2, 55, 2006),
(760, 8.7, 55, 2007),
(761, 13.9, 55, 2008),
(762, 14, 55, 2009),
(763, 12.4, 55, 2011),
(764, 14.8, 56, 2006),
(765, 9.1, 56, 2007),
(766, 7.2, 56, 2008),
(767, 11.7, 56, 2009),
(768, 8, 56, 2011),
(769, 10.2, 57, 2006),
(770, 12.3, 57, 2007),
(771, 19, 57, 2008),
(772, 14.7, 57, 2009),
(773, 11.3, 57, 2011),
(774, 14.3, 58, 2006),
(775, 7.8, 58, 2007),
(776, 15.2, 58, 2008),
(777, 11.4, 58, 2009),
(778, 14.1, 58, 2011),
(779, 8.5, 59, 2006),
(780, 15, 59, 2007),
(781, 13.1, 59, 2008),
(782, 11.5, 59, 2009),
(783, 9.6, 59, 2011),
(784, 11.9, 60, 2006),
(785, 19.3, 60, 2007),
(786, 19.7, 60, 2008),
(787, 15.4, 60, 2009),
(788, 16.3, 60, 2011),
(789, 10.7, 61, 2006),
(790, 16.1, 61, 2007),
(791, 19.4, 61, 2008),
(792, 16.5, 61, 2009),
(793, 16.1, 61, 2011),
(794, 19.5, 62, 2006),
(795, 24, 62, 2007),
(796, 24.9, 62, 2008),
(797, 23.6, 62, 2009),
(798, 32.6, 62, 2011),
(799, 20.9, 63, 2006),
(800, 24, 63, 2007),
(801, 25.1, 63, 2008),
(802, 21.7, 63, 2009),
(803, 23.5, 63, 2011),
(804, 17.9, 64, 2006),
(805, 21.1, 64, 2007),
(806, 23.8, 64, 2008),
(807, 27.7, 64, 2009),
(808, 24.1, 64, 2011),
(809, 15.2, 65, 2006),
(810, 16.6, 65, 2007),
(811, 31.5, 65, 2008),
(812, 29.4, 65, 2009),
(813, 18.9, 65, 2011),
(814, 19.6, 66, 2006),
(815, 23.6, 66, 2007),
(816, 21.6, 66, 2008),
(817, 21, 66, 2009),
(818, 20.4, 66, 2011),
(819, 8.5, 67, 2006),
(820, 19, 67, 2007),
(821, 15.9, 67, 2008),
(822, 13.2, 67, 2009),
(823, 14.6, 67, 2011),
(824, 9.9, 68, 2006),
(825, 15.5, 68, 2007),
(826, 17.9, 68, 2008),
(827, 17.6, 68, 2009),
(828, 16.3, 68, 2011),
(829, 14.1, 69, 2006),
(830, 20.4, 69, 2007),
(831, 25.5, 69, 2008),
(832, 25.4, 69, 2009),
(833, 17.4, 69, 2011),
(834, 25.8, 70, 2006),
(835, 29.5, 70, 2007),
(836, 22.1, 70, 2008),
(837, 26.9, 70, 2009),
(838, 22.3, 70, 2011),
(839, 16.3, 71, 2006),
(840, 17.9, 71, 2007),
(841, 23.2, 71, 2008),
(842, 21.4, 71, 2009),
(843, 21.9, 71, 2011),
(844, 9.2, 72, 2006),
(845, 13.1, 72, 2007),
(846, 11.8, 72, 2008),
(847, 10.8, 72, 2009),
(848, 14.3, 72, 2011),
(849, 8, 73, 2006),
(850, 8.5, 73, 2007),
(851, 10.8, 73, 2008),
(852, 5.7, 73, 2009),
(853, 7.8, 73, 2011),
(854, 17.1, 74, 2006),
(855, 18.9, 74, 2007),
(856, 15.8, 74, 2008),
(857, 18.1, 74, 2009),
(858, 17.4, 74, 2011),
(859, 33.2, 75, 2006),
(860, 18.7, 75, 2007),
(861, 24.7, 75, 2008),
(862, 24.5, 75, 2009),
(863, 21.5, 75, 2011),
(864, 11.1, 76, 2006),
(865, 17.3, 76, 2007),
(866, 19.6, 76, 2008),
(867, 22.7, 76, 2009),
(868, 18.1, 76, 2011),
(869, 17.2, 77, 2006),
(870, 15.1, 77, 2007),
(871, 13.6, 77, 2008),
(872, 21, 77, 2009),
(873, 18.3, 77, 2011),
(874, 22, 78, 2006),
(875, 19, 78, 2007),
(876, 17, 78, 2008),
(877, 11, 78, 2009),
(878, 14.4, 78, 2011),
(879, 7.4, 79, 2006),
(880, 9.1, 79, 2007),
(881, 11.5, 79, 2008),
(882, 13.3, 79, 2009),
(883, 10.8, 79, 2011),
(884, 4.3, 80, 2006),
(885, 3.6, 80, 2007),
(886, 3.9, 80, 2008),
(887, 8.5, 80, 2009),
(888, 11.2, 80, 2011),
(889, 11.4, 81, 2006),
(890, 14.5, 81, 2007),
(891, 10, 81, 2008),
(892, 12.8, 81, 2009),
(893, 13.9, 81, 2011),
(894, 10.3, 82, 2006),
(895, 11.9, 82, 2007),
(896, 4.4, 82, 2008),
(897, 8.8, 82, 2009),
(898, 7.7, 82, 2011),
(899, 16.5, 83, 2006),
(900, 14.7, 83, 2007),
(901, 14.6, 83, 2008),
(902, 13.2, 83, 2009),
(903, 8.6, 83, 2011),
(904, 13.9, 84, 2006),
(905, 15.6, 84, 2007),
(906, 12.9, 84, 2008),
(907, 20.4, 84, 2009),
(908, 13, 84, 2011),
(909, 16.2, 85, 2006),
(910, 20.9, 85, 2007),
(911, 19.4, 85, 2008),
(912, 15.4, 85, 2009),
(913, 16.1, 85, 2011),
(914, 4, 86, 2006),
(915, 5.3, 86, 2007),
(916, 4.2, 86, 2008),
(917, 9.3, 86, 2009),
(918, 7.4, 86, 2011),
(919, 11.9, 87, 2006),
(920, 10.1, 87, 2007),
(921, 23.4, 88, 2006),
(922, 23.9, 88, 2007),
(923, 20.6, 88, 2008),
(924, 19.1, 88, 2009),
(925, 17.1, 88, 2011),
(926, 22.3, 89, 2006),
(927, 19.5, 89, 2007),
(928, 22.1, 89, 2008),
(929, 21.2, 89, 2009),
(930, 15.1, 89, 2011),
(931, 29.9, 90, 2006),
(932, 20.6, 90, 2007),
(933, 23.2, 90, 2008),
(934, 25.1, 90, 2009),
(935, 19.6, 90, 2011),
(936, 24.6, 91, 2006),
(937, 21.7, 91, 2007),
(938, 21.5, 91, 2008),
(939, 21, 91, 2009),
(940, 17, 91, 2011),
(941, 16.9, 92, 2006),
(942, 16.8, 92, 2007),
(943, 18.2, 92, 2008),
(944, 18.2, 92, 2009),
(945, 17.2, 92, 2011),
(1001, 17.9, 42, 2006),
(1002, 10.7, 42, 2007),
(1003, 17.7, 42, 2008),
(1004, 19.6, 42, 2009),
(1005, 24.4, 42, 2011),
(1007, 9.8, 47, 2011),
(1008, 12.1, 87, 2008),
(1010, 10.4, 87, 2011),
(2009, 11.6, 87, 2009);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `hood`
--

CREATE TABLE `hood` (
  `hood_id` int(11) NOT NULL,
  `hood_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `hood`
--

INSERT INTO `hood` (`hood_id`, `hood_name`) VALUES
(26, 'Selecteer een wijk'),
(27, 'Tarwewijk'),
(28, 'Carnisse'),
(29, 'Zuidwijk'),
(30, 'Oud Charlois'),
(31, 'Wielewaal'),
(32, 'Zuidplein'),
(33, 'Pendrecht'),
(34, 'Heijplaat'),
(35, 'Schiebroek'),
(36, 'Hillegersberg Zuid'),
(37, 'Hillegersberg Noord'),
(38, 'Terbregge'),
(39, 'Molenlaankwartier'),
(40, 'Delfshaven'),
(41, 'Bospolder'),
(42, 'Tussendijken'),
(43, 'Spangen'),
(44, 'Nieuwe Westen'),
(45, 'Middelland'),
(46, 'Oud/Nieuw Mathenesse/Witte Dorp'),
(47, 'Schiemond'),
(48, 'Kop van Zuid Entrepot'),
(49, 'Vreewijk'),
(50, 'Bloemhof'),
(51, 'Hillesluis'),
(52, 'Katendrecht'),
(53, 'Afrikaanderwijk'),
(54, 'Feijenoord'),
(55, 'Noordereiland'),
(56, 'Hoek van Holland'),
(57, 'Hoogvliet Noord'),
(58, 'Hoogvliet Zuid'),
(59, 'Oud IJsselmonde'),
(60, 'Lombardijen'),
(61, 'Groot IJsselmonde'),
(62, 'Beverwaard'),
(63, 'Rubroek'),
(64, 'Nieuw Crooswijk'),
(65, 'Oud Crooswijk'),
(66, 'Kralingen West'),
(67, 'Kralingen Oost/Kralingse Bos'),
(68, 'De Esch'),
(69, 'Struisenburg'),
(70, 'Agniesebuurt'),
(71, 'Provenierswijk'),
(72, 'Bergpolder'),
(73, 'Blijdorp'),
(74, 'Liskwartier'),
(75, 'Oude Noorden'),
(76, 'Kleinpolder'),
(77, 'Overschie eo'),
(78, 'Pernis'),
(79, 's-Gravenland'),
(80, 'Kralingse Veer'),
(81, 'Prinsenland'),
(82, 'Het Lage Land'),
(83, 'Ommoord'),
(84, 'Oosterflank'),
(85, 'Zevenkamp'),
(86, 'Nesselande'),
(87, 'Rozenburg'),
(88, 'Stadsdriehoek/C.S. Kwartier'),
(89, 'Oude Westen'),
(90, 'Cool/Nieuwe Werk/Dijkzigt'),
(91, 'Stadscentrum'),
(92, 'Rotterdam');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `hood_points`
--

CREATE TABLE `hood_points` (
  `hood_points_id` int(11) NOT NULL,
  `points` float DEFAULT NULL,
  `hood_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `hood_points`
--

INSERT INTO `hood_points` (`hood_points_id`, `points`, `hood_id`) VALUES
(199, 3.5, 78),
(205, 2.6, 44),
(206, 3.6, 58),
(208, 4.1, 56),
(210, 3.9, 82),
(213, 2.2, 88),
(214, 3.5, 35),
(216, 2.3, 63),
(219, 2.3, 28),
(220, 3.1, 61),
(221, 2.1, 51),
(222, 1.9, 62),
(229, 3.2, 40),
(231, 3.5, 81),
(235, 2.3, 49),
(236, 2.7, 48),
(237, 4, 86),
(241, 3.1, 84),
(243, 2.9, 67),
(244, 2.5, 66),
(245, 3.6, 57),
(248, 3.2, 60),
(249, 3.1, 77),
(250, 2.1, 75),
(251, 2.1, 75),
(253, 3.3, 72),
(254, 2.8, 43),
(256, 3.6, 73),
(257, 2.5, 53),
(259, 2.4, 33),
(264, 1.9, 90);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `parkgarage`
--

CREATE TABLE `parkgarage` (
  `parkgarage_id` int(11) NOT NULL,
  `parkgarage_name` varchar(255) DEFAULT NULL,
  `parkgarage_code` varchar(255) DEFAULT NULL,
  `langitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `parkgarage_address_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `parkgarage`
--

INSERT INTO `parkgarage` (`parkgarage_id`, `parkgarage_name`, `parkgarage_code`, `langitude`, `longitude`, `parkgarage_address_id`) VALUES
(1, 'P+R Pernis (Rotterdam)', '599_PERNIS', 51.88471, 4.381786, 1),
(2, 'Garage Boulevard Zuid (Rotterdam)', '599_BOUZ', 51.898207, 4.51103, 2),
(3, 'Garage Zoomstraat (Rotterdam)', '599_ZMST', 51.93651, 4.483875, 3),
(4, 'P+R Slinge (Rotterdam)', '599_PRSL', 51.874141, 4.477503, 4),
(5, 'Garage Veranda (Rotterdam)', '599_VERA', 51.896826, 4.527824, 5),
(6, 'Garage Kiphof (Rotterdam)', '599_KIPH', 51.92174, 4.492332, 6),
(7, 'Garage Nieuwe Binnenweg (Rotterdam)', '599_NWBW', 51.910645, 4.451188, 7),
(8, 'P+R Hoogvliet Zalmplaat (Rotterdam)', '599_HOOGZA', 51.860247, 4.354667, 8),
(9, 'Garage World Port Center (Rotterdam)', '599_WPC', 51.904862, 4.484671, 9),
(10, 'P+R Hoek van Holland (Rotterdam)', '599_HOEK', 51.973286, 4.140888, 10),
(11, 'Garage Westblaak (Rotterdam)', '599_WEST', 51.916411, 4.477952, 11),
(12, 'P+R Alexander (Rotterdam)', '599_PRAL', 51.952483, 4.549973, 12),
(13, 'Garage Benthuizerstraat (Rotterdam)', '599_BHST', 51.93605, 4.479279, 13),
(14, 'Garage Mathenesserplein (Rotterdam)', '599_MATP', 51.918159, 4.444795, 14),
(15, 'P+R Proveniersplein (Rotterdam)', '599_PROV', 51.926068, 4.469854, 15),
(16, 'P+R Melanchtonweg (Rotterdam)', '599_MELAN', 51.949166, 4.471467, 16),
(17, 'P+R Meijersplein (Rotterdam)', '599_MPLEIN', 51.955679, 4.457328, 17),
(18, 'Garage Oude Haven (Rotterdam)', '599_OUHA', 51.92086, 4.492952, 18),
(19, 'Garage Museumpark (Rotterdam)', '599_MUPL', 51.913674, 4.470555, 19),
(20, 'Weena (Rotterdam)', '599_WEENA', 51.922468, 4.463711, 20),
(21, 'Zuidplein (Rotterdam)', '599_ZUIDPL', 51.887077, 4.490022, 21),
(22, 'Garage Hart van IJsselmonde (Rotterdam)', '599_HART', 51.888384, 4.548958, 22),
(23, 'Garage Colosseumweg (Rotterdam)', '599_COLW', 51.899154, 4.512353, 23),
(24, 'P+R Beverwaard (Rotterdam)', '599_BEVER', 51.884817, 4.566634, 24),
(25, 'P+R Hoogvliet Tussenwater (Rotterdam)', '599_HOOGTU', 51.867528, 4.380746, 25),
(26, 'Ikazia (Ziekenhuis) (Rotterdam)', '599_IKAZIA', 51.886169, 4.493907, 26),
(27, 'Garage Kruiskade (Rotterdam)', '599_KRUI', 51.923201, 4.476211, 27),
(28, 'Garage The Red Apple Parkeerkelder (Rotterdam)', '599_RED', 51.917229, 4.488321, 28),
(29, 'P+R Kralingse Zoom (Rotterdam)', '599_KRAL', 51.920701, 4.533021, 29),
(30, 'Garage De Boompjes (Rotterdam)', '599_BOOM', 51.914043, 4.485541, 30),
(31, 'Schiecentrale (Rotterdam)', '599_SCHIE', 51.904048, 4.458551, 31),
(32, 'P+R Schenkel (Rotterdam)', '599_SCHENK', 51.931771, 4.563377, 32),
(33, 'P+R Capelsebrug (Rotterdam)', '599_CAPEL', 51.920639, 4.558823, 33),
(34, 'Garage Lijnbaan (Rotterdam)', '599_LIJN', 51.918728, 4.476802, 34),
(35, 'Maastoren (Rotterdam)', '599_MAAS', 51.908684, 4.493162, 35),
(36, 'P+R Hoogvliet (Rotterdam)', '599_HOOGPR', 51.860247, 4.354667, 36),
(37, 'P+R Noorderhelling (Rotterdam)', '599_NOORD', 51.895184, 4.53467, 37),
(38, 'De Rotterdam (Rotterdam)', '599_ROT', 51.906345, 4.48795, 38),
(39, 'P+R Nesselande (Rotterdam)', '599_NESSE', 51.978011, 4.590285, 39),
(40, 'Terrein Alexandrium II Megastores (Rotterdam)', '599_ALE2', 51.951437, 4.558188, 40),
(41, 'Garage De Bijenkorf (Rotterdam)', '599_BIJE', 51.920857, 4.477924, 41),
(42, 'Garage Koopgoot (Rotterdam)', '599_KOOP', 51.91923, 4.481526, 42),
(43, 'Garage Alexandrium III Woonmall (Rotterdam)', '599_ALE3', 51.951263, 4.557674, 43),
(44, 'Gehele Stad', 'V5999', 51.92442, 4.477733, 44),
(45, 'P+R Kralingse Zoom (Rotterdam)', '599_KRZM', 51.920701, 4.533021, 45),
(46, 'Garage Lusthofstraat (Rotterdam)', '599_LUST', 51.925685, 4.509852, 46),
(47, 'Garage Hoogvliet Centrum (Rotterdam)', '599_HOOG', 51.861464, 4.366741, 47),
(48, 'Garage Zorgboulevard (Rotterdam)', '599_ZORG', 51.87888, 4.533468, 48),
(49, 'Garage Blaak 16 (Rotterdam)', '599_BLAA', 51.918815, 4.487807, 49),
(50, 'P+R Station Rotterdam Lombardijen (Rotterdam)', '599_PRLOM', 51.880402, 4.530868, 50),
(51, 'Carpool Schieveensedijk (Rotterdam)', '599_CPSCH', 51.952051, 4.420501, 51),
(52, 'Noordplein 21', '15993', 51.9311014, 4.4831771, 52),
(53, 'Noordplein 233', '15998', 51.9299137, 4.4806855, 53),
(54, 'Garage Arrivals Parking (Rotterdam)', '599_ARPA', 51.922142, 4.470304, 54),
(55, 'Garage Eudokiaplein (Rotterdam)', '599_EUKO', 51.932879, 4.470045, 55),
(56, 'Garage Bigshops (Rotterdam)', '599_BIGS', 51.90941, 4.436469, 56),
(57, 'Garage Markthal (Rotterdam)', '599_MAR', 51.91993, 4.486842, 57),
(58, 'Garage De Vlaggeman (Rotterdam)', '599_VLAG', 51.926799, 4.436094, 58),
(59, 'Garage Jumbo Hillelaan (Rotterdam)', '599_JUM', 51.90299, 4.496208, 59),
(60, 'Garage Schouwburgplein 1 (Rotterdam)', '599_SCHBP', 51.920336, 4.473731, 60),
(61, 'Garage Plein 1953 (Rotterdam)', '599_PL53', 51.874549, 4.467818, 61),
(62, 'Garage Schouwburgplein 2 (Rotterdam)', '599_KRPL', 51.922763, 4.470522, 62),
(63, 'Garage Meent (Rotterdam)', '599_STJP', 51.924162, 4.482371, 63),
(64, 'Garage Erasmusbrug (Rotterdam)', '599_ERMB', 51.911372, 4.482159, 64),
(65, 'Erasmus MC Sofia', '599_ERMC', 51.910311, 4.469219, 65),
(66, 'Garage Westerpark', '599_WEST', 51.905381, 4.474401, 66),
(67, 'Garage Carnisselande', '599_CARN', 51.847258, 4.498686, 67);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `parkgarage_address`
--

CREATE TABLE `parkgarage_address` (
  `parkgarage_address_id` int(11) NOT NULL,
  `hood_id` int(11) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `street_number` varchar(15) DEFAULT NULL,
  `zipcode` varchar(15) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `parkgarage_address`
--

INSERT INTO `parkgarage_address` (`parkgarage_address_id`, `hood_id`, `street`, `street_number`, `zipcode`, `city`) VALUES
(1, 78, 'Schalekampplein ', '1', '3195 XW', 'Pernis'),
(2, 51, 'Polderstraat ', '10', '3074 XJ', 'Rotterdam'),
(3, 75, 'Raephorststraat ', '51-55', '3036 ', 'Rotterdam'),
(4, 33, 'Slinge', '763', '3086 EZ', 'Rotterdam'),
(5, 49, 'Siem Heidenstraat', '6', '3077 MK', 'Rotterdam'),
(6, 63, 'Kipstraat', '117', '3011 ZX', 'Rotterdam'),
(7, 44, 'Nieuwe Binnenweg', '388C', '3023 ET', 'Rotterdam'),
(8, 58, 'Doggersbank', '1', '3192 DA', 'Hoogvliet Rotterdam\r\n'),
(9, 48, 'Wilhelminakade', '981', '3072 AP', 'Rotterdam'),
(10, 56, 'Prins Hendrikstraat', '1', '3151 AE', 'Hoek van Holland'),
(11, 90, 'Hartmansstraat', '35', '3012 VA', 'Rotterdam'),
(12, 82, 'Prins Alexanderlaan', '35', '3068 PN', 'Rotterdam'),
(13, 75, 'Bloklandstraat', '154', '3063 TS', 'Rotterdam'),
(14, 43, 'Aelbrechtskade', '67', '3023 JA', 'Rotterdam'),
(15, 88, 'EC, Proveniersplein', '1', '3033 JA', 'Rotterdam'),
(16, 35, 'Melanchtonweg', '1', '3045 JA', 'Rotterdam'),
(17, 77, 'Fairoaksbaan', '300', '3045 AS', 'Rotterdam'),
(18, 63, 'Burgemeester van Walsumweg', '718', '3011 MZ', 'Rotterdam'),
(19, 90, 'Museumpark', '32', '3015 CX', 'Rotterdam'),
(20, 90, 'Karel Doormanstraat', '10', '3012 GJ', 'Rotterdam'),
(21, 28, 'Twentestraat', '10', '3083 BD', 'Rotterdam'),
(22, 61, 'Koningswaard', '3', '3078 AA', 'Rotterdam'),
(23, 51, 'Colosseumweg', '13', '3074 EJ', 'Rotterdam'),
(24, 62, 'Edo Bergsmaweg', '1', '3077 PX', 'Rotterdam'),
(25, 57, 'Koddeweg', '1', '3194 DH', 'Rotterdam'),
(26, 49, 'Montessoriweg', '9', '3083 AN', 'Rotterdam'),
(27, 90, 'Kruiskade', '21', '3012 EE', 'Rotterdam'),
(28, 90, 'Wijnbrugstraat', '20', '3011 XW', 'Rotterdam'),
(29, 67, 'Kralingse Zoom ', '50', '3062 SM', 'Rotterdam'),
(30, 90, 'Tarwenakker', '18', '3011 VX', 'Rotterdam'),
(31, 40, 'Schiehavenkade', '120', '3024 EZ', 'Rotterdam'),
(32, 81, 'Kralingseweg', '461', '3065 RG', 'Rotterdam'),
(33, 81, 'Capelsebrugpad', '60', '3065 SM', 'Rotterdam'),
(34, 90, 'Crispijnstraat', '6', '3012 GB', 'Rotterdam'),
(35, 48, 'Wilhelminakade', '101', '3072 AP', 'Rotterdam'),
(36, 57, 'Langs de Baan', '94', '3191 TP', 'Hoogvliet'),
(37, 49, 'Stadionweg', '1', '3077 AN', 'Rotterdam'),
(38, 48, 'Wilhelminakade', '300', '3072 AR', 'Rotterdam'),
(39, 86, 'Corsicalaan', '1', '3059 LG', 'Rotterdam'),
(40, 84, 'Watermanweg', '1E', '3067 GA', 'Rotterdam'),
(41, 90, 'Aert van Nesstraat', '16', '3012 CA', 'Rotterdam'),
(42, 90, 'Bulgersteyn', '5', '3011 AB', 'Rotterdam'),
(43, 84, 'Watermanweg', '1E', '3067 GA', 'Rotterdam'),
(44, 90, 'Hofplein', '1', '3012 JA', 'Rotterdam'),
(45, 67, 'Kralingse Zoom', '50', '3062 SM', 'Rotterdam'),
(46, 66, 'Chris Bennekerslaan', '25C', '3061 EB', 'Rotterdam'),
(47, 57, 'Klencke', '74', '3191 VK', 'Hoogvliet'),
(48, 60, 'Krimpenerstraat', '9', '3079 DZ', 'Rotterdam'),
(49, 90, 'Hartmansstraat', '35', '3012 VA', 'Rotterdam'),
(50, 60, 'Aristotelesstraat', '294', '3076 BE', 'Rotterdam'),
(51, 77, 'Schieveensdijk', '13', '3045 AP', 'Rotterdam'),
(52, 75, 'Noordplein', '21', '3035 KD', 'Rotterdam'),
(53, 75, 'Noordplein', '233', '3035 KD', 'Rotterdam'),
(54, 90, 'Kruisplein', '19', '3014 DB', 'Rotterdam'),
(55, 72, 'Voorburgstraat', '200', '3037 BT', 'Rotterdam'),
(56, 43, 'Vierhavensstraat', '77', '3029 BB', 'Rotterdam'),
(57, 90, 'Dominee Jan Scharpstraat', '306', '3011 GZ', 'Rotterdam'),
(58, 73, 'Abraham van Stolkweg', '74', '3041 JA', 'Rotterdam'),
(59, 53, 'Hillelaan', '77', '3072 JE', 'Rotterdam'),
(60, 90, 'Schouwburgplein', '22', '3012 CL', 'Rotterdam'),
(61, 33, 'Plein 1953', '31', '3086 ED', 'Rotterdam'),
(62, 90, 'Weenatunnel', '50', '3013 AL', 'Rotterdam'),
(63, 90, 'Binnenrotte', '15', '3011 HB', 'Rotterdam'),
(64, 90, 'Gedempte Zalmhaven', '1', '3016 DR', 'Rotterdam'),
(65, 90, 'Wytemaweg', '80', '3015 CN', 'Rotterdam'),
(66, 90, 'Westerlaan', '10', '3016 CK', 'Rotterdam'),
(67, NULL, 'Middeldijkerplein', '20', '2993 DL', 'Barendrecht');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `parkgarage_details`
--

CREATE TABLE `parkgarage_details` (
  `parkgarage_details_id` int(11) NOT NULL,
  `parkgarage_code` varchar(255) DEFAULT NULL,
  `car_capacity` int(11) DEFAULT NULL,
  `charging_capacity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `parkgarage_details`
--

INSERT INTO `parkgarage_details` (`parkgarage_details_id`, `parkgarage_code`, `car_capacity`, `charging_capacity`) VALUES
(1, '599_KRZM', 1700, 4),
(2, '599_WEST', 780, 0),
(3, '599_PL53', 69, 0),
(4, '599_VLAG', 340, 0),
(5, '599_BIGS', 750, 0),
(6, '599_BLAA', 125, 0),
(7, '599_HOOGPR', 229, 0),
(8, '599_ALE3', 850, 0),
(9, '599_ROT', 642, 0),
(10, '599_WEENA', 480, 1),
(11, '599_BIJE', 460, 1),
(12, '599_KOOP', 435, 1),
(13, '599_SCHIE', 394, 1),
(14, '599_ZUIDPL', 1400, 1),
(15, '599_PROV', 106, 0),
(16, '599_ZORG', 1773, 0),
(17, '599_ALE2', 180, 0),
(18, '599_MAAS', 446, 0),
(19, '599_HART', 1200, 0),
(20, '599_IKAZIA', 439, 1),
(21, '599_CPSCH', 26, 0),
(22, '599_WPC', 505, 27),
(23, '599_MAR', 1024, 9),
(24, '599_ARPA', 399, 20),
(25, '599_RED', 337, 0),
(26, '599_LIJN', 540, 2),
(27, '599_EUKO', 220, 0),
(28, '599_JUM', 57, 0),
(29, '599_KRUI', 275, 0),
(30, '599_MUPL', 1162, 4),
(31, '599_STJP', 548, 0),
(32, '599_KRAL', 1700, 12),
(33, '599_COLW', 203, 0),
(34, '599_BOUZ', 189, 0),
(35, '599_BOOM', 623, 22),
(36, '599_KIPH', 339, 2),
(37, '599_VERA', 589, 0),
(38, '599_BHST', 135, 0),
(39, '599_PRAL', 437, 2),
(40, '599_OUHA', 229, 0),
(41, '599_MPLEIN', 500, 0),
(42, '599_PRSL', 849, 2),
(43, '599_NWBW', 115, 2),
(44, '599_KRPL', 760, 10),
(45, '599_SCHBP', 730, 2),
(46, '599_ZMST', 94, 0),
(47, '599_LUST', 217, 0),
(48, '599_ERMB', 327, 1),
(49, '599_HOOG', 257, 0),
(50, '599_MATP', 156, 0),
(51, '599_CARN', 700, 0),
(52, '15993', 50, 0),
(53, '15998', 53, 0),
(54, '599_PERNIS', 33, 0),
(55, '599_HOEK', 82, 0),
(56, '599_MELAN', 80, 0),
(57, '599_HOOGZA', 22, 0),
(58, '599_BEVER', 508, 0),
(59, '599_HOOGTU', 62, 0),
(60, '599_SCHENK', 102, 0),
(61, '599_CAPEL', 430, 0),
(62, '599_NOORD', 350, 0),
(63, '599_NESSE', 61, 0),
(64, 'V599', 0, 0),
(65, '599_PRLOM', 236, 0),
(66, '599_ERMC', 680, 0);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `theft_outof_car`
--

CREATE TABLE `theft_outof_car` (
  `theft_outof_car_id` int(11) NOT NULL,
  `percentage` float DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `hood_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `theft_outof_car`
--

INSERT INTO `theft_outof_car` (`theft_outof_car_id`, `percentage`, `year`, `hood_id`) VALUES
(322, 20.2, 2006, 27),
(323, 25.6, 2007, 27),
(324, 16.1, 2008, 27),
(325, 20, 2009, 27),
(326, 15.3, 2011, 27),
(327, 27.4, 2006, 28),
(328, 17.9, 2007, 28),
(329, 10.5, 2008, 28),
(330, 18.4, 2009, 28),
(331, 17.9, 2011, 28),
(332, 20.3, 2006, 29),
(333, 15.2, 2007, 29),
(334, 15, 2008, 29),
(335, 12.3, 2009, 29),
(336, 11.3, 2011, 29),
(337, 29.9, 2006, 30),
(338, 21.7, 2007, 30),
(339, 19, 2008, 30),
(340, 18.5, 2009, 30),
(341, 22.8, 2011, 30),
(342, 15.9, 2006, 31),
(343, 9.7, 2007, 31),
(344, 4.8, 2008, 31),
(345, 24.3, 2009, 31),
(346, 24, 2011, 31),
(347, 33.2, 2006, 32),
(348, 26.1, 2007, 32),
(349, 24.2, 2008, 32),
(350, 19.9, 2009, 32),
(351, 19.4, 2011, 32),
(352, 23.2, 2006, 33),
(353, 19, 2007, 33),
(354, 17, 2008, 33),
(355, 18.2, 2009, 33),
(356, 18.3, 2011, 33),
(357, 6.2, 2006, 34),
(358, 3, 2007, 34),
(359, 1.3, 2008, 34),
(360, 8.3, 2009, 34),
(361, 8.6, 2011, 34),
(362, 18.9, 2006, 40),
(363, 16.2, 2007, 40),
(364, 10.8, 2008, 40),
(365, 11.3, 2009, 40),
(366, 9.4, 2011, 40),
(367, 18.9, 2006, 41),
(368, 14.3, 2007, 41),
(369, 15.7, 2008, 41),
(370, 15.3, 2009, 41),
(371, 16.3, 2011, 41),
(372, 15.1, 2006, 42),
(373, 8.5, 2007, 42),
(374, 14, 2008, 42),
(375, 13.7, 2009, 42),
(376, 21.4, 2011, 42),
(377, 10.5, 2006, 43),
(378, 10.2, 2007, 43),
(379, 17.9, 2008, 43),
(380, 19.7, 2009, 43),
(381, 14.5, 2011, 43),
(382, 17.7, 2006, 44),
(383, 14.8, 2007, 44),
(384, 17.3, 2008, 44),
(385, 19, 2009, 44),
(386, 15.3, 2011, 44),
(387, 24.4, 2006, 45),
(388, 26.9, 2007, 45),
(389, 21.5, 2008, 45),
(390, 26.7, 2009, 45),
(391, 20.5, 2011, 45),
(392, 13.7, 2006, 46),
(393, 12.5, 2007, 46),
(394, 12.8, 2008, 46),
(395, 13.6, 2009, 46),
(396, 19.8, 2011, 46),
(397, 14.6, 2006, 47),
(398, 6.5, 2007, 47),
(399, 11.8, 2008, 47),
(400, 7.6, 2009, 47),
(401, 12.2, 2011, 47),
(402, 23.7, 2006, 48),
(403, 21.4, 2007, 48),
(404, 24.3, 2008, 48),
(405, 15.2, 2009, 48),
(406, 15.1, 2011, 48),
(407, 21.3, 2006, 49),
(408, 20.6, 2007, 49),
(409, 18.1, 2008, 49),
(410, 19.4, 2009, 49),
(411, 16.6, 2011, 49),
(412, 27, 2006, 50),
(413, 25.5, 2007, 50),
(414, 24.3, 2008, 50),
(415, 21.3, 2009, 50),
(416, 25.2, 2011, 50),
(417, 19.2, 2006, 51),
(418, 19.8, 2007, 51),
(419, 22.2, 2008, 51),
(420, 16.7, 2009, 51),
(421, 19.4, 2011, 51),
(422, 22.6, 2006, 52),
(423, 11.9, 2007, 52),
(424, 15.6, 2008, 52),
(425, 14.7, 2009, 52),
(426, 6.8, 2011, 52),
(427, 21.4, 2006, 53),
(428, 18, 2007, 53),
(429, 17, 2008, 53),
(430, 23.3, 2009, 53),
(431, 14.8, 2011, 53),
(432, 13.3, 2006, 54),
(433, 11.4, 2007, 54),
(434, 16.3, 2008, 54),
(435, 17.4, 2009, 54),
(436, 16.5, 2011, 54),
(437, 14.8, 2006, 55),
(438, 10.2, 2007, 55),
(439, 12.5, 2008, 55),
(440, 12.5, 2009, 55),
(441, 8.6, 2011, 55),
(442, 10.9, 2006, 35),
(443, 7.3, 2007, 35),
(444, 9.5, 2008, 35),
(445, 8.4, 2009, 35),
(446, 11.2, 2011, 35),
(447, 13.1, 2006, 36),
(448, 11.2, 2007, 36),
(449, 9.9, 2008, 36),
(450, 7.9, 2009, 36),
(451, 8.9, 2011, 36),
(452, 3.9, 2006, 37),
(453, 4.5, 2007, 37),
(454, 10.7, 2008, 37),
(455, 8.4, 2009, 37),
(456, 10.2, 2011, 37),
(457, 1.1, 2006, 38),
(458, 2.7, 2007, 38),
(459, 3.4, 2008, 38),
(460, 11.8, 2009, 38),
(461, 9.8, 2011, 38),
(462, 6.8, 2006, 39),
(463, 9.7, 2007, 39),
(464, 11.9, 2008, 39),
(465, 6, 2009, 39),
(466, 9.4, 2011, 39),
(467, 8.5, 2006, 56),
(468, 3.2, 2007, 56),
(469, 3.3, 2008, 56),
(470, 4.9, 2009, 56),
(471, 3.9, 2011, 56),
(472, 10.2, 2006, 57),
(473, 9.7, 2007, 57),
(474, 13.7, 2008, 57),
(475, 10.4, 2009, 57),
(476, 7.1, 2011, 57),
(477, 9.6, 2006, 58),
(478, 6.1, 2007, 58),
(479, 9.4, 2008, 58),
(480, 6.8, 2009, 58),
(481, 9.6, 2011, 58),
(482, 11.4, 2006, 59),
(483, 15, 2007, 59),
(484, 12.5, 2008, 59),
(485, 14.6, 2009, 59),
(486, 12, 2011, 59),
(487, 9.1, 2006, 60),
(488, 13.4, 2007, 60),
(489, 11.3, 2008, 60),
(490, 11.2, 2009, 60),
(491, 11.1, 2011, 60),
(492, 13.7, 2006, 61),
(493, 16.2, 2007, 61),
(494, 14.7, 2008, 61),
(495, 12.2, 2009, 61),
(496, 14.3, 2011, 61),
(497, 15.9, 2006, 62),
(498, 18.1, 2007, 62),
(499, 20.1, 2008, 62),
(500, 15.3, 2009, 62),
(501, 23.5, 2011, 62),
(502, 21.2, 2006, 63),
(503, 17.6, 2007, 63),
(504, 27.1, 2008, 63),
(505, 25, 2009, 63),
(506, 14.5, 2011, 63),
(507, 16.1, 2006, 64),
(508, 16.3, 2007, 64),
(509, 17, 2008, 64),
(510, 21.3, 2009, 64),
(511, 14.8, 2011, 64),
(512, 14.6, 2006, 65),
(513, 20.6, 2007, 65),
(514, 27.6, 2008, 65),
(515, 23.2, 2009, 65),
(516, 14.7, 2011, 65),
(517, 18.3, 2006, 66),
(518, 24.7, 2007, 66),
(519, 21.1, 2008, 66),
(520, 22.8, 2009, 66),
(521, 14.4, 2011, 66),
(522, 14.7, 2006, 67),
(523, 22.1, 2007, 67),
(524, 22.4, 2008, 67),
(525, 19.1, 2009, 67),
(526, 15.5, 2011, 67),
(527, 12.6, 2006, 68),
(528, 16.9, 2007, 68),
(529, 16.6, 2008, 68),
(530, 19.4, 2009, 68),
(531, 13.2, 2011, 68),
(532, 20.3, 2006, 69),
(533, 18.4, 2007, 69),
(534, 32.8, 2008, 69),
(535, 22.5, 2009, 69),
(536, 11.5, 2011, 69),
(537, 31, 2006, 70),
(538, 28.1, 2007, 70),
(539, 24, 2008, 70),
(540, 24.1, 2009, 70),
(541, 17.8, 2011, 70),
(542, 22.1, 2006, 71),
(543, 20.3, 2007, 71),
(544, 15.6, 2008, 71),
(545, 14.1, 2009, 71),
(546, 18, 2011, 71),
(547, 12, 2006, 72),
(548, 15, 2007, 72),
(549, 13.6, 2008, 72),
(550, 12.7, 2009, 72),
(551, 11.9, 2011, 72),
(552, 13.8, 2006, 73),
(553, 11.7, 2007, 73),
(554, 9.7, 2008, 73),
(555, 10.8, 2009, 73),
(556, 15.7, 2011, 73),
(557, 17.6, 2006, 74),
(558, 18.9, 2007, 74),
(559, 14.6, 2008, 74),
(560, 16.4, 2009, 74),
(561, 14.7, 2011, 74),
(562, 34.4, 2006, 75),
(563, 19.6, 2007, 75),
(564, 24.7, 2008, 75),
(565, 20.2, 2009, 75),
(566, 17, 2011, 75),
(567, 11.1, 2006, 76),
(568, 16.7, 2007, 76),
(569, 15.4, 2008, 76),
(570, 25.4, 2009, 76),
(571, 17.2, 2011, 76),
(572, 8.4, 2006, 77),
(573, 9.4, 2007, 77),
(574, 10.8, 2008, 77),
(575, 18, 2009, 77),
(576, 13.3, 2011, 77),
(577, 13.5, 2006, 78),
(578, 12.1, 2007, 78),
(579, 8.9, 2008, 78),
(580, 6.1, 2009, 78),
(581, 6.1, 2011, 78),
(582, 4.5, 2006, 79),
(583, 13.7, 2007, 79),
(584, 11.3, 2008, 79),
(585, 15.9, 2009, 79),
(586, 10.3, 2011, 79),
(587, 0.7, 2006, 80),
(588, 1.3, 2008, 80),
(589, 3.4, 2009, 80),
(590, 1.1, 2011, 80),
(591, 9.1, 2006, 81),
(592, 12.5, 2007, 81),
(593, 9, 2008, 81),
(594, 11.7, 2009, 81),
(595, 9.1, 2011, 81),
(596, 8, 2006, 82),
(597, 14.4, 2007, 82),
(598, 7.2, 2008, 82),
(599, 8.2, 2009, 82),
(600, 6.2, 2011, 82),
(601, 14, 2006, 83),
(602, 13.1, 2007, 83),
(603, 10.7, 2008, 83),
(604, 11.2, 2009, 83),
(605, 9, 2011, 83),
(606, 13.1, 2006, 84),
(607, 16.3, 2007, 84),
(608, 12.4, 2008, 84),
(609, 14.2, 2009, 84),
(610, 14.2, 2011, 84),
(611, 11.1, 2006, 85),
(612, 14.5, 2007, 85),
(613, 10.4, 2008, 85),
(614, 14, 2009, 85),
(615, 13.7, 2011, 85),
(616, 3.5, 2006, 86),
(617, 6, 2007, 86),
(618, 6, 2008, 86),
(619, 12.4, 2009, 86),
(620, 11, 2011, 86),
(621, 23.1, 2006, 87),
(622, 24.5, 2007, 87),
(623, 32.1, 2006, 88),
(624, 29.9, 2007, 88),
(625, 25.8, 2008, 88),
(626, 25.3, 2009, 88),
(627, 18.3, 2011, 88),
(628, 20.6, 2006, 89),
(629, 23.8, 2007, 89),
(630, 21.2, 2008, 89),
(631, 19.8, 2009, 89),
(632, 12.6, 2011, 89),
(633, 34.9, 2006, 90),
(634, 26.9, 2007, 90),
(635, 22.7, 2008, 90),
(636, 31.6, 2009, 90),
(637, 20.2, 2011, 90),
(638, 29.3, 2006, 91),
(639, 27.2, 2007, 91),
(640, 23.7, 2008, 91),
(641, 24.8, 2009, 91),
(642, 16.9, 2011, 91),
(1001, 22, 2008, 87),
(1002, 21, 2009, 87),
(1003, 24, 2011, 87),
(1060, 0, 2006, 26);

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `damage_or_theft_car`
--
ALTER TABLE `damage_or_theft_car`
  ADD PRIMARY KEY (`damage_or_theft_car_id`),
  ADD KEY `hood_id` (`hood_id`);

--
-- Indexen voor tabel `hood`
--
ALTER TABLE `hood`
  ADD PRIMARY KEY (`hood_id`);

--
-- Indexen voor tabel `hood_points`
--
ALTER TABLE `hood_points`
  ADD PRIMARY KEY (`hood_points_id`),
  ADD KEY `hood_id` (`hood_id`);

--
-- Indexen voor tabel `parkgarage`
--
ALTER TABLE `parkgarage`
  ADD PRIMARY KEY (`parkgarage_id`);

--
-- Indexen voor tabel `parkgarage_address`
--
ALTER TABLE `parkgarage_address`
  ADD PRIMARY KEY (`parkgarage_address_id`),
  ADD KEY `hood_id` (`hood_id`);

--
-- Indexen voor tabel `parkgarage_details`
--
ALTER TABLE `parkgarage_details`
  ADD PRIMARY KEY (`parkgarage_details_id`);

--
-- Indexen voor tabel `theft_outof_car`
--
ALTER TABLE `theft_outof_car`
  ADD PRIMARY KEY (`theft_outof_car_id`),
  ADD KEY `hood_id` (`hood_id`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `damage_or_theft_car`
--
ALTER TABLE `damage_or_theft_car`
  MODIFY `damage_or_theft_car_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2010;
--
-- AUTO_INCREMENT voor een tabel `hood`
--
ALTER TABLE `hood`
  MODIFY `hood_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=93;
--
-- AUTO_INCREMENT voor een tabel `hood_points`
--
ALTER TABLE `hood_points`
  MODIFY `hood_points_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=267;
--
-- AUTO_INCREMENT voor een tabel `parkgarage`
--
ALTER TABLE `parkgarage`
  MODIFY `parkgarage_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;
--
-- AUTO_INCREMENT voor een tabel `parkgarage_address`
--
ALTER TABLE `parkgarage_address`
  MODIFY `parkgarage_address_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;
--
-- AUTO_INCREMENT voor een tabel `parkgarage_details`
--
ALTER TABLE `parkgarage_details`
  MODIFY `parkgarage_details_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;
--
-- AUTO_INCREMENT voor een tabel `theft_outof_car`
--
ALTER TABLE `theft_outof_car`
  MODIFY `theft_outof_car_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1061;
--
-- Beperkingen voor geëxporteerde tabellen
--

--
-- Beperkingen voor tabel `damage_or_theft_car`
--
ALTER TABLE `damage_or_theft_car`
  ADD CONSTRAINT `damage_or_theft_car_ibfk_1` FOREIGN KEY (`hood_id`) REFERENCES `hood` (`hood_id`);

--
-- Beperkingen voor tabel `hood_points`
--
ALTER TABLE `hood_points`
  ADD CONSTRAINT `hood_points_ibfk_1` FOREIGN KEY (`hood_id`) REFERENCES `hood` (`hood_id`);

--
-- Beperkingen voor tabel `parkgarage_address`
--
ALTER TABLE `parkgarage_address`
  ADD CONSTRAINT `parkgarage_address_ibfk_1` FOREIGN KEY (`hood_id`) REFERENCES `hood` (`hood_id`);

--
-- Beperkingen voor tabel `theft_outof_car`
--
ALTER TABLE `theft_outof_car`
  ADD CONSTRAINT `theft_outof_car_ibfk_1` FOREIGN KEY (`hood_id`) REFERENCES `hood` (`hood_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
