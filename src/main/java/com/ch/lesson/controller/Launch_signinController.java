package com.ch.lesson.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ch.lesson.dao.Launch_signinMapper;
import com.ch.lesson.entity.Course;
import com.ch.lesson.entity.Launch_signin;
import com.ch.lesson.entity.Passport;
import com.ch.lesson.entity.User;
import com.ch.lesson.service.CourseIService;
import com.ch.lesson.service.Launch_signinIService;
import com.ch.lesson.service.SigninIService;
import com.ch.lesson.utils.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2019-06-18
 */
@RestController
public class Launch_signinController {
    @Autowired
    private CourseIService courseIService;
    @Autowired
    private Launch_signinIService launch_signinIService;
    @Autowired
    private Launch_signinMapper launch_signinMapper;
    /**
     * 班课创建人发起签到
     * @param currentTime 手机传来的当前时间
     * @param cid 手机传来的班课cid
     * @param session
     * @return
     */
    @RequestMapping(value = "/launch_signin", method = RequestMethod.POST)
    public Object launchSignin(
            @RequestBody Map<String, String> map,
//            @RequestParam(value = "currentTime") String currentTime, @RequestParam(value = "cid")Integer cid,
            HttpSession session) throws ParseException {
        String currentTime = map.get("currentTime");
        String cid1 = map.get("cid");
        Integer cid = Integer.parseInt(cid1);
        System.out.println("!"+currentTime);
        User account = (User) session.getAttribute("account");
        Course course = courseIService.getById(cid);
        ServiceResult result = null;
        if(course==null){
            return new ServiceResult("没有对应班课!",false);
        }
        //如果班课创建人和登录用户相同,有权创建
        if(course.getCreateBy()==account.getId() && currentTime.trim()!=null && currentTime.trim()!="" && cid!=null){
            List<Launch_signin> lists = launch_signinMapper.selectList(
                    new QueryWrapper<Launch_signin>()
                            .lambda().eq(Launch_signin::getCourseId, cid)
            );
            SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            if(!lists.isEmpty()){//当前班课号下有发布的签到了，有可能冲突
                boolean isCreate = true;
                for (Launch_signin ls : lists) {
                    String createDate = ls.getCreateDate();
                    Date createTime = df.parse(createDate);
                    Date now = df.parse(currentTime);
                    now.setTime(now.getTime()-2 * 60 * 1000);//当前的发起时间前两分钟
                    if(now.getTime()<=createTime.getTime()){//当前的发起时间前两分钟小于已有的创建好的发起签到
                        isCreate = false;
                        break;
                    }
                }
                if(isCreate){//可以创建
                    Launch_signin launch_signin = new Launch_signin();
                    launch_signin.setCourseId(cid);
                    launch_signin.setCreateBy(account.getId());
                    launch_signin.setCreateDate(currentTime);
                    boolean save = launch_signinIService.save(launch_signin);
                    if(save){
                        result = new ServiceResult("创建成功！",save);
                    }else{
                        result = new ServiceResult("创建失败！",save);
                    }
                }else{
                    result = new ServiceResult("两分钟内已有发起的签到，无法继续创建！",false);
                }
            }else{//当前班课号下没有发布的签到，直接创建
                Launch_signin launch_signin = new Launch_signin();
                launch_signin.setCourseId(cid);
                launch_signin.setCreateBy(account.getId());
                launch_signin.setCreateDate(currentTime);
                boolean save = launch_signinIService.save(launch_signin);
                if(save){
                    result = new ServiceResult("创建成功！",save);
                }else{
                    result = new ServiceResult("创建失败！",save);
                }
            }
        }else{
            result = new ServiceResult("你不是班课创建人，无权发起签到",false);
        }
        return result;
    }

    /**
     * 查看我的发起签到
     * @param session
     * @return
     */
    @GetMapping("/launch_signin/mylaunch")
    public Object getMylaunch(HttpSession session) {
        User account = (User) session.getAttribute("account");
        List<Launch_signin> list = launch_signinIService.list(
                new QueryWrapper<Launch_signin>().lambda()
                        .eq(Launch_signin::getCreateBy, account.getId())
        );
        ServiceResult result = null;
        if(list.isEmpty()){
            result = new ServiceResult("没有数据！",false);
        }else{
            result = new ServiceResult("查询成功！",true);
            result.addData("data",list);
        }
        return result;
    }
}
