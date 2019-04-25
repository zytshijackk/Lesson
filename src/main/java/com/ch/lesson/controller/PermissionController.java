package com.ch.lesson.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.ch.lesson.domain.Permission;
import com.ch.lesson.domain.User;
import com.ch.lesson.service.PermissionIService;
import com.ch.lesson.utils.ServiceResult;
import com.ch.lesson.utils.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2019-04-10
 */
@RestController
public class PermissionController {

    @Autowired
    private PermissionIService permissionIService;

    /**
     * 查找一个
     * @param id
     * @return Permission
     */
    @RequestMapping(value = "/permission/{id}", method = RequestMethod.GET)
    public Object findOnePermission(@PathVariable("id") Long id) {
        Permission permission = permissionIService.getById(id);
        if(permission!=null){
            ServiceResult result = new ServiceResult("查询成功！",true);
            result.addData("data",permission);
            return result;
        }else{
            return new ServiceResult("查询失败！",false);
        }
    }

    /**
     * 查找所有
     * @return
     */
    @GetMapping(value = "/permission")
    public List<Permission> findAllPermission() {
        return permissionIService.findAllPermission();
    }

    //获取菜单树
    @GetMapping(value = "/permission/tree")
    public TreeNode findTreePermission() {
        return permissionIService.findTreePermission();
    }


    /**
     * 添加permission
     * @param permission
     */
    //POST请求：后一个请求不会把第一个请求覆盖掉。（所以POST用来增资源）
    @RequestMapping(value = "/permission", method = RequestMethod.POST)
    public Object createPermission(@RequestBody Permission permission, HttpSession session) {
        //@RequestBody注解将Http请求正文插入方法中，即将请求中的 datas 写入 permission 对象中
        User account = (User) session.getAttribute("account");
        permission.setCreateBy(account.getId());
//        permission.setCreateBy(1);
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        permission.setCreateDate(dateFormat.format(date));
        permission.setModifyBy(account.getId());
//        permission.setModifyBy(1);
        permission.setModifyDate(dateFormat.format(date));
        Integer maxPositionByParentId = permissionIService.findMaxPositionByParentId(permission.getParentId());
        if(maxPositionByParentId==null){//表示父节点下没有子节点
            maxPositionByParentId=0;
        }
        permission.setPosition(maxPositionByParentId+1);
        //通过父节点的level+1表示自己的level（等级），parentId==0时表示没有父节点（根）
        Integer parentId = permission.getParentId();
        if(parentId==0){//不允许再建根节点
            return new ServiceResult("根节点只有一个，不能创建！",false);
        }else{
            Integer parentLevel = permissionIService.getById(parentId).getLevel();
            permission.setLevel(parentLevel+1);
        }
        boolean isSuccess = permissionIService.save(permission);
        if(isSuccess==true){
            return new ServiceResult("菜单添加成功！",true);
        }else{
            return new ServiceResult("菜单添加失败！",false);
        }
    }

    /**
     * 修改
     * @param permission
     */
    //PUT请求：如果两个请求相同，后一个请求会把第一个请求覆盖掉。（所以PUT用来改自愿）
    @RequestMapping(value = "/permission", method = RequestMethod.PUT)
    public Object modifyPermission(@RequestBody Permission permission, HttpSession session) {
        System.out.println(permission.toString());
        User account = (User) session.getAttribute("account");
        permission.setModifyBy(account.getId());
//        permission.setModifyBy(1);
        //获取当前时间
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        permission.setModifyDate(dateFormat.format(date));
        System.out.println(permission);
        boolean isSuccess = permissionIService.updateById(permission);
        if(isSuccess==true){
            return new ServiceResult("菜单修改成功！",true);
        }else{
            return new ServiceResult("菜单修改失败！",false);
        }
    }

    /**
     * 删除
     * @param id
     */
    @RequestMapping(value = "/permission/{id}", method = RequestMethod.DELETE)
    public Object modifyPermission(@PathVariable("id") Long id) {
        boolean isSuccess = permissionIService.removeById(id);
        if(isSuccess==true){
            return new ServiceResult("菜单删除成功！",true);
        }else{
            return new ServiceResult("菜单删除失败！",false);
        }
    }

}
