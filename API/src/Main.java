import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
  private static HttpURLConnection connection;
  public static ArrayList<String> titles;
  public static ArrayList<String> overviews;
  public static ArrayList<String> genres;
  public static ArrayList<String> posters;
  

  public static void main(String[] args) {
	  //List of now playing movies and upcoming movies
	  titles = new ArrayList<>();
	  overviews = new ArrayList<>();
	  genres = new ArrayList<>();
	  posters = new ArrayList<>();
	  HashMap<String, Integer> genreIds = new HashMap<String, Integer>();
	  
	  
	  String apiKey = "709c731348589bc63268f0736fe09578";	
	  String baseUrl = "https://api.themoviedb.org";
    
    //Method 1: java.net.HTTPURLConnection
	//GENRES
	    //
	    //
	    //
	    //
	    //
	    //
	    //
	    BufferedReader newReader;
	    String newLine;
	    StringBuffer newResponseContent = new StringBuffer();
	    
	    
	    try {
	    	//String upcomingMovies = "/3/movie/upcoming";
	    	String getGenres = "/3/genre/movie/list";
	    	URL url =  new URL(baseUrl + getGenres + "?api_key=" + apiKey);
	          	
	    	connection = (HttpURLConnection) url.openConnection();

	      //Request setup
	      connection.setRequestMethod("GET");
	      connection.setConnectTimeout(5000);
	      connection.setReadTimeout(5000);
	      
	      
	      
	      int status = connection.getResponseCode();
	      
//	      System.out.println(status);
	      

	      
	      if (status > 299) {
	        newReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
	        while ((newLine = newReader.readLine()) != null) {
	          newResponseContent.append(newLine);
	          
	        }
	        
	        newReader.close();
	        
	      } else {
	    	  
	        newReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        while ((newLine = newReader.readLine()) != null) {
	          newResponseContent.append(newLine);
	          
	        }
	        
	        newReader.close();
	      }

	      JSONObject output = new JSONObject(newResponseContent.toString());
//	      System.out.println(output.toString(4));
	      
	      
		  JSONArray genreArr = output.getJSONArray("genres");
		  
		  for (int i = 0; i < genreArr.length(); i++) {
			  String genreName = genreArr.getJSONObject(i).getString("name");
			  int id = genreArr.getJSONObject(i).getInt("id");

			  genreIds.put(genreName, id);
			  //System.out.println("Genre: " + genreName + ", Id: " + genreIds.get(genreName));
		  }
		  
		  

	    } catch (MalformedURLException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    } finally {
	      connection.disconnect();
	    }
	  
	  
	  
	//MOVIES
	//
	//
	 //
	//
	//    
    BufferedReader reader;
    String line;
    StringBuffer responseContent = new StringBuffer();
    
    try {
    	
    	String nowPlaying = "/3/movie/now_playing";
    	URL url = new URL(baseUrl + nowPlaying + "?api_key=" + apiKey);     
      	
    	connection = (HttpURLConnection) url.openConnection();

      //Request setup
      connection.setRequestMethod("GET");
      connection.setConnectTimeout(5000);
      connection.setReadTimeout(5000);
      
      
      
      int status = connection.getResponseCode();
      
//      System.out.println(status);
      

      
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

      JSONObject output = new JSONObject(responseContent.toString());
//      System.out.println(output.toString(4));
      
      
      
	  JSONArray movieInfoArr = output.getJSONArray("results");
	  
	  
	  
	  for (int i = 0; i < movieInfoArr.length(); i++) {
		  String title = movieInfoArr.getJSONObject(i).getString("title");
		  titles.add(title);
		  
		  String overview = movieInfoArr.getJSONObject(i).getString("overview");
		  overviews.add(overview);
		  
		  String poster_path = movieInfoArr.getJSONObject(i).getString("poster_path");
		  posters.add(poster_path);
		  
		  
		  JSONArray movieGenreIDs = movieInfoArr.getJSONObject(i).getJSONArray("genre_ids");
		  
		  for (String key : genreIds.keySet()) {
			  if (movieGenreIDs.getInt(0) == genreIds.get(key)) {
				  genres.add(key);
			  }
		  }

	  }
	  
//	  for (int j = 0; j < genres.size(); j++) {
//		  System.out.println(titles.get(j));
//		  System.out.println(overviews.get(j));
//		  System.out.println(genres.get(j));
//	  }
	  
	  
	  
	  

    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      connection.disconnect();
    }
    
    
    //
  
  }  
}
