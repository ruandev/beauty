-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 23, 2018 at 08:56 PM
-- Server version: 5.6.38
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `BEAUTY`
--

-- --------------------------------------------------------

--
-- Table structure for table `AGENDAMENTO`
--

CREATE TABLE `AGENDAMENTO` (
  `ID` int(11) NOT NULL,
  `ID_CLIENTE` int(11) NOT NULL,
  `DATA_HORA` datetime NOT NULL,
  `OBS` varchar(200) NOT NULL,
  `ID_FUNC` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `CAIXA`
--

CREATE TABLE `CAIXA` (
  `ID` int(11) NOT NULL,
  `ABERTURA` datetime NOT NULL,
  `FECHAMENTO` datetime NOT NULL,
  `VALOR_INICIAL` double NOT NULL,
  `VALOR_FINAL` double NOT NULL,
  `ABERTO` tinyint(1) NOT NULL,
  `ID_FUNC_ABERT` int(11) NOT NULL,
  `ID_FUNC_FECHA` int(11) NOT NULL,
  `OBS` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `CLIENTE`
--

CREATE TABLE `CLIENTE` (
  `ID` int(11) NOT NULL,
  `NOME` varchar(100) NOT NULL,
  `TELEFONE` varchar(11) NOT NULL,
  `RG` varchar(20) NOT NULL,
  `CPF` varchar(11) NOT NULL,
  `ENDERECO` varchar(50) NOT NULL,
  `NUMERO` varchar(10) NOT NULL,
  `COMPLEMENTO` varchar(100) NOT NULL,
  `BAIRRO` varchar(50) NOT NULL,
  `CIDADE` varchar(50) NOT NULL,
  `CEP` varchar(8) NOT NULL,
  `OBS` varchar(200) NOT NULL,
  `EMAIL` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `FORNECEDOR`
--

CREATE TABLE `FORNECEDOR` (
  `ID` int(11) NOT NULL,
  `NOME_FANTASIA` varchar(50) NOT NULL,
  `CNPJ` varchar(14) NOT NULL,
  `REPRESENTANTE` varchar(50) NOT NULL,
  `TELEFONE` varchar(11) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `CELULAR` varchar(11) NOT NULL,
  `OBS` varchar(200) NOT NULL,
  `ENDERECO` varchar(100) NOT NULL,
  `NUMERO` varchar(10) NOT NULL,
  `COMPLEMENTO` varchar(50) NOT NULL,
  `BAIRRO` varchar(50) NOT NULL,
  `CIDADE` varchar(50) NOT NULL,
  `CEP` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `FUNCIONARIO`
--

CREATE TABLE `FUNCIONARIO` (
  `ID` int(11) NOT NULL,
  `NOME` varchar(100) NOT NULL,
  `TELEFONE` varchar(11) NOT NULL,
  `RG` varchar(10) NOT NULL,
  `CPF` varchar(11) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `ENDERECO` varchar(50) NOT NULL,
  `NUMERO` varchar(10) NOT NULL,
  `COMPLEMENTO` varchar(50) NOT NULL,
  `BAIRRO` varchar(50) NOT NULL,
  `CIDADE` varchar(100) NOT NULL,
  `UF` varchar(2) NOT NULL,
  `CEP` varchar(8) NOT NULL,
  `OBS` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `MOVIMENTO_CAIXA`
--

CREATE TABLE `MOVIMENTO_CAIXA` (
  `ID` int(11) NOT NULL,
  `ID_CAIXA` int(11) NOT NULL,
  `DATA_HORA` datetime NOT NULL,
  `VALOR` double NOT NULL,
  `ENTRADA` tinyint(1) NOT NULL,
  `ID_FUNC_MOV` int(11) NOT NULL,
  `OBS` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `PRODUTO`
--

CREATE TABLE `PRODUTO` (
  `ID` int(11) NOT NULL,
  `DESCRICAO` varchar(100) NOT NULL,
  `VALOR_VENDA` double NOT NULL,
  `ESTOQUE_ATUAL` int(11) NOT NULL,
  `OBS` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `SERVICO`
--

CREATE TABLE `SERVICO` (
  `ID` int(11) NOT NULL,
  `DESCRICAO` varchar(50) NOT NULL,
  `VALOR` double NOT NULL,
  `OBS` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `SERVICO_AGENDAMENTO`
--

CREATE TABLE `SERVICO_AGENDAMENTO` (
  `ID` int(11) NOT NULL,
  `ID_SERVICO` int(11) NOT NULL,
  `ID_AGENDAMENTO` int(11) NOT NULL,
  `OBS` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `AGENDAMENTO`
--
ALTER TABLE `AGENDAMENTO`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `CAIXA`
--
ALTER TABLE `CAIXA`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `CLIENTE`
--
ALTER TABLE `CLIENTE`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `FORNECEDOR`
--
ALTER TABLE `FORNECEDOR`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `FUNCIONARIO`
--
ALTER TABLE `FUNCIONARIO`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `MOVIMENTO_CAIXA`
--
ALTER TABLE `MOVIMENTO_CAIXA`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `PRODUTO`
--
ALTER TABLE `PRODUTO`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `SERVICO`
--
ALTER TABLE `SERVICO`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `SERVICO_AGENDAMENTO`
--
ALTER TABLE `SERVICO_AGENDAMENTO`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;