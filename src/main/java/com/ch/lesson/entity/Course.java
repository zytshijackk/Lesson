package com.ch.lesson.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2019-05-11
 */
public class Course extends Entity {

    private static final long serialVersionUID = 1L;

	@TableId(value="Cid")
	private Integer Cid;
	@TableField("Num")
	private String Num;
	@TableField("ClassName")
	private String ClassName;
	@TableField("CourseName")
	private String CourseName;
	@TableField("IsSchoolClass")
	private String IsSchoolClass;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getCid() {
		return Cid;
	}

	public void setCid(Integer cid) {
		Cid = cid;
	}

	public String getNum() {
		return Num;
	}

	public void setNum(String num) {
		Num = num;
	}

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public String getIsSchoolClass() {
		return IsSchoolClass;
	}

	public void setIsSchoolClass(String isSchoolClass) {
		IsSchoolClass = isSchoolClass;
	}

	@Override
	public String toString() {
		return "Course{" +
				"Cid=" + Cid +
				", Num='" + Num + '\'' +
				", ClassName='" + ClassName + '\'' +
				", CourseName='" + CourseName + '\'' +
				", IsSchoolClass='" + IsSchoolClass + '\'' +
				'}';
	}
}
