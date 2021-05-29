package fr.keykatyu.sapinet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import fr.keykatyu.sapinet.service.Service;

public class Sapinet
{
	private String accessKey;
	
	public Sapinet(String accessKey)
	{
		this.accessKey = accessKey;
	}
	
	public Service pingService(int serviceId) throws MalformedURLException, IOException 
	{
		try {
			JSONObject response = new JSONObject(IOUtils.toString(new URL(
					"https://api.sapinet.fr/?token=" + accessKey + "&id=" + serviceId + "&method=getMonitor"), Charset.forName("UTF-8")));
			return new Service(response.getInt("id"), response.getString("name"), response.getString("testType"), 
					response.getInt("testPort"), response.getString("hostname"), response.getBoolean("status"), 
					response.getBoolean("underMaintenance"), response.getString("messageMaintenance"));
		} catch(JSONException e) {
			System.err.println("Le service n°" + serviceId + " n'existe pas chez Sapinet ou la clé est incorrecte.");
			return null;
		}		
	}
	
	public List<Service> pingAllServices() throws MalformedURLException, IOException
	{
		try {
			JSONObject response = new JSONObject(IOUtils.toString(new URL(
					"https://api.sapinet.fr/?token=" + accessKey + "&id=NULL&method=getAllMonitor"), Charset.forName("UTF-8")));
			List<Service> services = new ArrayList<Service>();
			for(int i = 1; i < response.length(); i++)
			{
				JSONObject service = response.getJSONObject(String.valueOf(i));
				services.add(new Service(service.getInt("id"), service.getString("name"), service.getString("testType"), 
						service.getInt("testPort"), service.getString("hostname"), service.getBoolean("status"), 
						service.getBoolean("underMaintenance"), service.getString("messageMaintenance")));
			}
			return services;
		} catch (JSONException e) {
			System.err.println("La clé est incorrecte.");
			return null;
		}
	}
	
	public String getAccessKey() {
		return accessKey;
	}
	
	public int getRate() throws MalformedURLException, IOException 
	{
		if(accessKey == null) {
			System.err.println("Votre clé est nulle.");
			return 0; 
		} else {
			try {
				JSONObject response = new JSONObject(IOUtils.toString(new URL(
						"https://api.sapinet.fr/?token=" + accessKey + "&id=NULL&method=getRate"), Charset.forName("UTF-8")));
				return response.getInt("rate");
			} catch (JSONException e) {
				System.err.println("La clé est incorrecte.");
				return 0;
			}
		}
	}
	
	public int getRateLimit() throws MalformedURLException, IOException 
	{
		if(accessKey == null) {
			System.err.println("Votre clé est nulle.");
			return 0; 
		} else {
			try {
				JSONObject response = new JSONObject(IOUtils.toString(new URL(
						"https://api.sapinet.fr/?token=" + accessKey + "&id=NULL&method=getRateLimit"), Charset.forName("UTF-8")));
				return response.getInt("rateLimit");
			} catch (JSONException e) {
				System.err.println("La clé est incorrecte.");
				return 0;
			}
		}
	}
}