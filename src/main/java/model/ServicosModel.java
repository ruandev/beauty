package model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServicosModel {

    Long id;
    String descricao;
    Double valor;
    String obs;
}
