package cn.summerwaves.dao;

import cn.summerwaves.model.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@ContextConfiguration(locations = {"classpath:shiro-spring.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {
    @Autowired
    UserDao userDao;


    @Test
    public void updateByPrimaryKeySelective() {
        User user = new User();
        user.setUsername("fuck");
        user.setId(1L);

        userDao.updateByPrimaryKeySelective(user);
    }

    @Test
    public void selectAllUser() {
        PageHelper.startPage(1, 10);
        List<User> userList = userDao.selectAllUser();
        System.out.println("==================================");
        System.out.println(userList.size());
        System.out.println("==================================");
        System.out.println(userList);
        System.out.println("==================================");
        System.out.println(((Page)userList).getTotal());
        System.out.println("==================================");
        System.out.println(((Page)userList).getPages());
        System.out.println("==================================");

        for (User user : userList) {
            System.out.println(user);
        }
        System.out.println("==================================");

    }

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        Long success = userDao.insert(user);
        System.out.println("the insert id is " + success);
    }

    @Test
    public void insertSelective() {
        User user = new User();
        user.setUsername("test");
//        user.setPassword("test");
//        user.setAge(13);
        Long success = userDao.insertSelective(user);
        System.out.println("the insert id is " + success);
    }
}