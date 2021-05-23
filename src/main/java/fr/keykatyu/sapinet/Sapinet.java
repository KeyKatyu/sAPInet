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
					response.getInt("testPort"), response.getString("hostname"), response.getBoolean("status"));
		} catch(JSONException e) {
			System.err.println("Le service n°" + serviceId + " n'existe pas chez Sapinet.");
			return null;
		}		
	}
	
	public List<Service> pingAllServices() throws JSONException, MalformedURLException, IOException
	{
		JSONObject response = new JSONObject(IOUtils.toString(new URL(
				"https://api.sapinet.fr/?token=" + accessKey + "&id=NULL&method=getAllMonitor"), Charset.forName("UTF-8")));
		List<Service> services = new ArrayList<Service>();
		for(int i = 1; i < response.length(); i++)
		{
			JSONObject service = response.getJSONObject(String.valueOf(i));
			services.add(new Service(service.getInt("id"), service.getString("name"), service.getString("testType"), service.getInt("testPort"), 
					service.getString("hostname"), service.getBoolean("status")));
			//
		}
		return services;
	}
	
	public String getAccessKey() {
		return accessKey;
	}
}