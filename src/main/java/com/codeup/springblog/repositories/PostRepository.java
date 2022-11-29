package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findById(long id);



}




//save