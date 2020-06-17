package tn.Esprit.Entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Annonce implements Serializable {
	public int IdAnnonce ;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    public Date DateAnnonce ;
    public String Titre ;
    public Type_ano type ;
    public Statut statut ;
    public String Type_Dannonce ;
    public String Description ;



    public float PrixAchat ;
    public float LoyerMensuel ;
    public String Localisation ;
    public String ImageBi ;
    public long SizeImage ;
    public float ChargeMensuel ;
  
    public int NombreDeChambre ;
    public String jardin ;

    public TypeStudio typeStudio ;

    public int Etage ;
    public boolean Ascensseur ;
    public boolean CuisineEquipe;

    public int post_like ;
    public float Superficie;
    public String UserID ;
     
    public Annonce() {
		super();
	}

	public Annonce(int idAnnonce, Date dateAnnonce, String titre, Type_ano type, Statut statut, String type_Dannonce,
			String description, float prixAchat, float loyerMensuel, String localisation, String imageBi,
			long sizeImage, float chargeMensuel, int nombreDeChambre, String jardin, TypeStudio typeStudio, int etage,
			boolean ascensseur, boolean cuisineEquipe, int post_like, float superficie, String userID) {
		super();
		IdAnnonce = idAnnonce;
		DateAnnonce = dateAnnonce;
		Titre = titre;
		this.type = type;
		this.statut = statut;
		Type_Dannonce = type_Dannonce;
		Description = description;
		PrixAchat = prixAchat;
		LoyerMensuel = loyerMensuel;
		Localisation = localisation;
		ImageBi = imageBi;
		SizeImage = sizeImage;
		ChargeMensuel = chargeMensuel;
		NombreDeChambre = nombreDeChambre;
		this.jardin = jardin;
		this.typeStudio = typeStudio;
		Etage = etage;
		Ascensseur = ascensseur;
		CuisineEquipe = cuisineEquipe;
		this.post_like = post_like;
		Superficie = superficie;
		UserID = userID;
	}

	public Annonce(Date dateAnnonce, String titre, Type_ano type, Statut statut, String type_Dannonce,
			String description, float prixAchat, float loyerMensuel, String localisation, String imageBi,
			long sizeImage, float chargeMensuel, int nombreDeChambre, String jardin, TypeStudio typeStudio, int etage,
			boolean ascensseur, boolean cuisineEquipe, int post_like, float superficie, String userID) {
		super();
		DateAnnonce = dateAnnonce;
		Titre = titre;
		this.type = type;
		this.statut = statut;
		Type_Dannonce = type_Dannonce;
		Description = description;
		PrixAchat = prixAchat;
		LoyerMensuel = loyerMensuel;
		Localisation = localisation;
		ImageBi = imageBi;
		SizeImage = sizeImage;
		ChargeMensuel = chargeMensuel;
		NombreDeChambre = nombreDeChambre;
		this.jardin = jardin;
		this.typeStudio = typeStudio;
		Etage = etage;
		Ascensseur = ascensseur;
		CuisineEquipe = cuisineEquipe;
		this.post_like = post_like;
		Superficie = superficie;
		UserID = userID;
	}
	

	public Annonce(String titre, int nombreDeChambre,float chargeMensuel, String description ) {
		super();
		Titre = titre;
		Description = description;
		ChargeMensuel = chargeMensuel;
		NombreDeChambre = nombreDeChambre;
	}

	public int getIdAnnonce() {
		return IdAnnonce;
	}

	public void setIdAnnonce(int idAnnonce) {
		IdAnnonce = idAnnonce;
	}

	public Date getDateAnnonce() {
		return DateAnnonce;
	}

	public void setDateAnnonce(Date dateAnnonce) {
		DateAnnonce = dateAnnonce;
	}

	public String getTitre() {
		return Titre;
	}

	public void setTitre(String titre) {
		Titre = titre;
	}

	public Type_ano getType() {
		return type;
	}

	public void setType(Type_ano type) {
		this.type = type;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public String getType_Dannonce() {
		return Type_Dannonce;
	}

	public void setType_Dannonce(String type_Dannonce) {
		Type_Dannonce = type_Dannonce;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public float getPrixAchat() {
		return PrixAchat;
	}

	public void setPrixAchat(float prixAchat) {
		PrixAchat = prixAchat;
	}

	public float getLoyerMensuel() {
		return LoyerMensuel;
	}

	public void setLoyerMensuel(float loyerMensuel) {
		LoyerMensuel = loyerMensuel;
	}

	public String getLocalisation() {
		return Localisation;
	}

	public void setLocalisation(String localisation) {
		Localisation = localisation;
	}

	public String getImageBi() {
		return ImageBi;
	}

	public void setImageBi(String imageBi) {
		ImageBi = imageBi;
	}

	public long getSizeImage() {
		return SizeImage;
	}

	public void setSizeImage(long sizeImage) {
		SizeImage = sizeImage;
	}

	public float getChargeMensuel() {
		return ChargeMensuel;
	}

	public void setChargeMensuel(float chargeMensuel) {
		ChargeMensuel = chargeMensuel;
	}

	public int getNombreDeChambre() {
		return NombreDeChambre;
	}

	public void setNombreDeChambre(int nombreDeChambre) {
		NombreDeChambre = nombreDeChambre;
	}

	public String getJardin() {
		return jardin;
	}

	public void setJardin(String jardin) {
		this.jardin = jardin;
	}

	public TypeStudio getTypeStudio() {
		return typeStudio;
	}

	public void setTypeStudio(TypeStudio typeStudio) {
		this.typeStudio = typeStudio;
	}

	public int getEtage() {
		return Etage;
	}

	public void setEtage(int etage) {
		Etage = etage;
	}

	public boolean isAscensseur() {
		return Ascensseur;
	}

	public void setAscensseur(boolean ascensseur) {
		Ascensseur = ascensseur;
	}

	public boolean isCuisineEquipe() {
		return CuisineEquipe;
	}

	public void setCuisineEquipe(boolean cuisineEquipe) {
		CuisineEquipe = cuisineEquipe;
	}

	public int getPost_like() {
		return post_like;
	}

	public void setPost_like(int post_like) {
		this.post_like = post_like;
	}

	public float getSuperficie() {
		return Superficie;
	}

	public void setSuperficie(float superficie) {
		Superficie = superficie;
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	@Override
	public String toString() {
		return "Annonce [IdAnnonce=" + IdAnnonce + ", DateAnnonce=" + DateAnnonce + ", Titre=" + Titre + ", type="
				+ type + ", statut=" + statut + ", Type_Dannonce=" + Type_Dannonce + ", Description=" + Description
				+ ", PrixAchat=" + PrixAchat + ", LoyerMensuel=" + LoyerMensuel + ", Localisation=" + Localisation
				+ ", ImageBi=" + ImageBi + ", SizeImage=" + SizeImage + ", ChargeMensuel=" + ChargeMensuel
				+ ", NombreDeChambre=" + NombreDeChambre + ", jardin=" + jardin + ", typeStudio=" + typeStudio
				+ ", Etage=" + Etage + ", Ascensseur=" + Ascensseur + ", CuisineEquipe=" + CuisineEquipe
				+ ", post_like=" + post_like + ", Superficie=" + Superficie + ", UserID=" + UserID + ", getIdAnnonce()="
				+ getIdAnnonce() + ", getDateAnnonce()=" + getDateAnnonce() + ", getTitre()=" + getTitre()
				+ ", getType()=" + getType() + ", getStatut()=" + getStatut() + ", getType_Dannonce()="
				+ getType_Dannonce() + ", getDescription()=" + getDescription() + ", getPrixAchat()=" + getPrixAchat()
				+ ", getLoyerMensuel()=" + getLoyerMensuel() + ", getLocalisation()=" + getLocalisation()
				+ ", getImageBi()=" + getImageBi() + ", getSizeImage()=" + getSizeImage() + ", getChargeMensuel()="
				+ getChargeMensuel() + ", getNombreDeChambre()=" + getNombreDeChambre() + ", getJardin()=" + getJardin()
				+ ", getTypeStudio()=" + getTypeStudio() + ", getEtage()=" + getEtage() + ", isAscensseur()="
				+ isAscensseur() + ", isCuisineEquipe()=" + isCuisineEquipe() + ", getPost_like()=" + getPost_like()
				+ ", getSuperficie()=" + getSuperficie() + ", getUserID()=" + getUserID() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (Ascensseur ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(ChargeMensuel);
		result = prime * result + (CuisineEquipe ? 1231 : 1237);
		result = prime * result + ((DateAnnonce == null) ? 0 : DateAnnonce.hashCode());
		result = prime * result + ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + Etage;
		result = prime * result + IdAnnonce;
		result = prime * result + ((ImageBi == null) ? 0 : ImageBi.hashCode());
		result = prime * result + ((Localisation == null) ? 0 : Localisation.hashCode());
		result = prime * result + Float.floatToIntBits(LoyerMensuel);
		result = prime * result + NombreDeChambre;
		result = prime * result + Float.floatToIntBits(PrixAchat);
		result = prime * result + (int) (SizeImage ^ (SizeImage >>> 32));
		result = prime * result + Float.floatToIntBits(Superficie);
		result = prime * result + ((Titre == null) ? 0 : Titre.hashCode());
		result = prime * result + ((Type_Dannonce == null) ? 0 : Type_Dannonce.hashCode());
		result = prime * result + ((UserID == null) ? 0 : UserID.hashCode());
		result = prime * result + ((jardin == null) ? 0 : jardin.hashCode());
		result = prime * result + post_like;
		result = prime * result + ((statut == null) ? 0 : statut.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((typeStudio == null) ? 0 : typeStudio.hashCode());
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
		Annonce other = (Annonce) obj;
		if (Ascensseur != other.Ascensseur)
			return false;
		if (Float.floatToIntBits(ChargeMensuel) != Float.floatToIntBits(other.ChargeMensuel))
			return false;
		if (CuisineEquipe != other.CuisineEquipe)
			return false;
		if (DateAnnonce == null) {
			if (other.DateAnnonce != null)
				return false;
		} else if (!DateAnnonce.equals(other.DateAnnonce))
			return false;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (Etage != other.Etage)
			return false;
		if (IdAnnonce != other.IdAnnonce)
			return false;
		if (ImageBi == null) {
			if (other.ImageBi != null)
				return false;
		} else if (!ImageBi.equals(other.ImageBi))
			return false;
		if (Localisation == null) {
			if (other.Localisation != null)
				return false;
		} else if (!Localisation.equals(other.Localisation))
			return false;
		if (Float.floatToIntBits(LoyerMensuel) != Float.floatToIntBits(other.LoyerMensuel))
			return false;
		if (NombreDeChambre != other.NombreDeChambre)
			return false;
		if (Float.floatToIntBits(PrixAchat) != Float.floatToIntBits(other.PrixAchat))
			return false;
		if (SizeImage != other.SizeImage)
			return false;
		if (Float.floatToIntBits(Superficie) != Float.floatToIntBits(other.Superficie))
			return false;
		if (Titre == null) {
			if (other.Titre != null)
				return false;
		} else if (!Titre.equals(other.Titre))
			return false;
		if (Type_Dannonce == null) {
			if (other.Type_Dannonce != null)
				return false;
		} else if (!Type_Dannonce.equals(other.Type_Dannonce))
			return false;
		if (UserID == null) {
			if (other.UserID != null)
				return false;
		} else if (!UserID.equals(other.UserID))
			return false;
		if (jardin == null) {
			if (other.jardin != null)
				return false;
		} else if (!jardin.equals(other.jardin))
			return false;
		if (post_like != other.post_like)
			return false;
		if (statut != other.statut)
			return false;
		if (type != other.type)
			return false;
		if (typeStudio != other.typeStudio)
			return false;
		return true;
	}
    
    
    


}
