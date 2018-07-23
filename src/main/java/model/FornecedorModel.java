package model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FornecedorModel extends EnderecoModel {

    Long id;
    String nomeFantasia;
    String cnpj;
    String representante;
    String telefone;
    String email;
    String celular;
    String obs;
}
