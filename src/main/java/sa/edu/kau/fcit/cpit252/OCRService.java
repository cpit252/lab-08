package sa.edu.kau.fcit.cpit252;

public interface OCRService {
    String recognizeText(String imagePath, String language) throws Exception;
}
