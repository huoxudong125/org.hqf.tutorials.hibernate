package org.hqf.hibernate.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.criterion.DetachedCriteria;
import org.hqf.hibernate.dao.LinkManDao;
import org.hqf.hibernate.domain.LinkMan;
import org.hqf.hibernate.utils.HibernateUtils;

import java.util.List;

public class LinkManDaoImpl implements LinkManDao {

	public void save(LinkMan lm) {
		//1 获得session
		Session session = HibernateUtils.getCurrentSession();
		session.save(lm);
	}

    @Override
    public List<LinkMan> getAll(DetachedCriteria dc) {
        //1 获得session
        Session session = HibernateUtils.getCurrentSession();
        //2 将离线对象关联到session
        Criteria c = dc.getExecutableCriteria(session);
        //3 执行查询并返回
        return c.list();
    }


}
