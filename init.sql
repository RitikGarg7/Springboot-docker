-- Create the database
CREATE DATABASE IF NOT EXISTS springbootdb;

-- Create the user and grant privileges
CREATE USER IF NOT EXISTS 'springuser'@'%' IDENTIFIED BY 'springpassword';
GRANT ALL PRIVILEGES ON springbootdb.* TO 'springuser'@'%';
FLUSH PRIVILEGES;
