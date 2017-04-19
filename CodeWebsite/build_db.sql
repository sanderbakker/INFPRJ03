CREATE DATABASE wagga;
USE wagga;

CREATE TABLE parkgarage_details (
	parkgarage_details_id	int NOT NULL AUTO_INCREMENT,
    parkgarage_code			varchar(255),
    car_capacity			int,
    charging_capacity		int,
    PRIMARY KEY (parkgarage_details_id)
);

CREATE TABLE parkgarage (
	parkgarage_id	int NOT NULL AUTO_INCREMENT,
    parkgarage_address_id int,
    parkgarage_name		varchar(255),
    parkgarage_code		varchar(255),
	langitude 			float,
    longitude	    	float,
    PRIMARY KEY (parkgarage_name_id),
    FOREIGN KEY (parkgarage_address_id) REFERENCES parkgarage_address(parkgarage_address_id)
);

CREATE TABLE hood(
	hood_id	int NOT NULL AUTO_INCREMENT,
	hood_name varchar(255),
    PRIMARY KEY (hood_id)
);

CREATE TABLE parkgarage_address (
	parkgarage_address_id 	int NOT NULL AUTO_INCREMENT,
    hood_id					int,
    street					varchar(255),
    street_number			varchar(15),
    zipcode					varchar(15),
    city					varchar(255),
    PRIMARY KEY (parkgarage_address_id),
    FOREIGN KEY (hood_id) REFERENCES hood(hood_id)
);

CREATE TABLE theft_outof_car(
	theft_outof_car_id int NOT NULL AUTO_INCREMENT,
    percentage float,
	year int,
    hood_id int,
    FOREIGN KEY (hood_id) REFERENCES hood(hood_id),
    PRIMARY KEY (theft_outof_car_id)
);
    
CREATE TABLE damage_or_theft_car(
	damage_or_theft_car int NOT NULL AUTO_INCREMENT,
	percentage float,
    hood_id int,
    year int,
    FOREIGN KEY (hood_id) references hood(hood_id),
    PRIMARY KEY (damage_or_theft_car)
);

CREATE TABLE hood_points (
	hood_points_id	int NOT NULL AUTO_INCREMENT,
    points			float,
    hood_id			int,
    FOREIGN KEY (hood_id) REFERENCES hood(hood_id),
    PRIMARY KEY (hood_points_id)
);
