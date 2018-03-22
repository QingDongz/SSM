package cn.summerwaves.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void setId() {
        User user = new User();
        user.setId(11);
        user.setAge(55);
        System.out.println(user.getTotal());
    }
}