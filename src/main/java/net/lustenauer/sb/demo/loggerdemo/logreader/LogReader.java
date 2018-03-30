package net.lustenauer.sb.demo.loggerdemo.logreader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogReader {
    private final Logger logger = LoggerFactory.getLogger(LogReader.class);

    /*
     * PUBLIC METHODS
     */
    public void readFromPlc(){
        logger.trace("readFromPlc() called"); //NON-NLS
    }
}
