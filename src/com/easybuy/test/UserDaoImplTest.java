package com.easybuy.test;

import com.easybuy.dao.UserDao;
import com.easybuy.dao.impl.UserDaoImpl;
import com.easybuy.entity.User;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/19
 */
public class UserDaoImplTest {
    private UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        User admin = userDao.queryUserByUsername("admin");
        System.out.println(new Date().getTime());
        System.out.println(admin);
    }

    @Test
    public void queryUserByUserNameAndPassword() {
        User user = userDao.queryUserByUserNameAndPassword("管理员", "admin");
        System.out.println(user);
    }

    @Test
    public void saveUser() {
        User user = new User(13, "用户", "纣王", "男",
                new Date(), new Date().getTime(), "zhouwanghuataijia@qq.com", "1380809090", "地球村", 2);
        int i = userDao.saveUser(user);
        System.out.println(i);
    }
    @Test
    public void query(){
        User user = userDao.queryUserById(3);
        System.out.println(user);
    }
}