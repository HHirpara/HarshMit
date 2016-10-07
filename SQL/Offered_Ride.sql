CREATE TABLE `sharemyridewebservice`.`offered_ride` (
  `OFFERED_RIDE_ID` BIGINT(20) NOT NULL,
  `USER_ID` BIGINT(20) NOT NULL,
  `FROM_LOCATION` VARCHAR(100) NOT NULL,
  `TO_LOCATION` VARCHAR(100) NOT NULL,
  `START_DATETIME` TIMESTAMP NULL,
  `IS_ROUND_TRIP` TINYINT NULL,
  `RETURN_DATETIME` TIMESTAMP NULL,
  `LUGGAGE` TINYINT NULL,
  `MY_VEHICLE_ID` BIGINT(20) NULL,
  `OFFERED_SEATS` TINYINT NULL,
  `PREFERRED_GENDER` TINYINT NULL,
  `TIME_ADJUSTMENT` TINYINT NULL,
  `DETOUR` TINYINT NULL,
  PRIMARY KEY (`OFFERED_RIDE_ID`),
  INDEX `MY_VEHICLE_ID_OFRD_idx` (`MY_VEHICLE_ID` ASC),
  INDEX `USER_ID_OFRD_idx` (`USER_ID` ASC),
  CONSTRAINT `MY_VEHICLE_ID_OFRD`
    FOREIGN KEY (`MY_VEHICLE_ID`)
    REFERENCES `sharemyridewebservice`.`my_vehicle` (`MY_VEHICLE_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `USER_ID_OFRD`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `sharemyridewebservice`.`user` (`USER_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

ALTER TABLE `sharemyridewebservice`.`offered_ride` 
ADD COLUMN `PICK_UP_FLEXIBILITY` TINYINT NULL AFTER `DETOUR`,
ADD COLUMN `LANGUAGE` VARCHAR(45) NULL AFTER `PICK_UP_FLEXIBILITY`,
ADD COLUMN `PET` TINYINT NULL AFTER `LANGUAGE`,
ADD COLUMN `CREATED_DATE` TIMESTAMP NULL AFTER `PET`,
ADD COLUMN `MODIFIED_DATE` TIMESTAMP NULL AFTER `CREATED_DATE`;
