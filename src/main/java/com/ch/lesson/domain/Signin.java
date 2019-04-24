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
    /**
     * 课程，对应dictionary表
     */
	private Integer ClassId;
	private String CreateDate;
	private Integer CreateBy;
	private String ModifyDate;
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

	public Integer getClassId() {
		return ClassId;
	}

	public void setClassId(Integer ClassId) {
		this.ClassId = ClassId;
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
