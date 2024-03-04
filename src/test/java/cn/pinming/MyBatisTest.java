package cn.pinming;

import cn.pinming.entity.User;
import cn.pinming.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Chen.J.Y
 * @date 2024/3/4
 */
public class MyBatisTest {

    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        // 1.读取配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        // 2.创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 3.使用工厂生产SqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        // 4.关闭资源
    }

    @Test
    public void test() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }
}
