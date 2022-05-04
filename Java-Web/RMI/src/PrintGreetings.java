import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PrintGreetings extends Remote {
    public String printGreeting() throws RemoteException;
}
