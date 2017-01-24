# CREATE TABLE `account_type` (
#   `id` int(11) NOT NULL AUTO_INCREMENT,
#   `name` varchar(255) DEFAULT NULL,
#   PRIMARY KEY (`id`)
# ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
#
# CREATE TABLE `account_status` (
#   `id` int(11) NOT NULL AUTO_INCREMENT,
#   `name` varchar(255) DEFAULT NULL,
#   PRIMARY KEY (`id`)
# ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
#
# CREATE TABLE `account` (
#   `id` int(11) NOT NULL AUTO_INCREMENT,
#   `date_close` date DEFAULT NULL,
#   `date_of_open` TIMESTAMP DEFAULT NULL,
#   `percentage` int(11) NOT NULL,
#   `sum` double NOT NULL,
#   `account_status_id` int(11) DEFAULT NULL,
#   `account_type_id` int(11) DEFAULT NULL,
#   `user_id` int(11) DEFAULT NULL,
#   PRIMARY KEY (`id`),
#   KEY `FK_hq4heoxtxp4ppa6oh0blhs792` (`account_status_id`),
#   KEY `FK_jq2kvaqxef9bpxk6xs870x7lk` (`account_type_id`),
#   KEY `FK_h6dr47em6vg85yuwt4e2roca4` (`user_id`),
#   CONSTRAINT `FK_h6dr47em6vg85yuwt4e2roca4` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
#   CONSTRAINT `FK_hq4heoxtxp4ppa6oh0blhs792` FOREIGN KEY (`account_status_id`) REFERENCES `account_status` (`id`),
#   CONSTRAINT `FK_jq2kvaqxef9bpxk6xs870x7lk` FOREIGN KEY (`account_type_id`) REFERENCES `account_type` (`id`)
# ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
#
# CREATE TABLE `user` (
#   `id` int(11) NOT NULL AUTO_INCREMENT,
#   `login` varchar(255) DEFAULT NULL,
#   `password` varchar(255) DEFAULT NULL,
#   `role_id` int(11) DEFAULT NULL,
#   PRIMARY KEY (`id`),
#   UNIQUE KEY `UK_ew1hvam8uwaknuaellwhqchhb` (`login`),
#   KEY `FK_qleu8ddawkdltal07p8e6hgva` (`role_id`),
#   CONSTRAINT `FK_qleu8ddawkdltal07p8e6hgva` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
# ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
#
# CREATE TABLE `type_payment` (
#   `id` int(11) NOT NULL AUTO_INCREMENT,
#   `name` varchar(255) DEFAULT NULL,
#   PRIMARY KEY (`id`)
# ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
#
# CREATE TABLE `roles` (
#   `id` int(11) NOT NULL AUTO_INCREMENT,
#   `name` varchar(255) DEFAULT NULL,
#   PRIMARY KEY (`id`)
# ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
#
# CREATE TABLE `credit_payments` (
#   `id` int(11) NOT NULL AUTO_INCREMENT,
#   `date_of_payment` TIMESTAMP DEFAULT NULL,
#   `sum` double NOT NULL,
#   `account_id` int(11) NOT NULL,
#   `type_id` int(11) DEFAULT NULL,
#   PRIMARY KEY (`id`),
#   KEY `FK_17aiisifvj95630buypntfweq` (`account_id`),
#   KEY `FK_qrd74219txw5drh316ia7g310` (`type_id`),
#   CONSTRAINT `FK_17aiisifvj95630buypntfweq` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
#   CONSTRAINT `FK_qrd74219txw5drh316ia7g310` FOREIGN KEY (`type_id`) REFERENCES `type_payment` (`id`)
# ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

# INSERT INTO roles VALUES (1, 'ROLE_USER');
# INSERT INTO roles VALUES (2, 'ROLE_ADMIN');
# INSERT INTO user VALUES (1, 'admin','password', 2);
# INSERT INTO account_status VALUES (1, 'Open');
# INSERT INTO account_status VALUES (2, 'Close');
# INSERT INTO account_type VALUES (1, 'Credit');
# INSERT INTO account_type VALUES (2, 'Deposit');
# INSERT INTO type_payment VALUES (1, 'EveryMonth Withdrawal  By Percent');
# INSERT INTO type_payment VALUES (2, 'EveryMonth Additional');
# INSERT INTO type_payment VALUES (3, 'EveryMonth Payment On Credit Account');
#
