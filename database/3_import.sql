INSERT INTO manager.role (id, name) VALUES (default, 'admin');
INSERT INTO manager.role (id, name) VALUES (default, 'company_admin');
INSERT INTO manager.role (id, name) VALUES (default, 'company_user');

INSERT INTO manager."user" (id, role_id, email,password, name, status) VALUES (default,7, 'admin','123', 'admin', 'A');
INSERT INTO manager."user" (id, role_id, email,password, name, status) VALUES (default,8, 'joonas','123', 'joonask', 'A');
INSERT INTO manager."user" (id, role_id, email,password, name, status) VALUES (default,9, 'peeter','123', 'peeterl', 'A');

INSERT INTO manager.project_role(id, name) VALUES (default,'Projektijuht');

INSERT INTO manager.project(id, code, name, client, bank_link, status) VALUES (default,'A62','Oluline Tegevus','Oluline klinet','MINGIURL','A');

INSERT INTO manager.subscription_type(id, tier) VALUES (default,1);

INSERT INTO manager.company(id, subscription_type_id, name, image_data) VALUES (default,1,'Oluline Firma',NULL);

INSERT INTO manager.company_user (id, company_id, user_id, project_role_id) VALUES (default,1,7,2);

/*INSERT INTO manager.time_log(id, user_id, project_id, minutes, timestamp) VALUES (default,1,1,60,2024-07-20 12:15:15);*/

INSERT INTO manager.project_user(id, user_id, project_role_id, project_id, color_rgb, status) VALUES (default,7,2,1,'123123','A');

INSERT INTO manager.part(id, name, volume, end_deadline, status) VALUES (default,'OsaProtsessist',4,1,'A');

INSERT INTO manager.process(id, project_id, name, description, project_role_id, status) VALUES (default,1,'Oluline Protsess','Täidab olulist tegevust',2,'A');

/*INSERT INTO manager.process_part(id, part_id, process_id, project_user_id, deadline, status) VALUES (default,1,1,1,2024-08-15,'A');

INSERT INTO manager.project_role(id, name) VALUES (default, 'projektijuht');
INSERT INTO manager.project_role(id, name) VALUES (default, 'seenior');

INSERT INTO manager.subscription_type(id, tier) VALUES (default, 1);
INSERT INTO manager.subscription_type(id, tier) VALUES (default, 2);

INSERT INTO manager.company(id, subscription_type_id, name, image_data) values (default, 1, 'ehitus', null);

INSERT INTO manager.company_user(id, company_id, user_id, project_role_id) VALUES (default,1,2,1);
INSERT INTO manager.company_user(id, company_id, user_id, project_role_id) VALUES (default,1,3,2);