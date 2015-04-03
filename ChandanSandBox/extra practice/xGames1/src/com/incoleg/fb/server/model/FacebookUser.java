package com.incoleg.fb.server.model;

import java.util.Date;

import javax.persistence.Id;

public class FacebookUser
{
	@Id
	private String userId;

	private String accessToken;
	private long expiryTime;
	private Date firstAccessTime;
	private boolean active;
	private String email;
	private String firstName;
	private String lastName;
	private String link;
	private String username;
	private String gender;
	private boolean verified;

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getAccessToken()
	{
		return accessToken;
	}

	public void setAccessToken(String accessToken)
	{
		this.accessToken = accessToken;
	}

	public long getExpiryTime()
	{
		return expiryTime;
	}

	public void setExpiryTime(long expiryTime)
	{
		this.expiryTime = expiryTime;
	}

	public Date getFirstAccessTime()
	{
		return firstAccessTime;
	}

	public void setFirstAccessTime(Date firstAccessTime)
	{
		this.firstAccessTime = firstAccessTime;
	}

	public boolean isActive()
	{
		return active;
	}

	public void setActive(boolean active)
	{
		this.active = active;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getLink()
	{
		return link;
	}

	public void setLink(String link)
	{
		this.link = link;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public boolean isVerified()
	{
		return verified;
	}

	public void setVerified(boolean verified)
	{
		this.verified = verified;
	}
}
