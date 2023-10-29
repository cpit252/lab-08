package sa.edu.kau.fcit.cpit252;

import net.sourceforge.tess4j.Tesseract;
import java.io.File;


// Real OCR service implementation
public class RealOCRService implements OCRService {
    private Tesseract tesseract;
    public RealOCRService(String dataPath){
        this.tesseract = new Tesseract();
        tesseract.setDatapath(dataPath);
    }
    /**
     * performs OCR on the given image for the given language
     * @param imagePath the path to the image that contains text
     * @param language the first three letters of the target language. Multiple languages can
     *                 be combined with the plus sign (e.g., eng+ara).
     * @return the text that was detected in the image
     */
    @Override
    public String recognizeText(String imagePath, String language) throws Exception {
        if(imagePath == null || language == null) {
            System.err.println("Image path and the target language are required.");
            return null;
        }
        File imageFile = new File(imagePath);
        tesseract.setLanguage(language);
        return tesseract.doOCR(imageFile);
    }
}