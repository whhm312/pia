package com.pines.student.common;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import org.springframework.web.multipart.MultipartFile;

import com.pines.student.common.vo.UploadFile;

public class FileTools {

	public static UploadFile upload(MultipartFile multipartFile, String path) {
		if (multipartFile == null || multipartFile.isEmpty()) {
			return new UploadFile();
		}
		long newFilename = System.currentTimeMillis();
		String originalFilename = multipartFile.getOriginalFilename();
		String fileExt = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
		String filePath = path + newFilename + "." + fileExt;

		makeDirs(path);

		File file = new File(filePath);

		UploadFile uploadFile = new UploadFile();
		uploadFile.setFilePath(filePath);
		uploadFile.setFileSize(file.length());
		uploadFile.setFile(file);
		uploadFile.setOriginalFilename(originalFilename);
		uploadFile.setFileDownloadUrl(filePath);
		return uploadFile;
	}

	public static void makeDirs(String path) {
		File filePath = new File(path);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
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

	public static String getFileExtension(String filename) {
		if (Tools.isNull(filename)) {
			return "";
		}

		if (Tools.isEmpty(filename)) {
			return "";
		}

		int dotIndex = filename.lastIndexOf(".");
		if (dotIndex < 0) {
			return "";
		}

		return filename.substring(dotIndex);
	}

	public static String getDownloadFilename(String fileName, String ext) {
		if (Tools.isEmpty(fileName) || Tools.isEmpty(ext)) {
			return "";
		}

		if (fileName.lastIndexOf(".") > 0) {
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		}

		if (ext.indexOf(".") > -1) {
			fileName += ext;
		} else {
			fileName += ".";
			fileName += ext;
		}
		
		fileName = replaceAllBlankToUnderbar(fileName);
		try {
			fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
		}
		
		return fileName;
	}

	public static String getUploadFilename(String staffId, String ext) {
		Calendar calendar = Calendar.getInstance();
		StringBuffer newFilename = new StringBuffer();
		newFilename.append(calendar.get(Calendar.YEAR));
		newFilename.append(calendar.get(Calendar.MONTH) + 1);
		newFilename.append(calendar.get(Calendar.DAY_OF_MONTH));
		newFilename.append(calendar.get(Calendar.HOUR_OF_DAY));
		newFilename.append(calendar.get(Calendar.MINUTE));
		newFilename.append(calendar.get(Calendar.SECOND));
		newFilename.append("-");
		newFilename.append(staffId);
		newFilename.append(ext);
		return newFilename.toString();
	}

	public static String replaceAllBlankToUnderbar(String str) {
		if (Tools.isEmpty(str)) {
			return "";
		}

		str = str.replaceAll("%20", "_");
		return str.replaceAll(" ", "_");
	}
}
