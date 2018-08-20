package model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CaixaModel {
    Long id;
    LocalDateTime dataAbertura;
    LocalDateTime dataFechamento;
    Double valorInicial;
    Double valorFinal;
    Boolean aberto;
    FuncionarioModel funcionarioAbertura;
    FuncionarioModel funcionarioFechamento;
    String obs;
}
