import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiCambiodemoneda {




        public Moneda seleccionDeMonedas(String tipoMoneda)throws IOException, InterruptedException {

            HttpClient client = HttpClient.newHttpClient();
            String api = "https://v6.exchangerate-api.com/v6/37a6a31a965a4a0d71690f47/latest/"+ tipoMoneda;

           // System.out.println(api);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(api))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        }


}
