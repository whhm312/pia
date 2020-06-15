package com.pines.student.common.sms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ISMSService {
	public boolean send(SMS sms) {
		try {
			URL myUrl = sms.getSMSURL();
			URLConnection conn = myUrl.openConnection();
			conn.setDoOutput(true);
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = null;
			boolean isSuccessed = false;
			while ((line = rd.readLine()) != null) {
				if ("2000 = SUCCESS".equals(line)) {
					isSuccessed = true;
					break;
				} else {
					System.out.println(line);
					System.out.println(myUrl);
					isSuccessed = false;
				}
			}
			rd.close();
			return isSuccessed;
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
			return false;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean sends(SMS sms) {
		try {
			boolean isSuccessed = false;
			List<URL> smsUrlLists = sms.getSMSURLList();
			URLConnection conn = null;
			BufferedReader bufferedReader = null;
			String line = null;
			for (URL myUrl : smsUrlLists) {
				conn = myUrl.openConnection();
				conn.setDoOutput(true);
				bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				while ((line = bufferedReader.readLine()) != null) {
					if ("2000 = SUCCESS".equals(line)) {
						isSuccessed = true;
						break;
					} else {
						System.err.println(line);
						System.err.println(myUrl);
						isSuccessed = false;
					}
				}
				bufferedReader.close();
				conn = null;
				bufferedReader = null;
			}
			return isSuccessed;
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
			return false;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
