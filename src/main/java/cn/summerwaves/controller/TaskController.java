package cn.summerwaves.controller;

import cn.summerwaves.util.DES2Base64Util;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URLEncoder;
import java.nio.charset.Charset;

@Controller
public class TaskController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @RequestMapping(value = "/xinhuameiyu", method = RequestMethod.GET)
    public String getUserById(Model model, String client, String username, String mobile,String name) throws Exception {

        log.info(Charset.defaultCharset()+"");
        String token = DES2Base64Util.encryption("client="+client+"&username="+username+"&mobile="+mobile+"&name="+name+"&timestamp="+System.currentTimeMillis(),"a7ca3c5d");
        token = URLEncoder.encode(token, "UTF-8");
        if (StringUtils.isBlank(client)
                && StringUtils.isBlank(username)
                && StringUtils.isBlank(mobile)
                && StringUtils.isBlank(name)) {
            return "xinhuameiyu";
        }
        model.addAttribute("token", "http://zhiyu.xinhuameiyu.com/a/xinhuameiyu?token="+token);
        model.addAttribute("client",client);
        model.addAttribute("username", username);
        model.addAttribute("mobile", mobile);
        model.addAttribute("name", name);

        return "xinhuameiyu";
    }



}
