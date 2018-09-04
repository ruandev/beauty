package model;

import java.util.Date;
import java.util.List;

public class ClienteServicoModel {
    Long id;
    Date dataAgendamento;
    ClienteModel cliente;
    List<ServicoModel> servicos;
    Double valorMaoObra;
    String obs;
}
