package cn.summerwaves.controller;


import cn.summerwaves.dao.UserDao;
import cn.summerwaves.model.User;
import cn.summerwaves.util.JsonPropertyFilter;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource
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
    public Map<String, Object> test2(HttpServletRequest request,Boolean fuck) {
        log.info("the boolean fuck value is {},the head params is {}", fuck, request.getHeader("test"));
        Map<String, Object> map = new HashMap<String, Object>();

        User user = new User();
        user.setId(1L);
        user.setUsername("1234");
        user.setPassword("4567");
        map.put("fuck", 1234);
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



    @RequestMapping(value = "/set/request", method = RequestMethod.GET)
    public String setRequest(Model model,HttpServletRequest request) {
        request.setAttribute("fuck","hedonglin");
        return "/setRquest";
    }

    @RequestMapping(value = "/get/request", method = RequestMethod.GET)
    public String getRequest(Model model,HttpServletRequest request,String test,String test2) {
        String fuck =  request.getParameter("fuck");
        log.info("the test is {},test2 is {}", test,test2);
        model.addAttribute("request", fuck);
        return "getRequest";
    }



    @RequestMapping(value = "/test/filter", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject filter(Model model,Integer page,Integer size) {
        if (null == page || page < 1) {
            page = 1;
        }
        if (null == size || size < 0) {
            size = 10;
        }
        JSONObject jsonObject = new JSONObject();
        PageHelper.startPage(page, size);
        List<User> userList = userDao.selectAllUser();
        List<String> filterList = Arrays.asList("password","age");
        JsonPropertyFilter jsonPropertyFilter = new JsonPropertyFilter();
        JSONArray jsonArray = jsonPropertyFilter.jsonPropertyFilter(userList, filterList);
        jsonObject.put("code", 0);
        jsonObject.put("message", "success");
        jsonObject.put("pageNum", ((Page)userList).getPages());
        jsonObject.put("studentList", jsonArray);

        return jsonObject;
    }


    @RequestMapping(value = "/header", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> getDomain(HttpServletRequest request, String test) {

        String domain = request.getHeader("header");
        log.info("请求头是：{}", domain);
        log.info("主体内容为：{}", test);
        HashMap<String, String> map = new HashMap<String, String>(2);
        map.put("body", test);
        map.put("header", domain);

        return map;
    }








}
