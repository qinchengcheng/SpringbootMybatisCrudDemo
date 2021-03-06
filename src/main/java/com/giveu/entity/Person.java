package com.giveu.entity;

import com.giveu.common.validate.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;

/**
 * Person 实体类
 * Created by fox on 2018/7/27.
 */
public class Person {


	private Integer id;
	@IsEmptyAnnotation(message="员工名称不能为空")
    @MaxSize(message = "员工名称长度过长")
	private String personName;
	@Phone
	private String personPhone;
	@Email
	private String personEmail;
	@IsEmptyAnnotation(message="员工性别不能为空")
	private String personSex;
	@Qq
	private String personQq;

	@MaxSize(message = "员工描述长度过长",max = 300)
	private String personDesc;

	private String personCreateTime;
	@IsEmptyAnnotation(message="员工部门不能为空")
	private Integer deptNo;

	public String getPersonCreateTime() {
		return personCreateTime;
	}

	public void setPersonCreateTime(String personCreateTime) {
		this.personCreateTime = personCreateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonPhone() {
		return personPhone;
	}

	public void setPersonPhone(String personPhone) {
		this.personPhone = personPhone;
	}

	public String getPersonEmail() {
		return personEmail;
	}

	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}

	public String getPersonSex() {
		return personSex;
	}

	public void setPersonSex(String personSex) {
		this.personSex = personSex;
	}

	public String getPersonQq() {
		return personQq;
	}

	public void setPersonQq(String personQq) {
		this.personQq = personQq;
	}

	public String getPersonDesc() {
		return personDesc;
	}

	public void setPersonDesc(String personDesc) {
		this.personDesc = personDesc;
	}
	public Integer getDeptNo(){return deptNo;}
	public void setDeptNo(Integer deptNo){this.deptNo=deptNo;}
}
