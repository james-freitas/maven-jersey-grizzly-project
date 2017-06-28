package com.codeonblue.shop.resource;

import com.codeonblue.shop.dao.CartDAO;
import com.codeonblue.shop.model.Cart;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("carts")
public class CartResource {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public String getCartById(@PathParam("id") long id){
        Cart cart = new CartDAO().getCartById();
        return "";
    }

}
