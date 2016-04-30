package com.adimeo.feder.cas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.jasig.cas.services.DefaultRegisteredServiceAccessStrategy;

public class FederRegisteredServiceAccessStrategy extends DefaultRegisteredServiceAccessStrategy {

	private String federUrl;
	private String identifier;
	
	@Override
	public boolean doPrincipalAttributesAllowServiceAccess(Map<String, Object> attr) {
		boolean access = false;
		if(attr.containsKey("uid")){
			try{
				access = Boolean.parseBoolean(this.getResponseFromUrl(this.getFederUrl()+  "/" + this.getIdentifier() + "/" + attr.get("uid")));
			}catch(Exception ex){}
		}
		return this.isEnabled() && this.isSsoEnabled() && access;
	}
	
	private String getResponseFromUrl(String url){
		try{
			URL u = new URL(url);
			HttpURLConnection connection = (HttpURLConnection)u.openConnection();
			TrustModifier.relaxHostChecking(connection);
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			String inputLine;
			while((inputLine = reader.readLine()) != null){
				response.append(inputLine);
			}
			reader.close();
			return response.toString();
		}
		catch(Exception e){
			return null;
		}
	}

	public String getFederUrl() {
		return federUrl;
	}

	/**
	 * 
	 * @param federUrl
	 */
	public void setFederUrl(String federUrl) {
		this.federUrl = federUrl;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

}
