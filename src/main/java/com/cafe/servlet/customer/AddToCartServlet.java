package com.cafe.servlet.customer;

import java.io.IOException;

import com.cafe.DAO.CartDAO;
import com.cafe.DAO.CartItemDAO;
import com.cafe.DAO.ProductDAO;
import com.cafe.DAOImpl.CartDAOImpl;
import com.cafe.DAOImpl.CartItemDAOImpl;
import com.cafe.DAOImpl.ProductDAOImpl;
import com.cafe.Model.Cart;
import com.cafe.Model.CartItem;
import com.cafe.Model.Product;
import com.cafe.Model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/cart/add")
public class AddToCartServlet extends HttpServlet {

    private CartDAO cartDAO;
    private CartItemDAO cartItemDAO;
    private ProductDAO productDAO;

    @Override
    public void init() {

        cartDAO = new CartDAOImpl();
        cartItemDAO = new CartItemDAOImpl();
        productDAO = new ProductDAOImpl();

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
   

        if (session == null) {
            System.out.println("Session is NULL");
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {
            System.out.println("User is NULL");
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        System.out.println("Logged in user : " + user.getUserName());

        User user1 =
                (User)session.getAttribute("loggedInUser");

        int productId =
                Integer.parseInt(
                        request.getParameter("productId"));

        int quantity =
                Integer.parseInt(
                        request.getParameter("quantity"));

        Cart cart =
                cartDAO.getCartByUserId(
                        user1.getUserId());
        if(cart == null){

            Cart newCart = new Cart();

            newCart.setUserId(user1.getUserId());

            cartDAO.addCart(newCart);

            cart = cartDAO.getCartByUserId(user1.getUserId());

        }
        

        Product product =
                productDAO.getProduct(productId);

        double total =
                product.getPrice() * quantity;

        CartItem item =
                new CartItem();

        item.setCartId(cart.getCartId());
        item.setProductId(productId);
        item.setQuantity(quantity);
        item.setItemTotal(total);

        cartItemDAO.addCartItem(item);

        response.sendRedirect(
                request.getContextPath()+"/cart");
       
        
        
        

    }
    
    

}