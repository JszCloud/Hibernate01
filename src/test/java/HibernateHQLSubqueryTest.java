import online.shixun.model.Order;
import online.shixun.model.User;
import online.shixun.util.Matter;
import org.hibernate.Query;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Nominal on 2017/12/24 0024.
 * 微博：@李明易DY
 */
public class HibernateHQLSubqueryTest {
    Matter matter = new Matter();

    public static void main(String[] args) {
        HibernateHQLSubqueryTest hibernateHQLSubqueryTest = new HibernateHQLSubqueryTest();
        //hibernateHQLSubqueryTest.saveUserAndOrders();
        hibernateHQLSubqueryTest.listOrders();
    }

    /**
     * 保存用户及其订单数据
     */
    public void saveUserAndOrders() {
        matter.init();
        User user = new User("admin1", "123456", new Date());
        user.getOrder().add(new Order("12355", new Date()));
        user.getOrder().add(new Order("12356", new Date()));
        user.getOrder().add(new Order("12357", new Date()));
        user.getOrder().add(new Order("12358", new Date()));
        matter.session.save(user);
        matter.destroy();
    }

    /**
     * 查询指定用户的所有订单数据
     */
    public void listOrders() {
        matter.init();
        String hql = "FROM Order order WHERE order.user IN(SELECT user.id FROM User user WHERE user.loginName=? AND user.password=?)";
        Query query = matter.session.createQuery(hql);
        query.setString(0, "admin1");
        query.setString(1, "123456");
        //Iterator迭代遍历
        Iterator<Order> iterator = query.iterate();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            System.out.println(order);
        }
        //foreach遍历
        /*List<Order> orders = query.list();
        for (Order order : orders) {
            System.out.println(order);
        }*/
        matter.destroy();
    }
}
