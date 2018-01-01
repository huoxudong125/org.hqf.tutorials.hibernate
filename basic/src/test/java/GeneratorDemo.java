import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hqf.tutorials.hibernate.domain.Generator.*;
import org.junit.Test;

public class GeneratorDemo {

    @Test
    //保存客户
    public void AddCustomerGeneratorIdentity() {
        Configuration conf = new Configuration().configure();

        SessionFactory sessionFactory = conf.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        //----------------------------------------------
        CustomerGeneratorIdentity c = new CustomerGeneratorIdentity();
        c.setCust_name("CustomerGeneratorIdentity ");

        session.save(c);//执行保存

        //----------------------------------------------
        tx.commit();
        session.close();
        sessionFactory.close();
    }


    @Test
    //保存客户
    public void AddCustomerGeneratorIncrement() {
        Configuration conf = new Configuration().configure();

        SessionFactory sessionFactory = conf.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        //----------------------------------------------
        CustomerGeneratorIncrement c = new CustomerGeneratorIncrement();
        c.setCust_name("CustomerGeneratorIncrement");

        session.save(c);//执行保存

        //----------------------------------------------
        tx.commit();
        session.close();
        sessionFactory.close();
    }


    @Test
    //保存客户
    public void AddCustomerGeneratorNative() {
        Configuration conf = new Configuration().configure();

        SessionFactory sessionFactory = conf.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        //----------------------------------------------
        CustomerGeneratorNative c = new CustomerGeneratorNative();
        c.setCust_name("CustomerGeneratorNative");

        session.save(c);//执行保存

        //----------------------------------------------
        tx.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    //保存客户
    public void AddCustomerGeneratorUuid() {
        Configuration conf = new Configuration().configure();

        SessionFactory sessionFactory = conf.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        //----------------------------------------------
        CustomerGeneratorUuid c = new CustomerGeneratorUuid();
        c.setCust_name("CustomerGeneratorUuid");

        session.save(c);//执行保存

        //----------------------------------------------
        tx.commit();
        session.close();
        sessionFactory.close();
    }


    @Test
    //保存客户
    public void AddCustomerGeneratorAssigned() {
        Configuration conf = new Configuration().configure();

        SessionFactory sessionFactory = conf.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        //----------------------------------------------
        CustomerGeneratorAssigned c = new CustomerGeneratorAssigned();
        c.setCust_name("CustomerGeneratorAssigned");
        c.setCust_id(100L);
        session.save(c);//执行保存

        //----------------------------------------------
        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
