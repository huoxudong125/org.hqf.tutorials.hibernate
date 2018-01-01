import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hqf.tutorials.hibernate.domain.Generator.CustomerGeneratorAssigned;
import org.junit.Assert;
import org.junit.Test;

public class CacheDemo {
    @Test
    public void TestHibernateCache() {
        Configuration conf = new Configuration().configure();

        SessionFactory sessionFactory = conf.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        CustomerGeneratorAssigned customer = new CustomerGeneratorAssigned();
        customer.setCust_name("Customer1000");
        customer.setCust_id(1000L);
        session.saveOrUpdate(customer);
        tx.commit();

        // Get the same Customer, Second Object got from cache.Not from DB
        CustomerGeneratorAssigned customer1 = session.get(CustomerGeneratorAssigned.class, 1000L);
        CustomerGeneratorAssigned customer2 = session.get(CustomerGeneratorAssigned.class, 1000L);
       // Will Select another Object not using Cache.
        // CustomerGeneratorAssigned customer3 = session.get(CustomerGeneratorAssigned.class, 100L);

        Assert.assertNotNull(customer1);
        Assert.assertNotNull(customer2);
        Assert.assertEquals(customer1, customer2);

        System.out.println("customer = " + customer);
        System.out.println("customer1 = " + customer1);
        System.out.println("customer2 = " + customer2);
        System.out.println("customer1 = customer2  " + (customer1 == customer2));

        session.close();
        sessionFactory.close();
    }
}
