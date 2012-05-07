package com.chandan.biz;

public interface IIdList {

	public static final int COMMAND_LOGIN = 1;
	public static final int COMMAND_LOGOUT = 2;
	public static final int COMMAND_FETCH_PROFILE = 3;
	public static final int COMMAND_FETCH_PHOTO = 4;

	public static final int EVENT_LOGIN_SUCCESS = 1;
	public static final int EVENT_LOGOUT_SUCCESS = 2;
	public static final int EVENT_FETCH_PROFILE_SUCCESS = 3;
	public static final int EVENT_FETCH_PHOTO_SUCCESS = 4;
}
