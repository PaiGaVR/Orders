package com.example.orders.setting;

public class PrefectInformation {

	// 姓名
	private String name;
	// 性别
	private String sex;
	// 出生日期
	private String brithday;
	// 照片
	private int dirveAge;

	public String getBrithday() {
		return brithday;
	}

	public void setBrithday(String brithday) {
		this.brithday = brithday;
	}

	public int getDirveAge() {
		return dirveAge;
	}

	public void setDirveAge(int dirveAge) {
		this.dirveAge = dirveAge;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
