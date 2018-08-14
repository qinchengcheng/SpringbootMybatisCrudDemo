package com.giveu.entity;

/**
 * Person 实体类
 * Created by fox on 2018/7/27.
 */
public class Dept {

	private Integer id;

	private String deptName;

	private Integer deptNo;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setPersonName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getDeptNo(){return deptNo;}
	public void setDeptNo(Integer deptNo){this.deptNo=deptNo;}
}
