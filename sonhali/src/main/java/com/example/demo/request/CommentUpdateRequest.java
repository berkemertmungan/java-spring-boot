package com.example.demo.request;

import lombok.Data;

@Data
public class CommentUpdateRequest {

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	String text;
	
}
