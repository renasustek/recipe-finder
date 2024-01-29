package com.github.group37.roadmap.service;

import com.github.group37.roadmap.percistance.models.RoadmapDao;
import com.github.group37.roadmap.percistance.RoadmapRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RoadmapService {
    public final RoadmapRepo roadmapRepo;

    public RoadmapService(RoadmapRepo roadmapRepo) {
        this.roadmapRepo = roadmapRepo;
    }

    public Optional<RoadmapDao> getRoadmap(UUID uuid){
        return roadmapRepo.findByUUID(uuid);
    }
}
