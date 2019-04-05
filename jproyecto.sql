-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-04-2019 a las 07:08:04
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `jproyecto`
--
CREATE DATABASE IF NOT EXISTS `jproyecto` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `jproyecto`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bitacoras`
--

CREATE TABLE `bitacoras` (
  `id_bitacora` int(5) NOT NULL,
  `id_caso` varchar(8) NOT NULL,
  `observaciones` varchar(800) DEFAULT NULL,
  `descripcion_actividad` varchar(800) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bitacoras`
--

INSERT INTO `bitacoras` (`id_bitacora`, `id_caso`, `observaciones`, `descripcion_actividad`) VALUES
(1, 'Log19001', 'prueba de menu con devoluciones, es decir que cuando vuelva al menu y escoga este caso nuevamene\nno tendria que salirme las opciones de botones, veamos XDD', 'Se mejoro el logon\nprueba de Menu con finalizar caso\nFunco lo de Menu XDD'),
(2, 'Log19002', '', 'iniciando\nprueba 1 de esperando  aprobacion del area solicitante'),
(3, 'Log19003', 'prueba con mysql\nprueba con ide 15 devolviendo\nprobando la modificacion de los 7 dias ', 'prueba de caso en esperando aprobacion\nprueba 15, corroborando solo las 3  anteriores han funcionado'),
(4, 'Amb19002', '', ''),
(5, 'Amb19001', 'aun le falta xD\n', 'primera bitacora y esperando respuesta\n'),
(6, 'Amb19003', '', ''),
(7, 'Log19005', 'no esta ', 'suda prueba'),
(8, 'Log19006', 'prueba de observaciones ', 'prueba de actividad\nprueba de fin');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargo`
--

CREATE TABLE `cargo` (
  `id_cargo` int(5) NOT NULL,
  `nombre_cargo` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cargo`
--

