package br.com.alura.ecommerce;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class Extrato {

    private String description;
    private String title;
    private BigDecimal value;
    private Long id;
    private String date;
    private int parcel;


}
