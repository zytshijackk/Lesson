package com.ch.lesson.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ch.lesson.domain.User;
import org.apache.ibatis.annotations.Param;

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
}