package com.ch.lesson.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ch.lesson.domain.*;
import com.ch.lesson.domain.User;
import com.ch.lesson.domain.User;
import com.ch.lesson.domain.User;
import com.ch.lesson.service.UserIService;
import com.ch.lesson.utils.Result;
import com.ch.lesson.utils.ServiceResult;
import com.ch.lesson.utils.exception.NotFoundException;
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
    @GetMapping(value = "/user")
    public List<User> findAllUser() {
        return userIService.list(new QueryWrapper<>());
    }


    /**
     * 添加user
     * @param user
     */
    //POST请求：后一个请求不会把第一个请求覆盖掉。（所以POST用来增资源）
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Object createUser(@RequestBody User user, HttpSession session) {
        //@RequestBody注解将Http请求正文插入方法中，即将请求中的 datas 写入 user 对象中
        User account = (User) session.getAttribute("account");
        user.setCreateBy(account.getId());
//        user.setCreateBy(1);
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        user.setCreateDate(dateFormat.format(date));
        user.setModifyBy(account.getId());
//        user.setModifyBy(1);
        user.setModifyDate(dateFormat.format(date));
        boolean isSuccess = userIService.save(user);
        if(isSuccess==true){
            return new ServiceResult("用户添加成功！",true);
        }else{
            return new ServiceResult("用户添加失败！",false);
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
