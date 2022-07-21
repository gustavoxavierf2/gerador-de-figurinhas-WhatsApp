import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class clientHttp {
    public String buscaDados(String url){
        try { 
        URI endereco = URI.create(url);
        /*HttpClient*/var request = HttpRequest.newBuilder(endereco).GET().build(); 
        /*HttpClient*/ var client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        return response.body();
    } catch (IOException | InterruptedException e) {//tratando a exceçao elançando uma nova que n obriga quem usar a tratar
        throw new RuntimeException(e);
    }
}
    
}
