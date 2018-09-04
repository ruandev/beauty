package model;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AgendamentoModel {
    @Setter Long id;
    ClienteModel clienteModel;
    LocalDateTime dataHora;
    FuncionarioModel agendadoPor;
    String obs;
}
