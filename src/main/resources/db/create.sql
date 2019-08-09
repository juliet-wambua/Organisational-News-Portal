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
departmentId VARCHAR,
);

CREATE TABLE IF NOT EXISTS users (
id int PRIMARY KEY auto_increment,
userName VARCHAR,
userAddress VARCHAR,
userMobileNo int,
userEmail VARCHAR,
position VARCHAR,
departmentId VARCHAR,
);