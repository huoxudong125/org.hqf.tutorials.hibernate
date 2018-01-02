package Queries;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hqf.tutorials.hibernate.domain.Customer;
import org.hqf.tutorials.hibernate.utils.HibernateUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class HQLDemo {

    @Test
    public void GetALL() {
        Configuration conf = new Configuration().configure();

        SessionFactory sessionFactory = conf.buildSessionFactory();

        Session session = sessionFactory.openSession();
        String hql = " from Customer";

        Query query = session.createQuery(hql);

        List<Customer> customers = query.list();

        for (Customer customer :
                customers) {
            System.out.println("customer = " + customer);
        }


        session.close();
        sessionFactory.close();
    }


    //拼接HQL
    @Test
    public void Get() {
        Configuration conf = new Configuration().configure();

        SessionFactory sessionFactory = conf.buildSessionFactory();

        Session session = sessionFactory.openSession();
        String hql = " from Customer where cust_id=1";

        Query query = session.createQuery(hql);

        Customer customer = (Customer) query.uniqueResult();

        System.out.println("customer = " + customer);


        session.close();
        sessionFactory.close();
    }

    //占位查询
    @Test
    public void getByParameterPlaceHolder() {
        Configuration conf = new Configuration().configure();

        SessionFactory sessionFactory = conf.buildSessionFactory();

        Session session = sessionFactory.openSession();
        String hql = " from Customer where cust_id=?";

        Query query = session.createQuery(hql);
//        query.setParameter(0,1L);
        query.setLong(0, 1L);
        Customer customer = (Customer) query.uniqueResult();

        System.out.println("customer = " + customer);


        session.close();
        sessionFactory.close();
    }

    //命名占位
    @Test
    public void getByParameterNamedPlaceHolder() {
        Configuration conf = new Configuration().configure();

        SessionFactory sessionFactory = conf.buildSessionFactory();

        Session session = sessionFactory.openSession();
        String hql = " from Customer where cust_id=:Id";

        Query query = session.createQuery(hql);
//        query.setParameter(0,1L);
        query.setParameter("Id",1L);
        Customer customer = (Customer) query.uniqueResult();

        System.out.println("customer = " + customer);


        session.close();
        sessionFactory.close();
    }

    @Test
    public void pageResult(){



        Session session = HibernateUtils.openSession();
        String hql = " from Customer where cust_id=:Id";

        Query query = session.createQuery(hql);
//        query.setParameter(0,1L);
        query.setParameter("Id",1L);

        query.setFetchSize(1);
        Customer customer = (Customer) query.uniqueResult();

        System.out.println("customer = " + customer);

        session.close();
    }


}
