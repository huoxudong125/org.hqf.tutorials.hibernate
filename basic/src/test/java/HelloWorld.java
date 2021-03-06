import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hqf.tutorials.hibernate.domain.Customer;
import org.junit.Assert;
import org.junit.Test;

public class HelloWorld {
    @Test
    //保存客户
    public void Add() {
        Configuration conf = new Configuration().configure();

        SessionFactory sessionFactory = conf.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        //----------------------------------------------
        Customer c = new Customer();
        c.setCust_name("google公司");

        session.save(c);//执行保存

        //----------------------------------------------
        tx.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void GetAll() {
        Configuration conf = new Configuration().configure();

        SessionFactory sessionFactory = conf.buildSessionFactory();

        Session session = sessionFactory.openSession();

//

        session.close();
        sessionFactory.close();
    }

    @Test
    public void Get() {
        Configuration conf = new Configuration().configure();

        SessionFactory sessionFactory = conf.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Customer customer = session.get(Customer.class, 1L);

        Assert.assertNotNull(customer);

        System.out.println("customer = " + customer);

        session.close();
        sessionFactory.close();
    }


}
