package currency;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import org.json.*;
import java.io.*;


public class HttpHandler {
	private String endpointUrl = "";
	private String data = "";
	
	public HttpHandler(String url) {
		endpointUrl = url;
	}
	
	public void load() throws IOException {
		StringBuilder result = new StringBuilder();
	    
	    BufferedReader rd = new BufferedReader(getStream());
	    String line;
	    while ((line = rd.readLine()) != null) {
	       result.append(line);
	    }
	    rd.close();
	    data = result.toString();
	}
	
	public JSONObject getJsonObject() {
		return new JSONObject(data);
	}
	
	private InputStreamReader getStream() throws IOException {
		URL url;
		url = new URL(endpointUrl);
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    return new InputStreamReader(conn.getInputStream());
	}

}