package com.easybuy.service.impl;

import com.easybuy.dao.GoodsDao;
import com.easybuy.dao.impl.GoodsDaoImpl;
import com.easybuy.entity.Page;
import com.easybuy.entity.Product;
import com.easybuy.service.GoodsService;

import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/21
 */
public class GoodsServiceImpl implements GoodsService {
    private GoodsDao goodsDao = new GoodsDaoImpl();

    @Override
    public void addGoods(Product product) {
        goodsDao.addGoods(product);
    }

    @Override
    public void deleteGoodsById(Integer id) {
        goodsDao.deleteGoodsById(id);
    }

    @Override
    public void updateGoods(Product product) {
        goodsDao.updateGoods(product);
    }

    @Override
    public Product queryById(Integer id) {
        return goodsDao.queryGoodsById(id);
    }

    @Override
    public List<Product> queryAllGoods() {

        return goodsDao.queryGoods();
    }

    @Override
    public Page<Product> page(Integer childId, Integer epcid, int pageNo, int pageSize) {
        Page<Product> page = new Page<>();
        //设置每页显示的数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = null;
        if (epcid == null && childId == null) {
            pageTotalCount = goodsDao.queryForPageTotalCount();
        } else if (epcid !=null){
            pageTotalCount = goodsDao.queryForPageCategoryTotalCount(epcid);
        }else {
            pageTotalCount = goodsDao.queryForPageCategoryChildTotalCount(childId);
        }
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);
        //设置当前页的开始索引
        Integer begin = null;
        if((page.getPageNo() - 1) * pageSize>0){
            begin = (page.getPageNo() - 1) * pageSize;
        }else {
            begin=0;
        }
        //设置页对象的中的数据对象即每页的一条条数据
        List products = null;
        if (epcid == null && childId == null) {
            products = goodsDao.queryForPageItems(begin, pageSize);
        } else if (epcid != null) {
            products = goodsDao.queryCatePage(epcid, begin, pageSize);
        } else {
            products = goodsDao.queryCatePageByChild(childId, begin, pageSize);
        }

        page.setItems(products);

        return page;
    }
}
