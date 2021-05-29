package fr.keykatyu.sapinet.service;

public class Service
{
	private int serviceId;
	private String name;
	private String testType;
	private int testPort;
	private String hostname;
	private boolean isOnline;
	private boolean isUnderMaintenance;
	private String maintenanceMessage;
	
	public Service(int serviceId, String name, String testType, int testPort, String hostname, boolean isOnline, boolean isUnderMaintenance, String maintenanceMessage)
	{
		this.serviceId = serviceId;
		this.name = name;
		this.testType = testType;
		this.testPort = testPort;
		this.hostname = hostname;
		this.isOnline = isOnline;
		this.isUnderMaintenance = isUnderMaintenance;
		this.maintenanceMessage = maintenanceMessage;
	}
	
	public int getServiceId() {
		return serviceId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getTestType() 
	{
		return testType;
	}
	
	public int getTestPort() {
		return testPort;
	}
	
	public String getHostname() {
		return hostname;
	}
	
	public boolean isOnline() {
		return isOnline;
	}
	
	public boolean isUnderMaintenance() {
		return isUnderMaintenance;
	}
	
	public String getMaintenanceMessage() {
		return maintenanceMessage;
	}
}