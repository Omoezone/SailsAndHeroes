USE shipsandsailsuge;


SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS ship_type;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE ship_type
(
	ship_type_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    type_name VARCHAR(60) NOT NULL,
    number_of_guns INT NOT NULL,
	min_number_of_sailors_per_gun INT NOT NULL,
	number_of_sails INT NOT NULL,
    min_number_of_sailors_per_sail INT NOT NULL,
    number_of_sailors INT NOT NULL,
    max_speed INT NOT NULL,
    max_speed_change INT NOT NULL,
    sail_quality DOUBLE NOT NULL,
    hull_quality DOUBLE NOT NULL,
    number_of_turns_per_round INT NOT NULL
);

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS ammunition;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE ammunition
(
	ammunition_id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    ammunition_type VARCHAR(45) NOT NULL
); 

DROP TABLE IF EXISTS ship;
DROP TABLE IF EXISTS ships;

CREATE TABLE ships
(
	ship_id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    ship_type_id INT NOT NULL,
    CONSTRAINT ships_fk_ship_type
		FOREIGN KEY (ship_type_id) REFERENCES ship_type (ship_type_id),
	ammunition_id INT NOT NULL,
    CONSTRAINT ships_fk_ammunition
		FOREIGN KEY (ammunition_id) REFERENCES ammunition (ammunition_id),
	ship_name VARCHAR(50) NOT NULL,
    direction VARCHAR(45) NOT NULL,
    nationality VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS hibernate_sequence;
DROP TABLE IF EXISTS ship_path;