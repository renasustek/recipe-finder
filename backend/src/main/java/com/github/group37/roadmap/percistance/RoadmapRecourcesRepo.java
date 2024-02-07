package com.github.group37.roadmap.percistance;

import com.github.group37.roadmap.percistance.models.RoadmapRecources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Repository
public interface RoadmapRecourcesRepo extends JpaRepository<RoadmapRecources, UUID> {

    @Query("SELECT u FROM RoadmapRecources u WHERE u.roadmapId = ?1")
    List<UUID> findAllRecourcesUsingRoadmapid(UUID roadmapId);
}
