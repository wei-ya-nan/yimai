package com.easybuy.filter;

import com.easybuy.entity.Cart;
import com.easybuy.entity.CartItems;
import com.easybuy.entity.Product;
import com.easybuy.service.GoodsService;
import com.easybuy.service.impl.GoodsServiceImpl;
import com.easybuy.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/24
 */
public class CartFilter implements Filter {
    private GoodsService goodsService = new GoodsServiceImpl();

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException,
            IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        Object user = httpServletRequest.getSession().getAttribute("user");
        Integer id = WebUtils.parseInt(httpServletRequest.getParameter("productOneId"), 0);


        Cart cart = (Cart) httpServletRequest.getSession().getAttribute("cart");
        if (user == null && cart == null) {
            //根据id查询单个的商品项
            Product product = goodsService.queryById(id);
            //存到购物车内
            CartItems cartItems = new CartItems(product.getId(), product.getName(), 1, product.getPrice(),
                    product.getPrice(), product.getFileName());
            cart = new Cart();
            httpServletRequest.getSession().setAttribute("cart", cart);
            cart.addCartItem(cartItems);
            httpServletRequest.getRequestDispatcher("/pages/client/login.jsp").forward(req, resp);
        } else {
            chain.doFilter(req, resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
