package cn.solr.service;

import java.util.List;

import cn.solr.dao.jdDao;
import cn.solr.pojo.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class JdServiceImpl implements JdService {

    @Resource
    private jdDao jddao;

    //// 通过上面四个条件查询对象商品结果集
    public List<ProductModel> selectProductModelListByQuery(String queryString, String catalog_name,
                                                            String price, String sort) throws Exception {

        return jddao.selectProductModelListByQuery(queryString, catalog_name, price, sort);

    }
}
