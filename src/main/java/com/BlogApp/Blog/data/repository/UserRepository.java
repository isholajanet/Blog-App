package com.BlogApp.Blog.data.repository;

import com.BlogApp.Blog.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
