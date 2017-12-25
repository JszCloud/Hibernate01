package online.shixun.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by Nominal on 2017/12/19 0019.
 * 微博：@李明易DY
 */
public class Matter {

    SessionFactory sf = null;
    public Session session = null;
    Transaction transaction = null;

    public void init() {
        //加载配置文件
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        //注册标准服务
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
        StandardServiceRegistry ssr = ssrb.applySettings(configuration.getProperties()).build();
        //通过标准服务加载配置文件后获得会话工厂
        sf = configuration.buildSessionFactory(ssr);//二级缓存
        //开启一个会话
        session = sf.openSession();//一级缓存

        //开启事物
        transaction = session.beginTransaction();
        //操作
        System.out.println("连接开启成功");
    }

    public void destroy() {
        //提交事物
        transaction.commit();
        // 关闭
        session.close();
        sf.close();
        System.out.println("连接关闭成功");
    }
}
