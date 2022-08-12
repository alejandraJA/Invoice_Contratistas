-- This insert use for local example data

INSERT INTO address VALUES(0,'And. Paseo ','545','41','una colonia ','una ciudad','un municipio ','89689','un estado','un país ','bba762b5-174a-4809-abf0-33c8bdd4e060');
INSERT INTO address VALUES(1,'And. Paseo','874','','una colonia ','una ciudad','un municipio ','89689','un estado','un país ','5aefe41e-e32d-4709-b3d1-f7b2f395f78d');
INSERT INTO address VALUES(2,'And. Paseo','78','76','una colonia ','una ciudad','un municipio ','89689','un estado','un país ','9e105645-d198-477e-9c41-5991cd80fde7');

INSERT INTO customer VALUES('bba762b5-174a-4809-abf0-33c8bdd4e060','Dunder Mifflin S.A. de C.V.','ABC101010111','601','email23@email.com','3317886494');
INSERT INTO customer VALUES('5aefe41e-e32d-4709-b3d1-f7b2f395f78d','Alejandra Jimenez Avalos ','ABC101010111','601','Galletitas_con_queso@hotmail.com','3317886494');
INSERT INTO customer VALUES('9e105645-d198-477e-9c41-5991cd80fde7','Otro más ','ABC101010111','601','uncorreo@email.com','3317886494');

INSERT INTO note VALUES('01ba022b-c772-4728-b27f-4a6b521efc13',1,'Una nota. Podemos seguir escribiendo sin problemas. ');
INSERT INTO note VALUES('d91872dc-d1bc-4c08-bd85-7d2960256996',1,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. ');

INSERT INTO event VALUES('1','5aefe41e-e32d-4709-b3d1-f7b2f395f78d','Creado','Reparación de contactos ','Instalación eléctrica ');
INSERT INTO event VALUES('3','9e105645-d198-477e-9c41-5991cd80fde7','Creado','Aplicación de pintura en exteriores ','Pintura ');
INSERT INTO event VALUES('9b542475-627c-4106-9c33-803c3ee0eec0','5aefe41e-e32d-4709-b3d1-f7b2f395f78d','Creado','No me entregan documentación 😒','Un evento ');
INSERT INTO event VALUES('5ac46bc7-d32f-47fa-91d7-062773efc29f','5aefe41e-e32d-4709-b3d1-f7b2f395f78d','Creado','Nota para el evento ','Un evento ');

INSERT INTO date VALUES(1,'1','2022-08-10 15:56:11','Creado');
INSERT INTO date VALUES(3,'3','2022-08-10 16:32:05','Creado');
INSERT INTO date VALUES(4,'9b542475-627c-4106-9c33-803c3ee0eec0','2022-08-10 18:55','Creado');
INSERT INTO date VALUES(5,'5ac46bc7-d32f-47fa-91d7-062773efc29f','2022-08-10 19:00','Creado');