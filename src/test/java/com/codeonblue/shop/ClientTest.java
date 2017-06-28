package com.codeonblue.shop;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.codeonblue.shop.infra.Server;
import com.codeonblue.shop.model.Cart;
import com.thoughtworks.xstream.XStream;

import junit.framework.Assert;

public class ClientTest {

	private HttpServer server;
	private WebTarget target;
	
	@Before
	public void startServer(){
		this.server = Server.startServer();	
		Client client = ClientBuilder.newClient();
		this.target = client.target("http://localhost:8080");
	}
	
	@After
	public void killServer() {
		this.server.stop();
	}

	@Test
	public void testIfLocalServerConnectionWorksInCartPath(){
		String content = target.path("/carts").request().get(String.class);
		Cart cart = (Cart) new XStream().fromXML(content);
		Assert.assertEquals("Viveiros de Castro", cart.getStreet());		
	}


}
