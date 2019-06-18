package com.ch.lesson.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ch.lesson.dao.Launch_signinMapper;
import com.ch.lesson.entity.Course;
import com.ch.lesson.entity.Launch_signin;
import com.ch.lesson.entity.Signin;
import com.ch.lesson.entity.User;
import com.ch.lesson.service.CourseIService;
import com.ch.lesson.service.Launch_signinIService;
import com.ch.lesson.service.SigninIService;
import com.ch.lesson.utils.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2019-04-10
 */
@RestController
public class SigninController {
    @Autowired
    private Launch_signinMapper launch_signinMapper;
    @Autowired
    private Launch_signinIService launch_signinIService;
    @Autowired
    private SigninIService signinIService;
    @Autowired
    private CourseIService courseIService;
    /**
     * 根据传来的时间，判断是否有可签到的发起签到
     * @param currentTime 手机传来的当前时间
     * @param cid  手机传来的班课cid
     * @return
     */
    @RequestMapping(value = "/signin/join", method = RequestMethod.POST)
    public Object joinSignin(@RequestParam(value = "currentTime") String currentTime,@RequestParam(value = "cid")Integer cid, HttpSession session) throws ParseException {
        User account = (User) session.getAttribute("account");
        Course currentCourse = courseIService.getById(cid);
        if(currentCourse.getCreateBy()==account.getId()){
            return new ServiceResult("你是班课创建者，不能参与签到！",false);
        }
        ServiceResult result = null;
        //找到所有cid对应的发布签到
        List<Launch_signin> lists = launch_signinMapper.selectList(
                new QueryWrapper<Launch_signin>()
                        .lambda().eq(Launch_signin::getCourseId, cid)
        );
        SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        if(!lists.isEmpty()){
            for (Launch_signin ls : lists) {
                String createDate = ls.getCreateDate();
                Date createTime = df.parse(createDate);
                Date now = df.parse(currentTime);
                //已发起时间 <= 当前时间 <= 已发起时间+2分钟（定了默认值）
                if(now.getTime()>=createTime.getTime() &&
                    now.getTime()<=createTime.getTime()+2 * 60 * 1000){
                    List<Signin> list = signinIService.list(new QueryWrapper<Signin>()
                            .lambda().eq(Signin::getUserId, account.getId()));
                    if(!list.isEmpty()){
                        for (Signin signin : list) {
                            Launch_signin launch = launch_signinIService.getById(signin.getLaunchSigninId());
                            if(launch!=null) {
                                if (launch.getCourseId() == cid) {//当前用户在两分钟内已经有当前课程Id对应的签到了
                                    return new ServiceResult("不要重复签到！", false);
                                }
                            }
                        }
                    }
                    Signin signin = new Signin();
                    signin.setLaunchSigninId(ls.getId());
                    signin.setStatus("已签到");
                    signin.setUserId(account.getId());
                    signin.setTime(currentTime);
                    signinIService.save(signin);
                    result = new ServiceResult("签到成功",true);
                    return result;
                }
            }
        }
        result = new ServiceResult("没有可参与的签到",false);
        return result;
    }
}
