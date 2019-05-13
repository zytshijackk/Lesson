package com.ch.lesson.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

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

	@TableId(value="Id", type= IdType.AUTO)
	private Integer Id;
	@TableField("ClassName")
	private String ClassName;
	@TableField("CourseName")
	private String CourseName;
    /**
     * 所属学期
     */
	@TableField("Semester")
	private String Semester;
    /**
     * 学习要求
     */
	@TableField("Demand")
	private String Demand;
    /**
     * “教学进度”
     */
	@TableField("Process")
	private String Process;
    /**
     * 考试安排
     */
	@TableField("Exam")
	private String Exam;


	public Integer getId() {
		return Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String ClassName) {
		this.ClassName = ClassName;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String CourseName) {
		this.CourseName = CourseName;
	}

	public String getSemester() {
		return Semester;
	}

	public void setSemester(String Semester) {
		this.Semester = Semester;
	}

	public String getDemand() {
		return Demand;
	}

	public void setDemand(String Demand) {
		this.Demand = Demand;
	}

	public String getProcess() {
		return Process;
	}

	public void setProcess(String Process) {
		this.Process = Process;
	}

	public String getExam() {
		return Exam;
	}

	public void setExam(String Exam) {
		this.Exam = Exam;
	}


	@Override
	protected Serializable pkVal() {
		return this.Id;
	}

}
