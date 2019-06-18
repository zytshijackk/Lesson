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
public class Signin extends Model<Signin> {

    private static final long serialVersionUID = 1L;

	@TableId(value="Id", type= IdType.AUTO)
	private Integer Id;
    /**
     * 签到状态
     */
	@TableField("Status")
	private String Status;
    /**
     * 备注
     */
	@TableField("Remark")
	private String Remark;
	@TableField("Time")
	private String Time;
	@TableField("UserId")
	private Integer UserId;

	@TableField("LaunchSigninId")
	private Integer LaunchSigninId;
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

	public String getStatus() {
		return Status;
	}

	public void setStatus(String Status) {
		this.Status = Status;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String Remark) {
		this.Remark = Remark;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String Time) {
		this.Time = Time;
	}

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer UserId) {
		this.UserId = UserId;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getLaunchSigninId() {
		return LaunchSigninId;
	}

	public void setLaunchSigninId(Integer launchSigninId) {
		LaunchSigninId = launchSigninId;
	}

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

	@Override
	protected Serializable pkVal() {
		return this.Id;
	}

}
