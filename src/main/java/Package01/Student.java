package com.temp.Hibernate_Project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stud_id")
	private Integer studId;
	@Column(name = "stud_name")
	private String studName;
	@Column(name = "stud_fee")
	private Integer studFee;
	public Integer getStudId() {
		return studId;
	}
	public void setStudId(Integer studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public Integer getStudFee() {
		return studFee;
	}
	public void setStudFee(Integer studFee) {
		this.studFee = studFee;
	}
	

}
