import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
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
   
  /*
  public void retrieveMovieList() {




	//List of now playing movies and upcoming movies
	  //String titles[] = new String[100];
	  ArrayList<Movie> movies = new ArrayList<>();
	  HashMap<String, Integer> genreIds = new HashMap<String, Integer>();
	  
	  
	  String apiKey = "709c731348589bc63268f0736fe09578";	
	  String baseUrl = "https://api.themoviedb.org";
    
 
	  
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
        
	  
	 //entire output
      JSONObject output = new JSONObject(responseContent.toString());
//      System.out.println(output.toString(4));
      //results is just the movies and their info
	  JSONArray movieInfoArr = output.getJSONArray("results");
	  
	  //this for loop pairs the genre with its id since the results gives only genre ids not genres
	  JSONArray genreArr = output.getJSONArray("genres");
      for (int i = 0; i < genreArr.length(); i++) {
		  String genreName = genreArr.getJSONObject(i).getString("name");
		  int id = genreArr.getJSONObject(i).getInt("id");

		  genreIds.put(genreName, id);
		  //System.out.println("Genre: " + genreName + ", Id: " + genreIds.get(genreName));
	  }
	  
      //looks through the movies and takes out the title, overview, and genre of each movie
      //creates a new Movie object and adds it to a list of Movies.
	  for (int i = 0; i < movieInfoArr.length(); i++) {

		  String title = movieInfoArr.getJSONObject(i).getString("title");
		  String overview = movieInfoArr.getJSONObject(i).getString("overview");
		  JSONArray movieGenreIDs = movieInfoArr.getJSONObject(i).getJSONArray("genre_ids");
		  String genre = null;
		  for (String key : genreIds.keySet()) {
			  if (movieGenreIDs.getInt(0) == genreIds.get(key)) {
				  genre = key;
				  
			  }
		  }
		  
		  movies.add(new Movie(title, genre, overview));
		  
		  //String title = movieInfoArr.getJSONObject(i).getString("title");
		  //titles[i] = (title);
		  
		 
	  }
	  
	  
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      connection.disconnect();
    }
    
  
  
  }
  
  

  public String[] retrievePlotSummary() {


	  String overviews[] = new String[100];
	  String apiKey = "709c731348589bc63268f0736fe09578";	
	  String baseUrl = "https://api.themoviedb.org";
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
		 
		  String overview = movieInfoArr.getJSONObject(i).getString("overview");
		  overviews[i] = (overview);
	  }
	  
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      connection.disconnect();
    }
    
    return overviews;
  }
*/

  public static HashMap<String, Integer> retrieveGenre() {

	  	String apiKey = "709c731348589bc63268f0736fe09578";	
		String baseUrl = "https://api.themoviedb.org";
		HashMap<String, Integer> genreIds = new HashMap<String, Integer>();
	  	
	  	
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
	      JSONArray genreArr = output.getJSONArray("genres");
		  
		  for (int i = 0; i < genreArr.length(); i++) {
			  String genreName = genreArr.getJSONObject(i).getString("name");
			  int id = genreArr.getJSONObject(i).getInt("id");

			  genreIds.put(genreName, id);
			  //System.out.println("Genre: " + genreName + ", Id: " + genreIds.get(genreName));
		  }
	      
	     
//	      System.out.println(output.toString(4));
	      

	    } catch (MalformedURLException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    } finally {
	      connection.disconnect();
	    }
	  
	  return genreIds;
}
  public ArrayList<Movie> setupMovieList() {
	//List of now playing movies and upcoming movies	  
	  ArrayList<Movie> movies = new ArrayList<>();
	  HashMap<String, Integer> genreIds = retrieveGenre();
	  
	  String apiKey = "709c731348589bc63268f0736fe09578";	
	  String baseUrl = "https://api.themoviedb.org";
    
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
      
		  int status = connection.getResponseCode();   //System.out.println(status);
      
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
		  //entire output
		  JSONObject output = new JSONObject(responseContent.toString());
		  //System.out.println(output.toString(4));
		  //results is just the movies and their info
		  JSONArray movieInfoArr = output.getJSONArray("results");
	
		  //looks through the movies and takes out the title, overview, and genre of each movie
		  //creates a new Movie object and adds it to a list of Movies.
		  for (int i = 0; i < movieInfoArr.length(); i++) {

			  String title = movieInfoArr.getJSONObject(i).getString("title");
			  String overview = movieInfoArr.getJSONObject(i).getString("overview");
			  JSONArray movieGenreIDs = movieInfoArr.getJSONObject(i).getJSONArray("genre_ids");
			  String genre;
			  for (String key : genreIds.keySet()) {
				  if (movieGenreIDs.getInt(0) == genreIds.get(key)) {
					  genre = key;
					  movies.add(new Movie(title, genre, overview));
					  
				  }
			  
			  }
			  //System.out.println(movies.get(0).getGenre());	  
		 
		  }
		  
	  } catch (MalformedURLException e) {
		  e.printStackTrace();
	  } catch (IOException e) {
		  e.printStackTrace();
	  } finally {
		  connection.disconnect();
	  }
	  
	  return movies;
  	}  
  	
}

