package tn.Esprit.Entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Meuble implements Serializable{
	public int IdMeuble ;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	 public Date DatePublication;
    public String Titre ;
    public String Adresse;
    public String Image ;
    public float PrixM ;
    public String Description ;
    
    public Meuble() {
		super();
	}
    
   
    
    
    
    public Meuble(Date datePublication, String titre, String adresse, String image, float prixM, String description,
			String userID) {
		super();
		DatePublication = datePublication;
		Titre = titre;
		Adresse = adresse;
		Image = image;
		PrixM = prixM;
		Description = description;
		UserID = userID;
	}









	public Meuble(int idMeuble, Date datePublication, String titre, String adresse, String image, float prixM,
			String description, String userID) {
		super();
		IdMeuble = idMeuble;
		DatePublication = datePublication;
		Titre = titre;
		Adresse = adresse;
		Image = image;
		PrixM = prixM;
		Description = description;
		UserID = userID;
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
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String UserID ;

	@Override
	public String toString() {
		return "Meuble [IdMeuble=" + IdMeuble + ", DatePublication=" + DatePublication + ", Titre=" + Titre
				+ ", Adresse=" + Adresse + ", Image=" + Image + ", PrixM=" + PrixM + ", Description=" + Description
				+ ", UserID=" + UserID + "]";
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Adresse == null) ? 0 : Adresse.hashCode());
		result = prime * result + ((DatePublication == null) ? 0 : DatePublication.hashCode());
		result = prime * result + ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + IdMeuble;
		result = prime * result + ((Image == null) ? 0 : Image.hashCode());
		result = prime * result + Float.floatToIntBits(PrixM);
		result = prime * result + ((Titre == null) ? 0 : Titre.hashCode());
		result = prime * result + ((UserID == null) ? 0 : UserID.hashCode());
		return result;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Meuble other = (Meuble) obj;
		if (Adresse == null) {
			if (other.Adresse != null)
				return false;
		} else if (!Adresse.equals(other.Adresse))
			return false;
		if (DatePublication == null) {
			if (other.DatePublication != null)
				return false;
		} else if (!DatePublication.equals(other.DatePublication))
			return false;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (IdMeuble != other.IdMeuble)
			return false;
		if (Image == null) {
			if (other.Image != null)
				return false;
		} else if (!Image.equals(other.Image))
			return false;
		if (Float.floatToIntBits(PrixM) != Float.floatToIntBits(other.PrixM))
			return false;
		if (Titre == null) {
			if (other.Titre != null)
				return false;
		} else if (!Titre.equals(other.Titre))
			return false;
		if (UserID == null) {
			if (other.UserID != null)
				return false;
		} else if (!UserID.equals(other.UserID))
			return false;
		return true;
	}
    
	
	
	
	
	
}
