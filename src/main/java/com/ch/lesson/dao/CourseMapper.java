package com.ch.lesson.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ch.lesson.domain.Course;
import com.ch.lesson.vo.CourseUserVO;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2019-05-11
 */
public interface CourseMapper extends BaseMapper<Course> {


    /**
     *
     * @param page 翻页对象，可以作为 xml 参数直接使用，传递参数 Page 即自动分页
     * @return
     */
//    @Select("SELECT Course.Cid,Course.Num,Course.ClassName,Course.CourseName," +
//            "Course.IsSchoolClass,Id,No,Name,RoleId,Sex,Phone,Email,DepartmentId," +
//            "U.CreateDate,U.CreateBy,U.ModifyDate,U.ModifyBy" +
//            "FROM Course,User " +
//            "WHERE Course.CreateBy=User.Id")
    List<CourseUserVO> getCourseUserVO(Page page);
}