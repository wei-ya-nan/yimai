package com.easybuy.web;

import com.easybuy.dao.GoodsDao;
import com.easybuy.dao.impl.GoodsDaoImpl;
import com.easybuy.entity.Cart;
import com.easybuy.entity.CartItems;
import com.easybuy.entity.Product;
import com.easybuy.service.GoodsService;
import com.easybuy.service.impl.GoodsServiceImpl;
import com.easybuy.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/24
 */
public class CartServlet extends BaseServlet {
    private GoodsDao goodsDao = new GoodsDaoImpl();
    private GoodsService goodsService = new GoodsServiceImpl();

    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        int id = WebUtils.parseInt(request.getParameter("productOneId"), 0);
        Product product = goodsService.queryById(id);
        CartItems cartItems = new CartItems(product.getId(), product.getName(), 1, product.getPrice(),
                product.getPrice(), product.getFileName());
        System.out.println(cartItems);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        cart.addCartItem(cartItems);
        System.out.println(cart);
        response.sendRedirect(request.getHeader("Referer"));

    }

    protected void updateAjaxCount(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        Integer number = WebUtils.parseInt(request.getParameter("number"), 1);
        Integer productOneId = WebUtils.parseInt(request.getParameter("productOneId"), 0);
        Product product = goodsService.queryById(productOneId);
        CartItems cartItems = new CartItems(product.getId(), product.getName(), 1, product.getPrice(),
                product.getPrice(), product.getFileName());
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.updateCount(productOneId, number);
        }
        Integer cartTotalCount = cart.getCartTotalCount();

        Map<String,Object> resultMap = new HashMap<>();
        Map<Integer, CartItems> itemsMap = cart.getItemsMap();
        resultMap.put("itemsMap", itemsMap);
        resultMap.put("cartTotalCount", cartTotalCount);
        System.out.println(resultMap);
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        response.getWriter().write(json);
    }

    protected void addAjaxItemToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        int id = WebUtils.parseInt(request.getParameter("productOneId"), 0);
        Product product = goodsDao.queryGoodsById(id);
        CartItems cartItems = new CartItems(product.getId(), product.getName(), 1, product.getPrice(),
                product.getPrice(), product.getFileName());
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        cart.addCartItem(cartItems);
        request.getSession().setAttribute("lastName", product.getName());
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("totalCount", cart.getCartTotalCount());
        map.put("lastName", cartItems.getName());
        Gson gson = new Gson();
        String json = gson.toJson(map);
        System.out.println(json);
        response.getWriter().write(json);

    }

    protected void deleteCartById(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        Integer id = WebUtils.parseInt(request.getParameter("productOneId"), 0);
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if(cart!=null){
            cart.deleteCart(id);
            System.out.println(id+"id");
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
}
