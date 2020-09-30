package com.dxc.comments.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "comments")
public class Comments {
@Id
private Integer id;
private String comments;
public Comments() {
	
}

public Comments(int id, String comments) {
	super();
	this.id = id;
	this.comments= comments;
	}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getComments() {
	return comments;
}

public void setComments(String comments) {
	this.comments = comments;
}}
