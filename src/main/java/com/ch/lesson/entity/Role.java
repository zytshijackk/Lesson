package com.ch.lesson.entity;

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
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

	@TableId(value="Id", type= IdType.AUTO)
	private Integer Id;
	@TableField("Name")
	private String Name;
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

}
