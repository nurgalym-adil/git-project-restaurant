-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Апр 29 2020 г., 09:31
-- Версия сервера: 10.3.13-MariaDB-log
-- Версия PHP: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `restaurant_project`
--

-- --------------------------------------------------------

--
-- Структура таблицы `bookingtables`
--

CREATE TABLE `bookingtables` (
  `restaurantname` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `foodname` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `restauranttable` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `driver` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `music` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `parking` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `bookingtables`
--

INSERT INTO `bookingtables` (`restaurantname`, `user`, `foodname`, `restauranttable`, `driver`, `music`, `parking`) VALUES
('Restaurnt2', 'handle3', 'foodNice', 'Restaurnt2', 'Yes', 'No', 'No'),
('Restaurnt2', 'handle3', 'food1', 'Restaurnt2', 'Yes', 'Yes', 'Yes'),
('Restaurnt1', 'handle2', 'Sushi', 'Restaurnt1', 'Yes', 'Yes', 'Yes'),
('Restaurnt1', 'handle2', 'Sushi', 'Restaurnt1', 'No', 'No', 'No'),
('Restaurnt2', 'handle1', 'food1', 'Restaurnt2', 'No', 'Yes', 'Yes');

-- --------------------------------------------------------

--
-- Структура таблицы `food`
--

CREATE TABLE `food` (
  `restaurantName` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `foodName` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `food`
--

INSERT INTO `food` (`restaurantName`, `foodName`) VALUES
('Restaurnt2', 'food1'),
('Restaurnt2', 'food2'),
('Restaurnt2', 'food3'),
('Restaurnt2', 'foodNice'),
('Restaurnt1', 'Sushi'),
('Restaurnt1', 'Pizza'),
('Restaurnt3', 'Burger'),
('Restaurnt3', 'KFC'),
('Restaurnt4', 'Coca cola'),
('Restaurnt4', 'Pepsi');

-- --------------------------------------------------------

--
-- Структура таблицы `fooddelivery`
--

CREATE TABLE `fooddelivery` (
  `foodname` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `data` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `fooddelivery`
--

INSERT INTO `fooddelivery` (`foodname`, `user`, `data`) VALUES
('Pizza', 'handle3', 'Almaty, Akkent, 14, 1'),
('foodNice', 'handle1', 'Mega Towers, 7');

-- --------------------------------------------------------

--
-- Структура таблицы `restauranttable`
--

CREATE TABLE `restauranttable` (
  `restaurantName` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `data` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tablenum` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `restauranttable`
--

INSERT INTO `restauranttable` (`restaurantName`, `data`, `tablenum`) VALUES
('Restaurnt1', 'Is empty', '1'),
('Restaurnt1', 'Is empty', '2'),
('Restaurnt1', 'Is empty', '3'),
('Restaurnt1', 'Is empty', '4'),
('Restaurnt1', 'Is empty', '5'),
('Restaurnt2', 'Is empty', '1'),
('Restaurnt2', 'Is empty', '2'),
('Restaurnt2', 'Is empty', '3'),
('Restaurnt2', 'Is empty', '4'),
('Restaurnt3', 'Is empty', '1'),
('Restaurnt3', 'Is empty', '2'),
('Restaurnt3', 'Is empty', '3'),
('Restaurnt3', 'Is empty', '4'),
('Restaurnt3', 'Is empty', '5'),
('Restaurnt4', 'Is empty', '1'),
('Restaurnt4', 'Is empty', '2'),
('Restaurnt4', 'Is empty', '3'),
('Restaurnt4', 'Is empty', '4'),
('Restaurnt4', 'Is empty', '5'),
('Restaurnt4', 'Is empty', '6'),
('Restaurnt4', 'Is empty', '7'),
('Restaurnt4', 'Is empty', '8');

-- --------------------------------------------------------

--
-- Структура таблицы `therestaurant`
--

CREATE TABLE `therestaurant` (
  `restaurantName` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `rating` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `therestaurant`
--

INSERT INTO `therestaurant` (`restaurantName`, `rating`) VALUES
('Restaurnt1', '1'),
('Restaurnt2', '12'),
('Restaurnt3', '5'),
('Restaurnt4', '8');

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `surname` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `handle` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phonenumber` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`name`, `surname`, `handle`, `password`, `phonenumber`) VALUES
('name1', 'surname1', 'handle1', '12345678', '12345678'),
('name2', 'surname2', 'handle2', '12345678', '12'),
('name3', 'surname3', 'handle3', '12345678', '1214'),
('name4', 'surname4', 'handle4', '12345678', '2421132'),
('name5', 'surname5', 'handle5', '12345678', '3483279');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
