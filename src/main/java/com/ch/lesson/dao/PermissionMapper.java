package com.ch.lesson.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ch.lesson.domain.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2019-04-10
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    Integer findMaxPositionByParentId(@Param("parentId")Integer parentId);

}