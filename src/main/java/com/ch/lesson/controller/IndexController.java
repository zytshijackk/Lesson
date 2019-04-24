/**
 * @ClassName
 * @Description TODO
 * @Author zytshijack
 * @Date 2019-04-13 09:55
 * @Version 1.0
 */
package com.ch.lesson.controller;

import com.ch.lesson.domain.User;
import com.ch.lesson.service.PermissionIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Map;

/**
 * @Description
 *      需要跳转到thymeleaf的要使用@Controller注解，
 *      因为@RestController = @Controller + @ResponseBody
 * @Author zytshijack
 * @Date 2019-04-13 09:55
 * @Version 1.0
 */
@Controller
public class IndexController {

    @Autowired
    PermissionIService permissionIService;

//    @ResponseBody
    @RequestMapping({"/","/index.html","/index"})
    public String index(Model model, HttpSession session){
//        User user = (User)session.getAttribute("account");
//        System.out.println(user);
//        model.addAttribute("accou");
//        permissionIService.getMap();
        return "index";
    }

    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }//返回login.html

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    //查出一些数据，在页面展示
    @RequestMapping("/success")
    public String success(final Model model){
//        map.put("hello","<h1>你好<h1>");
//        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        model.addAttribute("hello","<h1>你好</h1>");
        model.addAttribute("users",Arrays.asList("zhangsan","lisi","wangwu"));
        //classpath:/templates/success1.html
        return "success";
    }

}
