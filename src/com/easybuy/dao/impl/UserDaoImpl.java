package com.easybuy.dao.impl;

import com.easybuy.dao.UserDao;
import com.easybuy.entity.User;

import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/19
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select EU_USER_ID as userId, EU_USER_NAME as userName, EU_PASSWORD `password`, EU_SEX sex," +
                " EU_BIRTHDAY birthDay, EU_IDENTITY_CODE identityCode, EU_EMAIL email, EU_MOBILE mobile, " +
                "EU_ADDRESS adress, EU_STATUS `status` from  easybuy_user where EU_USER_NAME=?";
        return queryOne(sql, User.class, username);
    }

    @Override
    public User queryUserByUserNameAndPassword(String username, String password) {
        String sql = "select EU_USER_ID as userId, EU_USER_NAME as userName, EU_PASSWORD `password`, EU_SEX sex," +
                " EU_BIRTHDAY birthDay, EU_IDENTITY_CODE identityCode, EU_EMAIL email, EU_MOBILE mobile, " +
                "EU_ADDRESS address, EU_STATUS `status` from easybuy_user where EU_USER_NAME=? and EU_PASSWORD=?";
        return queryOne(sql, User.class, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into EASYBUY_USER (EU_USER_ID , EU_USER_NAME , EU_PASSWORD " +
                ", EU_SEX , EU_BIRTHDAY , EU_IDENTITY_CODE , EU_EMAIL , " +
                "EU_MOBILE , EU_ADDRESS , EU_STATUS ) values (?, ?, ?, ?, ?, ?, ?, ?, " +
                "?,?)";
        return update(sql, user.getUserId(), user.getUserName(), user.getPassword(), user.getSex(),
                user.getBirthDay(), user.getIdentityCode(), user.getEmail(), user.getMobile(), user.getAddress(),
                user.getStatus());
    }

    @Override
    public List<User> QueryAllUser() {
        String sql = "select EU_USER_ID as userId, EU_USER_NAME as userName, EU_PASSWORD `password`, EU_SEX sex," +
                " EU_BIRTHDAY birthDay, EU_IDENTITY_CODE identityCode, EU_EMAIL email, " +
                "EU_MOBILE mobile,EU_ADDRESS adress, EU_STATUS `status` from EASYBUY_USER";
        return queryForList(User.class, sql);
    }

    @Override
    public List<User> queryUserPage(Integer begin, Integer pageSize) {
        String sql = "select EU_USER_ID as userId, EU_USER_NAME as userName, EU_PASSWORD `password`, EU_SEX sex," +
                " EU_BIRTHDAY birthDay, EU_IDENTITY_CODE identityCode, EU_EMAIL email, EU_MOBILE mobile," +
                "EU_ADDRESS address, EU_STATUS `status` from EASYBUY_USER limit ?,?";
        return queryForList(User.class, sql, begin, pageSize);
    }

    @Override
    public Integer getUserPageTotalCount() {
        String sql = "select count(*) from EASYBUY_USER";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public User queryUserById(Integer id) {
        String sql = "select EU_USER_ID as userId, EU_USER_NAME as userName, EU_PASSWORD `password`, EU_SEX sex," +
                " EU_BIRTHDAY birthDay, EU_IDENTITY_CODE identityCode, EU_EMAIL email, " +
                "EU_MOBILE mobile, EU_ADDRESS address, EU_STATUS `status` from EASYBUY_USER where EU_USER_ID = ?";
        return queryOne(sql, User.class, id);
    }

    @Override
    public int updateUserById(User user) {
        String sql = "update easybuy_user set EU_USER_NAME=?,EU_PASSWORD=?,EU_SEX=?," +
                "EU_BIRTHDAY=?,EU_MOBILE=?,EU_ADDRESS=?" +
                "where EU_USER_ID = ?";
        return update(sql, user.getUserName(),user.getPassword(),user.getSex(),user.getBirthDay(),
                user.getMobile(),user.getAddress(),user.getUserId());
    }

    @Override
    public int deleteUser(Integer id) {
        String sql = "delete from easybuy_user where EU_USER_ID = ?";
        return update(sql , id);
    }


}
