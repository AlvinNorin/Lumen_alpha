/**
 *	**	**	**	**	**	**	**	**
 * 	server.java
 * 	singleplayer
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		Alvin
 * 	Year		:		2014
 * 	Time		:		17:49:20
 * 
 *	**	**	**	**	**	**	**	**
 */
package singleplayer;

/**
 * @author Alvin
 */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
 






import javax.net.ssl.HttpsURLConnection;

public class server {
	
	public static String PLAYER_1_NAME = "PLAYER 1";
	public static int PLAYER_1_X = 0;
	public static String address = "192.168.2.10";
	
	private final static String USER_AGENT = "Mozilla/5.0";
 
	public static void main(String[] args) throws Exception {
 
		server http = new server();
 
		//System.out.println("Testing 1 - Send Http GET request");
		server.sendGet("http://localhost/index.php");
	}
 
	// HTTP GET request
	public static String sendGet(String url) {
		URL obj = null;
		try {
			obj = new URL(url);
		} catch (MalformedURLException e) {
		}
		HttpURLConnection con = null;
		try {
			con = (HttpURLConnection) obj.openConnection();
		} catch (IOException e1) {
		}
 
		// optional default is GET
		try {
			con.setRequestMethod("GET");
		} catch (ProtocolException e) {
		}
 
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
 
		//int responseCode = 0;
		/*try {
			responseCode = con.getResponseCode();
		} catch (IOException e) {
		}*/
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = null;
		try {
			in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
		} catch (IOException e) {
		}
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		try {
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
		} catch (IOException e) {
		}
		try {
			in.close();
		} catch (IOException e) {
		}
 
		//print result
		//System.out.println(response.toString());
		return response.toString();
	}
	
	private String sendPost(String url, String par) {
		try {
		URL obj = null;
		try {
			obj = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
 
		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
 
		String urlParameters = par;
 
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
 
		int responseCode = con.getResponseCode();
		/*System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);*/
		
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		return response.toString();
		} catch (Exception e) {
			System.err.println("[POST]: Connection failed..");
		}
		return "errno0";
	}
}
