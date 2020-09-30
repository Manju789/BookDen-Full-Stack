package com.dxc.comments.repositary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dxc.comments.model.Comments;
@Repository

public interface CommentsRepositary extends MongoRepository<Comments, Integer>{

	
	


}
