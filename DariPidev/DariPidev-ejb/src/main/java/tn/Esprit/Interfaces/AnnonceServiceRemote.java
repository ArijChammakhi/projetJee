package tn.Esprit.Interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.Esprit.Entity.Annonce;

@Remote
public interface AnnonceServiceRemote {
	List<Annonce> GetAll();
	public void Delete(int AnnonceId);
	public void Create(Annonce f);
	public void Update(int id,Annonce f);
}
