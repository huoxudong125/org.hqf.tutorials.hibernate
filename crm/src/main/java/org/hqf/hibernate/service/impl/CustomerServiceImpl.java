package org.hqf.hibernate.service.impl;

import org.hqf.hibernate.dao.CustomerDao;
import org.hqf.hibernate.dao.impl.CustomerDaoImpl;
import org.hqf.hibernate.domain.Customer;
import org.hqf.hibernate.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao = new CustomerDaoImpl();

	public void save(Customer c) {
		//调用Dao保存客户
		customerDao .save(c);
	}

}
