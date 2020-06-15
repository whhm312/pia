package com.pines.student.common;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

public class Tools {

	public static boolean isNull(String str) {
		if (str == null) {
			return true;
		}
		return false;
	}

	public static boolean isNull(Object obj) {
		if (obj == null) {
			return true;
		}
		return false;
	}

	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	public static boolean isEmpty(String str) {
		if (isNull(str)) {
			return true;
		}

		if ("".equals(blankInsteadOfNull(str.trim()))) {
			return true;
		}

		return false;
	}

	public static boolean isNotNull(String str) {
		return !isNull(str);
	}

	public static String blankInsteadOfNull(String str) {
		if (isNull(str)) {
			return "";
		}
		return str;
	}

	public static String trim(String str) {
		if (isEmpty(str)) {
			return "";
		}
		return str.trim();
	}

	public static String removeAllSpaces(String str) {
		if (isEmpty(str)) {
			return "";
		}
		return str.trim().replaceAll(" ", "");
	}

	public static String removeAllDoubleSpaces(String str) {
		if (isEmpty(str)) {
			return "";
		}
		return trim(str).replaceAll(" +", " ");
	}

	public static String getOnlyEnglishWithBirth(String str) {
		String regExpKor = "[가-힣]*";
		String regExpSpecial = "[\\+.\\^:,_\\[\\]\\(\\)]";
		str = str.replaceAll(regExpSpecial, " ");
		str = str.replaceAll(regExpKor, "");
		return str;
	}

	public static String getOnlyEnglish(String str) {
		String regExpKor = "[가-힣]*";
		String regExpSpecial = "[\\+.\\^:,_\\[\\]\\(\\)]";
		String regExpNumber = "[0-9]*";
		str = str.replaceAll(regExpSpecial, " ");
		str = str.replaceAll(regExpKor, "");
		str = str.replaceAll(regExpNumber, "");
		return str;
	}

	public static int getInt(String str, int defultValue) {
		if (isEmpty(str)) {
			return defultValue;
		}

		return Integer.valueOf(str);
	}

	public static int getInt(String str) {
		if (isEmpty(str)) {
			return 0;
		}

		return Integer.valueOf(str);
	}

	public static int getInt(Integer integer) {
		if (integer == null) {
			return 0;
		}

		return integer.intValue();
	}

	public static int[] getIntArray(String str) {
		if (isEmpty(str)) {
			return new int[0];
		}

		String[] strArr = str.split(",");
		int[] result = new int[strArr.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = getInt(strArr[i]);
		}
		return result;
	}

	public static boolean getBoolean(String str) {
		if (isEmpty(str)) {
			return false;
		}

		if (!str.toLowerCase().equals("true")) {
			return false;
		}

		return Boolean.parseBoolean(str);
	}

	public static String getUpperCase(String str) {
		if (isEmpty(str)) {
			return "";
		}

		return str.toUpperCase();
	}

	public static String getOnlyNumber(String str) {
		if (isEmpty(str)) {
			return "";
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}

	public static String getWeek(String format, String date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getDate(format, date)); // 하루더한 날자 값을 Calendar 넣는다.

		int dayNum = cal.get(Calendar.DAY_OF_WEEK) - 1; // 요일을 구해온다.

		List<String> week = new ArrayList<String>();
		week.add("Sun");
		week.add("Mon");
		week.add("Tue");
		week.add("Wed");
		week.add("Thu");
		week.add("Fri");
		week.add("Sat");
		// week = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		return Tools.blankInsteadOfNull(week.get(dayNum));
	}

	public static String getTodayStringType(String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(new Date());
	}

	public static Date getToday() {
		return getToday("yyyy/MM/dd");
	}

	public static Date getToday(String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		String formatted = dateFormat.format(new Date());

		Date departDate = new Date();
		try {
			departDate = dateFormat.parse(formatted);
		} catch (Exception e) {
			return departDate;
		}

		return departDate;
	}

	public static Date getDate(String date) {
		return getDate("yyyy/MM/dd", date);
	}

	public static Date getDate(String format, String date) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date departDate = new Date();
		try {
			departDate = dateFormat.parse(date);
		} catch (Exception e) {
			return departDate;
		}
		return departDate;
	}

	public static String changeDateFormat(String date, String originalFormat, String newFormat) {
		Date originalDate = getDate(originalFormat, date);
		DateFormat newDateFormat = new SimpleDateFormat(newFormat);
		try {
			return newDateFormat.format(originalDate);
		} catch (Exception e) {
			return date;
		}
	}

	public static String getTime(long seconds) {
		if (seconds < 1) {
			return "";
		}

		long second = seconds % 60;
		long minute = (seconds / 60) % 60;
		long hour = seconds / 3600;

		String time = String.valueOf(second);
		if (minute < 1 && hour < 1) {
			return time + "sec.";
		} else {
			time = LPad(String.valueOf(minute), 2, "0") + ":" + LPad(time, 2, "0");
			time = LPad(String.valueOf(hour), 2, "0") + ":" + time;
		}

		return time;
	}

	public static String LPad(String str, int totalLength, String addStr) {
		if (isNull(str)) {
			str = "";
		}

		if (str.length() > totalLength) {
			return str;
		}

		int loopCount = totalLength - str.length();
		char[] addStrs = addStr.toCharArray();
		int addStrIndex = 0;

		String loopResult = "";
		for (int i = 0; i < loopCount; i++) {
			loopResult += addStrs[addStrIndex++];

			if (addStrIndex == addStr.length() - 1) {
				addStrIndex = 0;
			}
		}

		return loopResult + str;
	}

	public static String decode(String str) {
		if (isEmpty(str)) {
			return "";
		}

		try {
			return URLDecoder.decode(str, "UTF-8");
		} catch (Exception e) {
			return "";
		}
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

	public static int getStartIndex(int selectedPage, int offset) {
		if (selectedPage == 1) {
			return 0;
		} else {
			return (selectedPage - 1) * offset;
		}
	}

	public static boolean matches(String regex, String str) {
		try {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(str);
			return matcher.matches();
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isNumber(String str) {
		return matches("^[0-9]*$", str);
	}

	public static boolean isYyyyMmDdFormat(String str) {
		String regex = "^[1-2]{1}[0-9]{1}[0-9]{2}[0-1]{1}[0-9]{1}[0-3]{1}[0-9]{1}$";
		return matches(regex, str);
	}

	public static boolean isBirthdayType(String str) {
		String regex = "^[0-9]{2}[0-1]{1}[0-9]{1}[0-3]{1}[0-9]{1}$";
		if (matches(regex, str)) {
			return true;
		} else {
			regex = "^[1-2]{1}[0-9]{1}[0-9]{2}[0-1]{1}[0-9]{1}[0-3]{1}[0-9]{1}$";
			return matches(regex, str);
		}
	}

	public static boolean isOnlyEnglishWithSpace(String str) {
		String regex = "[a-zA-Z\\s]*$";
		return matches(regex, str);
	}

	public static boolean isNotOnlyEnglishWithSpace(String str) {
		return !isOnlyEnglishWithSpace(str);
	}

	public static boolean isOnlyEnglish(String str) {
		String regex = "[a-zA-Z]*$";
		return matches(regex, str);
	}

	public static boolean isNotOnlyEnglish(String str) {
		return !isOnlyEnglish(str);
	}

	public static boolean isOnlyNumber(String str) {
		String regex = "[0-9]*$";
		return matches(regex, str);
	}

	public static boolean isNotOnlyNumber(String str) {
		return !isOnlyNumber(str);
	}

	public static String URLEncodeUTF8(String str) {
		if (isEmpty(str)) {
			return "";
		}
		return URLEncode(str, "UTF-8");
	}

	public static String URLEncode(String str, String URL_ENCODE) {
		if (isEmpty(str)) {
			return "";
		}
		try {
			return URLEncoder.encode(str, URL_ENCODE);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static String subString(int startIndex, int endIndex, String str) {
		if (isEmpty(str)) {
			return "";
		}

		if (startIndex > endIndex) {
			return "";
		}

		if (startIndex < 0) {
			startIndex = 0;
		}

		if (str.length() < endIndex) {
			endIndex = str.length() - 1;
		}

		return str.substring(startIndex, endIndex);
	}

	public static String getPath(String path) {
		if (isWindowPath(path)) {
			return path.replaceAll("\\\\", "/");
		}
		return path;
	}

	public static boolean isWindowPath(String path) {
		return System.getProperty("os.name").toLowerCase().indexOf("win") >= 0;
	}

	public static String getPesoFormat(int money) {
		return "P" + getCommaFormat(money);
	}

	public static String getCommaFormat(int money) {
		try {
			return String.format("%,d", money);
		} catch (Exception e) {
			return "0";
		}
	}
}
