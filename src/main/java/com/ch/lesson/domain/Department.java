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
 * @since 2019-05-11
 */
public class Department extends Model<Department> {

    private static final long serialVersionUID = 1L;

	@TableId(value="Id", type= IdType.AUTO)
	private Integer Id;
	@TableField("Name")
	private String Name;
	@TableField("SchoolId")
	private Integer SchoolId;


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

	public Integer getSchoolId() {
		return SchoolId;
	}

	public void setSchoolId(Integer SchoolId) {
		this.SchoolId = SchoolId;
	}

	@Override
	protected Serializable pkVal() {
		return this.Id;
	}

}
