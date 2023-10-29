package sa.edu.kau.fcit.cpit252;

import net.sourceforge.tess4j.Tesseract;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Lab8Test {
    /**
     * There should an interface called OCRService
     * This interface should have a method called recognizeText,
     * which takes two parameters (String imagePath, String language)
     * and throws an Exception
     */

    @Test
    public void testInterfaceOCRService() {
        assertTrue(Modifier.isInterface(OCRService.class.getModifiers()));
        assertEquals(1, OCRService.class.getDeclaredMethods().length);
        Method m = OCRService.class.getDeclaredMethods()[0];
        assertEquals("recognizeText", m.getName());
        assertEquals(2, m.getParameterCount());
        for (Class parameterType : m.getParameterTypes()) {
            assertEquals(String.class.getTypeName(), parameterType.getName());
        }
        Class<?>[] exceptionTypes = m.getExceptionTypes();
        assertEquals(1, exceptionTypes.length);
        assertEquals(Exception.class.getTypeName(), exceptionTypes[0].getTypeName());
    }

    /**
     * There should be a class called RealOCRService that implements the OCRService interface.
     * This class should have a constructor that takes a string for Tesseract's dataset path.
     */
    @Test
    public void testRealOCRService() {
        // 1. Should implement the OCRService interface
        List<Class<?>> interfaces = Arrays.asList(RealOCRService.class.getInterfaces());
        assertEquals(1, interfaces.size());
        assertTrue(interfaces.contains(OCRService.class));
        // 2. Should have an instance variable of type Tesseract
        Field[] fields = RealOCRService.class.getDeclaredFields();
        assertEquals(1, fields.length);
        assertTrue(Modifier.isPrivate(fields[0].getModifiers()));
        assertEquals(Tesseract.class.getTypeName(), fields[0].getType().getTypeName());
        // 3. Should have a constructor with one parameter of type string
        Constructor[] constructors = RealOCRService.class.getDeclaredConstructors();
        assertEquals(1, constructors.length);
        assertEquals(1, constructors[0].getParameterCount());
        assertEquals(String.class.getTypeName(), constructors[0].getParameterTypes()[0].getTypeName());
    }

    /**
     * There should be a class called OCRServiceProxy that implements the OCRService interface.
     * This class should have a constructor that takes a string for Tesseract's dataset path, and
     * a key of type string. It should also have four private fields of the following types:
     * OCRService for the realOCRService object, String for the key library, integer for the maximum number
     * of allowed requests, and a Map to keep track of how many requests were made for each key.
     */
    @Test
    public void testOCRServiceProxy() {
        // 1. Should implement the OCRService interface
        List<Class<?>> interfaces = Arrays.asList(OCRServiceProxy.class.getInterfaces());
        assertEquals(1, interfaces.size());
        assertTrue(interfaces.contains(OCRService.class));
        // 2. Should have four fields
        Field[] fields = OCRServiceProxy.class.getDeclaredFields();
        int stringCount = 0;
        int intCount = 0;
        int mapCount = 0;
        int OCRServiceCount = 0;
        for (Field field : fields) {
            if (field.getType() == OCRService.class) {
                OCRServiceCount++;
            } else if (field.getType() == String.class) {
                stringCount++;
            } else if (field.getType() == int.class) {
                intCount++;
            } else if (field.getType() == Map.class) {
                mapCount++;
            }
        }
        assertEquals(4, fields.length);
        assertEquals(1, OCRServiceCount);
        assertEquals(1, stringCount);
        assertEquals(1, intCount);
        assertEquals(1, mapCount);
        // 3. Should have a constructor with two parameters of type string
        Constructor[] constructors = OCRServiceProxy.class.getDeclaredConstructors();
        assertEquals(1, constructors.length);
        assertEquals(2, constructors[0].getParameterCount());
        assertEquals(String.class.getTypeName(), constructors[0].getParameterTypes()[0].getTypeName());
        assertEquals(String.class.getTypeName(), constructors[0].getParameterTypes()[1].getTypeName());
    }

    /**
     * The class RealOCRService should be able to perform OCR correctly
     */
//    @Test
//    public void testOCRinRealOCRService(){
//        String dataPathOnMac = "/opt/homebrew/Cellar/tesseract/5.3.3/share/tessdata";
//        RealOCRService realOCRService = new RealOCRService(dataPathOnMac);
//        File testImage = new File(App.class.getClassLoader().getResource("images" + File.separator +"test-marhaba-word.png").getPath());
//        try {
//            assertEquals("مرحبا", realOCRService.recognizeText(testImage.getAbsolutePath(), "ara").trim());
//        }
//        catch(Exception e){
//            assertEquals(null, e);
//        }
//    }
}
