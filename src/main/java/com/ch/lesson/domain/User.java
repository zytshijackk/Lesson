package com.ch.lesson.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2019-04-10
 */
public class User extends Entity{

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
    @TableField("Sex")
	private String Sex;
	@TableField("Phone")
	private String Phone;
	@TableField("Email")
	private String Email;
    @TableField("DepartmentId")
	private  Integer DepartmentId;


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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public Integer getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        DepartmentId = departmentId;
    }
}
