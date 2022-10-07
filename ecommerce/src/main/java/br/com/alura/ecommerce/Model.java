package br.com.alura.ecommerce;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Model {

    private String bank;
    private String cpf;
    private String conditions;

    private Extrato extrato;


}
