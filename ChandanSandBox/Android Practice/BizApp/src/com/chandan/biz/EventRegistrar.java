package com.chandan.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class EventRegistrar {

	private static final int ID_EVENT_HANDLERS_FIRE = 123456;

	private static final EventRegistrar instance = new EventRegistrar();

	private Map<Integer, List<IEventHandler>> registry = new  HashMap<Integer, List<IEventHandler>>();

	private Handler handler = new Handler()
	{
		public void handleMessage(Message msg)
		{
			switch(msg.what)
			{
			case ID_EVENT_HANDLERS_FIRE:
				Object[] items = (Object[]) msg.obj;
				Integer id = (Integer) items[0];
				Object tag = items[1];
				Object data = items[2];
				List<IEventHandler> list = registry.get(id);
				if(list != null)
				{
					Log.i("BAA", "EventRegistrar::fire, will fire the handlers");
					for(IEventHandler h: list)
					{
						h.onEvent(id, tag, data);
					}
					Log.i("BAA", "EventRegistrar::fire, handlers fired");
				}
				break;
			default:
				super.handleMessage(msg);
			}
		};
	};

	private EventRegistrar() {
	}

	public static EventRegistrar getInstance() {
		return instance;
	}

	public void initialize(Context ctx)
	{
		//
	}
	
	public void subscribe(int id, IEventHandler handler)
	{
		List<IEventHandler> list = registry.get(id);
		if(list == null)
		{
			list = new ArrayList<IEventHandler>();
			registry.put(id, list);
		}
		list.add(handler);
	}

	public void unsubscribe(int id, IEventHandler handler)
	{
		List<IEventHandler> list = registry.get(id);
		if(list != null)
		{
			list.remove(handler);
		}
	}

	public void fire(int id, Object tag, Object data)
	{
		Message msg = Message.obtain();
		msg.what = ID_EVENT_HANDLERS_FIRE;
		msg.obj = new Object[] { id, tag, data };
		handler.sendMessage(msg);
	}
}








