INSERT INTO DISTRICT(CODE, NAME) VALUES
('HAICHAU', 'Hải Châu'),
('THANHKHE', 'Thanh Khê'),
('SONTRA', 'Sơn Trà'),
('NGUHANHSON', 'Ngũ Hành Sơn'),
('CAMLE', 'Cẩm Lệ'),
('LIENCHIEU', 'Liên Chiểu'),
('HOAVANG', 'Hòa Vang');

INSERT INTO RENTTYPE(CODE, NAME) VALUES
('TANG_TRET', 'Tầng trệt'),
('NGUYEN_CAN', 'Nguyên căn'),
('NOI_THAT', 'Nội thất'),
('VAN_PHONG', 'Văn phòng'),
('SHARED_OFFICE', 'Văn phòng chia sẻ'),
('COWORKING', 'Coworking Space');

INSERT INTO ROLE(CODE, NAME) VALUES
('ADMIN', 'Administrator'),
('MANAGER', 'Manager'),
('STAFF', 'Staff'),
('CUSTOMER_CARE', 'Customer Care'),
('SALES', 'Sales');

INSERT INTO USER(USERNAME, PASSWORD) VALUES
('admin', '123456'),
('manager01', '123456'),
('staff01', '123456'),
('staff02', '123456'),
('staff03', '123456'),
('staff04', '123456'),
('sales01', '123456'),
('care01', '123456');

INSERT INTO USER_ROLE(USERID, ROLEID) VALUES
(1,1),
(2,2),
(3,3),
(4,3),
(5,3),
(6,3),
(7,5),
(8,4);

INSERT INTO BUILDING
(
NAME,
DISTRICTID,
WARD,
STREET,
STRUCTURE,
NUMBEROFBASEMENT,
FLOOR_AREA,
DIRECTION,
BUILDING_LEVEL,
RENT,
SERVICE_PRICE,
CAR_FEES,
MOTO_FEES,
OVERHOURS_FEES,
ELECTRICITY_PAY,
DEPOSIT,
PAYMENT,
RENTAL_TERM,
DECORATION_TIME,
MANAGER_NAME,
MANAGER_PHONE_NUMBER,
BROKERAGE_FEES,
NOTES
)
VALUES

('Indochina Riverside Tower',1,'Thạch Thang','Bạch Đằng',
'BTCT',2,1200,'Đông','A',350000,50000,1200000,120000,150000,
4500,700000000,'Chuyển khoản','3 năm','30 ngày',
'Nguyễn Văn Hùng','0905000001',0.05,'View sông Hàn'),

('Danang Plaza',1,'Hải Châu 1','Trần Phú',
'BTCT',1,900,'Tây','B',250000,40000,1000000,100000,100000,
4300,500000000,'Chuyển khoản','2 năm','20 ngày',
'Lê Minh Đức','0905000002',0.05,'Trung tâm thành phố'),

('VTC Building',2,'Chính Gián','Nguyễn Văn Linh',
'BTCT',1,750,'Nam','B',220000,35000,800000,80000,100000,
4200,300000000,'Tiền mặt','2 năm','15 ngày',
'Trần Quốc Nam','0905000003',0.04,'Gần sân bay'),

('Song Han Tower',1,'Hải Châu 1','Nguyễn Văn Linh',
'BTCT',2,1500,'Đông','A',420000,60000,1500000,150000,180000,
4500,900000000,'Chuyển khoản','5 năm','45 ngày',
'Phạm Đức Long','0905000004',0.06,'Hạng A'),

('Ocean Office',3,'An Hải Bắc','Ngô Quyền',
'BTCT',1,600,'Đông Bắc','B',200000,30000,700000,70000,80000,
4200,250000000,'Chuyển khoản','1 năm','10 ngày',
'Nguyễn Hoàng Sơn','0905000005',0.04,'Gần cầu Rồng'),

('FPT Complex',4,'Hòa Hải','Nam Kỳ Khởi Nghĩa',
'BTCT',3,3000,'Đông','A',500000,70000,1800000,180000,200000,
4600,1200000000,'Chuyển khoản','5 năm','60 ngày',
'Võ Thanh Bình','0905000006',0.06,'Khu CNTT'),

('Lien Chieu Business Center',6,'Hòa Minh','Nguyễn Lương Bằng',
'BTCT',1,800,'Tây Bắc','C',180000,25000,600000,60000,50000,
4100,200000000,'Tiền mặt','1 năm','10 ngày',
'Đặng Văn Hải','0905000007',0.03,'Giá tốt'),

('Cam Le Tower',5,'Khuê Trung','Cách Mạng Tháng 8',
'BTCT',1,700,'Nam','B',190000,28000,650000,65000,70000,
4200,220000000,'Chuyển khoản','2 năm','15 ngày',
'Nguyễn Quốc Thái','0905000008',0.04,'Gần bến xe'),

