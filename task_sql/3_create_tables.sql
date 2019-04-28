USE `think`;

CREATE TABLE `users` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `login` VARCHAR(32) NOT NULL UNIQUE,
    `email` VARCHAR(60) NOT NULL UNIQUE,
    `password` CHAR(128) NOT NULL,
    /*
        * 0 - администратор (Role.ADMINISTRATOR)
        * 1 - модератор (Role.MODERATOR)
        * 2 - пользаватель (Role.USER)
    */
    `role` TINYINT NOT NULL CHECK (`role` IN (0, 1, 2)),
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE `infousers` (
    `user_id` INTEGER NOT NULL UNIQUE,
    `birthday` DATE NOT NULL,
    `name` VARCHAR(40) NOT NULL,
    `lastname` VARCHAR(40) NOT NULL,
    `patronymic` VARCHAR(40) NOT NULL,
    `avatar` BLOB NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES users(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE `subscription` (
    `subscriber_id` INTEGER NOT NULL,
    `user_id` INTEGER NOT NULL,
    CONSTRAINT FK_subscriber
    FOREIGN KEY (`subscriber_id`) REFERENCES users(id),
    CONSTRAINT FK_user_id
    FOREIGN KEY (`user_id`) REFERENCES users(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE `notes` (
    `id` INTEGER NOT NULL UNIQUE AUTO_INCREMENT,
    `user_id` INTEGER NOT NULL,
    `note` VARCHAR(250) NOT NULL,
    `date_notes` TIMESTAMP NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES users(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE `note_tag` (
    `tag_id` INTEGER NOT NULL UNIQUE AUTO_INCREMENT,
    `note_id` INTEGER NOT NULL,
    PRIMARY KEY (`tag_id`),
    FOREIGN KEY (`note_id`) REFERENCES notes(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE `tags` (
    `id` INTEGER NOT NULL UNIQUE,
    `tag` VARCHAR(25),
    FOREIGN KEY (`id`) REFERENCES note_tag(tag_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE `likes` (
    `note_id` INTEGER NOT NULL,
    `like` TINYINT NOT NULL CHECK (`like` IN (0, 1)),
    `user_id` INTEGER NOT NULL,
    CONSTRAINT FK_note
    FOREIGN KEY (`note_id`) REFERENCES notes(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
   CONSTRAINT FK_liker
    FOREIGN KEY (`user_id`) REFERENCES users(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE `comments` (
    `id` INTEGER NOT NULL UNIQUE,
    `note_id` INTEGER NOT NULL,
    `comment` VARCHAR(110) NOT NULL,
    `user_id` INTEGER NOT NULL,
    `date_comment` TIMESTAMP NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`note_id`) REFERENCES notes(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;