package cn.solr.service;

import java.util.List;

import cn.solr.pojo.ProductModel;

public interface JdService {

    //// 通过上面四个条件查询对象商品结果集
    public List<ProductModel> selectProductModelListByQuery(String queryString, String catalog_name,
                                                            String price, String sort) throws Exception;

}
