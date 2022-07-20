import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
//import javax.imageio.IIOException;

//import javax.imageio.stream.ImageInputStream;


public class App {


    public static void main(String[] args) throws Exception {

        // fazer uma conexao HTTP e buscar o top 250 filmes
        // https://alura-imdb-api.herokuapp.com/movies
       String url =  "https://api.mocki.io/v2/549a5d8b/MostPopularTVs";
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
        var geradoraDeFigurinhas = new GeradoraDeFigurinhas();
        //System.out.println(listaDeFilmes.size());
        for (Map<String,String> filme : listaDeFilmes) {
            
            String URLimagem = filme.get("image");
            String titulo = filme.get("title");  

            InputStream inputStream = new URL(URLimagem).openStream();
            String nomeArquivo = titulo.replace(":", "-")  + ".png";// usa-se isso pq o windows n reconhece alguns arquivos com : por isso  troca
            
            geradoraDeFigurinhas.create(inputStream, nomeArquivo);
           
           System.out.println("\u001b[38;2;255;255;255m \u001b[48;2;42;122;228m " + titulo + "\u001b[m");
            System.out.println();
           
            /*System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();*/
            
        }


    }
}
