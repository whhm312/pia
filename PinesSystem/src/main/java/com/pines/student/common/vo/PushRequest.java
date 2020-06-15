package com.pines.student.common.vo;

import com.pines.student.common.Tools;

public class PushRequest {
	public enum DEVICE_TYPE {
		ANDROID, IOS
	}

	private final String DEFAULT_TITLE = "Pines International Academy";
	private final String DEFAULT_SITE = "http://pinesportal.com/02_03_00_education.html";
	private String message;
	private String title;
	private String imageUrl;
	private String site;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTitle() {
		return Tools.isEmpty(title) ? DEFAULT_TITLE : title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSite() {
		return Tools.isEmpty(site) ? DEFAULT_SITE : site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@Override
	public String toString() {
		return "Push [message=" + message + ", title=" + getTitle() + ", imageUrl=" + imageUrl + ", site=" + getSite() + "]";
	}

}
