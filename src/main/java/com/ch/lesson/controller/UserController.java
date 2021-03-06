package com.ch.lesson.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ch.lesson.entity.*;
import com.ch.lesson.entity.User;
import com.ch.lesson.service.PassportIService;
import com.ch.lesson.service.UserIService;
import com.ch.lesson.utils.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2019-03-31
 */
@RestController
public class UserController {
	@Autowired
    private UserIService userIService;
    @Autowired
    private PassportIService passportIService;

	/**
	 * @Author CH
	 * @Description 返回自定义错误的写法
	 * @Date 8:00 2019/4/26
	 **/
//    @RequestMapping(value = "{id}", method = RequestMethod.GET)
//    public Object findOneUser(@PathVariable("id") Long id) throws NotFoundException {
//        User user = userIService.getById(id);
//        if (user == null)
//        {
//            throw new NotFoundException("user " + id + " is not exist!", Result.ErrorCode.USER_NOT_FOUND.getCode());
//        }
//        return user;
//    }

    /**
     * 查找一个
     * @param id
     * @return User
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Object findOneUser(@PathVariable("id") Long id) {
        User user = userIService.getById(id);
        if(user!=null){
            ServiceResult result = new ServiceResult("查询成功！",true);
            result.addData("data",user);
            return result;
        }else{
            return new ServiceResult("查询失败！",false);
        }
    }

    /**
     * 查找所有
     * @return
     */
    @CrossOrigin//跨源资源共享（CORS）
    @GetMapping(value = "/user")
    public List<User> findAllUser() {
        return userIService.list(new QueryWrapper<>());
    }


    /**
     * 添加user
     * @param user
     */
    //POST请求：后一个请求不会把第一个请求覆盖掉。（所以POST用来增资源）
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public Object createUser(@RequestBody User user, HttpSession session) {
        boolean isSuccess = userIService.save(user);
        if(isSuccess==true){
            if(user.getPassword().trim()!=null && user.getPassword().trim()!=""){
                if(user.getPhone().trim()!=null && user.getPhone().trim()!=""){
                    Passport passport = new Passport(user.getPhone(), user.getPassword(), user.getId(), 1);
                    passportIService.save(passport);
                }
                if(user.getEmail().trim()!=null && user.getEmail().trim()!=""){
                    Passport passport = new Passport(user.getEmail(), user.getPassword(), user.getId(), 2);
                    passportIService.save(passport);
                }
            }
            return new ServiceResult("用户注册成功！",true);
        }else{
            return new ServiceResult("用户注册失败！",false);
        }
    }

    /**
     * 修改
     * @param user
     */
    //PUT请求：如果两个请求相同，后一个请求会把第一个请求覆盖掉。（所以PUT用来改自愿）
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public Object modifyUser(@RequestBody User user, HttpSession session) {
        User account = (User) session.getAttribute("account");
        user.setModifyBy(account.getId());
//        user.setModifyBy(1);
        //获取当前时间
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        user.setModifyDate(dateFormat.format(date));
        boolean isSuccess = userIService.updateById(user);
        if(isSuccess==true){
            return new ServiceResult("用户修改成功！",true);
        }else{
            return new ServiceResult("用户修改失败！",false);
        }
    }

    /**
     * 删除
     * @param id
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public Object modifyUser(@PathVariable("id") Long id) {
        boolean isSuccess = userIService.removeById(id);
        if(isSuccess==true){
            return new ServiceResult("用户删除成功！",true);
        }else{
            return new ServiceResult("用户删除失败！",false);
        }
    }

}
