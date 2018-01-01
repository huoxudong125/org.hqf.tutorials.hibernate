package org.hqf.hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hqf.hibernate.dao.CustomerDao;
import org.hqf.hibernate.domain.Customer;
import org.hqf.hibernate.utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao {

	public void save(Customer c) {
		//1 获得session
		Session session = HibernateUtils.openSession();
		//2 打开事务
		Transaction tx = session.beginTransaction();
		//3 执行保存
		session.save(c);
		//4 提交事务
		tx.commit();
		//5 关闭资源
		session.close();
		
	}

}
