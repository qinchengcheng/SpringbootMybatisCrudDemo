package com.giveu.responEntity;

/**
 * Person 实体类
 * Created by fox on 2018/7/27.
 */
public class ResponPerson {

	private Integer id;

	private String personName;

	private String personPhone;

	private String personEmail;

	private String personSex;

	private String personQq;

	private String personDesc;

	private String personCreateTime;
	private Integer deptNo;
	private String deptName;

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
	public String getDeptName(){return deptName;}
	public void setDeptName(String deptName){this.deptName=deptName;}
}
