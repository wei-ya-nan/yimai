package com.easybuy.web;

import com.easybuy.entity.Page;
import com.easybuy.entity.Product;
import com.easybuy.entity.ProductCategory;
import com.easybuy.entity.User;
import com.easybuy.service.GoodsService;
import com.easybuy.service.ProductCategoryService;
import com.easybuy.service.UserService;
import com.easybuy.service.impl.GoodsServiceImpl;
import com.easybuy.service.impl.ProductCategoryServiceImpl;
import com.easybuy.service.impl.UserServiceImpl;
import com.easybuy.utils.WebUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/25
 */
@SuppressWarnings("all")
public class ManageUserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    private ProductCategoryService categoryService = new ProductCategoryServiceImpl();
    private GoodsService goodsService = new GoodsServiceImpl();


    protected void manageLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

    }

    protected void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);
        userService.deleteUserById(id);
        response.sendRedirect(request.getHeader("Referer"));

    }

    protected void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        Integer id = WebUtils.parseInt(request.getParameter("userId"), 0);
        User user = userService.UserOne(id);
        request.setAttribute("userOne", user);
        request.getRequestDispatcher("/pages/manage/user-modify.jsp").forward(request, response);
    }

    protected void allUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
//        List<User> users = userService.queryUserAll();
//        request.setAttribute("users", users);
//        request.getRequestDispatcher("/pages/manage/user.jsp").forward(request, response);
    }

    protected void userPage(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用BookService.page(pageNo，pageSize)：Page对象
        Page<User> page = userService.pageUser(pageNo, pageSize);
        page.setUrl("manage/user?action=userPage");
        //3 保存Page对象到Request域中
        request.setAttribute("page", page);
        //4 请求转发到pages/manager/book_manager.jsp页面
        request.getRequestDispatcher("/pages/manage/user.jsp").forward(request, response);
    }

    protected void updateCommit(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException, ParseException {

        Map<Object, Object> itemMap = new HashMap<>();
        String fileName = null;
        //先判断是否是多段数据
        if (ServletFileUpload.isMultipartContent(request)) {
            //然后创建FileItemFactory类
            DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传的数据的工具类的ServletFileUpload
            ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
            try {
                //解析上传的数据，得到每个上传的表单项FileItem
                List<FileItem> list = fileUpload.parseRequest(request);
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {
                        System.out.println("表单项的name的属性值:" + fileItem.getFieldName());
                        System.out.println("表单项的value的值:" + fileItem.getString("UTF-8"));
                        itemMap.put(fileItem.getFieldName(), fileItem.getString("UTF-8"));


                    } else {
                        //上传的文件
                        System.out.println("表单项的name的属性值:" + fileItem.getFieldName());
                        System.out.println("上传的文件名：" + fileItem.getName());
                        fileName = fileItem.getName();
                        fileItem.write(new File("d:\\" + fileName));
                    }

                }

            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

            User user = new User(Integer.parseInt(itemMap.get("userId").toString()),
                    itemMap.get("password").toString(),
                    itemMap.get("userName").toString(),
                    itemMap.get("sex").toString(),
                    Date.valueOf(itemMap.get("birthDay").toString()),
                    null,
                    null,
                    itemMap.get("mobile").toString(),
                    itemMap.get("address").toString(),
                    null);
            userService.updateUser(user);


        }
       response.sendRedirect(request.getContextPath()+"/manage/user?action=userPage");
    }

    protected void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        User user = new User(null
                , request.getParameter("password"),
                request.getParameter("userName"),
                request.getParameter("sex"),
                Date.valueOf(request.getParameter("birthDay").toString()),
                null,
                null, request.getParameter("mobile"),
                request.getParameter("address"), 2);
        userService.registerUser(user);
        response.sendRedirect(request.getContextPath()+"/manage/user?action=userPage");
    }

    protected void productClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductCategory> all = categoryService.queryAllProductCategory();
        request.setAttribute("all", all);
        request.getRequestDispatcher("/pages/manage/productClass.jsp").forward(request, response);
    }

    protected void parentCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ProductCategory productCategory = categoryService.queryProductCategoryById(Integer.parseInt(id));
        List<ProductCategory> categories = categoryService.queryAllProductCategory();
        request.setAttribute("categorys", categories);
        request.setAttribute("allClass", productCategory);
        request.getRequestDispatcher("/pages/manage/productClass-modify.jsp").forward(request, response);
    }

    protected void updateClass(HttpServletRequest request, HttpServletResponse response) throws ServletException
            , IOException {
        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);
        String className = request.getParameter("className");
        ProductCategory productCategory = new ProductCategory(id, className, null);
        categoryService.updateProductCategory(productCategory);
        response.sendRedirect(request.getContextPath()+"/manage/user?action=productClass");
