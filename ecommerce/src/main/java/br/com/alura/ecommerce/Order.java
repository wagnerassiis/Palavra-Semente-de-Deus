package br.com.alura.ecommerce;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Order {

    private final String userId, orderId;
    private final BigDecimal amount;



}
