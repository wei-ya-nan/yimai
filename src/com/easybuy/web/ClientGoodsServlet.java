package com.easybuy.web;

import com.easybuy.dao.GoodsDao;
import com.easybuy.dao.impl.GoodsDaoImpl;
import com.easybuy.entity.*;
import com.easybuy.service.GoodsService;
import com.easybuy.service.ProductCategoryService;
import com.easybuy.service.impl.GoodsServiceImpl;
import com.easybuy.service.impl.ProductCategoryServiceImpl;
import com.easybuy.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.annotation.Repeatable;
import java.util.HashMap;
import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/21
 */
public class ClientGoodsServlet extends BaseServlet {
    private GoodsService goodsService = new GoodsServiceImpl();
    private ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
    private GoodsDao goodsDao = new GoodsDaoImpl();

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        Integer childId = WebUtils.parseInt(request.getParameter("childId"), null);
        Integer integerEpcID = WebUtils.parseInt(request.getParameter("epcID"), null);


        System.out.println(pageNo);
        List<ProductCategory> productCategories = productCategoryService.queryListCategoryByParentId();
        request.setAttribute("parent", productCategories);

        //查询所有的分类信息
        List<ProductCategory> all = productCategoryService.queryAllProductCategory();
        request.setAttribute("all", all);

        Page<Product> page = page = goodsService.page(childId, integerEpcID, pageNo, pageSize);
        page.setUrl("client/goodsServlet?action=page&epcID=" + integerEpcID);
        request.setAttribute("page", page);
        request.setAttribute("chileId", childId);
        request.setAttribute("epcId", integerEpcID);

        Cookie[] cookies = request.getCookies();

        if( cookies !=null&&cookies.length >3){
            Cookie c = null;
            for (Cookie cookie : cookies) {
                    if("productName".equals(cookie.getName()) && "productImg".equals(cookie.getName())){
                        c = cookie;
                        c.setMaxAge(0);
                        c.setPath(request.getContextPath());
                        response.addCookie(c);
                    }
            }
        }

        request.getRequestDispatcher("/pages/client/product-list.jsp").forward(request, response);
    }

    protected void productView(HttpServletRequest request, HttpServletResponse response) throws ServletException
            , IOException {
        Integer prodId = Integer.parseInt(request.getParameter("prodId"));
        Product product = goodsService.queryById(prodId);
        request.setAttribute("productOne", product);
//        System.out.println(product);
        utils(request, response);
        Cookie cookie = new Cookie("productName", product.getName().toString());
        Cookie cookie1 = new Cookie("productImg",(product.getFileName().toString()).trim());
        Cookie cookieId = new Cookie("id", prodId.toString());
        cookie.setMaxAge(60*60);
        cookie.setPath(request.getContextPath());
        cookie1.setPath(request.getContextPath());
        cookieId.setPath(request.getContextPath());

        cookie1.setMaxAge(60*60);

        response.addCookie(cookie);
//        response.addCookie(cookie1);
        response.addCookie(cookieId);

        request.getRequestDispatcher("/pages/client/product-view.jsp").forward(request, response);

    }

    protected void indexPage(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        utils(request, response);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);

    }


    private void utils(HttpServletRequest request, HttpServletResponse response) {
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        Integer childId = WebUtils.parseInt(request.getParameter("childId"), null);
        Integer integerEpcID = WebUtils.parseInt(request.getParameter("epcID"), null);


        System.out.println(pageNo);
        List<ProductCategory> productCategories = productCategoryService.queryListCategoryByParentId();
        request.setAttribute("parent", productCategories);

        //查询所有的分类信息
        List<ProductCategory> all = productCategoryService.queryAllProductCategory();
        request.setAttribute("all", all);

        Page<Product> page = page = goodsService.page(childId, integerEpcID, pageNo, pageSize);
        page.setUrl("client/goodsServlet?action=page&epcID=" + integerEpcID);
        request.setAttribute("page", page);
        request.setAttribute("chileId", childId);
        request.setAttribute("epcId", integerEpcID);
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
}
