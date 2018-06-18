package cn.summerwaves.model;

import cn.summerwaves.dao.UserDao;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class StudentTest {
    @Mock
    private UserDao userDao;

    @Test
    public void setNumber() {
        User user = new User();
        user.setId(1L);
        user.setPassword("pwd");
        user.setUsername("username");
        when(userDao.insertSelective(user)).thenReturn(1L);
        userDao.insertSelective(user);
    }

    @Test
    public void setAge() {

    }

    @Test
    public void setName() {
    }
}