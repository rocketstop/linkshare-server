package com.trickyspot.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.trickyspot.model.EntityFacade;
import com.trickyspot.model.Link;
import com.trickyspot.model.Links;

@Path("l")
public class LinkService {
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Links getAllLinks(){
		//Response res;
		List<Link> links = new ArrayList<>();
		
		links.addAll(EntityFacade.instance.getLinks());
		//res = Response.ok(links).build();
		
		return new Links(links); //TODO This is a hack
		
		// JAXB doesn't like Lists, to fix, create a type that contains the list.
		// In this case, Links.
		
	}

	@Path("{linkid}")
    @GET
	@Produces(MediaType.APPLICATION_JSON)
    public Response getLink(@PathParam("linkid") UUID linkid) {
		
    	Response res;
		Link link;
		
		link = EntityFacade.instance.getLink(linkid);
		res = Response.ok(link).build();
		
		return res;
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addLink(String url){
		Response res;
		
		Link link = new Link(UUID.randomUUID(),url);
		
		EntityFacade.instance.addLink(link);
		
		URI newURI=uriInfo.getAbsolutePathBuilder().build(link.getUUID());

		res = Response.created(newURI)
				.encoding(MediaType.APPLICATION_JSON)
				.build();
		
		return res;
	}

}
