package cn.solr.dao;

import cn.solr.pojo.ProductModel;

import java.util.List;

public interface jdDao {
    //// 通过上面四个条件查询对象商品结果集
    public List<ProductModel> selectProductModelListByQuery(String queryString, String catalog_name,
                                                            String price, String sort) throws Exception;
}
