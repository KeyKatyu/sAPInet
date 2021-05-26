package fr.keykatyu.sapinet.service;

public enum TestType 
{
	IP_PORT("IP+PORT"),
	IP("IP");
	
	private String type;
	
	TestType(String type)
	{
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}