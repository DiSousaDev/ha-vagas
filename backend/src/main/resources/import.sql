INSERT INTO tb_empresa (razao_social, cnpj, website, contato, email_contato) VALUES ('Empresa Teste', '01001100000100', 'https://empresateste.com', 'Jonas', 'jonas@empresateste.com');

INSERT INTO tb_area_atuacao (descricao) VALUES ('Data Science');
INSERT INTO tb_area_atuacao (descricao) VALUES ('Desenvolvimento');
INSERT INTO tb_area_atuacao (descricao) VALUES ('DevOps');
INSERT INTO tb_area_atuacao (descricao) VALUES ('QA');
INSERT INTO tb_area_atuacao (descricao) VALUES ('TI - Geral');
INSERT INTO tb_area_atuacao (descricao) VALUES ('UX - Design');
INSERT INTO tb_area_atuacao (descricao) VALUES ('Vagas Geral');

INSERT INTO tb_vaga (titulo, estado, descricao, automacao, nivel_carreira, nivel_ingles, regime_trabalho, data_atualizacao, empresa_id, area_atuacao_id) VALUES ('Pessoa desenvolvedora Junior', 'PR', '- Experiência com desenvolvimento - Ruby - Ruby on Rails - MY SQL', 'NAO_EXIGIDO', 'JUNIOR', 'NAO_EXIGIDO', 'NAO_IDENTIFICADO', TIMESTAMP WITH TIME ZONE '2022-02-01T13:00:00Z', 1, 2);
INSERT INTO tb_vaga (titulo, estado, descricao, automacao, nivel_carreira, nivel_ingles, regime_trabalho, data_atualizacao, empresa_id, area_atuacao_id) VALUES ('UX Designer Junior', null, 'Formação/ Experiências: Graduação completa ou em andamento em Marketing, Computação, UX Designer e/ou áreas afins.', 'NAO_EXIGIDO', 'JUNIOR', 'AVANCADO', 'NAO_IDENTIFICADO', TIMESTAMP WITH TIME ZONE '2022-02-01T13:00:00Z', 1, 6);

INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Alex', 'Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Maria', 'Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
