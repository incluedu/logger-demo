package net.lustenauer.sb.demo.loggerdemo.plclogger;

import net.lustenauer.sb.demo.loggerdemo.host.Host;
import net.lustenauer.sb.demo.loggerdemo.host.HostService;
import net.lustenauer.sb.demo.loggerdemo.logreader.LogReaderService;
import net.lustenauer.sb.demo.loggerdemo.logwriter.LogWriterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlcLoggerService {
    /*
     * CONSTANTS
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PlcLoggerService.class);

    /*
     * ATTRIBUTES
     */
    @Autowired private HostService hostService;
    @Autowired private LogWriterService logWriterService;
    @Autowired private LogReaderService logReaderService;


    /*
     * PUBLIC METHODS
     */
    public void start() {
        LOGGER.trace("start() called"); //NON-NLS

        List<Host> hosts = hostService.getAllHosts();
        for (Host host : hosts) {
            host.setRunning(true);
            logReaderService.logReaderTask(host);
            logWriterService.logWriterTask(host);
        }
    }

    public void stop() {
        LOGGER.trace("stop() called"); //NON-NLS

        List<Host> hosts = hostService.getAllHosts();
        for (Host host : hosts) {
            host.setRunning(false);
        }
    }
}
