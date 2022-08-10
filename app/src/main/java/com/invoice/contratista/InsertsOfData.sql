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