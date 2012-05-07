package com.chandan.br;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context ctx, Intent intent) {
		Bundle extras = intent.getExtras();
		Toast.makeText(ctx, "sms received", Toast.LENGTH_LONG).show();
		Log.i("BR", "sms received.");

		Object messages[] = (Object[]) extras.get("pdus");
		SmsMessage smsMessage[] = new SmsMessage[messages.length];
		for (int n = 0; n < messages.length; n++) {
			smsMessage[n] = SmsMessage.createFromPdu((byte[]) messages[n]);
		}

		// show first message
		Toast toast = Toast.makeText(ctx,
				"Received SMS: " + smsMessage[0].getMessageBody(),
				Toast.LENGTH_LONG);
		toast.show();

		Intent i = new Intent(ctx, AlarmActivity.class);
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		ctx.startActivity(i);
	}

}
