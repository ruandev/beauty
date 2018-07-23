package model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EnderecoModel {
    String endereco;
    String numero;
    String complemento;
    String bairro;
    String cidade;
    String cep;
}
