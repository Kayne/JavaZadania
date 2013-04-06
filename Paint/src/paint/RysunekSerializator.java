/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import javax.imageio.ImageIO;

/**
 * Klasa zapewniająca serializację rysunku
 * @author kayne
 */
public class RysunekSerializator implements Serializable {

    private byte[] rysunek;

    /**
     * Zamień BufferedImage na bajty, zapisz do zmiennej, obiekt zapisz do pliku.
     * @param rys rysunek typu BufferedImage
     * @throws IOException 
     */
    public void setRysunek(BufferedImage rys) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.flush();
        rysunek = baos.toByteArray();
        baos.close();
    }

    /**
     * Wczytuje obrazek z pliku do bajtów, po czym konwertuje na BufferedImage
     * @return rysunek typu BufferedImage
     * @throws IOException 
     */
    public BufferedImage getRysunek() throws IOException {
        InputStream in = new ByteArrayInputStream(rysunek);
        BufferedImage bImageFromConvert = ImageIO.read(in);
        return bImageFromConvert;
    }
}
