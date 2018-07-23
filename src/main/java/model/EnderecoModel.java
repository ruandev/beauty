package model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EnderecoModel {
    String endereco;
    String numero;
    String complemento;
    String bairro;
    String cidade;
    String cep;
}
