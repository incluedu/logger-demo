package net.lustenauer.sb.demo.loggerdemo.logreader;

import net.lustenauer.sb.demo.loggerdemo.host.Host;
import net.lustenauer.sb.demo.loggerdemo.host.HostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class LogReaderService {
    /*
     * CONSTANTS
     */
    private final Logger logger = LoggerFactory.getLogger(LogReaderService.class);
    /*
     * ATTRIBUTE
     */
    private boolean running;

    @Autowired HostService hostService;

    /*
     * PUBLIC METHODS
     */
    @Async
    public void logReaderTask(Host host) {
        logger.trace("logReaderTask() called with: host = [" + host + "]"); //NON-NLS

        while (running) {
            sleep(500);
            logger.info("logReader running ...");
        }
    }

    public void run() {
        logger.trace("run() called"); //NON-NLS
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

    /*
     * PRIVATE METHODS
     */
    private void sleep(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            logger.error(e.getLocalizedMessage());
            logger.debug("", e);
        }
    }
}
