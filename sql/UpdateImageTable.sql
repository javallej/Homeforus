CREATE DATABASE IF NOT EXISTS `homeforus`;

CREATE TABLE IF NOT EXISTS `homeforus`.`HOUSE`
(
`House_ID`INTEGER(200) UNSIGNED NOT NULL auto_increment,
`Realtor_ID` INTEGER(200) UNSIGNED NOT NULL,
`Realtor_Username` NVARCHAR(200) NOT NULL,
`State` NVARCHAR(200) NOT NULL,
`City` NVARCHAR(200) NOT NULL,
`Zip` NVARCHAR(200) NOT NULL,
`Street` NVARCHAR(200) NOT NULL,
`House_Number` INTEGER(200) NOT NULL,
`Cost` INTEGER(200) UNSIGNED NOT NULL,
`Year` INTEGER(200) UNSIGNED NOT NULL,
`Num_Floors` INTEGER(200) UNSIGNED NOT NULL,
`Num_Bed` INTEGER(200) UNSIGNED NOT NULL,
`Num_Bath` INTEGER(200) UNSIGNED NOT NULL,
`Sqr_Feet` INTEGER(200) UNSIGNED NOT NULL,
`Days_Listed` INTEGER(200) UNSIGNED NOT NULL,
PRIMARY KEY (`House_ID`)
);

CREATE TABLE IF NOT EXISTS `homeforus`.`IMAGE`
(
`House_ID`INTEGER(200) UNSIGNED NOT NULL,
`File_Path` NVARCHAR(200) NOT NULL,
`Image_Name` NVARCHAR(200) NOT NULL,
`Image_Data` mediumblob NOT NULL
);

CREATE TABLE IF NOT EXISTS `homeforus`.`USER`
(
`User_ID` INTEGER(200) UNSIGNED NOT NULL auto_increment,
`User_Username` NVARCHAR(200) NOT NULL,
`First_Name` NVARCHAR(200) NOT NULL,
`Last_Name` NVARCHAR(200) NOT NULL,
`Phone` NVARCHAR(200) NOT NULL,
`Email` NVARCHAR (200) NOT NULL,
`Password` NVARCHAR(200) NOT NULL,
PRIMARY KEY (`User_ID`,`User_Username`)
);

CREATE TABLE IF NOT EXISTS `homeforus`.`CONSUMER`
(
`Consumer_ID` INTEGER(200) UNSIGNED NOT NULL,
`Consumer_Username` NVARCHAR(200) NOT NULL,
`DOB` NVARCHAR(200) NOT NULL,
`SSN` INTEGER (200) UNSIGNED NOT NULL,
PRIMARY KEY (`Consumer_ID`,`Consumer_Username`)
);

CREATE TABLE IF NOT EXISTS `homeforus`.`REALTOR`
(
`Realtor_ID` INTEGER(200) UNSIGNED NOT NULL,
`Realtor_Username` NVARCHAR(200) NOT NULL,
`Business_Name` NVARCHAR(200) NOT NULL,
PRIMARY KEY (`Realtor_ID`,`Realtor_Username`)
);

CREATE TABLE IF NOT EXISTS `homeforus`.`APPLICATION`
(
`House_ID` INTEGER(200) UNSIGNED NOT NULL,
`Consumer_ID` INTEGER(200) UNSIGNED NOT NULL,
`Consumer_Username` NVARCHAR(200) NOT NULL,
`Realtor_ID` INTEGER (200) UNSIGNED NOT NULL,
`Realtor_Username` NVARCHAR(200) NOT NULL,
`Status` NVARCHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS `homeforus`.`SEARCH`
(
`Consumer_ID` INTEGER(200) UNSIGNED NOT NULL,
`Consumer_Username` NVARCHAR(200) NOT NULL,
`House_ID` INTEGER(200) UNSIGNED NOT NULL
);

USE `homeforus`; 
ALTER TABLE `HOUSE` ADD CONSTRAINT `FK_HOUSE_RealtorID-User` FOREIGN KEY (`Realtor_ID`,`Realtor_Username`) REFERENCES `REALTOR` (`Realtor_ID`,`Realtor_Username`) ON UPDATE CASCADE;

ALTER TABLE `IMAGE` ADD CONSTRAINT `FK_IMAGE_HouseID` FOREIGN KEY (`House_ID`) REFERENCES `HOUSE` (`House_ID`) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE `APPLICATION` ADD CONSTRAINT `FK_APPLICATION_HouseID` FOREIGN KEY (`House_ID`) REFERENCES `HOUSE` (`House_ID`) ON UPDATE CASCADE;
ALTER TABLE `APPLICATION` ADD CONSTRAINT `FK_APPLICATION_ConsumerID-User` FOREIGN KEY (`Consumer_ID`,`Consumer_Username`) REFERENCES `CONSUMER` (`Consumer_ID`,`Consumer_Username`) ON UPDATE CASCADE;
ALTER TABLE `APPLICATION` ADD CONSTRAINT `FK_APPLICATION_RealtorID-User` FOREIGN KEY (`Realtor_ID`,`Realtor_Username`) REFERENCES `REALTOR` (`Realtor_ID`,`Realtor_Username`) ON UPDATE CASCADE;
ALTER TABLE `CONSUMER` ADD CONSTRAINT `FK_CONSUMER_UserID-User` FOREIGN KEY (`Consumer_ID`,`Consumer_Username`) REFERENCES `USER` (`User_ID`,`User_Username`) ON UPDATE CASCADE;
ALTER TABLE `REALTOR` ADD CONSTRAINT `FK_REALTOR_UserID-User` FOREIGN KEY (`Realtor_ID`,`Realtor_Username`) REFERENCES `USER` (`User_ID`,`User_Username`) ON UPDATE CASCADE;
ALTER TABLE `SEARCH` ADD CONSTRAINT `FK_SEARCH_ConsumerID-User` FOREIGN KEY (`Consumer_ID`,`Consumer_Username`) REFERENCES `CONSUMER` (`Consumer_ID`,`Consumer_Username`) ON UPDATE CASCADE;
ALTER TABLE `SEARCH` ADD CONSTRAINT `FK_SEARCH_HouseID-User` FOREIGN KEY (`House_ID`) REFERENCES `HOUSE` (`HOUSE_ID`) ON UPDATE CASCADE;

