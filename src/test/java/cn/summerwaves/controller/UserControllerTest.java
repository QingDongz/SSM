//package cn.summerwaves.controller;
//
//import cn.summerwaves.service.UserService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.transaction.TransactionConfiguration;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.hamcrest.Matchers.is;
//import static org.junit.Assert.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@ContextConfiguration(locations = {"classpath:shiro-spring.xml", "classpath:shiro-servlet.xml"})
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
//@Transactional
//public class UserControllerTest {
//
//    private MockMvc mockMvc;
//
//    @Autowired
//    private UserController userController;
//
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    WebApplicationContext wac;
//
//
//    @Before
//    public void setUp() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//    }
//
//    @Test
//    public void test1() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/test").param("test", "测试"))
//                .andExpect(model().attribute("message", "测"))
//                .andExpect(forwardedUrl("/WEB-INF/jsp/test.jsp"))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }
//
//
//    @Test
//    public void test2() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/test2").param("fuck", "true").header("test", "test"))
//                .andDo(print())
//                .andExpect(jsonPath("$.fuck", is(1234)))
//                .andExpect(jsonPath("$.test.id", is(1)))
//                .andExpect(status().isOk());
//    }
//}