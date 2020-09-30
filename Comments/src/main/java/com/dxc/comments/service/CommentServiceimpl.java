package com.dxc.comments.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dxc.comments.model.Comments;
import com.dxc.comments.repositary.CommentsRepositary;

@Service
public class CommentServiceimpl implements CommentService{
	
	
		@Autowired
		CommentsRepositary commentDao;

			public void createComment(List<Comments> com) {
			commentDao.saveAll(com);
		}

		public Collection<Comments> getAllComments() {
			return commentDao.findAll();
		}

		public Optional<Comments> findCommentById(int id) {
			return commentDao.findById(id);
		}
		
		public void deleteCommentById(int id) {
			commentDao.deleteById(id);
		}

		public Comments updateComment(Comments com) {
			return commentDao.save(com);
		}

		public void deleteAllComments() {
			commentDao.deleteAll();
		}
		
		@Override
		public void addComment(Comments com) {
			// TODO Auto-generated method stub
			System.out.println(com.getComments());
			commentDao.save(com);
			
		}
}

		 
	 
