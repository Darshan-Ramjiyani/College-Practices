import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteAdder extends UnicastRemoteObject implements PrintGreetings {

    protected RemoteAdder() throws RemoteException {
        super();
    }

    @Override
    public String printGreeting() throws RemoteException {
        return "Namaskar! Welcome to the Dwiadh Terminal. :)";
    }
}
