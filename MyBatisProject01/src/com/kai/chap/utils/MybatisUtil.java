package com.kai.chap.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * mybatis工具类
 * @author hok
 * @since 2019-3-13 15:25:52
 */
public class MybatisUtil {
	
	private static SqlSessionFactory sqlSessionFactory = null;
	
	static {
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private MybatisUtil() {}
	
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}

}
