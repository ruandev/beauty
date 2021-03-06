--
-- Indexes for dumped tables
--

--
-- Indexes for table `AGENDAMENTO`
--
ALTER TABLE `AGENDAMENTO`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_CLIENTE_AGEND` (`ID_CLIENTE`),
  ADD KEY `FK_FUNC_AGEND` (`ID_FUNC`);

--
-- Indexes for table `CAIXA`
--
ALTER TABLE `CAIXA`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_FUNC_ABRE_CAIXA` (`ID_FUNC_ABERT`),
  ADD KEY `FK_FUNC_FECHA_CAIXA` (`ID_FUNC_FECHA`);

--
-- Indexes for table `CLIENTE`
--
ALTER TABLE `CLIENTE`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `CPF` (`CPF`);

--
-- Indexes for table `FORNECEDOR`
--
ALTER TABLE `FORNECEDOR`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `CNPJ` (`CNPJ`);

--
-- Indexes for table `FUNCIONARIO`
--
ALTER TABLE `FUNCIONARIO`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `CPF` (`CPF`);

--
-- Indexes for table `MOVIMENTO_CAIXA`
--
ALTER TABLE `MOVIMENTO_CAIXA`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_CAIXA_MOV` (`ID_CAIXA`),
  ADD KEY `FK_FUNC_MOV` (`ID_FUNC_MOV`);

--
-- Indexes for table `PRODUTO`
--
ALTER TABLE `PRODUTO`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `SERVICO`
--
ALTER TABLE `SERVICO`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `DESCRICAO` (`DESCRICAO`);

--
-- Indexes for table `SERVICO_AGENDAMENTO`
--
ALTER TABLE `SERVICO_AGENDAMENTO`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_SERVICO_SERVICO_AGEND` (`ID_SERVICO`),
  ADD KEY `FK_AGEND_SERVICO_AGEND` (`ID_AGENDAMENTO`);
