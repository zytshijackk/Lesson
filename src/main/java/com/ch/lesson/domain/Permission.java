package com.ch.lesson.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2019-04-10
 */
public class Permission extends Model<Permission> {

    private static final long serialVersionUID = 1L;

	@TableId(value="Id", type= IdType.AUTO)
	private Integer Id;
	@TableField("Name")
	private String Name;
    /**
     * 菜单排序
     */
	@TableField("Position")
	private Integer Position;
    /**
     * 父节点ID
     */
	@TableField("ParentId")
	private Integer ParentId;
    /**
     * 等级
     */
	@TableField("Level")
	private Integer Level;
    /**
     * 链接
     */
	@TableField("Router")
	private String Router;
	@TableField("CreateDate")
	private String CreateDate;
	@TableField("CreateBy")
	private Integer CreateBy;
	@TableField("ModifyDate")
	private String ModifyDate;
	@TableField("ModifyBy")
	private Integer ModifyBy;


	public Integer getId() {
		return Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public Integer getPosition() {
		return Position;
	}

	public void setPosition(Integer Position) {
		this.Position = Position;
	}

	public Integer getParentId() {
		return ParentId;
	}

	public void setParentId(Integer ParentId) {
		this.ParentId = ParentId;
	}

	public Integer getLevel() {
		return Level;
	}

	public void setLevel(Integer Level) {
		this.Level = Level;
	}

	public String getRouter() {
		return Router;
	}

	public void setRouter(String Router) {
		this.Router = Router;
	}

	public String getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(String CreateDate) {
		this.CreateDate = CreateDate;
	}

	public Integer getCreateBy() {
		return CreateBy;
	}

	public void setCreateBy(Integer CreateBy) {
		this.CreateBy = CreateBy;
	}

	public String getModifyDate() {
		return ModifyDate;
	}

	public void setModifyDate(String ModifyDate) {
		this.ModifyDate = ModifyDate;
	}

	public Integer getModifyBy() {
		return ModifyBy;
	}

	public void setModifyBy(Integer ModifyBy) {
		this.ModifyBy = ModifyBy;
	}

	@Override
	protected Serializable pkVal() {
		return this.Id;
	}


	@Override
	public String toString() {
		return "Permission{" +
				"Id=" + Id +
				", Name='" + Name + '\'' +
				", Position=" + Position +
				", ParentId=" + ParentId +
				", Level=" + Level +
				", Router='" + Router + '\'' +
				", CreateDate='" + CreateDate + '\'' +
				", CreateBy=" + CreateBy +
				", ModifyDate='" + ModifyDate + '\'' +
				", ModifyBy=" + ModifyBy +
				'}';
	}
}
