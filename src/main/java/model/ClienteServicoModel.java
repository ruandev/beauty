package model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClienteServicoModel {
    Long id;
    Date dataAgendamento;
    ClienteModel cliente;
    List<ServicoModel> servicos;
    Double valorMaoObra;
    String obs;
}
