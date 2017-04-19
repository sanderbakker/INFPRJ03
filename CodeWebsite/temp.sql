USE wagga;

CREATE TABLE hood_points (
	hood_points_id	int NOT NULL AUTO_INCREMENT,
    points			float,
    hood_id			int,
    FOREIGN KEY (hood_id) REFERENCES hood(hood_id),
    PRIMARY KEY (hood_points_id)
);
