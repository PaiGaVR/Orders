package com.example.orders.setting;

import android.media.Image;

public class PrefectInformation {

	// 姓名
	private String name;
	// 性别
	private String sex;
	// 出生年
	private int birthdayYear;
	// 出生月
	private int birthdayMouse;
	// 出生日
	private int birthdayDay;
	// 国籍
	private String nationality;
	// 住址
	private String address;
	// 照片
	private Image photo;
	// 驾龄
	private int dirveAge;

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

	public int getBirthdayYear() {
		return birthdayYear;
	}

	public void setBirthdayYear(int birthdayYear) {
		this.birthdayYear = birthdayYear;
	}

	public int getBirthdayMouse() {
		return birthdayMouse;
	}

	public void setBirthdayMouse(int birthdayMouse) {
		this.birthdayMouse = birthdayMouse;
	}

	public int getBirthdayDay() {
		return birthdayDay;
	}

	public void setBirthdayDay(int birthdayDay) {
		this.birthdayDay = birthdayDay;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Image getPhoto() {
		return photo;
	}

	public void setPhoto(Image photo) {
		this.photo = photo;
	}

}
