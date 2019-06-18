package com.ch.lesson.vo;

import com.ch.lesson.entity.Course;
import com.ch.lesson.entity.User;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2019-05-11
 */
public class CourseUserVO {


	private Integer Cid;
	private String Num;
	private String ClassName;
	private String CourseName;
	private String IsSchoolClass;
	private User CreateUser;
//	private String Name;

	public CourseUserVO() {
	}

	public CourseUserVO(Course course) {
		Cid = course.getCid();
		Num = course.getNum();
		ClassName = course.getClassName();
		CourseName = course.getCourseName();
		IsSchoolClass = course.getIsSchoolClass();
	}

//	public String getName() {
//		return Name;
//	}
//
//	public void setName(String name) {
//		Name = name;
//	}


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

	public User getCreateUser() {
		return CreateUser;
	}

	public void setCreateUser(User createUser) {
		CreateUser = createUser;
	}

	public Integer getCid() {
		return Cid;
	}

	public void setCid(Integer cid) {
		Cid = cid;
	}

	@Override
	public String toString() {
		return "CourseUserVO{" +
				"Cid=" + Cid +
				", Num='" + Num + '\'' +
				", ClassName='" + ClassName + '\'' +
				", CourseName='" + CourseName + '\'' +
				", IsSchoolClass='" + IsSchoolClass + '\'' +
				", CreateUser=" + CreateUser +
//				", Name='" + Name + '\'' +
				'}';
	}
}
