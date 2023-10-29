package sa.edu.kau.fcit.cpit252;


import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import net.sourceforge.tess4j.*;

public class App {
    /**
     * Return the paths to the images in src/main/resources
     * @return an array that contains the absolute path to images in src/main/resources
     */
    private static String[] getImages(){
        File directory = new File(App.class.getClassLoader().getResource("images").getPath());
        File[] files = directory.listFiles();
        String []images = new String[files.length];
        for(int i=0; i<images.length; i++){
            images[i] = files[i].getAbsolutePath();
        }
        return images;
    }
    public static void main(String[] args) {
        String dataPath = "/opt/homebrew/Cellar/tesseract/5.3.3/share/tessdata";
        String key = "A1B2C3-Free";
        OCRService ocr = new OCRServiceProxy(dataPath, key);
        String[] images = getImages();
        for(String imagePath: images){
            try {
                System.out.println(ocr.recognizeText(imagePath, "ara"));
                System.out.println("=================================================");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


//        System.out.println(proxy.recognizeText("image1.png"));
//        System.out.println(proxy.recognizeText("image2.png"));
//        System.out.println(proxy.recognizeText("image3.png"));
    }
}
