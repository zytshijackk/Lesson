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
public class Passport extends Model<Passport> {

    private static final long serialVersionUID = 1L;

	@TableId(value="Id", type= IdType.AUTO)
	private Integer Id;
	@TableField("Username")
	private String Username;
	@TableField("Password")
	private String Password;
	@TableField("UserId")
	private Integer UserId;
    /**
     * 登陆用户类型:手机号、邮箱
     */
	@TableField("Type")
	private Integer Type;
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

	public String getUsername() {
		return Username;
	}

	public void setUsername(String Username) {
		this.Username = Username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer UserId) {
		this.UserId = UserId;
	}

	public Integer getType() {
		return Type;
	}

	public void setType(Integer Type) {
		this.Type = Type;
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
