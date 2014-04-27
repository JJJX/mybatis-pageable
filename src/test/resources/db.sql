CREATE TABLE `user` (
  `username` varchar(20) NOT NULL DEFAULT '',
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `user` (`username`,`firstName`,`lastName`,`age`) VALUES ('feisan','san','fei',3);
INSERT INTO `user` (`username`,`firstName`,`lastName`,`age`) VALUES ('fensan','san','fen',4);
INSERT INTO `user` (`username`,`firstName`,`lastName`,`age`) VALUES ('guosan','san','guo',3);
INSERT INTO `user` (`username`,`firstName`,`lastName`,`age`) VALUES ('husan','san','hu',3);
INSERT INTO `user` (`username`,`firstName`,`lastName`,`age`) VALUES ('lisan','san','li',3);
INSERT INTO `user` (`username`,`firstName`,`lastName`,`age`) VALUES ('liusan','san','liu',4);
INSERT INTO `user` (`username`,`firstName`,`lastName`,`age`) VALUES ('manu','manu','ginobili',3);
INSERT INTO `user` (`username`,`firstName`,`lastName`,`age`) VALUES ('misan','sam','mi',4);
INSERT INTO `user` (`username`,`firstName`,`lastName`,`age`) VALUES ('parker','tony','zhang',3);
INSERT INTO `user` (`username`,`firstName`,`lastName`,`age`) VALUES ('san','san','zhang',3);
INSERT INTO `user` (`username`,`firstName`,`lastName`,`age`) VALUES ('sunsan','san','sun',3);
INSERT INTO `user` (`username`,`firstName`,`lastName`,`age`) VALUES ('tim','Tim','duncan',3);
INSERT INTO `user` (`username`,`firstName`,`lastName`,`age`) VALUES ('tony','tony','parker',3);
INSERT INTO `user` (`username`,`firstName`,`lastName`,`age`) VALUES ('wangsan','san','wang',3);
INSERT INTO `user` (`username`,`firstName`,`lastName`,`age`) VALUES ('wangwu','wu','wang',3);
INSERT INTO `user` (`username`,`firstName`,`lastName`,`age`) VALUES ('xu','san','xu',3);
INSERT INTO `user` (`username`,`firstName`,`lastName`,`age`) VALUES ('zhaisan','san','zhai',3);
INSERT INTO `user` (`username`,`firstName`,`lastName`,`age`) VALUES ('zhongsan','san','zhong',3);
