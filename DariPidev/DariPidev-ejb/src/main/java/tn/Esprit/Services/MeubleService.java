package tn.Esprit.Services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.Esprit.Entity.Meuble;
import tn.Esprit.Interfaces.MeubleServiceRemote;

public class MeubleService implements MeubleServiceRemote{

	public String GlobalEndPoint = "https://localhost:44326/api/";
	TrustManager[] noopTrustManager = new TrustManager[]{
            new X509TrustManager() {

                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                }
            }
        };
	
	@Override
	public List<Meuble> GetAll()  {
		
		
		List<Meuble> lasp=new ArrayList<Meuble>();
		try {
			SSLContext sc = SSLContext.getInstance("ssl");
            sc.init(null, noopTrustManager, null);
	Client client = ClientBuilder.newBuilder().sslContext(sc).build();
	WebTarget web = client.target(GlobalEndPoint+"MeubleApi/GetAll"); 
	Response response = web.request().get();
	
	String result = response.readEntity(String.class); 
	
	JsonReader jsonReader = Json.createReader(new StringReader(result));
	JsonArray object =  jsonReader.readArray();
	
    	
    	for (int i=0;i<object.size();i++)
    	{
    	 
    		Meuble m = new Meuble();
    	// String dateString;
       	 m.setIdMeuble(object.getJsonObject(i).getInt("IdMeuble")); 
    	 m.setTitre(object.getJsonObject(i).getString("Titre")); 
    	 m.setDescription(object.getJsonObject(i).getString("Description")); 
    	 m.setImage("http://localhost:44326/Content/"+object.getJsonObject(i).getString("Image")); 
       	 m.setPrixM(object.getJsonObject(i).getInt("PrixM")); 
       	 m.setAdresse(object.getJsonObject(i).getString("Adresse"));
    	
    	 
    	//m.setCreationDate(java.sql.Timestamp.valueOf(LocalDateTime.parse(object.getJsonObject(i).getString("creationDate").substring(0, 27))));
    	 if(object.getJsonObject(i).getString("OutDate").length() == 28){
    	 m.setDatePublication(java.sql.Timestamp.valueOf(LocalDateTime.parse(object.getJsonObject(i).getString("OutDate").substring(0, 27))));}
    	 else {m.setDatePublication(java.sql.Timestamp.valueOf(LocalDateTime.parse(object.getJsonObject(i).getString("OutDate"))));}

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
    	 
    	lasp.add(m);
    	}
		}catch(Exception ex) {
			System.out.println(ex);
		}
      return lasp;
	}
	@Override
	public void Delete(int AnnonceId) {
		try {
            SSLContext sc = SSLContext.getInstance("ssl");
            sc.init(null, noopTrustManager, null);

		Client client = ClientBuilder.newBuilder().sslContext(sc).build();
		String finalUrl=GlobalEndPoint+"MeubleApi/DeleteMeuble/"+AnnonceId;
		WebTarget target = client.target(finalUrl);
		Response response = target
		               .request().delete();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	@Override
	public void Create(Meuble f) {
		
		try {
			  SSLContext sc = SSLContext.getInstance("ssl");
	            sc.init(null, noopTrustManager, null);
		Client client = ClientBuilder.newBuilder().sslContext(sc).build();
		WebTarget web = client.target(GlobalEndPoint+"MeubleApi/Addmeuble?"); 
		WebTarget hello =web.path("");
		
		Response response =hello.request().post(Entity.entity(f, MediaType.APPLICATION_JSON) );		
		
		String result=response.readEntity(String.class);
		System.out.println(result);

		response.close();
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
	}

	@Override
	public void Update(int id, Meuble e) {
		 Meuble  f = new  Meuble ();
		f.setIdMeuble(id);
		f.setTitre(e.getTitre());
		f.setImage(e.getImage());
		f.setDescription(e.getDescription());
		f.setUserID(e.getUserID());
		f.setPrixM(e.getPrixM());
		f.setDatePublication(e.getDatePublication());
	
		
		
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
