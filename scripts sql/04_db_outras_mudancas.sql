use beauty;

ALTER TABLE `fornecedor` CHANGE `OBS` `OBS` VARCHAR(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL;
ALTER TABLE `fornecedor` CHANGE `TELEFONE` `TELEFONE` VARCHAR(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL;
ALTER TABLE `fornecedor` CHANGE `COMPLEMENTO` `COMPLEMENTO` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL;