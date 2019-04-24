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
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

	@TableId(value="Id", type= IdType.AUTO)
	private Integer Id;
    /**
     * 学号和工号
     */
	@TableField("No")
	private String No;
	@TableField("Name")
	private String Name;
    /**
     * 角色
     */
	@TableField("RoleId")
	private Integer RoleId;
	@TableField("Phone")
	private String Phone;
	@TableField("Email")
	private String Email;
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

	public String getNo() {
		return No;
	}

	public void setNo(String No) {
		this.No = No;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public Integer getRoleId() {
		return RoleId;
	}

	public void setRoleId(Integer RoleId) {
		this.RoleId = RoleId;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String Phone) {
		this.Phone = Phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
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
		return "User{" +
				"Id=" + Id +
				", No='" + No + '\'' +
				", Name='" + Name + '\'' +
				", RoleId=" + RoleId +
				", Phone='" + Phone + '\'' +
				", Email='" + Email + '\'' +
				", CreateDate='" + CreateDate + '\'' +
				", CreateBy=" + CreateBy +
				", ModifyDate='" + ModifyDate + '\'' +
				", ModifyBy=" + ModifyBy +
				'}';
	}
}
