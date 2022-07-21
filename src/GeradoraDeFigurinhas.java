import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    public void create(InputStream inputStream, String nomeArquivo) throws Exception {
        // leitura da imagem
        //InputStream inputStream = new URL("https://i0.wp.com/www.jbox.com.br/wp/wp-content/uploads/2022/06/oshinoko-destacada.jpg?fit=774%2C489&quality=99&strip=all&ssl=1").openStream();
        BufferedImage Original = ImageIO.read(inputStream);

        // criar nova imagem em memoria com transparencia e com tamanho novo
        int largura = Original.getWidth();
        int altura = Original.getHeight();
        int novaAltura = altura + 200;
        BufferedImage newImage = new BufferedImage(largura, novaAltura,BufferedImage.TRANSLUCENT);

        // copiar a imagem original pra novo imagem (em memoria)
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(Original, 0, 0, null);

        // config da fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 72);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        String tituloSerie = nomeArquivo.replace(".png", "").replace("Imagens/", "");//retirando endereços de diretorio do titulo
        //q vai aparecer na imagem
         graphics.drawString(tituloSerie, 100, novaAltura - 100);
        

        // escrever a nova imagem em um arquivo
        ImageIO.write(newImage, "png", new File(nomeArquivo));

        
    }
}
    
