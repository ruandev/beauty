package model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClienteModel extends EnderecoModel {

    Long id;
    String nome;
    String telefone;
    String rg;
    String cpf;
    String obs;
    String email;
}
