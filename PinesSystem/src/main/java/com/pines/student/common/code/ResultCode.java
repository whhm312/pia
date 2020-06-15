package com.pines.student.common.code;

public enum ResultCode {
	STATUS_200(200, "OK."), 
	STATUS_204(204, "No Content."),

	STATUS_400(400, "Bad Request."), 
	STATUS_401(401, "Unauthorized."), 
	STATUS_403(403, "Forbidden."), 
	STATUS_404(404, "Not Found."), 
	STATUS_405(405, "Method Not Allowed."),
	STATUS_406(406, "Not Acceptable."),
	STATUS_413(413, "Request Entity Too Large."),

	STATUS_10001(10001, "Unknown Level Information. (\"Levels\" and \"Timetable\" should have same level names."),
	STATUS_10002(10002, "The Information is Duplicated."),
	STATUS_10003(10003, "Already Applied the Exam."),
	STATUS_10004(10004, "Closed Appling the Exam."),
	STATUS_10005(10005, "Closed Canceling the Exam."),
	STATUS_10006(10006, "Wrong Password."),
	STATUS_10007(10007, "Registering new Student had a problem after register in POS System."),
	STATUS_10008(10008, "The student is already registered in POS System."),
	STATUS_10009(10009, "The student does not have ID card Information."),
	
	STATUS_500(500, "Internal Server Error."), 
	STATUS_500_DB(500, "Internal DB Error.");

	private int status;
	private String message;

	ResultCode(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

}
