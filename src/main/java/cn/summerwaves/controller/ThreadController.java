package cn.summerwaves.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ThreadController {

    @RequestMapping(value = "/thread", method = RequestMethod.GET)
    public String threadTest(){
        new Thread(() ->{
            try {
                Thread.sleep(5000);
                System.out.println("完成！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("fk you");}).start();


        System.out.println("控制器方法要结束啦！");
        return "message";
    }



}
