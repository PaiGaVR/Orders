package com.example.orders.push;

public class PusherGetGetter {
	private int icon_id;
	private String name;
	private String pushNum;
	private String GetNum;
	private String GloryNum;

	public PusherGetGetter() {

	}

	public PusherGetGetter(String name, String pushNum, String GetNum,
			String GloryNum) {
		this.name = name;
		this.pushNum = pushNum;
		this.GetNum = GetNum;
		this.GloryNum = GloryNum;
	}

	public int getIcon_id() {
		return icon_id;
	}

	public void setIcon_id(int icon_id) {
		this.icon_id = icon_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPushNum() {
		return pushNum;
	}

	public void setPushNum(String pushNum) {
		this.pushNum = pushNum;
	}

	public String getGetNum() {
		return GetNum;
	}

	public void setGetNum(String getNum) {
		GetNum = getNum;
	}

	public String getGloryNum() {
		return GloryNum;
	}

	public void setGloryNum(String gloryNum) {
		GloryNum = gloryNum;
	}

}
