package model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FuncionarioModel extends EnderecoModel {
    Long id;
    String nome;
    String cpf;
    String email;
    String telefone;
    String obs;
}
