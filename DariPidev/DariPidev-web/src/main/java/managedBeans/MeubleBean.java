package managedBeans;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import tn.Esprit.Entity.Meuble;
import tn.Esprit.Services.MeubleService;



@ManagedBean(name="meubleBean",eager=true)
@SessionScoped
public class MeubleBean {
	public int IdMeuble ;
	public Date DatePublication;
    public String Titre ;
    public String Adresse;
    public String Image ;
    public float PrixM ;
    public String Description ;
    private List<Meuble> meubles;
    public Part uploadFile;
    
    
    
    MeubleService MS;
	public MeubleBean() {
	  MS = new MeubleService();	
	}
	
	
	
	public int getIdMeuble() {
		return IdMeuble;
	}
	public void setIdMeuble(int idMeuble) {
		IdMeuble = idMeuble;
	}
	public Date getDatePublication() {
		return DatePublication;
	}
	public void setDatePublication(Date datePublication) {
		DatePublication = datePublication;
	}
	public String getTitre() {
		return Titre;
	}
	public void setTitre(String titre) {
		Titre = titre;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public float getPrixM() {
		return PrixM;
	}
	public void setPrixM(float prixM) {
		PrixM = prixM;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public List<Meuble> getMeubles() {
		return meubles;
	}
	public void setMeubles(List<Meuble> meubles) {
		this.meubles = meubles;
	}
	public Part getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(Part uploadFile) {
		this.uploadFile = uploadFile;
	}
	public MeubleService getMS() {
		return MS;
	}
	public void setMS(MeubleService mS) {
		MS = mS;
	}
	  public String deleteMeuble(int AnnonceId) {
			
			MS.Delete(AnnonceId);
			return "Index.jsf";
		}

	  public String addMeuble() {
	 		MS.Create(new  Meuble( this.DatePublication, this.Titre, this.Adresse, "table.png", this.PrixM, this.Description,
	 				"45130d39-47c8-4d95-9ed7-40c2b4d78f0c"));
	 		
	 		return "Index.jsf";
	 	}
	
public List<Meuble> getAll(){	
		
		return MS.GetAll();
	}

}
