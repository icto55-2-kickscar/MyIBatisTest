package com.sds.icto.dao.test;
import java.util.List;

import com.sds.icto.dao.EmailListDao;
import com.sds.icto.vo.EmailListVo;


public class EmailListDaoTest {

	private static EmailListDao dao;
	
	public static void main(String[] args) {
		before();
		testList();
	}
	
	public static void before() {
		dao = new EmailListDao();
	}
	
	public static void testList() {
		List<EmailListVo> list = dao.getList();
		for( EmailListVo vo : list ) {
			System.out.println( vo.getNo() + ":" + vo.getFirstName() + ":" + vo.getLastName() + ":" + vo.getEmail() );
		}
	}	
}