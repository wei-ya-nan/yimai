package com.easybuy.service.impl;

import com.easybuy.dao.UserDao;
import com.easybuy.dao.impl.UserDaoImpl;
import com.easybuy.entity.Page;
import com.easybuy.entity.User;
import com.easybuy.service.UserService;

import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/19
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUserNameAndPassword(user.getUserName(), user.getPassword());
    }

    @Override
    public boolean exitsUserName(String username) {
        if (userDao.queryUserByUsername(username) == null) {
            return false;
        }
        return true;
    }

    @Override
    public List<User> queryUserAll() {
        return userDao.QueryAllUser();
    }
    @Override
    public  Page<User> pageUser(Integer pageNo, Integer pageSize) {
        Page<User> page = new Page<>();
        //设置每页的数量
        page.setPageSize(pageSize);

        Integer totalCount = userDao.getUserPageTotalCount();
        page.setPageTotalCount(totalCount);
        //求总页码
        Integer pageTotal = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        Integer begin = null;
        if ((page.getPageNo() - 1) * pageSize > 0) {
            begin = (page.getPageNo() - 1) * pageSize;
        } else {
            begin = 0;
        }
        List<User> users = userDao.queryUserPage(begin, pageSize);
        page.setItems(users);

        return page;

    }

    @Override
    public User UserOne(Integer id) {
        return userDao.queryUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUserById(user);
    }

    public void deleteUserById(Integer id){
        userDao.deleteUser(id);
    }

//    public static void main(String[] args) {
//        Page<User> userPage = pageUser(1, 2, User.class);
//    }
//
}
