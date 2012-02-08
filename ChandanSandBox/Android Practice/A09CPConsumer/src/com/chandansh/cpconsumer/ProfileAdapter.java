package com.chandansh.cpconsumer;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ProfileAdapter extends BaseAdapter {

	private Context ctx;
	private List<Profile> profile;

	public ProfileAdapter(Context context, List<Profile> profile) {
		this.ctx = context;
		this.profile = profile;
	}

	@Override
	public int getCount() {
		return profile.size();
	}

	@Override
	public Object getItem(int position) {
		return profile.get(position);
	}

	@Override
	public long getItemId(int position) {
		return profile.get(position).hashCode();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewGroup view;

		if (convertView == null) {
			//Log.i("CA", "getView::Instantiating @" + position);
			LayoutInflater li = (LayoutInflater) ctx
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = (ViewGroup) li.inflate(R.layout.profile_item, null, false);
		} else {
			//Log.i("CA", "getView::Reusing @" + position);
			view = (ViewGroup) convertView;
		}
		Profile item = (Profile) getItem(position);

		((TextView) view.findViewById(R.id.p_id)).setText(item.getId());
		((TextView) view.findViewById(R.id.p_name)).setText(item.getName());

		view.setTag(item);

		return view;
	}

}
