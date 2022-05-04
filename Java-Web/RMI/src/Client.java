/**
 * author DSP
 */
import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
            PrintGreetings sharedObject = (PrintGreetings) Naming.lookup("rmi://localhost:5000/sonoo");
            System.out.println("Remote method says, " + sharedObject.printGreeting());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
