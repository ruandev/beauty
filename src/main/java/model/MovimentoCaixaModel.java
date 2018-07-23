package model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MovimentoCaixaModel {
    Long id;
    CaixaModel caixa;
    LocalDateTime dataHoraMovimento;
    Boolean entrada;
    String descricao;
    String obs;
    FuncionarioModel funcionarioAbertura;
    FuncionarioModel funcionarioFechamento;
}
