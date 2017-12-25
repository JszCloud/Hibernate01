import online.shixun.model.Commodity;
import online.shixun.model.Order;
import online.shixun.util.Matter;
import org.hibernate.Query;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Nominal on 2017/12/25 0025.
 * 微博：@李明易DY
 */
public class HibernateHQLBaseTest {
    Matter matter=new Matter();
    public static void main(String[] args) {
        HibernateHQLBaseTest hibernateHQLBaseTest=new HibernateHQLBaseTest();
        hibernateHQLBaseTest.saveCommodity();
        hibernateHQLBaseTest.selectTerm();
        //hibernateHQLBaseTest.listCommodity();
        //hibernateHQLBaseTest.iteratorCommodity();
    }
    public void saveCommodity(){
        matter.init();
        matter.session.save(new Commodity("TCL电视","一个可以用的东西",new Date(),new Date()));
        matter.session.save(new Commodity("香蕉","一个可以用的东西",new Date(),new Date()));
        matter.session.save(new Commodity("康佳电视","一个可以用的东西",new Date(),new Date()));
        matter.destroy();
    }
    public void listCommodity(){
        matter.init();
        String hql="from Commodity";
        Query query=matter.session.createQuery(hql);
        List<Commodity> list=query.list();
        for (Commodity com : list) {
            System.out.println(com);
        }
        matter.destroy();
    }
    public void iteratorCommodity(){
        matter.init();
        String hql="from Commodity";
        Query query=matter.session.createQuery(hql);
        Iterator<Commodity> iterator = query.iterate();
        while (iterator.hasNext()) {
            Commodity commodity = iterator.next();
            System.out.println(commodity);
        }
        matter.destroy();
    }
    public void selectTerm(){
        matter.init();
        String hql1="from Commodity co where co.id=? and co.name like ?";
        Query query=matter.session.createQuery(hql1);
        query.setInteger(0,1);
        query.setString(1,"%电视%");
        List<Commodity> commodities=query.list();
        for (Commodity commodity : commodities) {
            System.out.println(commodity);
        }
        matter.destroy();
    }
}
