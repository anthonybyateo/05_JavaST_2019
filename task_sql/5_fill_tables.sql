USE `think`;

INSERT INTO `users`
( `id`, `login`, `email`, 		`password`, 										`role`)
VALUES
( 2, 	"user", "user@user.com", "21232F297A57A5A743894A0E4A801FC3", /* MD5 хэш пароля*/ 1 ),
( 3, 	"user2","user2@user.com","EE11CBB19052E40B07AAC0CA060C23EE", /* MD5 хэш пароля*/ 2 );

INSERT INTO `infousers`
(`user_id`, `birthday`,  `name`, `lastname`, `patronymic`, `avatar`)
VALUES
(2,         "2000-09-21", "Иван",   "Иванов",    "Иванович", "+375 (29) 123-45-67"),
(3,         "1999-12-05", "Петр",   "Петров",    "Петрович", "+375 (29) 234-56-78");

INSERT INTO `subscription`
(`subscriber_id`, `user_id`)
VALUES
(2,                 3),
(2,                 1),
(1,                 2),
(3,                 1),
(1,                 3),
(3,                 2);

INSERT INTO `notes`
(`id`, `user_id`, `note`, 											`date_notes`)
VALUES
(1,        3,     "Год спустя спортсмен вернулся в Беларусь",      "2019-04-24"),

(2,        3,     "В четырех районах Минской области ввели", 	   "2019-04-25"),

(3,        2,     "В этом году минчане смогут купить карты", 	   "2019-04-26"),

(4,        2,     "Средняя зарплата превысила 1000 рублей.",       "2019-04-27"),

(5,        3,     "На «Нафтан» начала поступать «хорошая» нефть.", "2019-04-28"),

(6,        2,     "Банки вводят ограничения без комиссии",         "2019-04-29");

INSERT INTO `note_tag`
(`tag_id`, `note_id`)
VALUES
(1,          1),
(2,          2),
(3,          2),
(4,          3),
(5,          3),
(6,          4),
(7,          4),
(8,          5),
(9,          6);

INSERT INTO `tags`
(`id`, `tag`)
VALUES
(1,    "belarus"),
(2,    "minsk"),
(3,    "belarus"),
(4,    "belarus"),
(5,    "school"),
(6,    "belarus"),
(7,    "money"),
(8,    "belarus"),
(9,    "happy");

INSERT INTO `likes`
(`note_id`, `like`, `user_id`)
    VALUES
    (1,    1,      2),
    (2,    1,      3),
    (3,    1,      3);

INSERT INTO `comments`
(`id`, `note_id`, `comment`, `user_id`, `date_comment`)
	VALUES
	(1,    1, "комментарий 1", 2, "2019-04-29"),
	(2,    3, "комментарий 2", 3, "2019-04-29");