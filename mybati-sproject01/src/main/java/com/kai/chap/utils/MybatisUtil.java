package com.kai.chap.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * mybatis工具类
 * @author hok
 * @since 2019-3-12 11:31:10
 */
public class MybatisUtil {

    private static SqlSessionFactory sqlSessionFactory = null;

    static{
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private MybatisUtil(){}

    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

}
