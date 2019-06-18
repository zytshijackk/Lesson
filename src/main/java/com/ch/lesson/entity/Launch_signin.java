package com.ch.lesson.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2019-06-18
 */
public class Launch_signin extends Model<Launch_signin> {

    private static final long serialVersionUID = 1L;

	@TableId(value="Id", type= IdType.AUTO)
	private Integer Id;
	@TableField("CourseId")
	private Integer CourseId;
	@TableField("CreateBy")
	private Integer CreateBy;
	@TableField("CreateDate")
	private String CreateDate;


	public Integer getId() {
		return Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}

	public Integer getCourseId() {
		return CourseId;
	}

	public void setCourseId(Integer CourseId) {
		this.CourseId = CourseId;
	}

	public Integer getCreateBy() {
		return CreateBy;
	}

	public void setCreateBy(Integer CreateBy) {
		this.CreateBy = CreateBy;
	}


	public String getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(String createDate) {
		CreateDate = createDate;
	}

	@Override
	protected Serializable pkVal() {
		return this.Id;
	}

}
