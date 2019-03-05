package model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MovimentoCaixaModel {
    Long id;
    CaixaModel caixa;
    LocalDateTime dataHoraMovimento;
    Boolean entrada;
    Double valor;
    String descricao;
    String obs;
    FuncionarioModel funcionario;
    String formaEntrada;
}
