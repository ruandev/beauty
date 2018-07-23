package model;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AgendamentoModel {
    Long id;
    ClienteModel clienteModel;
    LocalDateTime dataHora;
    FuncionarioModel agendadoPor;
    String obs;
}
