package com.pines.student.common.sms;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.pines.student.common.Tools;

public class SMS {
	private final String I_SMS_SENDING_URL = "http://www.isms.com.my/isms_send.php";
	private final String I_SMS_USER_NAME = "pinestalking";
	private final String I_SMS_PASSWORD = "pines2023";
	/**
	 * 1 - ASCII (English, Bahasa Melayu, etc) <BR>
	 * 2 - Unicode (Chinese, Japanese, etc)
	 */
	private final int I_SMS_TYPE = 1;
	private final String agreedterm = "YES";
	@Deprecated
	private String I_SMS_SEND_ID = "";
	private String receiverNumber;
	private String message;
	private List<String> receiverNumbers = new ArrayList<String>();

	public String getI_SMS_SENDING_URL() {
		return I_SMS_SENDING_URL;
	}

	public String getI_SMS_USER_NAME() {
		return I_SMS_USER_NAME;
	}

	public String getI_SMS_PASSWORD() {
		return I_SMS_PASSWORD;
	}

	public int getI_SMS_TYPE() {
		return I_SMS_TYPE;
	}

	public String getAgreedterm() {
		return agreedterm;
	}

	public String getI_SMS_SEND_ID() {
		return I_SMS_SEND_ID;
	}

	@Deprecated
	public void setI_SMS_SEND_ID(String i_SMS_SEND_ID) {
		I_SMS_SEND_ID = i_SMS_SEND_ID;
	}

	public String getReceiverNumber() {
		return receiverNumber;
	}

	public void setReceiverNumber(String receiverNumber) {
		this.receiverNumber = receiverNumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getReceiverNumbers() {
		return receiverNumbers;
	}

	public void setReceiverNumbers(List<String> receiverNumbers) {
		this.receiverNumbers = receiverNumbers;
	}

	public void addReceiverNumber(String receiverNumber) {
		this.receiverNumbers.add(receiverNumber);
	}

	public URL getSMSURL() throws MalformedURLException {
		String un = "un=" + Tools.URLEncodeUTF8(getI_SMS_USER_NAME());
		String pwd = "pwd=" + Tools.URLEncodeUTF8(getI_SMS_PASSWORD());
		String type = "type=" + getI_SMS_TYPE();
		String sendid = "sendid=" + getI_SMS_SEND_ID();
		String dstno = "dstno=" + Tools.URLEncodeUTF8(getReceiverNumber());
		String msg = "msg=" + Tools.URLEncodeUTF8(getMessage());
		String agreedterm = "agreedterm=" + getAgreedterm();
		URL url = null;

		StringBuffer sbUrl = new StringBuffer();
		sbUrl.append(getI_SMS_SENDING_URL()).append("?");
		sbUrl.append(un);
		sbUrl.append("&");
		sbUrl.append(pwd);
		sbUrl.append("&");
		sbUrl.append(type);
		sbUrl.append("&");
		sbUrl.append(sendid);
		sbUrl.append("&");
		sbUrl.append(dstno);
		sbUrl.append("&");
		sbUrl.append(msg);
		sbUrl.append("&");
		sbUrl.append(agreedterm);

		try {
			url = new URL(sbUrl.toString());
		} catch (MalformedURLException e) {
			throw e;
		}
		return url;
	}

	public List<URL> getSMSURLList() throws MalformedURLException {
		String un = "un=" + Tools.URLEncodeUTF8(getI_SMS_USER_NAME());
		String pwd = "pwd=" + Tools.URLEncodeUTF8(getI_SMS_PASSWORD());
		String type = "type=" + getI_SMS_TYPE();
		String sendid = "sendid=" + getI_SMS_SEND_ID();
		String msg = "msg=" + Tools.URLEncodeUTF8(getMessage());
		String agreedterm = "agreedterm=" + getAgreedterm();
		StringBuffer sbUrl = new StringBuffer();

		List<URL> results = new ArrayList<URL>();
		URL url = null;
		for (String receiveNumber : receiverNumbers) {
			String dstno = "dstno=" + Tools.URLEncodeUTF8(receiveNumber);

			sbUrl.setLength(0);
			sbUrl.append(getI_SMS_SENDING_URL()).append("?");
			sbUrl.append(un);
			sbUrl.append("&");
			sbUrl.append(pwd);
			sbUrl.append("&");
			sbUrl.append(type);
			sbUrl.append("&");
			sbUrl.append(sendid);
			sbUrl.append("&");
			sbUrl.append(dstno);
			sbUrl.append("&");
			sbUrl.append(msg);
			sbUrl.append("&");
			sbUrl.append(agreedterm);

			try {
				url = new URL(sbUrl.toString());
			} catch (MalformedURLException e) {
				e.printStackTrace();
				continue;
			}
			results.add(url);
		}
		return results;
	}

	@Override
	public String toString() {
		return "SMS [I_SMS_SENDING_URL=" + I_SMS_SENDING_URL + ", I_SMS_USER_NAME=" + I_SMS_USER_NAME + ", I_SMS_PASSWORD=" + I_SMS_PASSWORD + ", I_SMS_TYPE=" + I_SMS_TYPE + ", agreedterm=" + agreedterm + ", I_SMS_SEND_ID=" + I_SMS_SEND_ID + ", receiverNumber=" + receiverNumber
				+ ", message=" + message + "]";
	}

}
