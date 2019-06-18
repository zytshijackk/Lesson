package com.ch.lesson.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ch.lesson.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2019-04-10
 */
public interface UserMapper extends BaseMapper<User> {
    User selectUserByCreateId(@Param("createId")Integer createId);

    List<User> selectStudentByCourseId(@Param("courseId")Long id);
}