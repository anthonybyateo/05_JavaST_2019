CREATE DATABASE `think` DEFAULT CHARACTER SET utf8;

drop user new_user;
flush privileges;
CREATE USER new_user IDENTIFIED BY 'password';

GRANT SELECT,INSERT,UPDATE,DELETE
    ON think.*
    TO new_user@localhost;

GRANT SELECT,INSERT,UPDATE,DELETE
    ON think.*
    TO new_user@'%';