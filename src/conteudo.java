public class conteudo {

    private final String titulo; // final serve para a variavel n poder ser alterada dps de criada
    private final String URLimagem;

    public conteudo(String titulo, String urlImagem){
        this.titulo = titulo;
        this.URLimagem = urlImagem;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getURLimagem() {
        return URLimagem;
    }
    public static String get(String string) {
        return null;
    }

    
}
