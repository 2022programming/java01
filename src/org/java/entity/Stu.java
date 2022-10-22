package org.java.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生实体类
 * 
 * @author FanShengSheng
 * @version
 */
public class Stu implements Serializable {

	private Integer stuId;// 学生编号
	private String stuName;// 学生名称
	private Character stuGender;// 学生性别
	private Date stuBirthday;//学生出生日期

	public Integer getStuId() {
		return stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Character getStuGender() {
		return stuGender;
	}

	public void setStuGender(Character stuGender) {
		this.stuGender = stuGender;
	}

	public Date getStuBirthday() {
		return stuBirthday;
	}

	public void setStuBirthday(Date stuBirthday) {
		this.stuBirthday = stuBirthday;
	}

}
