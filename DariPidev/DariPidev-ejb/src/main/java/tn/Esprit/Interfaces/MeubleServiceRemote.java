package tn.Esprit.Interfaces;

import java.net.MalformedURLException;
import java.util.List;
import javax.ejb.Remote;
import tn.Esprit.Entity.Meuble;
@Remote
public interface MeubleServiceRemote {
	List<Meuble> GetAll() throws MalformedURLException;
	public void Delete(int MeubleId);
	public void Create(Meuble f);
	public void Update(int id,Meuble f);
}
