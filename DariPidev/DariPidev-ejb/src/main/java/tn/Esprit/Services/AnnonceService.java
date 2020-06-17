package tn.Esprit.Services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.persistence.EntityManager;

import tn.Esprit.Entity.Annonce;
import tn.Esprit.Entity.Statut;
import tn.Esprit.Entity.TypeStudio;
import tn.Esprit.Entity.Type_ano;
import tn.Esprit.Interfaces.AnnonceServiceRemote;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Stateless
@LocalBean
public class AnnonceService implements AnnonceServiceRemote{
	EntityManager em;

	public AnnonceService() {
		// TODO Auto-generated constructor stub
	}

	TrustManager[] noopTrustManager;
	
	
	@Override
	public List<Annonce> GetAll()  {
		
		List<Annonce> listAbonnements = new ArrayList<Annonce>();
		try {
			SSLContext sc = SSLContext.getInstance("ssl");
			sc.init(null, noopTrustManager, null);

			Client client = ClientBuilder.newBuilder().sslContext(sc).build();

			WebTarget web = client.target("https://localhost:44326/api/AnnonceApiWeb/Get");
//			System.out.println(web);

			Response response = web.request().get();
			String result = response.readEntity(String.class);

//			System.out.println(result);

			JsonReader jsonReader = Json.createReader(new StringReader(result));
			JsonArray object = jsonReader.readArray();
    	for (int i=0;i<object.size();i++)
    	{
    	 
    		Annonce m = new Annonce();
    	// String dateString;
       	 m.setIdAnnonce(object.getJsonObject(i).getInt("Id")); 
    	 m.setTitre(object.getJsonObject(i).getString("Titre")); 
    	 m.setDescription(object.getJsonObject(i).getString("Description")); 
    	 m.setImageBi("http://localhost:44326/Content/"+object.getJsonObject(i).getString("ImageBi")); 

    	
    	 
    	//m.setCreationDate(java.sql.Timestamp.valueOf(LocalDateTime.parse(object.getJsonObject(i).getString("creationDate").substring(0, 27))));
    	 if(object.getJsonObject(i).getString("DateAnnonce").length() == 28){
    	 m.setDateAnnonce(java.sql.Timestamp.valueOf(LocalDateTime.parse(object.getJsonObject(i).getString("DateAnnonce").substring(0, 27))));}
    	 else {m.setDateAnnonce(java.sql.Timestamp.valueOf(LocalDateTime.parse(object.getJsonObject(i).getString("DateAnnonce"))));}

    	// m.setCreationDate(date);
    	// m.setVisibility(object.getJsonObject(i).getString("visibility"));
    	
   
    	// System.out.println(m.Start.toString());
    	// SimpleDateFormat sourceFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    	// try {
        
    	//  System.out.println(sourceFormat.parse(m.getStart().toString()));    	   
    	// } 
    	// catch (ParseException ex) {
    	//   ex.printStackTrace();
    //	 }
    	 
    	 listAbonnements.add(m);
    	}
		}catch(Exception ex) {
			System.out.println(ex);
		}
      return listAbonnements;
	}
	@Override
	public void Delete(int AnnonceId) {
		try {
			SSLContext sc = SSLContext.getInstance("ssl");
			sc.init(null, noopTrustManager, null);

			Client client = ClientBuilder.newBuilder().sslContext(sc).build();

			WebTarget target = client.target("https://localhost:44326/api/AnnonceApiWeb/DeleteAnnonce/" + AnnonceId);

			Response res = (Response) target.request().delete();
			System.out.println(res);

			res.close();
		} catch (Exception e) {
			System.out.println("Delete Error");
		}
	}

		@Override
		public void Create(Annonce a) {

			try {
				SSLContext sc = SSLContext.getInstance("ssl");
				sc.init(null, noopTrustManager, null);

				Client client = ClientBuilder.newBuilder().sslContext(sc).build();

				WebTarget web = client.target(
						"https://localhost:44326/api/AnnonceApiWeb/Post?UserID=a540fd0f-b13e-405e-9f45-4bb2216fe755&"
								+ "Type_Dannonce=Maison" + "&ImageBi=" + a.getImageBi()+ "&LoyerMensuel" +a.getLoyerMensuel() + "&DateAnnonce="
								+ a.getDateAnnonce() + "&IdAnnonce="
								+ a.getIdAnnonce());
				System.out.println("---------Web Target--------");
				System.out.println(web);

				Response response = web.request().post(Entity.entity(a, MediaType.APPLICATION_JSON));
				System.out.println("---------Response--------");
				System.out.println(response);

				String result = response.readEntity(String.class);
				System.out.println("---------Result--------");
				System.out.println(result);

				response.close();
				System.out.println("Not catch ADD");
			} catch (Exception e) {
				System.out.println("Catch in service");
				System.out.println(e);
			}

		}
	@Override
	public void Update(int id, Annonce e) {
		Annonce f = new Annonce();
		f.setIdAnnonce(id);
		f.setTitre(e.getTitre());
		f.setImageBi(e.getImageBi());
		f.setDescription(e.getDescription());
		f.setUserID(e.getUserID());
		f.setPrixAchat(e.getPrixAchat());
		f.setDateAnnonce(e.getDateAnnonce());
		f.setNombreDeChambre(e.getNombreDeChambre());
		f.setType(e.getType());
		f.setStatut(e.getStatut());
		f.setAscensseur(e.isAscensseur());
		f.setTypeStudio(e.getTypeStudio());
		f.setJardin(e.getJardin());
		
		
//   	 SimpleDateFormat sourceFormat = new SimpleDateFormat("dd-MM-yyyy");
//	 try {
//    
//	  f.setStart(sourceFormat.parse(e.getStart().toString()));
//	  f.setEnd(sourceFormat.parse(e.getEnd().toString()));
//	   
//	 } 
//	 catch (ParseException ex) {
//	   ex.printStackTrace();
//	 }
  		System.out.println("OK");
  		System.out.println(f.toString());
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:44326/Annonce/ModifAnnonces");
		WebTarget hello =target.path("");
		Response response = hello.request().put(Entity.entity(f, MediaType.APPLICATION_JSON));
		   System.out.println(response);
			response.close();	

	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void copyInputStreamToFile(InputStream inputStream, File file)
			throws IOException {

	        try (FileOutputStream outputStream = new FileOutputStream(file)) {

	            int read;
	            byte[] bytes = new byte[1024];

	            while ((read = inputStream.read(bytes)) != -1) {
	                outputStream.write(bytes, 0, read);
	            }

				// commons-io
	            //IOUtils.copy(inputStream, outputStream);

	        }
    }
}
