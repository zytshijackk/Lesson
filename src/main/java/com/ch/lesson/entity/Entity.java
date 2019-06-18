package com.ch.lesson.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * @Description 通用实体父类
 * @Author zytshijack
 * @Date 2019-05-11 08:48
 * @Version 1.0
 */
public class Entity extends Model<User> {
    @TableField("CreateDate")
    private String CreateDate;
    @TableField("CreateBy")
    private Integer CreateBy;
    @TableField("ModifyDate")
    private String ModifyDate;
    @TableField("ModifyBy")
    private Integer ModifyBy;

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String createDate) {
        CreateDate = createDate;
    }

    public Integer getCreateBy() {
        return CreateBy;
    }

    public void setCreateBy(Integer createBy) {
        CreateBy = createBy;
    }

    public String getModifyDate() {
        return ModifyDate;
    }

    public void setModifyDate(String modifyDate) {
        ModifyDate = modifyDate;
    }

    public Integer getModifyBy() {
        return ModifyBy;
    }

    public void setModifyBy(Integer modifyBy) {
        ModifyBy = modifyBy;
    }
}
