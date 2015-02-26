package com.trickyspot.model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;


public enum EntityFacade {
		instance;
		
		Hashtable<UUID, Link> links = new Hashtable<>();
	
		private EntityFacade(){
		}

		public List<? extends Link> getLinks() {

			return new ArrayList<Link>(links.values());
		}

		public Link getLink(UUID linkid) {
			
			return links.get(linkid);
		}

		public void addLink(Link link) {
			links.put(link.getUUID(), link);
			
		}

}
