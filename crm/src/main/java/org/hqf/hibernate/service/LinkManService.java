package org.hqf.hibernate.service;

import org.hibernate.criterion.DetachedCriteria;
import org.hqf.hibernate.domain.LinkMan;

import java.util.List;

public interface LinkManService {
	//保存联系人
	void save(LinkMan lm);

    List<LinkMan> getAll(DetachedCriteria dc);
}