//        request.getRequestDispatcher("/pages/manage/manage-result.jsp").forward(request, response);
    }

    protected void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer integer = WebUtils.parseInt(request.getParameter("id"), 0);
        categoryService.deleteProductCategory(integer);
        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void addClass(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        List<ProductCategory> productCategories = categoryService.queryCategoryParentAll();
        List<ProductCategory> all = categoryService.queryAllProductCategory();
        ProductCategory productCategory = all.get(all.size() - 1);
        Integer epcID = productCategory.getEpcID();
        System.out.println(epcID + 1);
        Integer parentId = productCategory.getParentId();
        request.setAttribute("epcId", epcID + 1);
        request.setAttribute("parentId", parentId);
        request.setAttribute("categorys", productCategories);

        request.getRequestDispatcher("/pages/manage/productClass-add.jsp").forward(request, response);
    }

    protected void addCommit(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String option = request.getParameter("parentId");
        Integer pcId = WebUtils.parseInt(request.getParameter("pcId"), 0);
        Integer parentId = WebUtils.parseInt(option, 0);
        String className = request.getParameter("className");

        List<ProductCategory> all = categoryService.queryAllProductCategory();
        ProductCategory category = all.get(all.size() - 1);
        Integer epcID = category.getEpcID() + 1;
        ProductCategory productCategory = null;
        if (parentId == 0) {
            System.out.println("bbbbbb");
            productCategory = new ProductCategory(epcID, className, epcID);
        } else {

            productCategory = new ProductCategory(epcID, className, parentId);
        }
        categoryService.addProductCategory(productCategory);
        response.sendRedirect(request.getContextPath()+"/manage/user?action=productClass");
//        request.getRequestDispatcher("/pages/manage/manage-result.jsp").forward(request, response);
    }

    protected void product(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        Integer childId = WebUtils.parseInt(request.getParameter("childId"), null);
        Integer integerEpcID = WebUtils.parseInt(request.getParameter("epcID"), null);

        System.out.println(pageNo + "pageNo");
        List<ProductCategory> productCategories = categoryService.queryListCategoryByParentId();
        request.setAttribute("parent", productCategories);

        //查询所有的分类信息
        List<ProductCategory> all = categoryService.queryAllProductCategory();
        request.setAttribute("all", all);

        Page<Product> page = page = goodsService.page(childId, integerEpcID, pageNo, pageSize);
        page.setUrl("manage/user?action=product&epcID=" + integerEpcID);
        request.setAttribute("page", page);
        request.setAttribute("chileId", childId);
        request.setAttribute("epcId", integerEpcID);
        request.getRequestDispatcher("/pages/manage/product.jsp").forward(request, response);
    }

    protected void productView(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);
        Product product = goodsService.queryById(id);
        request.setAttribute("product", product);
        List<ProductCategory> productCategories = categoryService.queryAllProductCategory();
        request.setAttribute("cate", productCategories);
        request.getRequestDispatcher("/pages/manage/product-modify.jsp").forward(request, response);
    }

    protected void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        Map<Object, Object> itemMap = new HashMap<>();
        String fileName = null;
        //先判断是否是多段数据
        if (ServletFileUpload.isMultipartContent(request)) {
            //然后创建FileItemFactory类
            DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传的数据的工具类的ServletFileUpload
            ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
            try {
                //解析上传的数据，得到每个上传的表单项FileItem
                List<FileItem> list = fileUpload.parseRequest(request);
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {
                        System.out.println("表单项的name的属性值:" + fileItem.getFieldName());
                        System.out.println("表单项的value的值:" + fileItem.getString("UTF-8"));
                        itemMap.put(fileItem.getFieldName(), fileItem.getString("UTF-8"));
                    } else {
                        //上传的文件
                        System.out.println("表单项的name的属性值:" + fileItem.getFieldName());
                        System.out.println("上传的文件名：" + fileItem.getName());
                        fileName = fileItem.getName();
                        itemMap.put(fileItem.getFieldName(), fileName);
                        fileItem.write(new File("d:\\" + fileName));
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Product pr = new Product(Integer.parseInt(itemMap.get("id").toString()),
                itemMap.get("productName").toString(),
                itemMap.get("description").toString(),
                new BigDecimal(itemMap.get("productPrice").toString()),
                Integer.parseInt(itemMap.get("stock").toString()),
                Integer.parseInt(itemMap.get("parentId").toString()),
                Integer.parseInt(itemMap.get("childId").toString()),
                itemMap.get("photo").toString());
        System.out.println(pr);
        goodsService.updateGoods(pr);
        response.sendRedirect(request.getContextPath()+"/manage/user?action=product");
//        request.getRequestDispatcher("/pages/manage/manage-result.jsp").forward(request, response);
    }

    protected void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);
        goodsService.deleteGoodsById(id);
        response.sendRedirect(request.getHeader("Referer"));

    }

    protected void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        List<ProductCategory> productCategories = categoryService.queryAllProductCategory();
        request.setAttribute("categorys", productCategories);
        request.getRequestDispatcher("/pages/manage/product-add.jsp").forward(request, response);
    }

    protected void addProductCommit(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        List<Product> listP = goodsService.queryAllGoods();
        Product product = listP.get(listP.size() - 1);
        Integer id = product.getId() + 1;
        Map<Object, Object> itemMap = new HashMap<>();
        String fileName = null;
        //先判断是否是多段数据
        if (ServletFileUpload.isMultipartContent(request)) {
            //然后创建FileItemFactory类
            DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传的数据的工具类的ServletFileUpload
            ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
            try {
                //解析上传的数据，得到每个上传的表单项FileItem
                List<FileItem> list = fileUpload.parseRequest(request);
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {
                        System.out.println("表单项的name的属性值:" + fileItem.getFieldName());
                        System.out.println("表单项的value的值:" + fileItem.getString("UTF-8"));
                        itemMap.put(fileItem.getFieldName(), fileItem.getString("UTF-8"));
                    } else {
                        //上传的文件
                        System.out.println("表单项的name的属性值:" + fileItem.getFieldName());
                        System.out.println("上传的文件名：" + fileItem.getName());
                        fileName = fileItem.getName();
                        itemMap.put(fileItem.getFieldName(), fileName);
                        fileItem.write(new File("d:\\" + fileName));
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Product pr = new Product(id,
                itemMap.get("productName").toString(),
                itemMap.get("description").toString(),
                new BigDecimal(itemMap.get("productPrice").toString()),
                Integer.parseInt(itemMap.get("stock").toString()),
                Integer.parseInt(itemMap.get("parentId").toString()),
                null,
                itemMap.get("photo").toString());
        System.out.println(pr);
        goodsService.addGoods(pr);
        response.sendRedirect(request.getContextPath()+"/manage/user?action=product");
//        request.getRequestDispatcher("/pages/manage/manage-result.jsp").forward(request, response);


    }
}
