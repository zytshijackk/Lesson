package com.ch.lesson.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ch.lesson.dao.CourseMapper;
import com.ch.lesson.domain.Course;
import com.ch.lesson.service.CourseIService;
import com.ch.lesson.vo.CourseUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2019-05-11
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseIService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public Page<CourseUserVO> getCourseUserVO(Page<CourseUserVO> page) {
        List<CourseUserVO> courseUserVO = courseMapper.getCourseUserVO(page);
        for (CourseUserVO userVO : courseUserVO) {
            System.out.println(userVO);
        }
        return page.setRecords(courseMapper.getCourseUserVO(page));
    }
}
