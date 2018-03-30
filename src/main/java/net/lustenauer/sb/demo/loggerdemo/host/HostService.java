package net.lustenauer.sb.demo.loggerdemo.host;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostService {
    /*
     * CONSTANTS
     */
    private final Logger logger = LoggerFactory.getLogger(HostService.class);

    /*
     * ATTRIBUTES
     */
    private List<Host> hosts;

    @Autowired private HostRepository hostRepository;

    /*
     * CONSTRUCTORS
     */
    public HostService() {
        logger.trace("HostService() called"); //NON-NLS

    }

    /*
     * PUBLIC METHODS
     */

    /**
     * @return a list with contain all current hosts, if hosts are not initialized the hostlist will request from
     * database
     */
    public List<Host> getAllHosts() {
        if (hosts == null || hosts.isEmpty()) {
            hosts = hostRepository.findAll();
        }
        return hosts;
    }

    /**
     * Save the hostlist in the database and use the result as new hostlist
     */
    public void saveHosts() {
        hosts = hostRepository.saveAll(hosts);
    }
}
