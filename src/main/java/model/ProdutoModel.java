package model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProdutoModel {

    Long id;
    String descricao;
    Double valorVenda;
    Integer estoqueAtual;
    String obs;
}
