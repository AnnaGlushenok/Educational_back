-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Апр 06 2024 г., 11:42
-- Версия сервера: 10.1.48-MariaDB
-- Версия PHP: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `test1`
--

-- --------------------------------------------------------

--
-- Структура таблицы `classes`
--

CREATE TABLE `classes` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `classes`
--

INSERT INTO `classes` (`id`, `name`) VALUES
(1, 'cl1'),
(3, 'cl3'),
(4, 'cl4');

-- --------------------------------------------------------

--
-- Дублирующая структура для представления `control_question`
-- (См. Ниже фактическое представление)
--
CREATE TABLE `control_question` (
`control` varchar(255)
,`question` varchar(255)
);

-- --------------------------------------------------------

--
-- Структура таблицы `control_works`
--

CREATE TABLE `control_works` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `control_works`
--

INSERT INTO `control_works` (`id`, `name`) VALUES
(2, 'c2'),
(3, 'c3'),
(4, 'c4');

-- --------------------------------------------------------

--
-- Структура таблицы `control_works_questions`
--

CREATE TABLE `control_works_questions` (
  `id_question` int(11) NOT NULL,
  `id_control_work` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `control_works_questions`
--

INSERT INTO `control_works_questions` (`id_question`, `id_control_work`) VALUES
(2, 2),
(3, 2),
(4, 3),
(3, 3);

-- --------------------------------------------------------

--
-- Структура таблицы `images`
--

CREATE TABLE `images` (
  `id` int(11) NOT NULL,
  `alt` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `images`
--

INSERT INTO `images` (`id`, `alt`, `name`) VALUES
(1, 'iAlt1', 'i1'),
(2, 'iAlt2', 'i2'),
(3, 'iAlt3', 'i3'),
(4, 'iAlt4', 'i4');

-- --------------------------------------------------------

--
-- Структура таблицы `paragraphs`
--

CREATE TABLE `paragraphs` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `paragraphs`
--

INSERT INTO `paragraphs` (`id`, `name`, `text`) VALUES
(2, 'p2', 'p2'),
(3, 'p3', 'p3'),
(4, 'p4', 'p4');

-- --------------------------------------------------------

--
-- Структура таблицы `paragraphs_control_works`
--

CREATE TABLE `paragraphs_control_works` (
  `id_paragraph` int(11) NOT NULL,
  `id_control_work` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `paragraphs_control_works`
--

INSERT INTO `paragraphs_control_works` (`id_paragraph`, `id_control_work`) VALUES
(2, 2),
(2, 3),
(3, 4),
(3, 3);

-- --------------------------------------------------------

--
-- Структура таблицы `paragraphs_questions`
--

CREATE TABLE `paragraphs_questions` (
  `id_question` int(11) NOT NULL,
  `id_paragraph` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `paragraphs_questions`
--

INSERT INTO `paragraphs_questions` (`id_question`, `id_paragraph`) VALUES
(2, 2),
(2, 3),
(3, 4),
(3, 3);

-- --------------------------------------------------------

--
-- Структура таблицы `paragraphs_tests`
--

CREATE TABLE `paragraphs_tests` (
  `id_paragraph` int(11) NOT NULL,
  `id_test` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Дублирующая структура для представления `paragraph_control_work`
-- (См. Ниже фактическое представление)
--
CREATE TABLE `paragraph_control_work` (
`paragraph` varchar(255)
,`control_work` varchar(255)
);

-- --------------------------------------------------------

--
-- Дублирующая структура для представления `paragraph_questino`
-- (См. Ниже фактическое представление)
--
CREATE TABLE `paragraph_questino` (
`paragraph` varchar(255)
,`question` varchar(255)
);

-- --------------------------------------------------------

--
-- Дублирующая структура для представления `paragraph_test`
-- (См. Ниже фактическое представление)
--
CREATE TABLE `paragraph_test` (
`paragraph` varchar(255)
,`test` varchar(255)
);

-- --------------------------------------------------------

--
-- Структура таблицы `paragraph_tests`
--

CREATE TABLE `paragraph_tests` (
  `is_final` bit(1) NOT NULL,
  `id_paragraph` int(11) NOT NULL,
  `id_test` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `paragraph_tests`
--

INSERT INTO `paragraph_tests` (`is_final`, `id_paragraph`, `id_test`) VALUES
(b'0', 2, 2),
(b'0', 2, 3),
(b'0', 3, 3),
(b'0', 3, 4);

-- --------------------------------------------------------

--
-- Структура таблицы `questions`
--

CREATE TABLE `questions` (
  `id` int(11) NOT NULL,
  `answers` varchar(255) DEFAULT NULL,
  `correct_answer` varchar(255) DEFAULT NULL,
  `explanation` varchar(255) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `questions`
--

INSERT INTO `questions` (`id`, `answers`, `correct_answer`, `explanation`, `question`) VALUES
(2, '2', '2', '2', 'q2'),
(3, '3', '3', '3', 'q3'),
(4, '4', '4', '4', 'q4');

-- --------------------------------------------------------

--
-- Структура таблицы `subjects`
--

CREATE TABLE `subjects` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `id_image` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `subjects`
--

INSERT INTO `subjects` (`id`, `name`, `id_image`) VALUES
(2, 's2', 2),
(3, 's3', 3),
(4, 's4', 4);

-- --------------------------------------------------------

--
-- Дублирующая структура для представления `subject_image`
-- (См. Ниже фактическое представление)
--
CREATE TABLE `subject_image` (
`subject` varchar(255)
,`image` varchar(255)
);

-- --------------------------------------------------------

--
-- Структура таблицы `tests`
--

CREATE TABLE `tests` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `tests`
--

INSERT INTO `tests` (`id`, `name`) VALUES
(2, 't2'),
(3, 't3'),
(4, 't4');

-- --------------------------------------------------------

--
-- Структура таблицы `tests_questions`
--

CREATE TABLE `tests_questions` (
  `id_test` int(11) NOT NULL,
  `id_question` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `tests_questions`
--

INSERT INTO `tests_questions` (`id_test`, `id_question`) VALUES
(2, 2),
(2, 3),
(3, 4),
(3, 3);

-- --------------------------------------------------------

--
-- Дублирующая структура для представления `test_question`
-- (См. Ниже фактическое представление)
--
CREATE TABLE `test_question` (
`test` varchar(255)
,`question` varchar(255)
);

-- --------------------------------------------------------

--
-- Дублирующая структура для представления `unit`
-- (См. Ниже фактическое представление)
--
CREATE TABLE `unit` (
`unit` varchar(255)
,`control` varchar(255)
,`class` varchar(255)
,`subject` varchar(255)
,`tests` varchar(255)
);

-- --------------------------------------------------------

--
-- Структура таблицы `units`
--

CREATE TABLE `units` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `control_work_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `test_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `units`
--

INSERT INTO `units` (`id`, `name`, `class_id`, `control_work_id`, `subject_id`, `test_id`) VALUES
(1, 'u1', 1, 3, NULL, NULL),
(2, 'u2', NULL, 2, 2, 2),
(3, 'u3', 3, 3, 3, 3),
(4, 'u4', NULL, 4, 4, 4);

-- --------------------------------------------------------

--
-- Структура таблицы `units_paragraphs`
--

CREATE TABLE `units_paragraphs` (
  `id_unit` int(11) NOT NULL,
  `id_paragraph` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `units_paragraphs`
--

INSERT INTO `units_paragraphs` (`id_unit`, `id_paragraph`) VALUES
(1, 2),
(1, 3),
(1, 4),
(2, 3),
(2, 4),
(4, 4);

-- --------------------------------------------------------

--
-- Дублирующая структура для представления `unit_paragraph`
-- (См. Ниже фактическое представление)
--
CREATE TABLE `unit_paragraph` (
`unit` varchar(255)
,`paragraph` varchar(255)
);

-- --------------------------------------------------------

--
-- Структура для представления `control_question`
--
DROP TABLE IF EXISTS `control_question`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `control_question`  AS SELECT `control_works`.`name` AS `control`, `questions`.`question` AS `question` FROM ((`control_works_questions` join `control_works` on((`control_works_questions`.`id_control_work` = `control_works`.`id`))) join `questions` on((`questions`.`id` = `control_works_questions`.`id_question`))) ;

-- --------------------------------------------------------

--
-- Структура для представления `paragraph_control_work`
--
DROP TABLE IF EXISTS `paragraph_control_work`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `paragraph_control_work`  AS SELECT `paragraphs`.`name` AS `paragraph`, `control_works`.`name` AS `control_work` FROM ((`paragraphs_control_works` join `paragraphs` on((`paragraphs`.`id` = `paragraphs_control_works`.`id_paragraph`))) join `control_works` on((`control_works`.`id` = `paragraphs_control_works`.`id_control_work`))) ;

-- --------------------------------------------------------

--
-- Структура для представления `paragraph_questino`
--
DROP TABLE IF EXISTS `paragraph_questino`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `paragraph_questino`  AS SELECT `paragraphs`.`name` AS `paragraph`, `questions`.`question` AS `question` FROM ((`paragraphs_questions` join `paragraphs` on((`paragraphs_questions`.`id_paragraph` = `paragraphs`.`id`))) join `questions` on((`questions`.`id` = `paragraphs_questions`.`id_question`))) ;

-- --------------------------------------------------------

--
-- Структура для представления `paragraph_test`
--
DROP TABLE IF EXISTS `paragraph_test`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `paragraph_test`  AS SELECT `paragraphs`.`name` AS `paragraph`, `tests`.`name` AS `test` FROM ((`paragraph_tests` join `tests` on((`paragraph_tests`.`id_test` = `tests`.`id`))) join `paragraphs` on((`paragraph_tests`.`id_paragraph` = `paragraphs`.`id`))) ;

-- --------------------------------------------------------

--
-- Структура для представления `subject_image`
--
DROP TABLE IF EXISTS `subject_image`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `subject_image`  AS SELECT `subjects`.`name` AS `subject`, `images`.`name` AS `image` FROM (`subjects` join `images` on((`images`.`id` = `subjects`.`id_image`))) ;

-- --------------------------------------------------------

--
-- Структура для представления `test_question`
--
DROP TABLE IF EXISTS `test_question`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `test_question`  AS SELECT `tests`.`name` AS `test`, `questions`.`question` AS `question` FROM ((`tests_questions` join `tests` on((`tests_questions`.`id_test` = `tests`.`id`))) join `questions` on((`questions`.`id` = `tests_questions`.`id_question`))) ;

-- --------------------------------------------------------

--
-- Структура для представления `unit`
--
DROP TABLE IF EXISTS `unit`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `unit`  AS SELECT `units`.`name` AS `unit`, `control_works`.`name` AS `control`, `classes`.`name` AS `class`, `subjects`.`name` AS `subject`, `tests`.`name` AS `tests` FROM ((((`units` left join `classes` on((`classes`.`id` = `units`.`class_id`))) left join `subjects` on((`subjects`.`id` = `units`.`subject_id`))) left join `tests` on((`tests`.`id` = `units`.`test_id`))) left join `control_works` on((`control_works`.`id` = `units`.`control_work_id`))) ;

-- --------------------------------------------------------

--
-- Структура для представления `unit_paragraph`
--
DROP TABLE IF EXISTS `unit_paragraph`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `unit_paragraph`  AS SELECT `units`.`name` AS `unit`, `paragraphs`.`name` AS `paragraph` FROM ((`units_paragraphs` join `units` on((`units`.`id` = `units_paragraphs`.`id_unit`))) join `paragraphs` on((`paragraphs`.`id` = `units_paragraphs`.`id_paragraph`))) ;

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `control_works`
--
ALTER TABLE `control_works`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `control_works_questions`
--
ALTER TABLE `control_works_questions`
  ADD KEY `FKcft0h0mmfspknc7bga85vyyhe` (`id_control_work`),
  ADD KEY `FK5bmrx908cmyyr48hiqqtnu4qc` (`id_question`);

--
-- Индексы таблицы `images`
--
ALTER TABLE `images`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `paragraphs`
--
ALTER TABLE `paragraphs`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `paragraphs_control_works`
--
ALTER TABLE `paragraphs_control_works`
  ADD KEY `FK9gf0yncjwoiuf8cxmxa9rph5v` (`id_control_work`),
  ADD KEY `FKs5yv9jwkxg14ge1gqbb2m91kg` (`id_paragraph`);

--
-- Индексы таблицы `paragraphs_questions`
--
ALTER TABLE `paragraphs_questions`
  ADD KEY `FK6h3p2xgt5icxwyso26e2m9ag` (`id_paragraph`),
  ADD KEY `FKsxb5dq6ij3j3284yu4g5qjc0y` (`id_question`);

--
-- Индексы таблицы `paragraphs_tests`
--
ALTER TABLE `paragraphs_tests`
  ADD KEY `FKi0qj9jnb7r99fy9fya5ascfn5` (`id_test`),
  ADD KEY `FKb6hkgnb5apfx9m7ureaag3wfu` (`id_paragraph`);

--
-- Индексы таблицы `paragraph_tests`
--
ALTER TABLE `paragraph_tests`
  ADD PRIMARY KEY (`id_paragraph`,`id_test`),
  ADD KEY `FKmwfotajqepsgvy5j2l1kehcbx` (`id_test`);

--
-- Индексы таблицы `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `subjects`
--
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_6remks40gp475wsnnq69tptys` (`id_image`);

--
-- Индексы таблицы `tests`
--
ALTER TABLE `tests`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `tests_questions`
--
ALTER TABLE `tests_questions`
  ADD KEY `FK17cyun8h3453f322t9bc395e0` (`id_question`),
  ADD KEY `FKihec9cycw7am5kepd6f1y5gjd` (`id_test`);

--
-- Индексы таблицы `units`
--
ALTER TABLE `units`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1fh0y79xh6k3gsocoo28yco8h` (`test_id`),
  ADD KEY `FK6vqfh06kiotyed6ybqgatdx7d` (`control_work_id`),
  ADD KEY `FK72qfm93ctr7iytcno768vaaro` (`subject_id`),
  ADD KEY `FKlqk927lawkwvch4kkv4q187db` (`class_id`);

--
-- Индексы таблицы `units_paragraphs`
--
ALTER TABLE `units_paragraphs`
  ADD KEY `FKnkk4xvkiyjj5if1yakcmun7mw` (`id_paragraph`),
  ADD KEY `FKc17ietkwv2kbak1q2cyk46h6r` (`id_unit`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `classes`
--
ALTER TABLE `classes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `control_works`
--
ALTER TABLE `control_works`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `images`
--
ALTER TABLE `images`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `paragraphs`
--
ALTER TABLE `paragraphs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `questions`
--
ALTER TABLE `questions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `subjects`
--
ALTER TABLE `subjects`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `tests`
--
ALTER TABLE `tests`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `units`
--
ALTER TABLE `units`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `control_works_questions`
--
ALTER TABLE `control_works_questions`
  ADD CONSTRAINT `FK5bmrx908cmyyr48hiqqtnu4qc` FOREIGN KEY (`id_question`) REFERENCES `questions` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKcft0h0mmfspknc7bga85vyyhe` FOREIGN KEY (`id_control_work`) REFERENCES `control_works` (`id`) ON DELETE CASCADE;

--
-- Ограничения внешнего ключа таблицы `paragraphs_control_works`
--
ALTER TABLE `paragraphs_control_works`
  ADD CONSTRAINT `FK9gf0yncjwoiuf8cxmxa9rph5v` FOREIGN KEY (`id_control_work`) REFERENCES `control_works` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKs5yv9jwkxg14ge1gqbb2m91kg` FOREIGN KEY (`id_paragraph`) REFERENCES `paragraphs` (`id`) ON DELETE CASCADE;

--
-- Ограничения внешнего ключа таблицы `paragraphs_questions`
--
ALTER TABLE `paragraphs_questions`
  ADD CONSTRAINT `FK6h3p2xgt5icxwyso26e2m9ag` FOREIGN KEY (`id_paragraph`) REFERENCES `paragraphs` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKsxb5dq6ij3j3284yu4g5qjc0y` FOREIGN KEY (`id_question`) REFERENCES `questions` (`id`) ON DELETE CASCADE;

--
-- Ограничения внешнего ключа таблицы `paragraphs_tests`
--
ALTER TABLE `paragraphs_tests`
  ADD CONSTRAINT `FKb6hkgnb5apfx9m7ureaag3wfu` FOREIGN KEY (`id_paragraph`) REFERENCES `paragraphs` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKi0qj9jnb7r99fy9fya5ascfn5` FOREIGN KEY (`id_test`) REFERENCES `tests` (`id`);

--
-- Ограничения внешнего ключа таблицы `paragraph_tests`
--
ALTER TABLE `paragraph_tests`
  ADD CONSTRAINT `FK1u9r2g01duod2rqb0quufand1` FOREIGN KEY (`id_paragraph`) REFERENCES `paragraphs` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKmwfotajqepsgvy5j2l1kehcbx` FOREIGN KEY (`id_test`) REFERENCES `tests` (`id`) ON DELETE CASCADE;

--
-- Ограничения внешнего ключа таблицы `subjects`
--
ALTER TABLE `subjects`
  ADD CONSTRAINT `FK7w4cqyoldkw245urldi8bi502` FOREIGN KEY (`id_image`) REFERENCES `images` (`id`) ON DELETE SET NULL;

--
-- Ограничения внешнего ключа таблицы `tests_questions`
--
ALTER TABLE `tests_questions`
  ADD CONSTRAINT `FK17cyun8h3453f322t9bc395e0` FOREIGN KEY (`id_question`) REFERENCES `questions` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKihec9cycw7am5kepd6f1y5gjd` FOREIGN KEY (`id_test`) REFERENCES `tests` (`id`) ON DELETE CASCADE;

--
-- Ограничения внешнего ключа таблицы `units`
--
ALTER TABLE `units`
  ADD CONSTRAINT `FK1fh0y79xh6k3gsocoo28yco8h` FOREIGN KEY (`test_id`) REFERENCES `tests` (`id`) ON DELETE SET NULL,
  ADD CONSTRAINT `FK6vqfh06kiotyed6ybqgatdx7d` FOREIGN KEY (`control_work_id`) REFERENCES `control_works` (`id`) ON DELETE SET NULL,
  ADD CONSTRAINT `FK72qfm93ctr7iytcno768vaaro` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`) ON DELETE SET NULL,
  ADD CONSTRAINT `FKlqk927lawkwvch4kkv4q187db` FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`) ON DELETE SET NULL;

--
-- Ограничения внешнего ключа таблицы `units_paragraphs`
--
ALTER TABLE `units_paragraphs`
  ADD CONSTRAINT `FKc17ietkwv2kbak1q2cyk46h6r` FOREIGN KEY (`id_unit`) REFERENCES `units` (`id`),
  ADD CONSTRAINT `FKnkk4xvkiyjj5if1yakcmun7mw` FOREIGN KEY (`id_paragraph`) REFERENCES `paragraphs` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
