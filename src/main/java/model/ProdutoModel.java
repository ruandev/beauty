package model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProdutoModel {

    Long id;
    String descricao;
    Double valorVenda;
    Integer estoqueAtual;
    String obs;
}
