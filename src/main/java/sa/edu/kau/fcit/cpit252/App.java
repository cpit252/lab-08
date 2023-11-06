package sa.edu.kau.fcit.cpit252;


import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import net.sourceforge.tess4j.*;

public class App {
    /**
     * Return the paths to the images in src/main/resources
     * @return an array that contains the absolute path to images in src/main/resources
     */
    private static String[] getImages() throws UnsupportedEncodingException {
        File directory = new File(App.class.getClassLoader().getResource("images").getPath());
        String decodedPath = URLDecoder.decode(directory.getPath(), StandardCharsets.UTF_8.name());
        System.out.println(decodedPath);
        File directory2 = new File(decodedPath);
        File[] files = directory.listFiles();
        String []images = new String[files.length];
        for(int i=0; i<images.length; i++){
            images[i] = files[i].getAbsolutePath();
        }
        return images;
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
        String dataPathOnMacBrew = "/opt/homebrew/Cellar/tesseract/5.3.3/share/tessdata";
        String dataPathOnMacPorts = "/opt/local/share/tessdata";
        String dataPathOnWindows = "C:\\Program Files\\Tesseract-OCR\\tessdata";
        String key = "A1B2C3-Free";
        OCRService ocr = new OCRServiceProxy(dataPathOnWindows, key);
        String[] images = getImages();
        for(String imagePath: images){
            try {
                System.out.println(ocr.recognizeText(imagePath, "ara"));
                System.out.println("=================================================");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
