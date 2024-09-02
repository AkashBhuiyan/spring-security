create table users(username varchar(50) not null primary key,password varchar(500) not null,enabled boolean not null);
create table authorities (username varchar(50) not null,authority varchar(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);

INSERT IGNORE INTO `users` VALUES ('user', '{noop}kothinPass#2255', '1');
INSERT IGNORE INTO `authorities` VALUES ('user', 'read');

INSERT IGNORE INTO `users` VALUES ('admin', '{bcrypt}$2a$12$vD9UitYrKYo/KxcFqsx/D.Fk5A0pHGzMlVK.Zp4gO5IujicEyPgf6', '1');
INSERT IGNORE INTO `authorities` VALUES ('admin', 'admin');

CREATE TABLE `customer` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `email` varchar(45) NOT NULL,
                            `pwd` varchar(200) NOT NULL,
                            `role` varchar(45) NOT NULL,
                            PRIMARY KEY (`id`)
);

INSERT  INTO `customer` (`email`, `pwd`, `role`) VALUES ('happy@example.com', '{noop}kothinPass#2255', 'read');
INSERT  INTO `customer` (`email`, `pwd`, `role`) VALUES ('admin@example.com', '{bcrypt}$2a$12$vD9UitYrKYo/KxcFqsx/D.Fk5A0pHGzMlVK.Zp4gO5IujicEyPgf6', 'admin');