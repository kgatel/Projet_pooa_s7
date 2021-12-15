
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Guy extends Remote {
   public String getName() throws RemoteException;
   public void setName(String name) throws RemoteException;
}