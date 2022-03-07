package com.easybuy.dao;

import com.easybuy.entity.User;

import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/19
 */
public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 返回null则没有这个用户
     */
    User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询 用信息
     * @param username 用户名
     * @param password 密码
     * @return
     */
    User queryUserByUserNameAndPassword(String username, String password);

    /**
     * 保存用户信息
     * @param user 用户信息
     * @return
     */
    int saveUser(User user);

    public List<User> QueryAllUser();

    public List<User> queryUserPage(Integer begin,Integer pageSize);


    public Integer getUserPageTotalCount();

    public User queryUserById(Integer id);

    public int updateUserById(User user);

    public int deleteUser(Integer id);

}
