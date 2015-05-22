package com.sds.icto.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sds.icto.vo.MemberVo;

public class MemberDao {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public MemberDao() {
		try {
			String resource = "configuration.xml";
			InputStream inputStream = Resources.getResourceAsStream( resource );
			sqlSessionFactory = new SqlSessionFactoryBuilder().build( inputStream );
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public MemberVo get( MemberVo vo ) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberVo memberVo = ( MemberVo ) sqlSession.selectOne( "member.getMember", vo );
		sqlSession.close();
		
		return memberVo;
	}
	
}
