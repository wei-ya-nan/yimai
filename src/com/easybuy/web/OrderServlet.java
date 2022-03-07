package com.easybuy.web;

import com.easybuy.dao.OrderDao;
import com.easybuy.dao.impl.OrderDaoImpl;
import com.easybuy.entity.*;
import com.easybuy.service.CommentService;
import com.easybuy.service.NewService;
import com.easybuy.service.OrderService;
import com.easybuy.service.impl.CommentServiceImpl;
import com.easybuy.service.impl.NewsServiceImpl;
import com.easybuy.service.impl.OrderServiceImpl;
import com.easybuy.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/1
 */
@SuppressWarnings("all")
public class OrderServlet extends BaseServlet {
    private CommentService commentService = new CommentServiceImpl();
    private NewService newsService = new NewsServiceImpl();
    private OrderService orderService = new OrderServiceImpl();

    protected void comment(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        List<Comment> comments = commentService.queryAll();
        request.setAttribute("comments", comments);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        Page<Comment> page = commentService.page(pageNo, pageSize);
        page.setUrl("manage/order?action=comment");
        request.setAttribute("page", page);

        request.getRequestDispatcher("/pages/manage/guestbook.jsp").forward(request, response);
    }

    protected void updateComment(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);
        Comment comment = commentService.queryOne(id);
        request.setAttribute("comment", comment);
        request.getRequestDispatcher("/pages/manage/guestbook-modify.jsp").forward(request, response);
    }

    protected void replay(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        Integer id = WebUtils.parseInt(request.getParameter("orderId"), 0);
        String name = request.getParameter("name");
        String replyContent = request.getParameter("replyContent");
        java.util.Date date = new java.util.Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate = simpleDateFormat.format(date);
        Comment comment = new Comment(id, null, null, replyContent, java.sql.Date.valueOf(stringDate), name);
        System.out.println(comment);
        commentService.updateComment(comment);
        response.sendRedirect(request.getContextPath() + "/manage/order?action=comment");
    }

    protected void deleteComment(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);
        commentService.deleteCommById(id);
        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void news(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
//        List<News> newsList = newsService.queryAllNew();
//        request.setAttribute("new",newsList);

        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        Page<News> page = newsService.page(pageNo, pageSize);
        System.out.println(Arrays.asList(page));
        page.setUrl("manage/order?action=news");
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/manage/news.jsp").forward(request, response);
    }

    protected void updateNews(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String s = request.getParameter("id");
        Integer id = WebUtils.parseInt(s, 0);
        News news = newsService.queryOneNews(id);
        request.setAttribute("one", news);
        request.getRequestDispatcher("/pages/manage/news-modify.jsp").forward(request, response);
    }

    protected void commitNews(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);
        Date date = new Date();
        SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = ss.format(date);

        News news = new News(id, request.getParameter("title"), request.getParameter("content"),
                java.sql.Date.valueOf(dateString));
        newsService.updateNews(news);
        response.sendRedirect(request.getContextPath() + "/manage/order?action=news");
    }

    protected void deleteNews(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);
        newsService.deleteNews(id);
        response.sendRedirect(request.getContextPath() + "/manage/order?action=news");
    }

    protected void addCommit(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        List<News> newsList = newsService.queryAllNew();
        News news1 = newsList.get(newsList.size() - 1);
        Integer id = news1.getId() + 1;
        Date date = new Date();
        SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = ss.format(date);
        News news = new News(id, request.getParameter("title"), request.getParameter("content"),
                java.sql.Date.valueOf(dateString));
        newsService.addNews(news);
        response.sendRedirect(request.getContextPath() + "/manage/order?action=news");
    }

    protected void order(HttpServletRequest req, HttpServletResponse response) throws ServletException,
            IOException {

        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用BookService.page(pageNo，pageSize)：Page对象
        Page<Order> page = orderService.page(pageNo, pageSize);
        page.setUrl("manage/order?action=order");
        //3 保存Page对象到Request域中
        req.setAttribute("page", page);
        //4 请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manage/order.jsp").forward(req, response);
    }

    protected void orderModify(HttpServletRequest request, HttpServletResponse response) throws ServletException
            , IOException {
        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);
        Order order = orderService.queryOneOrder(id);
        request.setAttribute("one", order);
        request.getRequestDispatcher("/pages/manage/order-modify.jsp").forward(request, response);

    }

    protected void orderCommit(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        Integer id = WebUtils.parseInt(request.getParameter("orderId"), 0);
        Order order = new Order(id, null, request.getParameter("userName"), request.getParameter("address"), null,
                null, 1, 11);
        orderService.updateOrder(order);
        response.sendRedirect(request.getContextPath() + "/manage/order?action=order");
    }

    protected void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException
            , IOException {
        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);
        orderService.deleteOrder(id);
        response.sendRedirect(request.getHeader("Referer"));

    }

    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        Integer id = WebUtils.parseInt(request.getParameter("orderId"), 0);

        OrderDao orderDao = new OrderDaoImpl();
        Order order = orderDao.queryOneByIdAndUserName(id, request.getParameter("userName"));
        request.setAttribute("queryOne", order);
        request.getRequestDispatcher("/pages/manage/order.jsp").forward(request, response);

    }

    protected void shopping(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        User user = (User) request.getSession().getAttribute("user");
        String userName = user.getUserName();
        List<Order> orders = orderService.queryAllOrder();
        Order od = orders.get(orders.size() - 1);
        int id = od.getId() + 1;

        Order order = new Order(id, user.getUserId(), user.getUserName(), user.getAddress(), WebUtils.getDate(),
                cart.getCartTotalPrice(), 2, 11);
        orderService.addOrder(order);

        cart.clearCart();
        request.getRequestDispatcher("/pages/client/shopping-result.jsp").forward(request, response);
    }

    protected void guestBook(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        List<Comment> comments = commentService.queryAll();
        request.setAttribute("comments", comments);

        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        Page<Comment> page = commentService.page(pageNo, pageSize);
        page.setUrl("manage/order?action=guestBook");
        request.setAttribute("page", page);
        System.out.println(page.getItems().toString());
        request.getRequestDispatcher("/pages/client/guestbook.jsp").forward(request, response);
    }

    protected void commitGustBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String guestName = request.getParameter("guestName");
        String guestContent = request.getParameter("guestContent");
        List<Comment> comments = commentService.queryAll();
        Comment cc = comments.get(comments.size() - 1);
        Integer ecId = cc.getEcId() + 1;
        Comment comment = new Comment(ecId, guestContent, WebUtils.getDate(), null, null, guestName);
        commentService.addComment(comment);
        response.sendRedirect(request.getContextPath()+"/client/goodsServlet?action=page");
    }
}
