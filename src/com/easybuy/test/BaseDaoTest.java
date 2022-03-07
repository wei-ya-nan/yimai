package com.easybuy.test;

import com.easybuy.dao.impl.BaseDao;
import org.junit.Test;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/19
 */
public class BaseDaoTest {
    BaseDao baseDao = new BaseDao();

    @Test
    public void update() {
        String sql = "insert into easybuy_user(EU_USER_ID, EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY, " +
                "EU_IDENTITY_CODE, EU_EMAIL, EU_MOBILE, EU_ADDRESS, EU_STATUS) values ('wwqww', '大家米', 'www', " +
                "'T'," +
                " null, null, null, null, null, 1)";
        baseDao.update(sql);
    }

    @Test
    public void queryOne() {
        String sql = "select * from easybuy_user where EU_USER_ID='admin'";
        Object o = baseDao.queryOne(sql, Object.class);
        System.out.println(o);


    }

    @Test
    public void queryForList() {
    }

    @Test
    public void queryForSingleValue() {
    }
}