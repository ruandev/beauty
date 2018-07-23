package model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CaixaModel {
    Long id;
    LocalDateTime dataAbertura;
    LocalDateTime dataFechamento;
    Double valorInicial;
    Double valorFinal;
    Boolean aberto;
    FuncionarioModel funcionarioMovimento;
}
