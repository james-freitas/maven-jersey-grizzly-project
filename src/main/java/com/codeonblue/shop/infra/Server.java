package com.codeonblue.shop.infra;

import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Server {

	public static HttpServer startServer() {
		ResourceConfig config = new ResourceConfig().packages("com.codeonblue.shop");
		URI uri = URI.create("http://localhost:8080/");
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
		return server;
	}
	
}
