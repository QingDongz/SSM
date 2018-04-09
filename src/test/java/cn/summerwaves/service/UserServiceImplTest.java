package cn.summerwaves.service;

import cn.summerwaves.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@ContextConfiguration(locations = {"classpath:shiro-spring.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void selectByPrimaryKey() {
        User user = userService.selectByPrimaryKey(1L);
        user.setPassword(666+"");
        Boolean success = userService.updateByPrimaryKeySelective(user);
        System.out.println(success);
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }


}