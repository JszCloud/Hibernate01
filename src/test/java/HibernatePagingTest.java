import online.shixun.model.Commodity;
import online.shixun.util.Matter;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by Nominal on 2017/12/25 0025.
 * 微博：@李明易DY
 */
public class HibernatePagingTest {
    Matter matter=new Matter();
    public static void main(String[] args) {
       HibernatePagingTest hibernatePagingTest=new HibernatePagingTest();
       hibernatePagingTest.listCommodityWithPaging();
    }
    /*
    * 分页查询商品信息
    * */
    public void listCommodityWithPaging(){
        matter.init();
        String hql="from Commodity co where co.id<?";
        Query query=matter.session.createQuery(hql);
        query.setInteger(0,100);
        query.setMaxResults(2);//每页显示条数
        query.setFirstResult((2-1)*2);//跳过条数
        List<Commodity> list=query.list();
        for (Commodity commodity : list) {
            System.out.println(commodity);
        }
        matter.destroy();
    }
}
