package org.hqf.hibernate.web;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hqf.hibernate.domain.LinkMan;
import org.hqf.hibernate.service.LinkManService;
import org.hqf.hibernate.service.impl.LinkManServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListLinkManServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LinkManService linkManService = new LinkManServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListLinkManServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1获得查询条件
        String cust_name = request.getParameter("lkm_name");
        //2判断查询条件是否不为空
        DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);

        if (cust_name != null && !"".equals(cust_name)) {
            dc.add(Restrictions.like("lkm_name", "%" + cust_name + "%"));
        }
        //不为空=>添加条件
        //3 调用Service查询所有客户
        List<LinkMan> list = linkManService.getAll(dc);
        //4 将客户列表放入request域
        request.setAttribute("list", list);
        //5 转发到list.jsp显示
        request.getRequestDispatcher("/jsp/linkman/list.jsp").forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}