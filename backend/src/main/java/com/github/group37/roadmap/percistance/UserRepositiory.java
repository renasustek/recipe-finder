package com.github.group37.roadmap.percistance;

import com.github.group37.roadmap.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepositiory extends JpaRepository<User, UUID> {

}
