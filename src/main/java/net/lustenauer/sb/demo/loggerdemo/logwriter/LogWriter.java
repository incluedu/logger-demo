package net.lustenauer.sb.demo.loggerdemo.logwriter;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

@Component
public class LogWriter {
    /*
     * CONSTANTS
     */
    private final Logger logger = LoggerFactory.getLogger(LogWriter.class);


    /*
     * ATTRIBUTES
     */
    private File file;

    /*
     * PUBLIC METHODS
     */
    public void writeToFile(String text) {
        try {
            FileUtils.writeStringToFile(file, text, Charset.forName("UTF-8"));
        } catch (IOException e) {
            logger.error(e.getLocalizedMessage());
            logger.debug("", e);
        }
    }

    /*
     * GETTER AND SETTER
     */
    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }
}
