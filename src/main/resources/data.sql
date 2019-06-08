

REPLACE INTO `role` VALUES (1,'ADMIN');
REPLACE INTO `role` VALUES (2,'AVALIADOR');
REPLACE INTO `role` VALUES (3,'ALUNO');

CREATE OR REPLACE VIEW   vw_projeto_participantes AS SELECT * FROM projeto LEFT JOIN projeto_participantes ON projeto_participantes.participantes_id = projeto.id;