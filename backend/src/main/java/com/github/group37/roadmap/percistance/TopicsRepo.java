package com.github.group37.roadmap.percistance;

import com.github.group37.roadmap.percistance.models.TopicDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TopicsRepo extends JpaRepository<TopicDao, UUID> {

    @Query("SELECT u.revisionResourceId FROM RoadmapResources u WHERE u.roadmapId = ?1")
    Optional<List<UUID>> findAllResourcesUsingRoadmapId(UUID roadmapId);
}
