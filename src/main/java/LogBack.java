
import java.net.UnknownHostException;

public class LogBack {


    public static void main(String[] args) throws UnknownHostException {

        RequestPath logBack = new RequestPath();
        logBack.getAndSetPath();

        for (String id:
                logBack.flagProcess) {
            System.out.println("ALert: " + id);
        }

    }



}
