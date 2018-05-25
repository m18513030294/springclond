package cn.solr.controller;

import cn.solr.pojo.ProductModel;
import cn.solr.service.JdService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class jdController {
    @Resource
    JdService jdService;

    @RequestMapping("list.action")
    public String list(String queryString, String catalog_name, String price, String sort, Model model) throws Exception {
        //通过上面四个条件查询对象商品
//通过上面四个条件查询对象商品结果集
        List<ProductModel> productModels = jdService.selectProductModelListByQuery(queryString, catalog_name, price, sort);
        model.addAttribute("productModels", productModels);
        model.addAttribute("queryString", queryString);
        model.addAttribute("catalog_name", catalog_name);
        model.addAttribute("price", price);
        model.addAttribute("sort", sort);
        return "product_list";
    }


}
