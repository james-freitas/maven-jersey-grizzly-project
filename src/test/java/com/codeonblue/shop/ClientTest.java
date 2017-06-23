package com.codeonblue.shop;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Test;

import com.codeonblue.shop.model.Cart;
import com.thoughtworks.xstream.XStream;

import junit.framework.Assert;

public class ClientTest {

	@Test
	public void testIfExternalConnectionWorks(){		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://www.mocky.io");
		String content = target.path("v2/594d7cef1100003401d6d349").request().get(String.class);
		Assert.assertTrue(content.contains("<street>Viveiros de Castro"));
	}
	
	@Test
	public void testIfLocalServerConnectionWorksInCartPath(){
		ResourceConfig config = new ResourceConfig().packages("com.codeonblue.shop");
		URI uri = URI.create("http://localhost:8080/");
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String content = target.path("/carts").request().get(String.class);
		
		Cart cart = (Cart) new XStream().fromXML(content);
		Assert.assertEquals("Viveiros de Castro", cart.getStreet());
		
		server.stop();
	}
}
