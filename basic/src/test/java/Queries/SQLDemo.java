package Queries;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hqf.tutorials.hibernate.domain.Customer;
import org.hqf.tutorials.hibernate.utils.HibernateUtils;
import org.junit.Test;

import java.util.List;

public class SQLDemo {

    @Test
    public void get() {
        Session seesion = HibernateUtils.openSession();

        String sql = "select * from Customer";

        SQLQuery sqlQuery = seesion.createSQLQuery(sql);
        sqlQuery.addEntity(Customer.class);

        List<Customer> customers = sqlQuery.list();
        for (Customer customer :
                customers) {
            System.out.println("customer = " + customer);
        }
    }

    @Test
    public void getByParameter() {
        Session seesion = HibernateUtils.openSession();

        String sql = "select * from Customer where id=:Id";

        SQLQuery sqlQuery = seesion.createSQLQuery(sql);
        sqlQuery.addEntity(Customer.class);
        sqlQuery.setParameter("Id", 1L);

        List<Customer> customers = sqlQuery.list();
        for (Customer customer :
                customers) {
            System.out.println("customer = " + customer);
        }
    }


    @Test
    public void pageByParameter() {
        Session seesion = HibernateUtils.openSession();

        String sql = "select * from Customer where id=:Id limit :start, :pageSize";

        SQLQuery sqlQuery = seesion.createSQLQuery(sql);
        sqlQuery.addEntity(Customer.class);
        sqlQuery.setParameter("Id", 1L);
        sqlQuery.setParameter("start", 0);
        sqlQuery.setParameter("pageSize", 10);

        List<Customer> customers = sqlQuery.list();
        for (Customer customer :
                customers) {
            System.out.println("customer = " + customer);
        }
    }

}
