package com.ch.lesson.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ch.lesson.entity.Course;
import com.ch.lesson.vo.CourseUserVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2019-05-11
 */
public interface CourseIService extends IService<Course> {

    /**
     * 分页得到 所有课程和对应创建者信息
     * @param objectPage
     * @return
     */
    Page<CourseUserVO> getCourseUserVO(Page<CourseUserVO> objectPage);

    /**
     * 通过用户id找到其所有的课程信息
     * @param id
     * @return
     */
    List<Course> getCoursesByUserId(Integer id);
}
