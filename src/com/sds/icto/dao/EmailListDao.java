package com.sds.icto.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sds.icto.vo.EmailListVo;

public class EmailListDao {

	private SqlSessionFactory sqlSessionFactory;

	public EmailListDao() {
		try {
			String resource = "configuration.xml";
			InputStream inputStream = Resources.getResourceAsStream( resource );
			sqlSessionFactory = new SqlSessionFactoryBuilder().build( inputStream );
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}	
	
	public void insert( EmailListVo vo ) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert( "emaillist.insert", vo );
		sqlSession.close();
	}
	
	public List<EmailListVo> getList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<EmailListVo> list = sqlSession.selectList( "emaillist.list" );
		sqlSession.close();

		return list;
	}

}