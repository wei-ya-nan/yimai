package com.easybuy.test;

import com.easybuy.entity.Page;
import com.easybuy.entity.User;
import com.easybuy.service.UserService;
import com.easybuy.service.impl.UserServiceImpl;
import com.sun.media.sound.EmergencySoundbank;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/19
 */
public class UserServiceImplTest {
    private UserService userService = new UserServiceImpl();
    @Test
    public void registerUser() {
//        userService.exitsUserName()
    }

    @Test
    public void login() {
        User login = userService.login(new User("admin", "admin"));
        System.out.println(login);
    }

    @Test
    public void exitsUserName() {
    }

    @Test
    public void queryAll(){
        List<User> users = userService.queryUserAll();
        System.out.println(Arrays.asList(users));
    }

    @Test
    public void paget(){
        Page<User> userPage = userService.pageUser(0, 6);
        System.out.println(userPage);
    }
}