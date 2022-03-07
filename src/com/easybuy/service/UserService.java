package com.easybuy.service;

import com.easybuy.entity.Page;
import com.easybuy.entity.User;

import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/19
 */
public interface UserService {
    /**
     * 注册用户
     *
     * @param user
     */
    public void registerUser(User user);

    /**
     * 登录
     *
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 检查用户名是否可以用
     *
     * @param username
     * @return
     */
    public boolean exitsUserName(String username);

    public List<User> queryUserAll();

    public Page<User> pageUser(Integer pageNo, Integer pageSize);

    public User UserOne(Integer id);

    public void updateUser(User user);

    public void deleteUserById(Integer id);
}
