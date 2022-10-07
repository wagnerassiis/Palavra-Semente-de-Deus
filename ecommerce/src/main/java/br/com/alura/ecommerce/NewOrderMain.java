package br.com.alura.ecommerce;

import com.google.gson.Gson;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {

    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        var dispatcher = new KafkaDispatcher();

        Model model = Model.builder().bank("NuBank").conditions("CREDITO").cpf("42469343801").extrato(Extrato.builder()
                .date(dateFormat.format(new Date())).id(1234L).description("LANCHONETE")
                .parcel(1).title("debito em conta").value(new BigDecimal(60)).build()).build();

        Gson gson = new Gson();
        var value = gson.toJson(model);

        var key = UUID.randomUUID().toString();

        dispatcher.send("ECOMMERCE_NEW_ORDER", key, value);

        var email = "Thank you for your order!";
        dispatcher.send("ECOMMERCE_SEND_EMAIL", key, email);
    }


}
