package com.ch.lesson.service;

import com.ch.lesson.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ch.lesson.utils.TreeNode;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2019-04-10
 */
public interface PermissionIService extends IService<Permission> {

    List<Permission> findAllPermission();
    TreeNode findTreePermission();

    Integer findMaxPositionByParentId(Integer parentId);
}
