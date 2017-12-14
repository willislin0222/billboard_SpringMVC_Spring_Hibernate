package com.billboard.model;

import java.util.List;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;



public class BillboardDAO implements BillboardDAO_interface{
	
	private static final String GET_ALL_STMT="From BillboardVO";
	
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void insert(BillboardVO billboardVO) {
		hibernateTemplate.saveOrUpdate(billboardVO);
	}

	@Override
	public void update(BillboardVO billboardVO) {
		hibernateTemplate.saveOrUpdate(billboardVO);
	}

	@Override
	public void delete(int bill_id) {
		BillboardVO billboardVO =(BillboardVO) hibernateTemplate.get(BillboardVO.class, bill_id);
		hibernateTemplate.delete(billboardVO);
	}

	@Override
	public BillboardVO findByPrimaryKey(int bill_id) {
		BillboardVO billboardVO =billboardVO =(BillboardVO) hibernateTemplate.get(BillboardVO.class, bill_id);
			
		return billboardVO;
	}

	@Override
	public List<BillboardVO> getAll() {
		List<BillboardVO> list = null;
		
		list = (List<BillboardVO>) hibernateTemplate.find(GET_ALL_STMT);
		return list;
	}
	
	public static void main(String[] args) {

		//EmpHibernateDAO dao = new EmpHibernateDAO();
		//為方便一般應用程式main方的測試,所以底下的model-config1-DriverManagerDataSource.xml內部dataSource設定是採用org.springframework.jdbc.datasource.DriverManagerDataSource
		ApplicationContext context = new ClassPathXmlApplicationContext("model-config-JDBC.xml");
        
        // 建立DAO物件
		BillboardDAO_interface dao =(BillboardDAO_interface) context.getBean("billboardDAO");

		//● 新增
//
//		BillboardVO billboardVO1 = new BillboardVO();
//		billboardVO1.setBill_title("1234");
//		billboardVO1.setBill_name("test");
//		billboardVO1.setBill_start(java.sql.Date.valueOf("2017-12-15"));
//		billboardVO1.setBill_end(java.sql.Date.valueOf("2017-12-18"));
//		billboardVO1.setBill_content("fdfdsgdsgs");
//		dao.insert(billboardVO1);



		//● 修改
//		BillboardVO billboardVO2 = new BillboardVO();
//		billboardVO2.setBill_id(5);
//		billboardVO2.setBill_title("7890");
//		billboardVO2.setBill_name("test");
//		billboardVO2.setBill_start(java.sql.Date.valueOf("2017-12-15"));
//		billboardVO2.setBill_end(java.sql.Date.valueOf("2017-12-18"));
//		billboardVO2.setBill_content("fdfdsgdsgs");
//		dao.update(billboardVO2);



		//● 刪除(小心cascade - 多方reservation.hbm.xml如果設為 cascade="all"或
		// cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除)
//		dao.delete(5);



		//● 查詢-findByPrimaryKey (多方reservation.hbm.xml必須設為lazy="false")(優!)
//		BillboardVO billboardVO3 = dao.findByPrimaryKey(4);
//		System.out.print(billboardVO3.getBill_id() + ",");
//		System.out.print(billboardVO3.getBill_name() + ",");
//		System.out.print(billboardVO3.getBill_start() + ",");
//		System.out.print(billboardVO3.getBill_end() + ",");
//		System.out.print(billboardVO3.getBill_content() + ",");



		//● 查詢-getAll (多方reservation.hbm.xml必須設為lazy="false")(優!)
//		List<BillboardVO> list = dao.getAll();
//		for (BillboardVO abillboard : list) {
//			System.out.print(abillboard.getBill_id() + ",");
//			System.out.print(abillboard.getBill_name() + ",");
//			System.out.print(abillboard.getBill_start() + ",");
//			System.out.print(abillboard.getBill_end() + ",");
//			System.out.print(abillboard.getBill_content() + ",");
//		}
	}


}
