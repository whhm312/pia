package com.pines.student.common.sms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.pines.student.common.Tools;

public class ISMSExample {
	public void main() throws Exception {
		try {
			String user = Tools.URLEncodeUTF8("pinestalking"); // user isms username
			String pass = Tools.URLEncodeUTF8("pines2023"); // user isms password
			String dstno = Tools.URLEncodeUTF8("639159614593"); // You are going compose a message to this destination number.
			String str = "new Request!"; // Your message over here
			String msg = Tools.URLEncodeUTF8(str);
			// String msg = str.replace(" ", "%20");
			/**
			 * Type of SMS 1 - ASCII (English, Bahasa Melayu, etc) 2 - Unicode (Chinese,
			 * Japanese, etc)
			 */
			int type = 1; // for unicode change to 2, normal will the 1.
			String sendid = Tools.URLEncodeUTF8("Pines"); // Malaysia does not support sender id yet.
			// Send data
			// http://www.isms.com.my/isms_send.php?un=pinestalking&pwd=pines2023&type=1&sendid=&dstno=639159614593&msg=Other+I+wonder+when+PIA+clean+my+room%3F+my+room+is+not+cleaned+before..&agreedterm=YES
			// URL myUrl = new
			// URL("http://www.isms.com.my/isms_send.php?un=pinestalking&pwd=pines2023&type=1&sendid=&dstno=639159614593&msg=Other+I+wonder+when+PIA+clean+my+room%3F+my+room+is+not+cleaned+before..&agreedterm=YES");
			// http://www.isms.com.my/isms_send.php?un=" + user + "&pwd=" + pass + "&dstno="
			// + dstno + "&msg=" + msg + "&type=" + type + "&sendid=" + sendid +
			// "&agreedterm=YES
			URL myUrl = new URL("http://www.isms.com.my/isms_send.php?un=" + user + "&pwd=" + pass + "&dstno=" + dstno + "&msg=" + msg + "&type=" + type + "&sendid=" + sendid + "&agreedterm=YES");
			URLConnection conn = myUrl.openConnection();
			conn.setDoOutput(true);
			// Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				// Print the response output...
				System.out.println(line);
			}
			rd.close();

			System.out.println(myUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
