package cn.summerwaves.controller;


import cn.summerwaves.dao.UserDao;
import cn.summerwaves.model.User;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test(ModelMap model, String test) {
        if (test == null) {
            test = "空信息";
        }
        model.addAttribute("message", test);
        return "test";
    }

    @RequestMapping(value = "test1", method = RequestMethod.GET)
    public void sendRedirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("http://www.baidu.com");
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> test2(Boolean fuck) {
        log.info("the boolean fuck value is {}", fuck);
        Map<String, Object> map = new HashMap<String, Object>();

        User user = new User();
        user.setId(1L);
        user.setUsername("1234");
        user.setPassword("4567");
        map.put("fuck", "1234");
        map.put("test", user);
        return map;
    }


    @RequestMapping(value = "/a/session/set",method = RequestMethod.GET)
    public String getSession(ModelMap model, HttpServletRequest request) {
        User user = new User();
        user.setId(1L);
        user.setUsername("1234");
        user.setPassword("4567");
        request.getSession().setAttribute("donglin", user);
        return "setSession";
    }

    @RequestMapping(value = "/a/session/get",method = RequestMethod.GET)
    public String setSession(ModelMap model, HttpServletRequest request) {
        User session = (User) request.getSession().getAttribute("donglin");
        model.addAttribute("session", session);
        return "getSession";
    }

    @RequestMapping(value = "/gson", method = RequestMethod.GET)
    @ResponseBody
    public String toGson() {
        User user = new User();
        user.setId(1L);
        user.setUsername("1234");
        user.setPassword("4567");
        Gson gson = new Gson();
        String json = gson.toJson(user);
        return json;
    }

    @RequestMapping(value = "/jsonobject", method = RequestMethod.GET)
    @ResponseBody
    public String toJsonObject() {
        User user1 = new User();
        user1.setId(1L);
        user1.setUsername("1234");
        user1.setPassword("4567");
        User user2 = new User();
        user2.setId(7L);
        user2.setUsername("55555");
        user2.setPassword("66666");

        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray(userList);


        json.put("userList", jsonArray);
        json.put("fuck", "you");
        return json.toString();
    }

    @RequestMapping(value = "/jsontaglib", method = RequestMethod.GET)
    public String toJsonTaglib(Model model) {
        User user1 = new User();
        user1.setId(1L);
        user1.setUsername("1234");
        user1.setPassword("4567");
        User user2 = new User();
        user2.setId(7L);
        user2.setUsername("55555");
        user2.setPassword("66666");
        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        model.addAttribute("userList", userList);
        model.addAttribute("total", 2);
        model.addAttribute("code", 0);
        model.addAttribute("message", "success");

        return "/jsontaglib";
    }

    @RequestMapping(value = "/a/u/user/list", method = RequestMethod.GET)
    public String toUserList(Model model) {
        List<User> userList = userDao.selectAllUser();


        model.addAttribute("code", 0);
        model.addAttribute("message", "success");
        model.addAttribute("total", userList.size());
        model.addAttribute("userList", userList);

        return "/getAllUser";
    }






}
