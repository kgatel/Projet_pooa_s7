
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Personne extends Remote {
	
   public String getName() throws RemoteException;
   public void setName(String nom) throws RemoteException;
   public void setSolde(float solde) throws RemoteException;
   public float getSolde() throws RemoteException;
   public void setId(int id) throws RemoteException;
   public int getId() throws RemoteException;
   public String toText() throws RemoteException;
}
