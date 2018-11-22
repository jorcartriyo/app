-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 22-11-2018 a las 12:18:52
-- Versión del servidor: 5.7.24-0ubuntu0.16.04.1
-- Versión de PHP: 7.0.32-4+ubuntu16.04.1+deb.sury.org+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `BDJorge`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `CLIENTES`
--

CREATE TABLE `CLIENTES` (
  `NOMBRE` varchar(50) NOT NULL,
  `TELEFONO` varchar(20) NOT NULL,
  `POBLACION` varchar(30) NOT NULL,
  `MARCA` varchar(20) NOT NULL,
  `MODELO` varchar(20) NOT NULL,
  `MATRICULA` varchar(20) NOT NULL,
  `ESTADO` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `MOTORMOT`
--

CREATE TABLE `MOTORMOT` (
  `ID` int(11) NOT NULL,
  `CLIENTE` varchar(100) NOT NULL,
  `MARCA` varchar(30) NOT NULL,
  `MODELO` varchar(50) NOT NULL,
  `MATRICULA` varchar(10) NOT NULL,
  `PRECIO` varchar(20) NOT NULL,
  `IMAGEN` varchar(800) NOT NULL,
  `ESTADO` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `MOTORMOT`
--

INSERT INTO `MOTORMOT` (`ID`, `CLIENTE`, `MARCA`, `MODELO`, `MATRICULA`, `PRECIO`, `IMAGEN`, `ESTADO`) VALUES
(1, '', 'SUZUKI', 'GSX250R', '56325CB', '13.000€', 'https://moto.suzuki.es/images/colores/ficha/GSX250RAL8_YAY_Right1.jpg', ''),
(2, '', 'SUZUKI', 'GSX-R125', '15325-CLM', '20.000€', 'https://moto.suzuki.es/images/colores/ficha/GSX-R125AL8_YUH_Right.jpg', ''),
(3, '', 'SUZUKI', 'GSX-S1000FA', '36255-VCD', '15.900€', 'https://moto.suzuki.es/images/colores/ficha/GSX-R125AL8_291_Right.jpg', ''),
(4, '', 'YAMAHA', 'FJR1300AE', '3625-NHG', '15.890€', 'https://www.arpem.com/imagenes/ficha/4/8/5/0/lateral.1154850.jpg', ''),
(5, '', 'YAMAHA', 'FJR 1300 AS', '2354487BK', '11.800€', 'https://motosnuevas.formulamoto.es/galeria/4395/Yamaha_FJR_1300_AS_2016.jpg', ''),
(6, '', 'YAMAHA', 'FJR 1300 AS', '23544858CD', '17.800€', 'https://banner2.kisspng.com/20180721/tqz/kisspng-yamaha-motor-company-yamaha-fjr1300-sport-touring-yamaha-rd400-5b52fd46dbf493.837337911532165446901.jpg', ''),
(7, '', 'YAMAHA', 'MT-09', '2542144BG', '15.800€', 'https://auto.ndtvimg.com/bike-images/colors/yamaha/mt-09/yamaha-mt-09-bluish-gray-solid.png?v=11', ''),
(8, '', 'KTM', '790 ADVETURE', '253544-BD', '12.500', 'https://www.ktm.com/globalassets/products-pim-data/ke2-motorcycles/travel/790-adventure-r/790-adventure-r-2019/f9603s3/pho_bike_90_re.png?404=fallback.png', ''),
(9, '', 'KTM', '1290 SUPER DUKE', '253155-CCC', '13.0000', 'https://www.ktm.com/globalassets/products-pim-data/ke2-motorcycles/naked-bike/1290-super-duke-r2/1290-super-duke-r-2019/f9986s2/pho_bike_90_re.png?404=fallback.png', ''),
(10, '', 'KTM', '1290 SUPER DUKE', '253155-CCC', '13.0000', 'https://www.ktm.com/globalassets/products-pim-data/ke2-motorcycles/naked-bike/1290-super-duke-r2/1290-super-duke-r-2019/f9986s2/pho_bike_90_re.png?404=fallback.png', '');

--
-- Disparadores `MOTORMOT`
--
DELIMITER $$
CREATE TRIGGER `updatecli` BEFORE UPDATE ON `MOTORMOT` FOR EACH ROW UPDATE CLIENTES SET ESTADO = 0 WHERE MATRICULA = NEW.MATRICULA
$$
DELIMITER ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `CLIENTES`
--
ALTER TABLE `CLIENTES`
  ADD PRIMARY KEY (`MATRICULA`);

--
-- Indices de la tabla `MOTORMOT`
--
ALTER TABLE `MOTORMOT`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
