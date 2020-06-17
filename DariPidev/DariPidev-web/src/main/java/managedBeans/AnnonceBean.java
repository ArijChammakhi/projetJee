package managedBeans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import com.fasterxml.jackson.annotation.JsonFormat;

import tn.Esprit.Entity.Annonce;
import tn.Esprit.Entity.Statut;
import tn.Esprit.Entity.TypeStudio;
import tn.Esprit.Entity.Type_ano;
import tn.Esprit.Services.AnnonceService;

@ManagedBean(name="annonceBean",eager=true)
@SessionScoped
public class AnnonceBean {
	static int id;
	public int IdAnnonce ;
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
    private List<Annonce> annonces;
    public Part uploadFile;
    
    @EJB
	private AnnonceService annonceService;
	
	
	

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		AnnonceBean.id = id;
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

	

	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}

	public Part getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(Part uploadFile) {
		this.uploadFile = uploadFile;
	}

	@PostConstruct
	public void init() {
		setAnnonces(annonceService.GetAll());
	}

	public List<Annonce> getAnnonces() {
		annonces = annonceService.GetAll();
		return annonces;
	}

	public String addAnnonce() {
		annonceService.Create(new Annonce(this.Titre,this.NombreDeChambre,this.ChargeMensuel,this.Description));
		
		return "Index.xhtml";
	}
	
	
	
	
     public String deleteAnnonce(int AnnonceId) {
		
    	 annonceService.Delete(AnnonceId);
		return "Index.jsf";
	}


	
	

}
