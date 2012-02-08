package com.chandan.biz;

public interface ICommand {

	void go(int cmdId, Object tag, Object params);
	
}

