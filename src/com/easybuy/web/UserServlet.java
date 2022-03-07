package com.easybuy.web;

import com.easybuy.entity.User;
import com.easybuy.service.UserService;
import com.easybuy.service.impl.UserServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/19
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    /**
     * 处理注册的功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        String rePassWord = request.getParameter("rePassWord");
        String veryCode = request.getParameter("veryCode");
        //获取Session中的验证码
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        System.out.println(token.equalsIgnoreCase(veryCode));
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        if (token != null && token.equalsIgnoreCase(veryCode)) {
            if (userService.exitsUserName(userName)) {
                System.out.println(userName + ":已存在");
                request.setAttribute("msg", "用户名已存在");
                request.setAttribute("username", userName);
                request.getRequestDispatcher("pages/client/register.jsp").forward(request, response);
            } else {
                userService.registerUser(new User(null,passWord,userName,"男",new Date(),new Date().getTime(),
                        null,null,null,1));
                request.getRequestDispatcher("index.jsp").forward(request, response);


            }
        } else {
            request.setAttribute("msg", "验证码错误");
            request.setAttribute("username", userName);
            request.getRequestDispatcher("pages/client/register.jsp").forward(request, response);

        }


    }


    /**
     * 登录功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        String userName = request.getParameter("userName");
        String password = request.getParameter("passWord");
        String veryCode = request.getParameter("veryCode");
        //获取Session中的验证码
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        User login = userService.login(new User(userName, password));
        if(veryCode.equalsIgnoreCase(token)){
            if (login == null) {
                request.setAttribute("msg", "用户或密码错误！");
                request.setAttribute("username", userName);
                request.getRequestDispatcher("pages/client/login.jsp").forward(request, response);
            } else {

                if("admin".equals(userName) && "admin".equals(password)){
                    request.getRequestDispatcher("pages/manage/index.jsp").forward(request, response);
                }
                request.getSession().setAttribute("user", login);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }else {
            request.setAttribute("msg", "验证码错误");
            request.setAttribute("username", userName);
            request.getRequestDispatcher("pages/client/login.jsp").forward(request, response);
        }

    }

    protected void ajaxExitsUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String userName = request.getParameter("userName");
        System.out.println(userName);
        //检验用户名可以用
        boolean exitsUserName = userService.exitsUserName(userName);
        Map<String ,Object> resultMap = new HashMap<>();
        //放到map集合中生成json对象
        resultMap.put("exitsUserName",exitsUserName);
        Gson goSon  =new Gson();
        String toStringJson = goSon.toJson(exitsUserName);
        response.getWriter().write(toStringJson);
    }

    protected void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath());
    }
}
