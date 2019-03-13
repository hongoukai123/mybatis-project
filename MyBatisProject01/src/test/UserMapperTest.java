package test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kai.chap.mapper.UserMapper;
import com.kai.chap.pojo.User;
import com.kai.chap.utils.MybatisUtil;

public class UserMapperTest {
	
	public static void main(String[] args) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
//		User user = sqlSession.selectOne("com.kai.chap.mapper.UserMapper.selectUser", 1);
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.selectUser(1);
		System.out.println(user);
	}
	
	public void test1() {
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
//		User user = sqlSession.selectOne("com.kai.chap.mapper.UserMapper.selectUser", 1);
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.selectUser(1);
		System.out.println(user);
	}

}
