//package cn.summerwaves.service;
//
//import cn.summerwaves.controller.UserController;
//import cn.summerwaves.model.User;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.transaction.TransactionConfiguration;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.hamcrest.Matchers.*;
//import static org.hamcrest.Matchers.is;
//import static org.mockito.Mockito.*;
//import org.mockito.Mockito;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@ContextConfiguration(locations = {"classpath:shiro-spring.xml","classpath:shiro-servlet.xml"})
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true)
//@Transactional
//public class UserServiceImplTest {
//    private MockMvc mockMvc;
//
//    @Autowired
//    private UserController userController;
//
//
////    @Autowired
////    private UserService userService;
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
//    public void getDemoidTest1() throws Exception {
//        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/jsontaglib"))
//                .andDo(print())
//                .andExpect(model().attribute("userList",hasItem(
//                        allOf(hasProperty("id",is(1L)),
//                                hasProperty("password"))
//                )))
////                .andExpect(model().attribute("userList",not)
//                .andExpect(status().isOk())
//                .andExpect(forwardedUrl("/WEB-INF/jsp/jsontaglib.jsp"));
////                .andExpect(jsonPath("$.message", is("success")));
//        System.out.println(resultActions.andReturn().getResponse().getContentAsString());
//    }
//
////    @Test
////    public void selectByPrimaryKey() {
////        User user = userService.selectByPrimaryKey(1L);
////        user.setPassword(666+"");
////        Boolean success = userService.updateByPrimaryKeySelective(user);
////        System.out.println(success);
////    }
//
//    @Test
//    public void updateByPrimaryKeySelective() {
//    }
//
//
//    @Test
//    public void selectByPrimaryKey1() {
//    }
//
//    @Test
//    public void updateByPrimaryKeySelective1() {
//    }
//
////    @Test
////
////    public void insert() {
////        User user = new User();
////        user.setUsername("fuck");
////        user.setPassword("pwd");
////        Long success = userService.insert(user);
////        System.out.println(success);
////        System.out.println(user.getId());
////
////    }
////
////    @Test
////    public void insertSelective(){
////        User user = new User();
////        user.setUsername("fuck");
////        user.setPassword("pwd");
////        Long success = userService.insertSelective(user);
////        System.out.println(success);
////        System.out.println(user.getId());
////    }
//}