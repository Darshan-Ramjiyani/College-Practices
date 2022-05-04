/**
 * author DSP
 */

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Server {

    public static void main(String[] args) {
        try {
            PrintGreetings sharingObject = new RemoteAdder();
            Naming.rebind("rmi://localhost:5000/sonoo", sharingObject);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
