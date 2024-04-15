INSERT INTO manager.role (id, name) VALUES (default, 'admin');
INSERT INTO manager.role (id, name) VALUES (default, 'company_admin');
INSERT INTO manager.role (id, name) VALUES (default, 'company_user');

INSERT INTO manager."user" (id, role_id, email,password, name, status) VALUES (default, 1, 'admin','123', 'admin', 'A');
INSERT INTO manager."user" (id, role_id, email,password, name, status) VALUES (default, 2, 'joonas','123', 'joonask', 'A');
INSERT INTO manager."user" (id, role_id, email,password, name, status) VALUES (default, 3, 'peeter','123', 'peeterl', 'A');

INSERT INTO manager.company_user (id, company_id, user_id, project_role_id) VALUES (default, 1, 2, 1);
INSERT INTO manager.company_user (id, company_id, user_id, project_role_id) VALUES (default, 1, 3, 2);

INSERT INTO manager.company (id, subscription_type_id, name, image_data) VALUES (default, 1, 'Tehas', null);

INSERT INTO manager.subscription_type (id, tier)  VALUES (1, 1);

INSERT INTO manager.project_role (id, name)  VALUES (default, 'projektijuht');
INSERT INTO manager.project_role (id, name)  VALUES (default, 'seenior')