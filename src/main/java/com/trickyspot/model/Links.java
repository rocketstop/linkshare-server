package com.trickyspot.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Links")
public class Links {
	
	private List<Link> links;
	
	public Links() {
	}
	
	public Links(List<Link> links){
		this.links= links;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

}
