import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import org.json.JSONArray;
import org.json.JSONObject;

class Main {
  private static HttpURLConnection connection;

  public static void main(String[] args) {
    
    //Method 1: java.net.HTTPURLConnection
    BufferedReader reader;
    String line;
    StringBuffer responseContent = new StringBuffer();
    try {
    	String key = "709c731348589bc63268f0736fe09578";	
    	String baseUrl = "https://api.themoviedb.org";
    	String addedUrl = "/3/movie/now_playing";
    	URL url = new URL(baseUrl + addedUrl + "?api_key=" + key);     
      	
    	connection = (HttpURLConnection) url.openConnection();
    
//      HttpPost post = new HttpPost(baseUrl + addedUrl + "?api_key=" + key);
//      post.setHeader("Accept", "application/json");
//      post.setHeader("Content-type", "application/json");
//      post.setHeader("Authorization", "api_key=" + key);
     
      //connection.addRequestProperty("Accept",  "application/json");
      //connection.addRequestProperty("Content-type",  "application/json");
      
//      HttpGet request = new HttpGet(baseUrl + addedUrl + "?api_key=" + key);
//      request.setHeader("Content-type", "application/json");
      
      //request.addHeader("Accept", "application/json");
      //request.addHeader("Content-type", "application/json");
      
//      System.out.println(request.getRequestLine());

      //Request setup
      connection.setRequestMethod("GET");
      connection.setConnectTimeout(5000);
      connection.setReadTimeout(5000);
      
      
      
      int status = connection.getResponseCode();
      
      System.out.println(status);
      

      
      if (status > 299) {
        reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
        while ((line = reader.readLine()) != null) {
          responseContent.append(line);
          
        }
        
        reader.close();
        
      } else {
    	  
        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        while ((line = reader.readLine()) != null) {
          responseContent.append(line);
          
        }
        
        reader.close();
      }

      //JSONObject output = new JSONObject(responseContent.toString());
      //System.out.println(output.toString(4));
      
      
      JSONObject result = new JSONObject(responseContent.toString());
	  JSONArray arr = result.getJSONArray("results");
	  ArrayList<String> posters = new ArrayList<>();
	  
	  for (int i = 0; i < arr.length(); i++) {
		  String title = arr.getJSONObject(i).getString("title");
		  System.out.println(title);
	  }
	  for (int i = 0; i < arr.length(); i++) {
		  String poster_path = arr.getJSONObject(i).getString("poster_path");
		  posters.add(poster_path);
	  }
	  
	  
	  

    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      connection.disconnect();
    }
  
  } //End main method
  
}
