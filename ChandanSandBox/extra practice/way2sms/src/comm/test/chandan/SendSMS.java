package comm.test.chandan;

import com.way2sms.SMS;

public class SendSMS {

	
	public static void main(String[] args) {

		SMS smsClient=new SMS();
		smsClient.send( "7795574824", "aditya", "7795574824", "hi chandan","");
	}

}
