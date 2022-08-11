-- This insert use for local example data

INSERT INTO address VALUES(0,'And. Paseo ','545','41','una colonia ','una ciudad','un municipio ','89689','un estado','un país ','bba762b5-174a-4809-abf0-33c8bdd4e060');
INSERT INTO address VALUES(1,'And. Paseo','874','','una colonia ','una ciudad','un municipio ','89689','un estado','un país ','5aefe41e-e32d-4709-b3d1-f7b2f395f78d');
INSERT INTO address VALUES(2,'And. Paseo','78','76','una colonia ','una ciudad','un municipio ','89689','un estado','un país ','9e105645-d198-477e-9c41-5991cd80fde7');

INSERT INTO customer VALUES('bba762b5-174a-4809-abf0-33c8bdd4e060','Dunder Mifflin S.A. de C.V.','ABC101010111','601','email23@email.com','3317886494');
INSERT INTO customer VALUES('5aefe41e-e32d-4709-b3d1-f7b2f395f78d','Alejandra Jimenez Avalos ','ABC101010111','601','Galletitas_con_queso@hotmail.com','3317886494');
INSERT INTO customer VALUES('9e105645-d198-477e-9c41-5991cd80fde7','Otro más ','ABC101010111','601','uncorreo@email.com','3317886494');

INSERT INTO event VALUES("1",'5aefe41e-e32d-4709-b3d1-f7b2f395f78d','Creado','Reparación de contactos ','Instalación eléctrica ');
INSERT INTO event VALUES("2",'bba762b5-174a-4809-abf0-33c8bdd4e060','Creado','Reparación de transformador a deshoras de la noche. ','Acometida en el transformador ');
INSERT INTO event VALUES("3",'9e105645-d198-477e-9c41-5991cd80fde7','Creado','Aplicación de pintura en exteriores ','Pintura ');

INSERT INTO date VALUES(1,'1','2022-08-10 15:56:11','Creado');
INSERT INTO date VALUES(2,'2','2022-08-10 11:24:45','Creado');
INSERT INTO date VALUES(3,'3','2022-08-10 16:32:05','Creado');



--------------------------------------------------------------------------------------------------------

PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
CREATE TABLE android_metadata (locale TEXT);
INSERT INTO android_metadata VALUES('es_US');
CREATE TABLE `address` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `street` TEXT NOT NULL, `exterior` TEXT NOT NULL, `interior` TEXT NOT NULL, `neighborhood` TEXT NOT NULL, `city` TEXT NOT NULL, `municipality` TEXT NOT NULL, `zip` TEXT NOT NULL, `state` TEXT NOT NULL, `country` TEXT NOT NULL, `idCustomer` TEXT NOT NULL);
INSERT INTO address VALUES(0,'And. Paseo ','545','41','una colonia ','una ciudad','un municipio ','89689','un estado','un país ','bba762b5-174a-4809-abf0-33c8bdd4e060');
INSERT INTO address VALUES(1,'And. Paseo','874','','una colonia ','una ciudad','un municipio ','89689','un estado','un país ','5aefe41e-e32d-4709-b3d1-f7b2f395f78d');
INSERT INTO address VALUES(2,'And. Paseo','78','76','una colonia ','una ciudad','un municipio ','89689','un estado','un país ','9e105645-d198-477e-9c41-5991cd80fde7');
CREATE TABLE `customer` (`id` TEXT NOT NULL, `legal_name` TEXT NOT NULL, `tax_id` TEXT NOT NULL, `tax_system` TEXT NOT NULL, `email` TEXT NOT NULL, `phone` TEXT NOT NULL, PRIMARY KEY(`id`));
INSERT INTO customer VALUES('bba762b5-174a-4809-abf0-33c8bdd4e060','Dunder Mifflin S.A. de C.V.','ABC101010111','601','email23@email.com','3317886494');
INSERT INTO customer VALUES('5aefe41e-e32d-4709-b3d1-f7b2f395f78d','Alejandra Jimenez Avalos ','ABC101010111','601','Galletitas_con_queso@hotmail.com','3317886494');
INSERT INTO customer VALUES('9e105645-d198-477e-9c41-5991cd80fde7','Otro más ','ABC101010111','601','uncorreo@email.com','3317886494');
CREATE TABLE `budget` (`id` INTEGER NOT NULL, `number` INTEGER NOT NULL, `id_customer` TEXT NOT NULL, `id_event` INTEGER NOT NULL, `date` TEXT NOT NULL, `dateEnd` TEXT NOT NULL, `conditions` TEXT NOT NULL, `status` TEXT NOT NULL, PRIMARY KEY(`id`, `id_customer`));
CREATE TABLE `note` (`id` TEXT NOT NULL, `id_event` INTEGER NOT NULL, `note` TEXT NOT NULL, PRIMARY KEY(`id`));
INSERT INTO note VALUES('01ba022b-c772-4728-b27f-4a6b521efc13',1,'Una nota. Podemos seguir escribiendo sin problemas. ');
INSERT INTO note VALUES('d91872dc-d1bc-4c08-bd85-7d2960256996',1,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. ');
CREATE TABLE `part` (`id` INTEGER NOT NULL, `number` INTEGER NOT NULL, `idBudget` INTEGER NOT NULL, `idProduct` TEXT NOT NULL, `quantity` INTEGER NOT NULL, `discount` INTEGER NOT NULL, `custom_keys` TEXT NOT NULL, `description` TEXT NOT NULL, PRIMARY KEY(`id`, `idProduct`));
CREATE TABLE `schedule` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id_event` INTEGER NOT NULL, `date` TEXT NOT NULL, `state` TEXT NOT NULL, `note` TEXT NOT NULL, `location` TEXT NOT NULL);
CREATE TABLE `event` (`id` TEXT NOT NULL, `id_customer` TEXT NOT NULL, `state` TEXT NOT NULL, `note` TEXT NOT NULL, `event_name` TEXT NOT NULL, PRIMARY KEY(`id`));
INSERT INTO event VALUES('1','5aefe41e-e32d-4709-b3d1-f7b2f395f78d','Creado','Reparación de contactos ','Instalación eléctrica ');
INSERT INTO event VALUES('3','9e105645-d198-477e-9c41-5991cd80fde7','Creado','Aplicación de pintura en exteriores ','Pintura ');
INSERT INTO event VALUES('9b542475-627c-4106-9c33-803c3ee0eec0','5aefe41e-e32d-4709-b3d1-f7b2f395f78d','Creado','No me entregan documentación 😒','Un evento ');
INSERT INTO event VALUES('5ac46bc7-d32f-47fa-91d7-062773efc29f','5aefe41e-e32d-4709-b3d1-f7b2f395f78d','Creado','Nota para el evento ','Un evento ');
CREATE TABLE `local_tax` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rate` INTEGER NOT NULL, `type` TEXT NOT NULL, `withholding` INTEGER NOT NULL, `idProduct` TEXT NOT NULL);
CREATE TABLE `product` (`id` TEXT NOT NULL, `description` TEXT NOT NULL, `product_key` INTEGER NOT NULL, `price` REAL NOT NULL, `tax_included` INTEGER NOT NULL, `taxability` TEXT NOT NULL, `unit_key` TEXT NOT NULL, `unit_name` TEXT NOT NULL, `sku` TEXT NOT NULL, PRIMARY KEY(`id`));
CREATE TABLE `tax` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `type` TEXT, `rate` REAL NOT NULL, `factor` TEXT, `withholding` INTEGER NOT NULL, `idProduct` TEXT NOT NULL);
CREATE TABLE `date` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `idReference` TEXT NOT NULL, `date` TEXT NOT NULL, `name` TEXT NOT NULL);
INSERT INTO date VALUES(1,'1','2022-08-10 15:56:11','Creado');
INSERT INTO date VALUES(3,'3','2022-08-10 16:32:05','Creado');
INSERT INTO date VALUES(4,'9b542475-627c-4106-9c33-803c3ee0eec0','2022-08-10 18:55','Creado');
INSERT INTO date VALUES(5,'5ac46bc7-d32f-47fa-91d7-062773efc29f','2022-08-10 19:00','Creado');
CREATE TABLE room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT);
INSERT INTO room_master_table VALUES(42,'6d3a8b84638ae731228888216aae6e70');
DELETE FROM sqlite_sequence;
INSERT INTO sqlite_sequence VALUES('address',2);
INSERT INTO sqlite_sequence VALUES('date',5);
COMMIT;