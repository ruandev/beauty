package model;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServicosAgendamentoModel {
    Long id;
    AgendamentoModel agendamento;
    ServicoModel servico;
    String obs;
}
