package com.test;

public class AuthorPost1 {
	private long authorPostId;
	private long postId;
	private String title;
	private String content;
	private long authorId;
	private String name;
	private String specialization;

	public AuthorPost1() {

	}

	public long getAuthorPostId() {
		return authorPostId;
	}

	public void setAuthorPostId(long authorPostId) {
		this.authorPostId = authorPostId;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

}
