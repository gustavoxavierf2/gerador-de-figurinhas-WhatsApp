import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class extratatorConteudoNasa implements extratorConteudo{
    public List<conteudo> extrairConteudo(String json){
        var parser = new JsonParser();
        List<Map<String, String>> listaAtributos = parser.parse(json);

        List<conteudo> conteudos = new ArrayList<>();

        for (Map<String, String> atributos : listaAtributos) {
            String titulo = atributos.get("title");  
            String urlimagem = atributos.get("url");
            conteudo conteudo = new conteudo(titulo, urlimagem);

            conteudos.add(conteudo);
        }
        return conteudos;
    }    
}
