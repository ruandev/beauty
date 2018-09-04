package model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FuncionarioModel extends EnderecoModel {
    Long id;
    String nome;
    String cpf;
    String email;
    String telefone;
    String obs;
}
