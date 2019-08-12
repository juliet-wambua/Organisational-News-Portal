SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS departments(
id int PRIMARY KEY auto_increment,
departmentName VARCHAR,
departmentDescription VARCHAR,
noOfEmployees int
);

CREATE TABLE IF NOT EXISTS news(
id int PRIMARY KEY auto_increment,
generalNews VARCHAR,
departmentId int,
);

CREATE TABLE IF NOT EXISTS user (
id int PRIMARY KEY auto_increment,
userName VARCHAR,
address VARCHAR,
phone int,
email VARCHAR,
position VARCHAR,
departmentId int,
roles VARCHAR
);