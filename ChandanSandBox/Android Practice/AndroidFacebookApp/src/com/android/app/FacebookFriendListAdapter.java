package com.android.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.app.core.IResponseHandler;
import com.android.app.core.QueueManager;

public class FacebookFriendListAdapter extends BaseAdapter {

	private Context context;
	private String[] users;

	public FacebookFriendListAdapter(Context context, String[] users) {
		super();
		this.context = context;
		this.users = users;

	}

	@Override
	public int getCount() {
		return users.length;
	}

	@Override
	public Object getItem(int position) {
		return users[position];
	}

	@Override
	public long getItemId(int position) {
		return users[position].hashCode();
	}
	
	

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewGroup view;

		if (convertView == null) {
			Log.i("CA", "getView::Instantiating @" + position);
			LayoutInflater li = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = (ViewGroup) li.inflate(R.layout.list_item, null, false);
		} else {
			Log.i("CA", "getView::Reusing @" + position);
			view = (ViewGroup) convertView;
		}

		Object tag = getItem(position);
		view.setTag(tag);
		final ImageView imageview = (ImageView) view.findViewById(R.id.iv);
		((TextView) view.findViewById(R.id.tv)).setText("List => "
				+ tag);

		String url = "http://graph.facebook.com/" + tag
				+ "/picture";

		final View vview = view;

		ThumbnailCommand command = new ThumbnailCommand(1234, url, new IResponseHandler() {
			@Override
			public void onResponse(int code, Object tag, Object response) {
				Log.i("CA", "onResponse: => tag: " + tag + "");
				if(vview.getTag() != null && vview.getTag().equals(tag)){
					Log.i("CA", "\t Tags were same, using");
					imageview.setImageBitmap((Bitmap) response);
				} else {
					Log.i("CA", "\t Tags were not same, discarding");
				}
			}
		}, tag);
		try {
			QueueManager.get().addQueue(command);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return view;
	}

	static interface IWebCallback {
		void onResponse();
	}

	// private void loadImageFromWeb(final String url, final IWebCallback
	// callback) {
	// Log.i("CA", "Fetching image");
	//
	// try {
	// Runnable runnable = new Runnable() {
	//
	// @Override
	// public void run() {
	//
	// try {
	// HttpGet request = new HttpGet(url);
	// HttpClient client = new DefaultHttpClient();
	// HttpResponse response = client.execute(request);
	//
	// InputStream input = response.getEntity().getContent();
	// bmp = BitmapFactory.decodeStream(input);
	// callback.onResponse();
	// } catch (MalformedURLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }
	// };
	// Thread t = new Thread(runnable);
	// t.start();
	// // runnable.run();
	// Log.i("CA", "Created image from stream");
	// } catch (Exception e) {
	// // TODO handle error
	// Log.i("CA", "Error fetching image");
	// System.out.println("Exception : " + e);
	// }
	// }

}
