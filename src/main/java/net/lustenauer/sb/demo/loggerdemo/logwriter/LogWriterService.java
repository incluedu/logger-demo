package net.lustenauer.sb.demo.loggerdemo.logwriter;

import net.lustenauer.sb.demo.loggerdemo.host.Host;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class LogWriterService {
    /*
     * CONSTANTS
     */
    private final Logger logger = LoggerFactory.getLogger(LogWriterService.class);

    /*
     * ATTRIBUTES
     */
    @Autowired private LogWriter logWriter;

    private boolean running;

    /*
     * PUBLIC METHODS
     */
    @Async
    public void logWriterTask(Host host) {
        logger.trace("logWriterTask() called with: host = [" + host + "]"); //NON-NLS
        while (running) {

            sleep(2000);
            logger.info("logWriter running ...");
        }
    }

    private void sleep(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            logger.error(e.getLocalizedMessage());
            logger.debug("", e);
        }
    }


    public void start() {
        logger.trace("start() called"); //NON-NLS
        running = true;
    }

    public void stop() {
        logger.trace("stop() called"); //NON-NLS
        running = false;
    }

    /*
     * GETTER AND SETTER
     */
    public boolean isRunning() {
        return running;
    }

}
