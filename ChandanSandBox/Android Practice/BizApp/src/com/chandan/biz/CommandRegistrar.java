package com.chandan.biz;

import java.util.HashMap;
import java.util.Map;

import android.util.Log;

public class CommandRegistrar {

	private static final CommandRegistrar instance = new CommandRegistrar();

	private Map<Integer, Class<? extends ICommand>> commands = new HashMap<Integer, Class<? extends ICommand>>();

	public static CommandRegistrar getInstance() {
		return instance;
	}

	static
	{
		getInstance().register(IIdList.COMMAND_LOGIN, LoginCommand.class);
	}
	
	private CommandRegistrar() {
	}

	public void register(int id, Class<? extends ICommand> clz)
	{
		commands.put(id, clz);
	}
	
	public void unregister(int id)
	{
		commands.remove(id);
	}

	public void go(int id, Object tag, Object params)
	{
		Log.i("BAA", "CmdRegistrar, entry");
		Class<? extends ICommand> clz = commands.get(id);
		if(clz != null)
		{
			try {
				ICommand cmd = clz.newInstance();
				cmd.go(id, tag, params);
				Log.i("BAA", "cmd::go executed");
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}





