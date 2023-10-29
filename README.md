
## Lab 8: Proxy Design Pattern
An example of using the Proxy Design Pattern in Java.

### Requirements

- Install Tesseract:
  - On Windows: 
    - [Download the latest from UB Mannheim (tesseract-ocr-w64-setup-5.3.0)](https://digi.bib.uni-mannheim.de/tesseract/tesseract-ocr-w64-setup-5.3.0.20221222.exe)
  - On macos:
    ```shell
    brew install tesseract
    ```
  - On Linux (Debian/Ubuntu)
    ```shell
    sudo apt install tesseract-ocr
    sudo apt install libtesseract-dev
    ```
    
  - Download the arabic dataset
    ```shell
    curl -LO https://github.com/tesseract-ocr/tessdata/raw/main/ara.traineddata
    mv ara.traineddata /opt/homebrew/Cellar/tesseract/5.3.3/share/tessdata
    ``` 
  - If you're on macOS, you may need to add `libtesseract.dylib` to tess4j's jar file:
    ```shell
    cd ~/.m2/repository/net/sourceforge/tess4j/tess4j/5.8.0
    mkdir darwin
    jar uf tess4j-5.8.0.jar darwin/
    cp /opt/homebrew/Cellar/tesseract/5.3.3/lib/libtesseract.5.dylib darwin/libtesseract.dylib
    jar uf tess4j-5.8.0.jar darwin/libtesseract.dylib 
    jar tf tess4j-5.8.0.jar
    ```

### License
MIT

