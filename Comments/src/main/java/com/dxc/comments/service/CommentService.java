package com.dxc.comments.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


import com.dxc.comments.model.Comments;

public interface CommentService {

	
	public Comments updateComment(Comments com);
	
	public void addComment(Comments com);

	public Optional<Comments> findCommentById(int id);

	public void deleteCommentById(int id);

	public Collection<Comments> getAllComments();

	public void createComment(List<Comments> com);

	public void deleteAllComments(); 
	
}