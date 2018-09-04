package model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Builder
@Data
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
