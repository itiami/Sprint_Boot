/*
 Navicat Premium Data Transfer

 Source Server         : Docker_MariaDB_Local
 Source Server Type    : MySQL
 Source Server Version : 110002
 Source Host           : localhost:6603
 Source Schema         : nDB

 Target Server Type    : MySQL
 Target Server Version : 110002
 File Encoding         : 65001

 Date: 01/07/2023 19:15:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for agents
-- ----------------------------
DROP TABLE IF EXISTS `agents`;
CREATE TABLE `agents`  (
                           `AGENT_CODE` varchar(6) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
                           `AGENT_NAME` varchar(40) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
                           `WORKING_AREA` varchar(35) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
                           `COMMISSION` decimal(10, 2) NULL DEFAULT NULL,
                           `PHONE_NO` varchar(15) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
                           `COUNTRY` varchar(25) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
                           PRIMARY KEY (`AGENT_CODE`) USING BTREE
) ;

-- ----------------------------
-- Records of agents
-- ----------------------------
INSERT INTO `agents` VALUES ('A007  ', 'Ramasundar                              ', 'Bangalore                          ', 0.15, '077-25814763   ', '\r');
INSERT INTO `agents` VALUES ('A003  ', 'Alex                                    ', 'London                             ', 0.13, '075-12458969   ', '\r');
INSERT INTO `agents` VALUES ('A008  ', 'Alford                                  ', 'New York                           ', 0.12, '044-25874365   ', '\r');
INSERT INTO `agents` VALUES ('A011  ', 'Ravi Kumar                              ', 'Bangalore                          ', 0.15, '077-45625874   ', '\r');
INSERT INTO `agents` VALUES ('A010  ', 'Santakumar                              ', 'Chennai                            ', 0.14, '007-22388644   ', '\r');
INSERT INTO `agents` VALUES ('A012  ', 'Lucida                                  ', 'San Jose                           ', 0.12, '044-52981425   ', '\r');
INSERT INTO `agents` VALUES ('A005  ', 'Anderson                                ', 'Brisban                            ', 0.13, '045-21447739   ', '\r');
INSERT INTO `agents` VALUES ('A001  ', 'Subbarao                                ', 'Bangalore                          ', 0.14, '077-12346674   ', '\r');
INSERT INTO `agents` VALUES ('A002  ', 'Mukesh                                  ', 'Mumbai                             ', 0.11, '029-12358964   ', '\r');
INSERT INTO `agents` VALUES ('A006  ', 'McDen                                   ', 'London                             ', 0.15, '078-22255588   ', '\r');
INSERT INTO `agents` VALUES ('A004  ', 'Ivan                                    ', 'Torento                            ', 0.15, '008-22544166   ', '\r');
INSERT INTO `agents` VALUES ('A009  ', 'Benjamin                                ', 'Hampshair                          ', 0.11, '008-22536178   ', '\r');

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
                            `COMPANY_ID` varchar(6) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
                            `COMPANY_NAME` varchar(25) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
                            `COMPANY_CITY` varchar(25) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
                            PRIMARY KEY (`COMPANY_ID`) USING BTREE
) ;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('18', 'Order All', 'Boston\r');
INSERT INTO `company` VALUES ('15', 'Jack Hill Ltd', 'London\r');
INSERT INTO `company` VALUES ('16', 'Akas Foods', 'Delhi\r');
INSERT INTO `company` VALUES ('17', 'Foodies.', 'London\r');
INSERT INTO `company` VALUES ('19', 'sip-n-Bite.', 'New York\r');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
                             `CUST_CODE` varchar(6) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
                             `CUST_NAME` varchar(40) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
                             `CUST_CITY` varchar(35) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
                             `WORKING_AREA` varchar(35) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
                             `CUST_COUNTRY` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
                             `GRADE` decimal(10, 0) NULL DEFAULT NULL,
                             `OPENING_AMT` decimal(12, 2) NOT NULL,
                             `RECEIVE_AMT` decimal(12, 2) NOT NULL,
                             `PAYMENT_AMT` decimal(12, 2) NOT NULL,
                             `OUTSTANDING_AMT` decimal(12, 2) NOT NULL,
                             `PHONE_NO` varchar(17) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
                             `AGENT_CODE` varchar(6) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
                             INDEX `CUSTCITY`(`CUST_CITY`) USING BTREE,
                             INDEX `CUSTCITY_COUNTRY`(`CUST_CITY`, `CUST_COUNTRY`) USING BTREE
) ;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('C00013', 'Holmes', 'London                             ', 'London', 'UK', 2, 6000.00, 5000.00, 7000.00, 4000.00, 'BBBBBBB', 'A003  ');
INSERT INTO `customer` VALUES ('C00001', 'Micheal', 'New York                           ', 'New York', 'USA', 2, 3000.00, 5000.00, 2000.00, 6000.00, 'CCCCCCC', 'A008  ');
INSERT INTO `customer` VALUES ('C00020', 'Albert', 'New York                           ', 'New York', 'USA', 3, 5000.00, 7000.00, 6000.00, 6000.00, 'BBBBSBB', 'A008  ');
INSERT INTO `customer` VALUES ('C00025', 'Ravindran', 'Bangalore                          ', 'Bangalore', 'India', 2, 5000.00, 7000.00, 4000.00, 8000.00, 'AVAVAVA', 'A011  ');
INSERT INTO `customer` VALUES ('C00024', 'Cook', 'London                             ', 'London', 'UK', 2, 4000.00, 9000.00, 7000.00, 6000.00, 'FSDDSDF', 'A006  ');
INSERT INTO `customer` VALUES ('C00015', 'Stuart', 'London                             ', 'London', 'UK', 1, 6000.00, 8000.00, 3000.00, 11000.00, 'GFSGERS', 'A003  ');
INSERT INTO `customer` VALUES ('C00002', 'Bolt', 'New York                           ', 'New York', 'USA', 3, 5000.00, 7000.00, 9000.00, 3000.00, 'DDNRDRH', 'A008  ');
INSERT INTO `customer` VALUES ('C00018', 'Fleming', 'Brisban                            ', 'Brisban', 'Australia', 2, 7000.00, 7000.00, 9000.00, 5000.00, 'NHBGVFC', 'A005  ');
INSERT INTO `customer` VALUES ('C00021', 'Jacks', 'Brisban                            ', 'Brisban', 'Australia', 1, 7000.00, 7000.00, 7000.00, 7000.00, 'WERTGDF', 'A005  ');
INSERT INTO `customer` VALUES ('C00019', 'Yearannaidu', 'Chennai                            ', 'Chennai', 'India', 1, 8000.00, 7000.00, 7000.00, 8000.00, 'ZZZZBFV', 'A010  ');
INSERT INTO `customer` VALUES ('C00005', 'Sasikant', 'Mumbai                             ', 'Mumbai', 'India', 1, 7000.00, 11000.00, 7000.00, 11000.00, '147-25896312', 'A002  ');
INSERT INTO `customer` VALUES ('C00007', 'Ramanathan', 'Chennai                            ', 'Chennai', 'India', 1, 7000.00, 11000.00, 9000.00, 9000.00, 'GHRDWSD', 'A010  ');
INSERT INTO `customer` VALUES ('C00022', 'Avinash', 'Mumbai                             ', 'Mumbai', 'India', 2, 7000.00, 11000.00, 9000.00, 9000.00, '113-12345678', 'A002  ');
INSERT INTO `customer` VALUES ('C00004', 'Winston', 'Brisban                            ', 'Brisban', 'Australia', 1, 5000.00, 8000.00, 7000.00, 6000.00, 'AAAAAAA', 'A005  ');
INSERT INTO `customer` VALUES ('C00023', 'Karl', 'London                             ', 'London', 'UK', 0, 4000.00, 6000.00, 7000.00, 3000.00, 'AAAABAA', 'A006  ');
INSERT INTO `customer` VALUES ('C00006', 'Shilton', 'Torento                            ', 'Torento', 'Canada', 1, 10000.00, 7000.00, 6000.00, 11000.00, 'DDDDDDD', 'A004  ');
INSERT INTO `customer` VALUES ('C00010', 'Charles', 'Hampshair                          ', 'Hampshair', 'UK', 3, 6000.00, 4000.00, 5000.00, 5000.00, 'MMMMMMM', 'A009  ');
INSERT INTO `customer` VALUES ('C00017', 'Srinivas', 'Bangalore                          ', 'Bangalore', 'India', 2, 8000.00, 4000.00, 3000.00, 9000.00, 'AAAAAAB', 'A007  ');
INSERT INTO `customer` VALUES ('C00012', 'Steven', 'San Jose                           ', 'San Jose', 'USA', 1, 5000.00, 7000.00, 9000.00, 3000.00, 'KRFYGJK', 'A012  ');
INSERT INTO `customer` VALUES ('C00008', 'Karolina', 'Torento                            ', 'Torento', 'Canada', 1, 7000.00, 7000.00, 9000.00, 5000.00, 'HJKORED', 'A004  ');
INSERT INTO `customer` VALUES ('C00003', 'Martin', 'Torento                            ', 'Torento', 'Canada', 2, 8000.00, 7000.00, 7000.00, 8000.00, 'MJYURFD', 'A004  ');
INSERT INTO `customer` VALUES ('C00009', 'Ramesh', 'Mumbai                             ', 'Mumbai', 'India', 3, 8000.00, 7000.00, 3000.00, 12000.00, 'Phone No', 'A002  ');
INSERT INTO `customer` VALUES ('C00014', 'Rangarappa', 'Bangalore                          ', 'Bangalore', 'India', 2, 8000.00, 11000.00, 7000.00, 12000.00, 'AAAATGF', 'A001  ');
INSERT INTO `customer` VALUES ('C00016', 'Venkatpati', 'Bangalore                          ', 'Bangalore', 'India', 2, 8000.00, 11000.00, 7000.00, 12000.00, 'JRTVFDD', 'A007  ');
INSERT INTO `customer` VALUES ('C00011', 'Sundariya', 'Chennai                            ', 'Chennai', 'India', 3, 7000.00, 11000.00, 7000.00, 11000.00, 'PPHGRTS', 'A010  ');

-- ----------------------------
-- Table structure for daysorder
-- ----------------------------
DROP TABLE IF EXISTS `daysorder`;
CREATE TABLE `daysorder`  (
                              `ORD_NUM` decimal(6, 0) NOT NULL,
                              `ORD_AMOUNT` decimal(12, 2) NOT NULL,
                              `ADVANCE_AMOUNT` decimal(12, 2) NOT NULL,
                              `ORD_DATE` date NOT NULL,
                              `CUST_CODE` varchar(6) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
                              `AGENT_CODE` varchar(6) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
                              `ORD_DESCRIPTION` varchar(60) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL
) ;

-- ----------------------------
-- Records of daysorder
-- ----------------------------
INSERT INTO `daysorder` VALUES (200107, 4500.00, 900.00, '2008-08-30', 'C00007', 'A010', 'SOD\r');
INSERT INTO `daysorder` VALUES (200114, 3500.00, 1500.00, '2008-08-15', 'C00002', 'A008', 'SOD\r');
INSERT INTO `daysorder` VALUES (200134, 4200.00, 1800.00, '2008-09-25', 'C00004', 'A005', 'SOD\r');
INSERT INTO `daysorder` VALUES (200115, 2000.00, 1200.00, '2008-02-08', 'C00013', 'A013', 'SOD\r');
INSERT INTO `daysorder` VALUES (200101, 3000.00, 1000.00, '2008-07-15', 'C00001', 'A008', 'SOD\r');
INSERT INTO `daysorder` VALUES (200128, 3500.00, 1500.00, '2008-07-20', 'C00009', 'A002', 'SOD\r');
INSERT INTO `daysorder` VALUES (200132, 4000.00, 1500.00, '2008-08-15', 'C00013', 'A013', 'SOD\r');

-- ----------------------------
-- Table structure for despatch
-- ----------------------------
DROP TABLE IF EXISTS `despatch`;
CREATE TABLE `despatch`  (
                             `DES_NUM` varchar(6) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
                             `DES_DATE` date NULL DEFAULT NULL,
                             `DES_AMOUNT` decimal(12, 2) NULL DEFAULT NULL,
                             `ORD_NUM` decimal(6, 0) NULL DEFAULT NULL,
                             `ORD_DATE` date NULL DEFAULT NULL,
                             `ORD_AMOUNT` decimal(12, 2) NULL DEFAULT NULL,
                             `AGENT_CODE` varchar(6) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
                             PRIMARY KEY (`DES_NUM`) USING BTREE
) ;

-- ----------------------------
-- Records of despatch
-- ----------------------------

-- ----------------------------
-- Table structure for foods
-- ----------------------------
DROP TABLE IF EXISTS `foods`;
CREATE TABLE `foods`  (
                          `ITEM_ID` varchar(6) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
                          `ITEM_NAME` varchar(25) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
                          `ITEM_UNIT` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
                          `COMPANY_ID` varchar(6) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
                          PRIMARY KEY (`ITEM_ID`) USING BTREE
) ;

-- ----------------------------
-- Records of foods
-- ----------------------------
INSERT INTO `foods` VALUES ('1', 'Chex Mix', 'Pcs', '16\r');
INSERT INTO `foods` VALUES ('6', 'Cheez-It', 'Pcs', '15\r');
INSERT INTO `foods` VALUES ('2', 'BN Biscuit', 'Pcs', '15\r');
INSERT INTO `foods` VALUES ('3', 'Mighty Munch', 'Pcs', '17\r');
INSERT INTO `foods` VALUES ('4', 'Pot Rice', 'Pcs', '15\r');
INSERT INTO `foods` VALUES ('5', 'Jaffa Cakes', 'Pcs', '18\r');
INSERT INTO `foods` VALUES ('7', 'Salt n Shake', 'Pcs', '\r');

-- ----------------------------
-- Table structure for listofitem
-- ----------------------------
DROP TABLE IF EXISTS `listofitem`;
CREATE TABLE `listofitem`  (
                               `ITEMCODE` varchar(6) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
                               `ITEMNAME` varchar(25) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
                               `BATCHCODE` varchar(35) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
                               `CONAME` varchar(35) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
                               UNIQUE INDEX `ITEMCODE`(`ITEMCODE`) USING BTREE
) ;

-- ----------------------------
-- Records of listofitem
-- ----------------------------
INSERT INTO `listofitem` VALUES ('I001  ', 'CHOCOLATE                ', 'DM/2007-08/WBM%1                   ', '\r');
INSERT INTO `listofitem` VALUES ('I003  ', 'HOT DOG                  ', 'DM/2007-08/WB1                     ', 'ABJ ENTERPRISE                     ');
INSERT INTO `listofitem` VALUES ('I002  ', 'CONDENSED MILK           ', 'DM/2007-08/WBM%2                   ', 'ABJ CONCERN                        ');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
                           `ORD_NUM` decimal(6, 0) NOT NULL,
                           `ORD_AMOUNT` decimal(12, 2) NOT NULL,
                           `ADVANCE_AMOUNT` decimal(12, 2) NOT NULL,
                           `ORD_DATE` date NOT NULL,
                           `CUST_CODE` varchar(6) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
                           `AGENT_CODE` varchar(6) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
                           `ORD_DESCRIPTION` varchar(60) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL
) ;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (200100, 1000.00, 600.00, '2008-01-08', 'C00015', 'A003  ', 'SOD\r');
INSERT INTO `orders` VALUES (200110, 3000.00, 500.00, '2008-04-15', 'C00019', 'A010  ', 'SOD\r');
INSERT INTO `orders` VALUES (200107, 4500.00, 900.00, '2008-08-30', 'C00007', 'A010  ', 'SOD\r');
INSERT INTO `orders` VALUES (200112, 2000.00, 400.00, '2008-05-30', 'C00016', 'A007  ', 'SOD\r');
INSERT INTO `orders` VALUES (200113, 4000.00, 600.00, '2008-06-10', 'C00022', 'A002  ', 'SOD\r');
INSERT INTO `orders` VALUES (200102, 2000.00, 300.00, '2008-05-25', 'C00012', 'A012  ', 'SOD\r');
INSERT INTO `orders` VALUES (200114, 3500.00, 2000.00, '2008-08-15', 'C00002', 'A008  ', 'SOD\r');
INSERT INTO `orders` VALUES (200122, 2500.00, 400.00, '2008-09-16', 'C00003', 'A004  ', 'SOD\r');
INSERT INTO `orders` VALUES (200118, 500.00, 100.00, '2008-07-20', 'C00023', 'A006  ', 'SOD\r');
INSERT INTO `orders` VALUES (200119, 4000.00, 700.00, '2008-09-16', 'C00007', 'A010  ', 'SOD\r');
INSERT INTO `orders` VALUES (200121, 1500.00, 600.00, '2008-09-23', 'C00008', 'A004  ', 'SOD\r');
INSERT INTO `orders` VALUES (200130, 2500.00, 400.00, '2008-07-30', 'C00025', 'A011  ', 'SOD\r');
INSERT INTO `orders` VALUES (200134, 4200.00, 1800.00, '2008-09-25', 'C00004', 'A005  ', 'SOD\r');
INSERT INTO `orders` VALUES (200115, 2000.00, 1200.00, '2008-02-08', 'C00013', 'A013  ', 'SOD\r');
INSERT INTO `orders` VALUES (200108, 4000.00, 600.00, '2008-02-15', 'C00008', 'A004  ', 'SOD\r');
INSERT INTO `orders` VALUES (200103, 1500.00, 700.00, '2008-05-15', 'C00021', 'A005  ', 'SOD\r');
INSERT INTO `orders` VALUES (200105, 2500.00, 500.00, '2008-07-18', 'C00025', 'A011  ', 'SOD\r');
INSERT INTO `orders` VALUES (200109, 3500.00, 800.00, '2008-07-30', 'C00011', 'A010  ', 'SOD\r');
INSERT INTO `orders` VALUES (200101, 3000.00, 1000.00, '2008-07-15', 'C00001', 'A008  ', 'SOD\r');
INSERT INTO `orders` VALUES (200111, 1000.00, 300.00, '2008-07-10', 'C00020', 'A008  ', 'SOD\r');
INSERT INTO `orders` VALUES (200104, 1500.00, 500.00, '2008-03-13', 'C00006', 'A004  ', 'SOD\r');
INSERT INTO `orders` VALUES (200106, 2500.00, 700.00, '2008-04-20', 'C00005', 'A002  ', 'SOD\r');
INSERT INTO `orders` VALUES (200125, 2000.00, 600.00, '2008-10-10', 'C00018', 'A005  ', 'SOD\r');
INSERT INTO `orders` VALUES (200117, 800.00, 200.00, '2008-10-20', 'C00014', 'A001  ', 'SOD\r');
INSERT INTO `orders` VALUES (200123, 500.00, 100.00, '2008-09-16', 'C00022', 'A002  ', 'SOD\r');
INSERT INTO `orders` VALUES (200120, 500.00, 100.00, '2008-07-20', 'C00009', 'A002  ', 'SOD\r');
INSERT INTO `orders` VALUES (200116, 500.00, 100.00, '2008-07-13', 'C00010', 'A009  ', 'SOD\r');
INSERT INTO `orders` VALUES (200124, 500.00, 100.00, '2008-06-20', 'C00017', 'A007  ', 'SOD\r');
INSERT INTO `orders` VALUES (200126, 500.00, 100.00, '2008-06-24', 'C00022', 'A002  ', 'SOD\r');
INSERT INTO `orders` VALUES (200129, 2500.00, 500.00, '2008-07-20', 'C00024', 'A006  ', 'SOD\r');
INSERT INTO `orders` VALUES (200127, 2500.00, 400.00, '2008-07-20', 'C00015', 'A003  ', 'SOD\r');
INSERT INTO `orders` VALUES (200128, 3500.00, 1500.00, '2008-07-20', 'C00009', 'A002  ', 'SOD\r');
INSERT INTO `orders` VALUES (200135, 2000.00, 800.00, '2008-09-16', 'C00007', 'A010  ', 'SOD\r');
INSERT INTO `orders` VALUES (200131, 900.00, 150.00, '2008-08-26', 'C00012', 'A012  ', 'SOD\r');
INSERT INTO `orders` VALUES (200133, 1200.00, 400.00, '2008-06-29', 'C00009', 'A002  ', 'SOD\r');
INSERT INTO `orders` VALUES (200132, 4000.00, 2000.00, '2008-08-15', 'C00013', 'A013  ', 'SOD\r');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
                            `NAME` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
                            `TITLE` varchar(25) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
                            `CLASS` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
                            `SECTION` varchar(1) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
                            `ROLLID` decimal(3, 0) NOT NULL,
                            PRIMARY KEY (`CLASS`, `SECTION`, `ROLLID`) USING BTREE
) ;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('Deepak                        ', 'Saxana                   ', 'V    ', 'A', 15);
INSERT INTO `student` VALUES ('Robert                        ', 'Paul                     ', 'VI   ', 'A', 2);
INSERT INTO `student` VALUES ('Danny                         ', 'Moris                    ', 'V    ', 'B', 15);

-- ----------------------------
-- Table structure for studentreport
-- ----------------------------
DROP TABLE IF EXISTS `studentreport`;
CREATE TABLE `studentreport`  (
                                  `CLASS` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
                                  `SECTION` varchar(1) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
                                  `ROLLID` decimal(3, 0) NOT NULL,
                                  `GRADE` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
                                  `SEMISTER` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
                                  `CLASS_ATTENDED` decimal(25, 0) NULL DEFAULT NULL,
                                  INDEX `FK_CSR`(`CLASS`, `SECTION`, `ROLLID`) USING BTREE
) ;

-- ----------------------------
-- Records of studentreport
-- ----------------------------
INSERT INTO `studentreport` VALUES ('V    ', 'A', 15, 'A++  ', '1St  ', 75);
INSERT INTO `studentreport` VALUES ('VI   ', 'A', 2, 'A+   ', '2Nd  ', 70);
INSERT INTO `studentreport` VALUES ('V    ', 'B', 15, 'AA   ', '1St  ', 85);
INSERT INTO `studentreport` VALUES ('VI   ', 'A', 2, 'A+   ', '1St  ', 70);
INSERT INTO `studentreport` VALUES ('V    ', 'A', 15, 'AA   ', '2Nd  ', 85);

SET FOREIGN_KEY_CHECKS = 1;
