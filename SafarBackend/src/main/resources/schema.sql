CREATE TABLE IF NOT EXISTS admin(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(40),
	email VARCHAR(100),
	image LONGTEXT
);

CREATE TABLE IF NOT EXISTS client(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(40),
	email VARCHAR(100),
	image LONGTEXT
);

CREATE TABLE IF NOT EXISTS tour (
    tour_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(40),
    description LONGTEXT,
    start_date DATE,
    end_date DATE,
    timestamp VARCHAR(40),
    image VARCHAR(255),
    price INT,
    destination LONGTEXT,
    days INT,
    admin_id INT,
    PRIMARY KEY (tour_id),
    FOREIGN KEY(admin_id) REFERENCES admin(id)
    ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS booking(
	id INT PRIMARY KEY AUTO_INCREMENT,
	tourId INT,
	NoOfPerson INT,
	ClientID INT,
	TotalPrice INT,
	ClientName VARCHAR(40),
	BookingDate DATE,
	FOREIGN KEY(ClientID) REFERENCES client(id),
	FOREIGN KEY(tourId) REFERENCES tour(tour_id)
);
