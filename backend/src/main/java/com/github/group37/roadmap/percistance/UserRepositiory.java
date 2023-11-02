package com.github.group37.roadmap.percistance;

import com.github.group37.roadmap.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositiory extends JpaRepository<User, Integer> {

    // custom query to search to blog post by title or content
    List<User> findByTitleContainingOrContentContaining(String text, String textAgain);
}