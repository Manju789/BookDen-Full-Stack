package com.dxc.comments.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.dxc.comments.model.Comments;
import com.dxc.comments.service.CommentService;


@CrossOrigin
@RestController
public class CommentController {
	@Autowired
	CommentService commentService;

	@PostMapping(value = "/create")
	public String create(@RequestBody List<Comments> com) {

		commentService.createComment(com);
		return "comments created.";
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<String> addComment(@RequestBody Comments com) {

		commentService.addComment(com);
		return new ResponseEntity<String>("New  record created.",HttpStatus.OK);
	}
	
	@GetMapping(value = "/getall")
	public Collection<Comments> getAll() {

		return commentService.getAllComments();
	}

	@GetMapping(value = "/getbyid/{user-id}")
	public Optional<Comments> getById(@PathVariable(value = "user-id") int id) {

		return commentService.findCommentById(id);
	}


	@PutMapping(value = "/update/{user-id}")
	public String update(@PathVariable(value = "user-id") int id, @RequestBody Comments com) {
		com.setId(id);
		commentService.updateComment(com);
		return "user record for user-id= " + id + " updated.";
	}

	@DeleteMapping(value = "/delete/{user-id}")
	public String delete(@PathVariable(value = "user-id") int id) {
		commentService.deleteCommentById(id);
		return "user record for user-id= " + id + " deleted.";
	}

	@DeleteMapping(value = "/deleteall")
	public String deleteAll() {
		commentService.deleteAllComments();
		return "All comments are deleted.";
	}
}

