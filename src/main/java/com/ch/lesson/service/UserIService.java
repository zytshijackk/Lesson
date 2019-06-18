package com.ch.lesson.service;

import com.ch.lesson.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2019-04-10
 */
public interface UserIService extends IService<User> {

    /**
     * 获取课程ID的学生信息
     * @param id
     * @return
     */
    List<User> selectStudentByCourseId(Long id);
}