INSERT INTO `cargo` (`id_cargo`, `nombre_cargo`) VALUES
(0, 'Administrador'),
(1, 'Jefe Desarrollo'),
(2, 'Jefe Funcional'),
(3, 'Programador'),
(4, 'Probador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caso`
--

CREATE TABLE `caso` (
  `id_caso` varchar(8) NOT NULL,
  `nombre_caso` varchar(80) NOT NULL,
  `descrip_req` varchar(10000) NOT NULL,
  `descrip_rechazo` varchar(10000) NOT NULL,
  `descripcion_jefedes` varchar(1000) NOT NULL,
  `id_estado` int(5) NOT NULL,
  `porcentaje_avance` mediumint(100) NOT NULL,
  `fecha_limite` varchar(10) DEFAULT NULL,
  `fecha_produccion` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `caso`
--

INSERT INTO `caso` (`id_caso`, `nombre_caso`, `descrip_req`, `descrip_rechazo`, `descripcion_jefedes`, `id_estado`, `porcentaje_avance`, `fecha_limite`, `fecha_produccion`) VALUES
('Amb19001', 'caso 1', 'prueba 1.1', '', '', 5, 0, '01-04-2019', ''),
('Amb19002', 'prueba 1.2', 'finalmente funca xD', '', '', 3, 0, '10-05-2019', ''),
('Amb19003', 'prueba 3', 'probando la solicitud de un caso de otra area', '', '', 3, 0, '24-05-2019', ''),
('Log19001', 'Primer Caso de Logistica', 'Se necesita un nuevo caso para esta area', '', 'empezar a trabajar en esto', 6, 10, '06-04-2019', ''),
('Log19002', 'Caso Log tipo 2', 'Necesitamos un caso que sea para cada empleado y \nno solo para el JF', '', '', 6, 80, '07-05-2019', ''),
('Log19003', 'caso numero 3', 'prueba 1.0', '', '', 7, 100, '23-06-2019', '03-04-2019'),
('Log19004', 'Caso numero cuatro', 'se necestita un caso para el area de logistica para el \ncontrol de llegadas tarde por parte de los empleados', 'preuba de rechazo', '', 2, 0, '', ''),
('Log19005', 'prueba 5', 'descripcioonn randow', '', 'acpetantaddd', 6, 10, '12-04-2019', ''),
('Log19006', 'caso de soli de prueba', 'descripcion de prueba', '', 'prueba de JD de descripcion de prueba', 6, 7, '12-05-2019', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamentos`
--

CREATE TABLE `departamentos` (
  `id_depto` int(5) NOT NULL,
  `nombre_depto` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `departamentos`
--

INSERT INTO `departamentos` (`id_depto`, `nombre_depto`) VALUES
(0, 'Logistica'),
(1, 'Ambiental'),
(2, 'Desarrollo'),
(3, 'Contabilidad'),
(4, 'Servicios');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `id_empleado` int(5) NOT NULL,
  `nombre_emp` varchar(80) NOT NULL,
  `apellidos` varchar(80) NOT NULL,
  `id_cargo` int(5) NOT NULL,
  `id_depto` int(5) NOT NULL,
  `edad` int(2) NOT NULL,
  `direccion` varchar(1000) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `password_emp` varchar(64) NOT NULL,
  `id_estado_emp` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`id_empleado`, `nombre_emp`, `apellidos`, `id_cargo`, `id_depto`, `edad`, `direccion`, `telefono`, `correo`, `password_emp`, `id_estado_emp`) VALUES
(0, 'lucas', 'apel1', 1, 0, 25, 'direccion 1', '1234-1200', 'mycorreo@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(1, 'jose', 'apel2', 1, 1, 26, 'direccion 2', '1234-1201', 'mycorreo1@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(2, 'jaun', 'apel3', 2, 0, 27, 'direccion 3', '1234-1202', 'mycorreo2@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(3, 'isma', 'apel4', 2, 1, 28, 'direccion 4', '1234-1203', 'mycorreo3@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(4, 'pro', 'apel1', 3, 0, 29, 'direccion 5', '1234-1204', 'mycorreo4@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(5, 'emp', 'apel1', 4, 0, 25, 'direccion 6', '1234-1205', 'mycorreo5@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(6, 'pro1', 'apel2', 3, 1, 29, 'direccion 7', '1234-1206', 'mycorreo6@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(7, 'emp1', 'apel3', 4, 1, 25, 'direccion 8', '1234-1207', 'mycorreo7@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(8, 'UserPrincipal', 'Apellido', 0, 0, 25, 'direccion 9', '1234-1208', 'admin@gmail.com', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', 0),
(9, 'new User', 'Apel de Des', 1, 3, 25, 'Direccion 10', '1212-2121', 'correoRR@gmail.com', 'e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855', 0),
(10, 'lucas', 'prueba', 4, 1, 25, 'prueba direccion', '1111-2222', 'prueba@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 1),
(11, 'programador log 2', 'apellido', 3, 0, 21, 'direccion de prog 2', '2121-4545', 'prog2_log@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(12, 'programador log 3', 'apellido', 3, 0, 22, 'direccion de prog 3', '2323-4545', 'prog3_log@gmail.coom', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(13, 'programador log 4', 'apellido', 3, 0, 23, 'direccion de prog 4', '4556-1212', 'prog4_log@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(14, 'programador log 5', 'apellido', 3, 0, 24, 'direccion de prog 5', '5555-5555', 'prog5_log@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(15, 'tester log 2', 'apellido', 4, 0, 21, 'direccion de tester 2', '2222-2222', 'tes2_log@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(16, 'tester log 3', 'apellido', 4, 0, 22, 'direccion de tester 3', '3333-3333', 'tes3_log@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(17, 'tester log 4', 'apellido', 4, 0, 23, 'direccion de tester 4', '4444-4444', 'tes4_log@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(18, 'tester log 5', 'apellido', 4, 0, 24, 'direccion de tester 5', '5555-5555', 'tes5_log@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(19, 'programador amb 2', 'apellido', 3, 1, 31, 'direccion prog2', '2222-2222', 'prog2_amb@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(20, 'programador amb 3', 'apellido', 3, 1, 33, 'direccion de prog 3', '3333-3333', 'prog3_amb@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(21, 'Patron JD  Desarrollo', 'apellido', 1, 2, 40, 'direcicon de jd', '4444-4444', 'jd_des@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(22, 'patrong jf desarrollo', 'apellido', 2, 2, 45, 'direccion de jf', '5454-5656', 'jf_des@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(23, 'programdor des 1', 'apellido', 3, 2, 25, 'direccion de prog 1', '1111-5565', 'prog1_des@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(24, 'programador des 2', 'apellido ', 3, 2, 24, 'direccion de prog 2', '7878-7887', 'prog2_des@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(25, 'programador des 3', 'apellido', 3, 2, 25, 'direccion de prog 3', '4578-4512', 'prog3_des@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(26, 'tester des 1', 'apellido', 4, 2, 22, 'direccion tes1', '4545-7812', 'tes1_des@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(27, 'tester des 2', 'apellido', 4, 2, 26, 'direccion tes2', '1212-7878', 'tes2_des@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(28, 'tester des 3', 'apellido ', 4, 2, 56, 'direccion de tes 3', '4578-9596', 'tes3_des@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(29, 'patron jf conta', 'apellido', 2, 3, 56, 'direcicon de jf', '7878-4545', 'jf_conta@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(30, 'prog conta 1', 'apellido', 3, 3, 45, 'direccion prog 1', '9898-5656', 'prog1_conta@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(31, 'prog conta 2', 'apellido ', 3, 3, 24, 'direccion prog 2', '6523-1245', 'prog2_conta@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(32, 'prog conta 3', 'apellido', 3, 3, 26, 'direccion prog 3', '3333-9663', 'prog3_conta@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(33, 'tester conta 1', 'apellidos', 4, 3, 31, 'direccion ', '3265-8525', 'tes1_conta@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(34, 'tester conta 2', 'apellido', 4, 3, 24, 'direccion tester 2', '6598-1003', 'tes2_conta@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(35, 'tester conta 3', 'apellido ', 4, 3, 23, 'direccion 23', '2010-3025', 'tes3_conta@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(36, 'patron jd servi', 'apellido de jd', 1, 4, 14, 'direcicon jd', '4010-5000', 'jd_servi@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(37, 'patron jf servi', 'apellido', 2, 4, 20, 'direccion jf', '4040-1010', 'jf_servi@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(38, 'prog servi 1', 'apellido p 1', 3, 4, 25, 'direccion p1', '5050-2321', 'prog1_servi@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(39, 'prog servi 2', 'apellido p2', 3, 4, 22, 'direccion de p2', '5050-9291', 'prog2_servi@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(40, 'prog servi 3', 'apellido p3', 3, 4, 21, 'direccion de p3', '7070-8989', 'prog3_servi@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(41, 'tester servi 1', 'apellido t1', 4, 4, 23, 'direccion t1', '8080-4512', 'tes1_servi@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(42, 'tester servi 2', 'apellido t2', 4, 4, 24, 'direccion t2', '8080-5051', 'tes2_servi@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0),
(43, 'tester servi 3', 'apellido t3', 4, 4, 25, 'direccion t3', '4561-4561', 'tes3_servi@gmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados_caso`
--

CREATE TABLE `empleados_caso` (
  `id_empleado` int(5) NOT NULL,
  `id_caso` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleados_caso`
--

INSERT INTO `empleados_caso` (`id_empleado`, `id_caso`) VALUES
(4, 'Log19001'),
(5, 'Log19001'),
(4, 'Log19002'),
(5, 'Log19002'),
(4, 'Log19003'),
(5, 'Log19003'),
(6, 'Amb19001'),
(7, 'Amb19001'),
(6, 'Amb19002'),
(7, 'Amb19002'),
(6, 'Amb19003'),
(7, 'Amb19003'),
(4, 'Log19005'),
(5, 'Log19005'),
(4, 'Log19006'),
(5, 'Log19006');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estados`
--

CREATE TABLE `estados` (
  `id_estado` int(5) NOT NULL,
  `nombre_estado` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estados`
--

INSERT INTO `estados` (`id_estado`, `nombre_estado`) VALUES
(1, 'En espera de respuesta'),
(2, 'Solicitud rechazada'),
(3, 'En desarrollo'),
(4, 'Esperando aprobación de área solicitante'),
(5, 'Vencido'),
(6, 'Devuelto con observaciones'),
(7, 'Finalizado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_empleados`
--

CREATE TABLE `estado_empleados` (
  `id_estado` int(5) NOT NULL,
  `estado` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estado_empleados`
--

INSERT INTO `estado_empleados` (`id_estado`, `estado`) VALUES
(0, 'Activo'),
(1, 'Inactivo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bitacoras`
--
ALTER TABLE `bitacoras`
  ADD PRIMARY KEY (`id_bitacora`),
  ADD KEY `id_caso` (`id_caso`);

--
-- Indices de la tabla `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`id_cargo`);

--
-- Indices de la tabla `caso`
--
ALTER TABLE `caso`
  ADD PRIMARY KEY (`id_caso`),
  ADD KEY `id_estado` (`id_estado`);

--
-- Indices de la tabla `departamentos`
--
ALTER TABLE `departamentos`
  ADD PRIMARY KEY (`id_depto`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`id_empleado`),
  ADD KEY `id_cargo` (`id_cargo`),
  ADD KEY `id_depto` (`id_depto`),
  ADD KEY `id_estado_emp` (`id_estado_emp`);

--
-- Indices de la tabla `empleados_caso`
--
ALTER TABLE `empleados_caso`
  ADD KEY `id_empleado` (`id_empleado`),
  ADD KEY `id_caso` (`id_caso`);

--
-- Indices de la tabla `estados`
--
ALTER TABLE `estados`
  ADD PRIMARY KEY (`id_estado`);

--
-- Indices de la tabla `estado_empleados`
--
ALTER TABLE `estado_empleados`
  ADD PRIMARY KEY (`id_estado`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bitacoras`
--
ALTER TABLE `bitacoras`
  ADD CONSTRAINT `bitacoras_ibfk_1` FOREIGN KEY (`id_caso`) REFERENCES `caso` (`id_caso`);

--
-- Filtros para la tabla `caso`
--
ALTER TABLE `caso`
  ADD CONSTRAINT `caso_ibfk_1` FOREIGN KEY (`id_estado`) REFERENCES `estados` (`id_estado`);

--
-- Filtros para la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`id_cargo`) REFERENCES `cargo` (`id_cargo`),
  ADD CONSTRAINT `empleados_ibfk_2` FOREIGN KEY (`id_depto`) REFERENCES `departamentos` (`id_depto`),
  ADD CONSTRAINT `empleados_ibfk_3` FOREIGN KEY (`id_estado_emp`) REFERENCES `estado_empleados` (`id_estado`);

--
-- Filtros para la tabla `empleados_caso`
--
ALTER TABLE `empleados_caso`
  ADD CONSTRAINT `empleados_caso_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleados` (`id_empleado`),
  ADD CONSTRAINT `empleados_caso_ibfk_2` FOREIGN KEY (`id_caso`) REFERENCES `caso` (`id_caso`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
