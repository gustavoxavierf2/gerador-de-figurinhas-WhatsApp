import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // fazer uma conexao HTTP e buscar o top 250 filmes
        String url =  "https://api.mocki.io/v2/549a5d8b";
        URI endereco = URI.create(url);
        /*HttpClient*/var request = HttpRequest.newBuilder(endereco).GET().build(); 
        /*HttpClient*/ var client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
     
        
        // pegar somente os dados que interessam (titulo).(poster).(classificaçao)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        //System.out.println(listaDeFilmes.size());   // tamanho da lista
        //System.out.println(listaDeFilmes.get(4));

        
        // exibir e manipular os dados 
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
        }

    }
}
