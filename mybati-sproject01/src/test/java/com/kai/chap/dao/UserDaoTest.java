package com.kai.chap.dao;

import com.kai.chap.mapper.UserMapper;
import com.kai.chap.pojo.User;
import com.kai.chap.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testSelectUserById(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.selectUserById(1);
            System.out.println(user);
        }finally{
            sqlSession.close();
        }
    }

}
