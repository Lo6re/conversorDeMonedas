import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConsulta {
    public Monedas busquedaMonedas(String moneda, String conversion, double cantidad){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/2c2b0de4bcdd1269def8e0ac/pair/"  + moneda + "/" + conversion + "/" + cantidad
        );

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Monedas.class);
        }
        catch (Exception e){
            throw new RuntimeException("No es posible localizar el tipo de moneda");
        }
    }
}
