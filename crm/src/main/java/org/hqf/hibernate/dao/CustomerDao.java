package org.hqf.hibernate.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import org.hqf.hibernate.domain.Customer;

public interface CustomerDao {
	//保存客户
	void save(Customer c);
	//查询所有客户
	List<Customer> getAll();
	//根据id获得客户
	Customer getById(Long cust_id);
	//根据条件查询所有客户
	List<Customer> getAll(DetachedCriteria dc);

}
