package com.ch.lesson.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ch.lesson.entity.Permission;
import com.ch.lesson.dao.PermissionMapper;
import com.ch.lesson.service.PermissionIService;
import com.ch.lesson.utils.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2019-04-10
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionIService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findAllPermission() {
        return permissionMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public TreeNode findTreePermission() {
        List<Permission> list = permissionMapper.selectList(new QueryWrapper<>());
        TreeNode root = new TreeNode(
                list.get(0).getId(),list.get(0).getParentId(),list.get(0).getName()
                ,list.get(0).getRouter(),list.get(0).getPosition());
        TreeNode child = null;
        for (Permission p : list) {
            child = new TreeNode(p.getId(),p.getParentId(),p.getName(),
                    p.getRouter(),p.getPosition());
            root.add(child);
        }
        return root;
    }

    @Override
    public Integer findMaxPositionByParentId(Integer parentId) {
        return permissionMapper.findMaxPositionByParentId(parentId);
    }
}
