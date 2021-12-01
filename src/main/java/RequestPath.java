import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

public class RequestPath {
    public  List<String> flagProcess= new ArrayList<>();
    private static InetAddress ip;


    void getAndSetPath() throws UnknownHostException {
        UUID getPathID = UUID.randomUUID();

        ip = InetAddress.getLocalHost();
        String hostname = ip.getHostName();

        long start = new Date().getTime();


        LoggerEntity startLog = new LoggerEntity();
        startLog.setId(String.valueOf(getPathID));
        startLog.setHost(hostname);
        startLog.setState(StateENUM.STARTED.name());
        startLog.setType("APPLICATION_LOG");
        startLog.setTimestamp(String.valueOf(start));



        Scanner scanner = new Scanner(System
                .in);

        System.out.println("Enter The Log Path: ");
        String path = scanner.next();



        System.setProperty("log.path",  path + "/log.txt");
        Logger logger = LoggerFactory.getLogger(LogBack.class);
        logger.info(startLog.toString());

        System.out.println( System.getProperty("log.path"));

        long end = new Date().getTime();


        LoggerEntity endLog = new LoggerEntity();
        endLog.setId(String.valueOf(getPathID));
        endLog.setHost(hostname);
        endLog.setState(StateENUM.FINISHED.name());
        endLog.setType("APPLICATION_LOG");
        endLog.setTimestamp(String.valueOf(end));
        logger.info(endLog.toString());


        if (end-start>=4){
            flagProcess.add(String.valueOf(getPathID));
        }



    }
}
