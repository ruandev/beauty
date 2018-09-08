use beauty;

ALTER TABLE `fornecedor` CHANGE `OBS` `OBS` VARCHAR(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL;
ALTER TABLE `fornecedor` CHANGE `TELEFONE` `TELEFONE` VARCHAR(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL;
ALTER TABLE `fornecedor` CHANGE `COMPLEMENTO` `COMPLEMENTO` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL;
ALTER TABLE `cliente` CHANGE `OBS` `OBS` VARCHAR(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL;
ALTER TABLE `cliente` CHANGE `COMPLEMENTO` `COMPLEMENTO` VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL;
ALTER TABLE `agendamento` CHANGE `OBS` `OBS` VARCHAR(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL;
ALTER TABLE `agendamento` CHANGE `ID_FUNC` `ID_FUNC` INT(11) NULL;
ALTER TABLE `servico_agendamento` CHANGE `OBS` `OBS` VARCHAR(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL;
ALTER TABLE `movimento_caixa` CHANGE `OBS` `OBS` VARCHAR(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL;
ALTER TABLE `movimento_caixa` CHANGE `ID_FUNC_MOV` `ID_FUNC_MOV` INT(11) NULL;
ALTER TABLE `caixa` CHANGE `FECHAMENTO` `FECHAMENTO` DATETIME NULL;
ALTER TABLE `caixa` CHANGE `VALOR_FINAL` `VALOR_FINAL` DOUBLE NULL;
ALTER TABLE `caixa` CHANGE `ID_FUNC_ABERT` `ID_FUNC_ABERT` INT(11) NULL;
ALTER TABLE `caixa` CHANGE `ID_FUNC_FECHA` `ID_FUNC_FECHA` INT(11) NULL;
ALTER TABLE `caixa` CHANGE `OBS` `OBS` VARCHAR(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL;
ALTER TABLE `movimento_caixa` ADD `DESCRICAO` VARCHAR(200) NOT NULL AFTER `DATA_HORA`;
ALTER TABLE `cliente` CHANGE `EMAIL` `EMAIL` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL;
ALTER TABLE `cliente` CHANGE `RG` `RG` VARCHAR(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL;
ALTER TABLE `cliente` CHANGE `CEP` `CEP` VARCHAR(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL;
ALTER TABLE `cliente` CHANGE `CPF` `CPF` VARCHAR(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL;