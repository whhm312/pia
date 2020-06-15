package com.pines.student.common.download.attachment;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pines.student.common.FileTools;
import com.pines.student.common.Tools;
import com.pines.student.common.code.ResultCode;
import com.pines.student.common.response.CommonResponseResult;

@RestController
public class FileDownloadController {

	@GetMapping("/filedownload")
	public CommonResponseResult profilePicture(DownloadFileRequest request, HttpServletResponse response) throws IOException {
		CommonResponseResult result = new CommonResponseResult();
		System.out.println("[FILE DOWNLOAD] : " + request.toString());

		if (Tools.isEmpty(request.getFilePath())) {
			result.setFailureHead(ResultCode.STATUS_400);
			return result;
		}

		File file = new File(request.getFilePath());
		if (!file.isFile()) {
			result.setFailureHead(ResultCode.STATUS_204);
			return result;
		}

		String fileName = Tools.decode(request.getFileName());
		if (Tools.isEmpty(fileName)) {
			fileName = file.getName();
		} else {
			fileName = FileTools.getDownloadFilename(fileName, FileTools.getFileExtension(file.getName()));
			if (Tools.isEmpty(fileName)) {
				fileName = file.getName();
			}
		}
		System.out.println("[FILE DOWNLOAD] : file name is " + fileName);

		response.setContentLength((int) file.length());
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

		ServletOutputStream outStream = response.getOutputStream();
		byte[] bbuf = new byte[(int) file.length() + 1024];
		InputStream targetStream = new FileInputStream(file);
		DataInputStream in = new DataInputStream(targetStream);

		int length = 0;
		while ((in != null) && ((length = in.read(bbuf)) != -1)) {
			outStream.write(bbuf, 0, length);
		}

		in.close();
		outStream.flush();

		result.setSuccessHead();
		result.setSuccessBody();
		return result;
	}
}
