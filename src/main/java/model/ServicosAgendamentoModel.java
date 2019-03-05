package model;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServicosAgendamentoModel {
    Long id;
    AgendamentoModel agendamento;
    ServicoModel servico;
    FuncionarioModel funcionario;
    String obs;
    Double valor;
}
