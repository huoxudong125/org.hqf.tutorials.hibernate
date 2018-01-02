package Queries;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hqf.tutorials.hibernate.domain.Customer;
import org.hqf.tutorials.hibernate.utils.HibernateUtils;
import org.junit.Test;

import java.util.List;

public class CeriteriaDemo {

    @Test
    public void get(){
        Session session= HibernateUtils.openSession();
        Criteria criteria = session.createCriteria(Customer.class);
        List<Customer> customers = criteria.list();
        for (Customer customer :
                customers) {
            System.out.println("customer = " + customer);
        }
    }

    @Test
    public void getByParameters(){
        Session session= HibernateUtils.openSession();
        Criteria criteria = session.createCriteria(Customer.class);
        //增加过滤条件
        criteria.add(Restrictions.eq("cust_id",1L));
        List<Customer> customers = criteria.list();
        for (Customer customer :
                customers) {
            System.out.println("customer = " + customer);
        }
    }

    // 分页查询
    @Test
    public void pageByParameters(){
        Session session= HibernateUtils.openSession();
        Criteria criteria = session.createCriteria(Customer.class);
        //增加过滤条件
        criteria.add(Restrictions.eq("cust_id",1L));
       criteria.setFirstResult(0);
       criteria.setFetchSize(1);
        List<Customer> customers = criteria.list();
        for (Customer customer :
                customers) {
            System.out.println("customer = " + customer);
        }
    }
 // 查询总数
    @Test
    public void getCountByParameters(){
        Session session= HibernateUtils.openSession();
        Criteria criteria = session.createCriteria(Customer.class);
        //增加过滤条件
//        criteria.add(Restrictions.eq("cust_id",1L));
        criteria.setProjection(Projections.rowCount());
        long customersCount = (long)criteria.uniqueResult();
        System.out.println("customersCount = " + customersCount);
    }

}
