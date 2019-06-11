package com.ch.lesson.controller;

import com.ch.lesson.service.PassportIService;
import com.ch.lesson.service.UserIService;
import com.ch.lesson.utils.CaptchaUtil;
import com.ch.lesson.utils.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2019-03-31
 */
@RestController
@RequestMapping("/passport")
public class PassportController {
	@Autowired
    private PassportIService passportIService;
	@Autowired
    private UserIService userIService;

    /**
     * 登录判断方法(使用异常拦截器方式)
     * @param userName
     * @param passWord
     * @return User信息
     * @throws Exception
     */
//    @RequestMapping(value = "login",method = RequestMethod.POST)
//    public User login(
//            @RequestParam(value = "userName", required = true) String userName,
//            @RequestParam(value = "passWord", required = true) String passWord,
//            HttpSession session
//            ) throws Exception {
//        Passport passport = passportIService.login(userName, passWord);
//        User user = userIService.getById(passport.getUserId());
//        session.setAttribute("account",user);
//        return userIService.getById(passport.getUserId());
//    }
//    @RequestMapping(value = "login",method = RequestMethod.POST)
    @CrossOrigin//跨源资源共享（CORS）
    @GetMapping(value = "vueLogin")
    public ServiceResult login3(
            @RequestParam(value = "userName", required = true) String userName,
            @RequestParam(value = "passWord", required = true) String passWord,
            HttpSession session
    ) {
        ServiceResult result = passportIService.login2(userName, passWord);
        session.setAttribute("account",result.getData().get("account"));
        return result;
    }

    @PostMapping(value = "login")
    public ServiceResult login2(
            @RequestParam(value = "userName", required = true) String userName,
            @RequestParam(value = "passWord", required = true) String passWord,
            @RequestParam(value = "validateCode",required = true) String validateCode,
            HttpSession session
    ) {
        if(!validateCode.equalsIgnoreCase(session.getAttribute("code").toString())){
            return new ServiceResult("验证码错误",false);
        }
        ServiceResult result = passportIService.login2(userName, passWord);
        session.setAttribute("account",result.getData().get("account"));
        return result;
    }



    // 生成验证码
    @RequestMapping("validateCode")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 通知浏览器不要缓存
        response.setHeader("Expires", "-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "-1");
        CaptchaUtil util = CaptchaUtil.Instance();
        // 将验证码输入到session中，用来验证
        String code = util.getString();
        System.out.println(code);
        request.getSession().setAttribute("code", code);
        // 输出打web页面
        ImageIO.write(util.getImage(), "jpg", response.getOutputStream());
    }

    //PUT请求：如果两个请求相同，后一个请求会把第一个请求覆盖掉。（所以PUT用来改自愿）
    //@RequestMapping(value = "/api/city", method = RequestMethod.PUT)
}
