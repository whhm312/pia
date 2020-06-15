package com.pines.admin;

import java.io.File;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

public class Tools {
	public static String blankInsteadOfNull(String str) {
		if (str == null) {
			return "";
		}
		return str;

	}

	public static int getStartIndex(int selectedPage, int offset) {
		if (selectedPage == 1) {
			return 0;
		} else {
			return (selectedPage - 1) * offset;
		}
	}

	public static void makeDirs(String path) {
		File filePath = new File(path);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
	}

	public static int getInt(Integer integer) {
		if (integer == null) {
			return 0;
		}

		return integer.intValue();
	}

	public static boolean isNull(String str) {
		if (str == null) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(String str) {
		if (isNull(str)) {
			return true;
		}

		if (blankInsteadOfNull(str).equals("")) {
			return true;
		}

		return false;
	}

	public static boolean isNotNull(String str) {
		return !isNull(str);
	}

	public static boolean deleteFile(String filePath) {
		if (Tools.isNotNull(filePath)) {
			File file = new File(filePath);
			if (file.exists()) {
				if (file.delete()) {
					System.out.println("[" + filePath + "] Successed to Delete File.");
					return true;
				} else {
					System.out.println("[" + filePath + "] Failed to Delete File.");
					return false;
				}
			} else {
				System.out.println("[" + filePath + "] It is not File.");
				return false;
			}
		} else {
			System.out.println("[" + filePath + "] filePath is null.");
			return false;
		}
	}

	public static boolean isNumber(String str) {
		return Pattern.matches("^[0-9]*$", str);
	}

	public static Integer getIntegerHttpSessionAttribute(HttpSession httpSession, String attributeName, int defaultNumber) {
		if (httpSession == null) {
			return defaultNumber;
		} else if (httpSession.getAttribute(attributeName) == null) {
			return defaultNumber;
		} else if (httpSession.getAttribute(attributeName) != null) {
			try {
				@SuppressWarnings("unused")
				String attribite = (String) httpSession.getAttribute(attributeName);
			} catch (java.lang.ClassCastException e) {
				return (Integer) httpSession.getAttribute(attributeName);
			}
			return defaultNumber;
		} else {
			return defaultNumber;
		}
	}

	public static String getFileExtension(String filename) {
		if (isNull(filename)) {
			return "";
		}

		if (isEmpty(filename)) {
			return "";
		}

		int dotIndex = filename.lastIndexOf(".");
		if (dotIndex < 0) {
			return "";
		}

		return filename.substring(dotIndex);
	}
}
