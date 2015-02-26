package com.trickyspot.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Link {
	
	@Id
	@XmlElement(required=true)
	private UUID linkId;
	@XmlElement(required=true)
	private String url;

	public Link() {}
	
	public Link(UUID linkId,
			String url){
		this.linkId = linkId;
		this.url = url;
	}
	
	public Link(String url){
		this.linkId= UUID.randomUUID();
		this.url = url;
	}

	public UUID getUUID() {
		return linkId;
	}
	
	public String getURL(){
		return url;
	}
	


}