('Sunshine Building',3,'Phước Mỹ','Võ Văn Kiệt',
'BTCT',2,1000,'Đông','A',330000,45000,1100000,100000,120000,
4400,600000000,'Chuyển khoản','3 năm','30 ngày',
'Lê Hoàng Anh','0905000009',0.05,'Gần biển'),

('Dragon Tower',1,'Bình Hiên','2/9',
'BTCT',2,1300,'Đông Nam','A',380000,55000,1300000,130000,160000,
4500,800000000,'Chuyển khoản','3 năm','40 ngày',
'Trần Minh Khoa','0905000010',0.05,'Đối diện công viên');

INSERT INTO BUILDINGTYPE(CODE, NAME) VALUES
('OFFICE', 'Văn phòng'),
('HOUSE', 'Nhà nguyên căn'),
('COMMERCIAL', 'Mặt bằng kinh doanh'),
('COWORKING', 'Coworking Space'),
('SHOPHOUSE', 'Shophouse'),
('WAREHOUSE', 'Kho bãi');

INSERT INTO BUILDING_BUILDINGTYPE VALUES
(1,1),
(2,1),
(3,3),
(4,1),
(5,4),
(6,1),
(7,6),
(8,5),
(9,1),
(10,3);

INSERT INTO RENTAREA(AREAVALUE, BUILDINGID) VALUES
(50,1),(100,1),(200,1),

(70,2),(120,2),

(50,3),(100,3),

(100,4),(200,4),(500,4),

(50,5),(100,5),

(200,6),(500,6),(1000,6),

(50,7),(100,7),

(70,8),(150,8),

(100,9),(300,9),

(150,10),(300,10);

INSERT INTO CUSTOMER
(FULLNAME,PHONE,EMAIL,COMPANYNAME,DEMAND,STATUS)
VALUES

('Nguyễn Văn An','0901111111','an@gmail.com',
'ABC Software','Thuê 100m2 văn phòng','NEW'),

('Trần Thị Mai','0901111112','mai@gmail.com',
'Mai Fashion','Thuê mặt bằng kinh doanh','PROCESSING'),

('Lê Quốc Bảo','0901111113','bao@gmail.com',
'Bảo Logistics','Thuê 300m2 văn phòng','NEW'),

('Phạm Hoàng Nam','0901111114','nam@gmail.com',
'Nam Tech','Văn phòng hạng A','PROCESSING'),

('Võ Thị Lan','0901111115','lan@gmail.com',
'Lan Beauty','Mặt bằng tầng trệt','DONE'),

('Huỳnh Minh Tuấn','0901111116','tuan@gmail.com',
'Tuấn Media','Coworking space','NEW'),

('Đặng Thu Hà','0901111117','ha@gmail.com',
'Hà Travel','Văn phòng gần sân bay','PROCESSING'),

('Ngô Thành Đạt','0901111118','dat@gmail.com',
'Đạt Foods','Thuê 150m2','DONE'),

('Bùi Ngọc Anh','0901111119','ngocanh@gmail.com',
'Smart AI','Văn phòng CNTT','NEW'),

('Phan Đức Huy','0901111120','huy@gmail.com',
'Huy Group','Thuê dài hạn','PROCESSING');

INSERT INTO TRANSACTIONTYPE(CODE, NAME) VALUES
('CALL', 'Gọi điện'),
('MEETING', 'Gặp trực tiếp'),
('VIEWING', 'Dẫn đi xem tòa nhà'),
('EMAIL', 'Trao đổi Email'),
('CONTRACT', 'Ký hợp đồng');

INSERT INTO `TRANSACTION`
(CUSTOMERID, TRANSACTIONTYPEID, NOTE, STATUS, STAFFID)
VALUES

(1,1,'Đã liên hệ khách hàng','DONE',3),
(1,3,'Hẹn xem tòa nhà tuần sau','PROCESSING',3),

(2,1,'Khách quan tâm mặt bằng tầng trệt','DONE',4),

(3,2,'Trao đổi nhu cầu thuê','DONE',5),

(4,3,'Dẫn đi xem Song Han Tower','PROCESSING',6),

(5,5,'Đã ký hợp đồng thuê','DONE',3),

(6,4,'Đã gửi báo giá qua email','DONE',4),

(7,2,'Khách muốn khảo sát thực tế','PROCESSING',5),

(8,5,'Ký hợp đồng thành công','DONE',6),

(9,1,'Khách mới đăng ký tư vấn','NEW',3),

(10,2,'Đặt lịch gặp khách','PROCESSING',4);

INSERT INTO ASSIGNMENTCUSTOMER VALUES
(1,3),
(2,4),
(3,5),
(4,6),
(5,3),
(6,4),
(7,5),
(8,6),
(9,3),
(10,4);

INSERT INTO ASSIGNMENTBUILDING VALUES
(1,3),
(2,3),
(3,4),
(4,4),
(5,5),
(6,5),
(7,6),
(8,6),
(9,3),
(10,4);

