/* If the warehouses or products table already exists, drop it so it can be remade */
drop table if exists WAREHOUSES;
drop table if exists PRODUCTS;

create table WAREHOUSES (
	id SERIAL PRIMARY KEY,
	name VARCHAR(10),
	city VARCHAR(20),
	state VARCHAR(2),
	capacity INT
);

create table PRODUCTS (
	id SERIAL PRIMARY KEY,
	category VARCHAR(20),
	quantity INT,
	storageLocation VARCHAR(7),
	warehouse_id INT,
	FOREIGN KEY (warehouse_id) REFERENCES WAREHOUSES(id)
);


/* make sure to insert warehouses first */
insert into WAREHOUSES (name, city, state, capacity) values ('DBC1', 'Boston', 'MA', 800);
insert into WAREHOUSES (name, city, state, capacity) values ('DBC2', 'NYC', 'NY', 1000);
insert into WAREHOUSES (name, city, state, capacity) values ('DBC3', 'Atlanta', 'GA', 500);
insert into WAREHOUSES (name, city, state, capacity) values ('DBC4', 'Orlando', 'FL', 600);
insert into WAREHOUSES (name, city, state, capacity) values ('DBC5', 'San Francisco', 'CA', 1000);
insert into WAREHOUSES (name, city, state, capacity) values ('DBC6', 'San Diego', 'CA', 800);


insert into PRODUCTS (category, quantity, storageLocation, warehouse_id) values ('Football', 200, 'SB1', 2);
insert into PRODUCTS (category, quantity, storageLocation, warehouse_id) values ('Basketball', 200, 'SB2', 2);
insert into PRODUCTS (category, quantity, storageLocation, warehouse_id) values ('Volleyball', 100, 'SB3', 2);
insert into PRODUCTS (category, quantity, storageLocation, warehouse_id) values ('Basktball', 100, 'SB2', 2);
insert into PRODUCTS (category, quantity, storageLocation, warehouse_id) values ('Volleyball', 80, 'SB3', 2);
insert into PRODUCTS (category, quantity, storageLocation, warehouse_id) values ('Football', 300, 'SB1', 2);
insert into PRODUCTS (category, quantity, storageLocation, warehouse_id) values ('Baseball', 200, 'SB1', 1);
insert into PRODUCTS (category, quantity, storageLocation, warehouse_id) values ('Handball', 170, 'SB1', 1);
insert into PRODUCTS (category, quantity, storageLocation, warehouse_id) values ('Soccer', 300, 'SB1', 1);
insert into PRODUCTS (category, quantity, storageLocation, warehouse_id) values ('Baseball', 40, 'SB1', 1);
insert into PRODUCTS (category, quantity, storageLocation, warehouse_id) values ('Handball', 60, 'SB1', 1);
insert into PRODUCTS (category, quantity, storageLocation, warehouse_id) values ('Football', 500, 'SB1', 3);
insert into PRODUCTS (category, quantity, storageLocation, warehouse_id) values ('Football', 80, 'SB1', 3);
insert into PRODUCTS (category, quantity, storageLocation, warehouse_id) values ('Basketball', 280, 'SB1', 3);
insert into PRODUCTS (category, quantity, storageLocation, warehouse_id) values ('Basketball', 100, 'SB1', 3);
insert into PRODUCTS (category, quantity, storageLocation, warehouse_id) values ('Handball', 50, 'SB1', 3);
insert into PRODUCTS (category, quantity, storageLocation, warehouse_id) values ('Handball', 70, 'SB1', 3);
insert into PRODUCTS (category, quantity, storageLocation, warehouse_id) values ('Soccer', 250, 'SB1', 4);
insert into PRODUCTS (category, quantity, storageLocation, warehouse_id) values ('Soccer', 150, 'SB1', 4);
insert into PRODUCTS (category, quantity, storageLocation, warehouse_id) values ('Volleyball', 100, 'SB1', 4);
insert into PRODUCTS (category, quantity, storageLocation, warehouse_id) values ('Volleyball', 120, 'SB1', 4);
insert into PRODUCTS (category, quantity, storageLocation, warehouse_id) values ('Football', 90, 'SB1', 4);
insert into PRODUCTS (category, quantity, storageLocation, warehouse_id) values ('Handbball', 60, 'SB1', 5);
insert into PRODUCTS (category, quantity, storageLocation, warehouse_id) values ('Handball', 100, 'SB1', 5);
insert into PRODUCTS (category, quantity, storageLocation, warehouse_id) values ('Baseball', 220, 'SB1', 5);
insert into PRODUCTS (category, quantity, storageLocation, warehouse_id) values ('Baseball', 160, 'SB1', 5);
