package cn.tedu.boot03.controller;

import cn.tedu.boot03.entity.Product;
import cn.tedu.boot03.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author Freg
 * @time 2022/9/7  16:46
 */
@RestController
public class ProductController {
    /*
    自动装配注解,由Spring框架所提供,添加此注解后Spring框架和MyBatis框架会创建一个
    ProductMapper接口的实现类,并在将其实例化后,把对象赋值给mapper变量
     */
    @Autowired       // 若报错则添加(required = false),此报错为idea误提示
    ProductMapper mapper;

    @RequestMapping("/insert")
    public String insert(Product product){
        System.out.println("product = " + product);
        mapper.insert(product);
        return "添加完成<a href='/'>返回首页</a>";
    }

    @RequestMapping("/select")
    public String select(){
        List<Product> list = mapper.select();

        //把list集合中的数据装进表格标签 响应给客户端
        String html = "<table border='1'>";
        html+="<caption>商品列表</caption>";
        html+="<tr><th>id</th><th>标题</th><th>价格</th><th>库存</th><th>操作</th></tr>";
        for (Product product:list) {
            html+="<tr>";
            html+="<td>"+product.getId()+"</td>";
            html+="<td>"+product.getTitle()+"</td>";
            html+="<td>"+product.getPrice()+"</td>";
            html+="<td>"+product.getNum()+"</td>";
            // ?是请求地址和请求参数的分隔符
            html+="<td><a href='/deleteById?id="+product.getId()+"'>删除</a></td>";
            html+="</tr>";
        }
        html+="</table>";
        return html;
    }

    @RequestMapping("/delete")
    public String delete(int id){
        mapper.deleteById(id);
        return "删除成功<a href='/'>返回主页</a>";
    }

    @RequestMapping("/update")
    public String update(Product product){
        mapper.update(product);
        return "修改成功<a href='/'>返回主页</a>";
    }

}
