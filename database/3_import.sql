INSERT INTO manager.role (id, role) VALUES (default, 'admin');
INSERT INTO manager.role (id, role) VALUES (default, 'company_admin');
INSERT INTO manager.role (id, role) VALUES (default, 'company_user');

INSERT INTO manager."user" (id, role_id, email,password, name, status) VALUES (default, 1, 'admin','123', 'admin', 'A');
INSERT INTO manager."user" (id, role_id, email,password, name, status) VALUES (default, 2, 'joonas','123', 'joonask', 'A');
INSERT INTO manager."user" (id, role_id, email,password, name, status) VALUES (default, 3, 'peeter','123', 'peeterl', 'A');
