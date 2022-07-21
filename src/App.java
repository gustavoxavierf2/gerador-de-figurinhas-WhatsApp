import java.io.InputStream;
import java.net.URL;
import java.util.List;
public class App {


    public static void main(String[] args) throws Exception {

        String url =  "https://api.mocki.io/v2/549a5d8b/NASA-APOD-JamesWebbSpaceTelescope";
        var http = new clientHttp();
        String Json = http.buscaDados(url);

        extratorConteudo extrator = new extratatorConteudoNasa();
        List<conteudo> conteudos = extrator.extrairConteudo(Json);
 
        var geradoraDeFigurinhas = new GeradoraDeFigurinhas();
        for (int i = 0; i<3;i++) {
            conteudo conteudo = conteudos.get(i);
     
            InputStream inputStream = new URL(conteudo.getURLimagem()).openStream();

            String nomeArquivo = "Imagens/"+conteudo.getTitulo() + ".png";
            geradoraDeFigurinhas.create(inputStream, nomeArquivo);
           
            System.out.println("\u001b[38;2;255;255;255m \u001b[48;2;42;122;228m " +conteudo.getTitulo() + "\u001b[m");
            System.out.println();
     
        }


    }
}
