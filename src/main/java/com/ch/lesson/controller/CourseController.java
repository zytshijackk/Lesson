package com.ch.lesson.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.ch.lesson.dao.User_courseMapper;
import com.ch.lesson.entity.Course;
import com.ch.lesson.entity.User;
import com.ch.lesson.entity.User_course;
import com.ch.lesson.service.CourseIService;
import com.ch.lesson.service.UserIService;
import com.ch.lesson.service.User_courseIService;
import com.ch.lesson.utils.ServiceResult;
import com.ch.lesson.vo.CourseUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2019-05-11
 */
@RestController
public class CourseController {
    @Autowired
    private CourseIService courseIService;
    @Autowired
    private UserIService userIService;
    @Autowired
    private User_courseMapper user_courseMapper;
    @Autowired
    private User_courseIService user_courseIService;
    /**
     * 移动端查找一个
     * @param id
     * @return Course
     */
    @RequestMapping(value = "/course/getCourseUserVO/{id}", method = RequestMethod.GET)
    public Object findOneCourse(@PathVariable("id") Long id) {
        Course course = courseIService.getById(id);
        if(course!=null){
            User CreateUser = userIService.getById(course.getCreateBy());
            CourseUserVO courseUserVO = new CourseUserVO(course);
            courseUserVO.setCreateUser(CreateUser);
            ServiceResult result = new ServiceResult("查询成功！",true);
            result.addData("data", courseUserVO);
            return result;
        }else{
            return new ServiceResult("查询失败！",false);
        }
    }

    /**
     * 移动端查找所有
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/course/getCourseUserVO/{page}/{size}")
    public Object getAllQuestionWithStudentByPage(@PathVariable Integer page, @PathVariable Integer size) {
        Map<String, Object> map = new HashMap<>();
        Page<CourseUserVO> CourseUserVO = courseIService.getCourseUserVO(new Page<>(page, size));
        if (CourseUserVO.getRecords().size() == 0) {
            return new ServiceResult("没有数据！",false);
        } else {
            ServiceResult result = new ServiceResult("查询成功！", true);
            result.addData("data",CourseUserVO);
            return result;
        }
    }

    /**
     * 添加course
     * @param course
     */
    //POST请求：后一个请求不会把第一个请求覆盖掉。（所以POST用来增资源）
    @RequestMapping(value = "/course", method = RequestMethod.POST)
    public Object createCourse(@RequestBody Course course, HttpSession session) {
        //@RequestBody注解将Http请求正文插入方法中，即将请求中的 datas 写入 course 对象中

        User account = (User) session.getAttribute("account");
        course.setCreateBy(account.getId());
//        course.setCreateBy(1);
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        course.setCreateDate(dateFormat.format(date));
        course.setModifyBy(account.getId());
//        course.setModifyBy(1);
        course.setModifyDate(dateFormat.format(date));
        System.out.println(course.toString());
        boolean isSuccess = courseIService.save(course);
        if(isSuccess==true){
            return new ServiceResult("班课添加成功！",true);
        }else{
            return new ServiceResult("班课添加失败！",false);
        }
    }

    /**
     * 修改
     * @param course
     */
    //PUT请求：如果两个请求相同，后一个请求会把第一个请求覆盖掉。（所以PUT用来改自愿）
    @RequestMapping(value = "/course", method = RequestMethod.PUT)
    public Object modifyCourse(@RequestBody Course course, HttpSession session) {
        User account = (User) session.getAttribute("account");
        course.setModifyBy(account.getId());
//        course.setModifyBy(1);
        //获取当前时间
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        course.setModifyDate(dateFormat.format(date));
        boolean isSuccess = courseIService.updateById(course);
        if(isSuccess==true){
            return new ServiceResult("班课修改成功！",true);
        }else{
            return new ServiceResult("班课修改失败！",false);
        }
    }

    /**
     * 删除
     * @param id
     */
    @RequestMapping(value = "/course/{id}", method = RequestMethod.DELETE)
    public Object modifyCourse(@PathVariable("id") Long id) {
        boolean isSuccess = courseIService.removeById(id);
        if(isSuccess==true){
            return new ServiceResult("班课删除成功！",true);
        }else{
            return new ServiceResult("班课删除失败！",false);
        }
    }

    /**
     * Web查找所有
     * @return
     */
    @GetMapping(value = "/course")
    public Object findAllCourse() {
        List<Course> courses = courseIService.list(new QueryWrapper<>());
        if(courses.isEmpty()!=true){
            ServiceResult result = new ServiceResult("查询成功！",true);
            result.addData("data", courses);
            return result;
        }else{
            return new ServiceResult("查询失败！",false);
        }
    }

    /**
     * 查找一个
     * @param id
     * @return Course
     */
    @RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
    public Object findOneCourse1(@PathVariable("id") Long id) {

        Course course = courseIService.getById(id);
        if(course!=null){
            ServiceResult result = new ServiceResult("查询成功！",true);
            result.addData("data", course);
            return result;
        }else{
            return new ServiceResult("查询失败！",false);
        }
    }

    /**
     * 加入班课
     * @param id
     * @return Course
     */
    @RequestMapping(value = "/course/join/{id}", method = RequestMethod.GET)
    public Object joinCourse(@PathVariable("id") Integer id,HttpSession session) {
        User account = (User) session.getAttribute("account");
        //查询用户是否已加入改班课
        List<User_course> user_courses = user_courseMapper.selectList(
                new QueryWrapper<User_course>().lambda()
                        .eq(User_course::getUserId, account.getId())
                        .eq(User_course::getCourseId, id)
        );
        if(!user_courses.isEmpty()){
            ServiceResult result = new ServiceResult("你已加入该班课，不要重复加入！",false);
            return result;
        }else{
            User_course user_course = new User_course();
            user_course.setCourseId(id);
            user_course.setUserId(account.getId());
            boolean save = user_courseIService.save(user_course);
            if(save){
                ServiceResult result = new ServiceResult("加入班课成功！",true);
                return result;
            }else{
                ServiceResult result = new ServiceResult("加入班课失败！",false);
                return result;
            }
        }
    }

    /**
     * 返回我的课程
     * @return
     */
    @RequestMapping(value = "/course/mycourse", method = RequestMethod.GET)
    public Object myCourse(HttpSession session) {
        User account = (User) session.getAttribute("account");
        List<Course> list = courseIService.getCoursesByUserId(account.getId());
        ServiceResult result = null;
        if(!list.isEmpty()){
            result= new ServiceResult("查找成功", true);
            result.addData("data",list);
        }else{
            result = new ServiceResult("该用户没有参与的课程！", true);
        }
        return result;
    }

    /**
     * 查询班课里的所有学生，不包括老师
     * @return
     */
    @RequestMapping(value = "/course/getStuByCourse/{id}", method = RequestMethod.GET)
    public Object selectStudentByCourseId(@PathVariable("id") Long id) {
        List<User> list = userIService.selectStudentByCourseId(id);
        ServiceResult result = null;
        if(!list.isEmpty()){
            result= new ServiceResult("查找成功", true);
            result.addData("data",list);
        }else{
            result = new ServiceResult("该课程没有学生参与！", true);
        }
        return result;
    }
}
