package com.pines.student.student.vo;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.Request;

public class RequestBasicInformationRequest {
	private String nationality;
	private String passportSurname;
	private String passportGivennames;
	private String name;
	private String dateOfBirth;
	private String sex;

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPassportSurname() {
		return passportSurname;
	}

	public void setPassportSurname(String passportSurname) {
		this.passportSurname = passportSurname;
	}

	public String getPassportGivennames() {
		return passportGivennames;
	}

	public void setPassportGivennames(String passportGivennames) {
		this.passportGivennames = passportGivennames;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "RequestBasicInformationRequest [nationality=" + nationality + ", passportSurname=" + passportSurname + ", passportGivennames=" + passportGivennames + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", sex=" + sex + "]";
	}

	public Request getRequest(int branchSeq, String studentId) {
		StringBuffer detail = new StringBuffer();
		detail.append("Please change student's basic information.");
		detail.append("</br>");
		detail.append("nationality : ");
		detail.append(Tools.blankInsteadOfNull(nationality));
		detail.append("</br>");
		detail.append("name : ");
		detail.append(Tools.blankInsteadOfNull(name));
		// detail.append("</br>");
		// detail.append("surname : ");
		// detail.append(Tools.blankInsteadOfNull(passportSurname));
		// detail.append("</br>");
		// detail.append("given names : ");
		// detail.append(Tools.blankInsteadOfNull(passportGivennames));
		detail.append("</br>");
		detail.append("sex : ");
		detail.append(Tools.blankInsteadOfNull(sex));
		detail.append("</br>");
		detail.append("date Of Birth : ");
		detail.append(Tools.blankInsteadOfNull(dateOfBirth));

		Request request = new Request();
		request.setBranchSeq(branchSeq);
		request.setStudentId(studentId);
		request.setDetail(detail.toString());
		request.setType("Info");
		return request;
	}

}
