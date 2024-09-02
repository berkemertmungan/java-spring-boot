package com.example.demo.responses;

import com.example.demo.entities.Like;
import com.example.demo.entities.Post;
import com.example.demo.response.LikeResponse;

import java.util.List;

public class PostResponse {
	Long id;
	Long userId;
	String userName;
	String title;
	String text;
	List<LikeResponse> postLikes;
	
	//neden entity kullanıp normal contructor oluşturmadı
	public PostResponse(Post entity, List<LikeResponse> likes) {
	    this.id = entity.getId();
	    this.userId = entity.getUser().getId();
	    this.userName = entity.getUser().getUserName();
	    this.title = entity.getTitle();
	    this.text = entity.getText();
	    this.postLikes = likes;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	public List<LikeResponse> getPostLikes() {
		return postLikes;
	}


	public void setPostLikes(List<LikeResponse> postLikes) {
		this.postLikes = postLikes;
	}



	
}
