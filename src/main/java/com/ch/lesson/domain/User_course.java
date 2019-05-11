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
 * @since 2019-05-11
 */
public class User_course extends Model<User_course> {

    private static final long serialVersionUID = 1L;

	@TableId(value="Id", type= IdType.AUTO)
	private Integer Id;

	@TableField("CourseId")
	private Integer CourseId;

	@TableField("UserId")
	private Integer UserId;


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

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer UserId) {
		this.UserId = UserId;
	}

	@Override
	protected Serializable pkVal() {
		return this.Id;
	}

}
