package com.billboard.model;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BillboardService {

	private BillboardDAO_interface dao;
	public BillboardService() {
		//dao = new EmpHibernateDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		ApplicationContext context = new ClassPathXmlApplicationContext("model-config-jndi.xml");
		dao =(BillboardDAO_interface) context.getBean("billboardDAO");
	}
	public void addBillboard(BillboardVO billboardVO) {
		dao.insert(billboardVO);
	}
	
	public void updateBillboard(BillboardVO billboardVO) {
		dao.update(billboardVO);
	}

	public void deleteBillboard(Integer bill_id) {
		dao.delete(bill_id);
	}

	public BillboardVO getOneBillboard(Integer bill_id) {
		return dao.findByPrimaryKey(bill_id);
	}

	public List<BillboardVO> getAll() {
		return dao.getAll();
	}
}
