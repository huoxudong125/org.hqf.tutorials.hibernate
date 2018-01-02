package org.hqf.hibernate.service.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hqf.hibernate.dao.CustomerDao;
import org.hqf.hibernate.dao.LinkManDao;
import org.hqf.hibernate.dao.impl.CustomerDaoImpl;
import org.hqf.hibernate.dao.impl.LinkManDaoImpl;
import org.hqf.hibernate.domain.Customer;
import org.hqf.hibernate.domain.LinkMan;
import org.hqf.hibernate.service.LinkManService;
import org.hqf.hibernate.utils.HibernateUtils;

import java.util.List;

public class LinkManServiceImpl implements LinkManService {

    private CustomerDao cd = new CustomerDaoImpl();
    private LinkManDao lmd = new LinkManDaoImpl();

    public void save(LinkMan lm) {
        //打开事务
        HibernateUtils.getCurrentSession().beginTransaction();

        try {
            //1 根据客户id获得客户对象
            Long cust_id = lm.getCust_id();
            Customer c = cd.getById(cust_id);
            //2 将客户放入LinkMan中表达关系
            lm.setCustomer(c);
            //3 保存LinkMan
            lmd.save(lm);
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            HibernateUtils.getCurrentSession().getTransaction().rollback();
        }
        //提交事务
        HibernateUtils.getCurrentSession().getTransaction().commit();

    }

    @Override
    public List<LinkMan> getAll(DetachedCriteria dc) {


        List<LinkMan> list = lmd.getAll(dc);

        return list;
    }

}
