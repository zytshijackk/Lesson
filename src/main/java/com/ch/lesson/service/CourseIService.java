package com.ch.lesson.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ch.lesson.domain.Course;
import com.ch.lesson.vo.CourseUserVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2019-05-11
 */
public interface CourseIService extends IService<Course> {

    Page<CourseUserVO> getCourseUserVO(Page<CourseUserVO> objectPage);
}
