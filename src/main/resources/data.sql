-- Table Creation Statements

-- Table for User
CREATE TABLE User (
    username VARCHAR(50) PRIMARY KEY,
    usr_password VARCHAR(100)
);

-- Table for Person
CREATE TABLE Person (
    p_id INT PRIMARY KEY,
    p_name VARCHAR(100),
    p_address VARCHAR(255),
    p_dob DATE,
    p_phone VARCHAR(20),
    p_gender VARCHAR(10),
    p_bloodtype VARCHAR(5)
);

-- Table for Donation
CREATE TABLE Donation (
    d_id SERIAL PRIMARY KEY,
    d_date DATE NOT NULL,
    d_time TIME NOT NULL,
    p_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (p_id) REFERENCES Person(p_id) ON DELETE CASCADE
);

-- Table for Receive
CREATE TABLE Receive (
    r_id SERIAL PRIMARY KEY,
    r_date DATE NOT NULL,
    p_id INT NOT NULL,
    quantity INT NOT NULL,
    r_hospital VARCHAR(100) NOT NULL,
    FOREIGN KEY (p_id) REFERENCES Person(p_id) ON DELETE CASCADE
);

-- Table for Stock
CREATE TABLE Stock (
    s_bloodtype VARCHAR(5) PRIMARY KEY,
    quantity INT NOT NULL
);

-- Insert Statements

-- Insert data into User table
INSERT INTO User (username, usr_password) VALUES
('jdoe', 'password123'),
('asmith', 'password234'),
('jane.d', 'password345'),
('tom.w', 'password456'),
('lucy.l', 'password567'),
('mark.k', 'password678'),
('alice.m', 'password789'),
('bob.s', 'password890'),
('clara.h', 'password901'),
('dave.t', 'password012'),
('ellen.p', 'password1234'),
('fred.b', 'password2345'),
('grace.j', 'password3456'),
('henry.o', 'password4567'),
('irene.z', 'password5678');

-- Insert data into Person table
INSERT INTO Person (p_id, p_name, p_address, p_dob, p_phone, p_gender, p_bloodtype) VALUES
(1, 'John Doe', '123 Elm St', '1980-04-12', '123-456-7890', 'Male', 'O+'),
(2, 'Anna Smith', '456 Oak St', '1992-11-20', '234-567-8901', 'Female', 'A+'),
(3, 'Michael Brown', '789 Pine St', '1985-07-22', '345-678-9012', 'Male', 'B+'),
(4, 'Emily Davis', '101 Maple St', '1978-03-15', '456-789-0123', 'Female', 'AB+'),
(5, 'Sarah Johnson', '202 Walnut St', '1982-12-05', '567-890-1234', 'Female', 'A-'),
(6, 'David Wilson', '303 Cedar St', '1990-09-18', '678-901-2345', 'Male', 'B-'),
(7, 'Lisa Martinez', '404 Cherry St', '1983-06-25', '789-012-3456', 'Female', 'AB-'),
(8, 'James Garcia', '505 Birch St', '1995-05-14', '890-123-4567', 'Male', 'O-'),
(9, 'Karen Clark', '606 Ash St', '1987-01-28', '901-234-5678', 'Female', 'O+'),
(10, 'Paul Lewis', '707 Hickory St', '1979-08-31', '012-345-6789', 'Male', 'A+'),
(11, 'Susan Young', '808 Spruce St', '1988-02-17', '123-456-7891', 'Female', 'B+'),
(12, 'Ryan King', '909 Willow St', '1984-11-29', '234-567-8902', 'Male', 'AB+'),
(13, 'Olivia Hall', '111 Poplar St', '1991-03-07', '345-678-9013', 'Female', 'A-'),
(14, 'Ethan Allen', '222 Dogwood St', '1986-10-11', '456-789-0124', 'Male', 'B-'),
(15, 'Mia Scott', '333 Redwood St', '1993-07-19', '567-890-1235', 'Female', 'AB-');

-- Insert data into Donation table
INSERT INTO Donation (d_date, d_time, p_id, quantity) VALUES
('2023-01-15', '09:30:00', 1, 450),
('2023-02-20', '11:00:00', 2, 500),
('2023-03-10', '13:15:00', 3, 450),
('2023-04-22', '10:45:00', 4, 500),
('2023-05-18', '08:30:00', 5, 450),
('2023-06-05', '12:00:00', 6, 500),
('2023-07-14', '14:30:00', 7, 450),
('2023-08-25', '09:15:00', 8, 500),
('2023-09-13', '11:45:00', 9, 450),
('2023-10-21', '15:00:00', 10, 500),
('2023-11-11', '13:30:00', 11, 450),
('2023-12-05', '10:15:00', 12, 500),
('2024-01-02', '09:45:00', 13, 450),
('2024-02-14', '08:00:00', 14, 500),
('2024-03-07', '14:00:00', 15, 450);

-- Insert data into Receive table
INSERT INTO Receive (r_date, p_id, quantity, r_hospital) VALUES
('2023-02-01', 2, 450, 'General Hospital'),
('2023-03-12', 3, 500, 'City Hospital'),
('2023-04-15', 4, 450, 'County Hospital'),
('2023-05-19', 5, 500, 'Regional Hospital'),
('2023-06-25', 6, 450, 'Central Medical'),
('2023-07-18', 7, 500, 'Memorial Hospital'),
('2023-08-30', 8, 450, 'St. Marys Hospital'),
('2023-09-20', 9, 500, 'St. Johns Hospital'),
('2023-10-10', 10, 450, 'General Hospital'),
('2023-11-02', 11, 500, 'City Hospital'),
('2023-12-22', 12, 450, 'County Hospital'),
('2024-01-15', 13, 500, 'Regional Hospital'),
('2024-02-05', 14, 450, 'Central Medical'),
('2024-03-22', 15, 500, 'Memorial Hospital'),
('2024-04-08', 1, 450, 'St. Marys Hospital');

-- Insert data into Stock table
INSERT INTO Stock (s_bloodtype, quantity) VALUES
('O+', 1500),
('A+', 1300),
('B+', 1400),
('AB+', 1200),
('A-', 1100),
('B-', 1000),
('AB-', 800),
('O-', 900);
