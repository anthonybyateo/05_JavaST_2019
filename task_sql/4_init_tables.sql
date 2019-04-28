USE `think`;

INSERT INTO `users` (
	`id`,
	`login`,
	`email`,
	`password`,
	`role`
) VALUES (
	1,
	"admin",
	"admin@admin.com",
	"21232F297A57A5A743894A0E4A801FC3", /* MD5 хэш пароля "admin" */
	0
);