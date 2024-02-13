package com.github.group37.roadmap.percistance;

import com.github.group37.roadmap.percistance.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("SELECT u FROM User u WHERE u.uuid = ?1")
    Optional<User> findByUUID(UUID uuid);

    @Query("DELETE u FROM User u WHERE e.uuid = ?1")
    void deleteByUUID(UUID uuid);
}
