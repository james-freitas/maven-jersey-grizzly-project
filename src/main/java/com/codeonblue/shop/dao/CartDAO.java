package com.codeonblue.shop.dao;

import com.codeonblue.shop.model.Cart;

public class CartDAO {

    public Cart getCartById() {
        return new Cart(1l, "Cart 1", 10);
    }
}
