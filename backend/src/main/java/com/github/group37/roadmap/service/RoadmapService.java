package com.github.group37.roadmap.service;

import com.github.group37.roadmap.other.Roadmap;
import com.github.group37.roadmap.percistance.RevisionRecourcesRepo;
import com.github.group37.roadmap.percistance.RoadmapRecourcesRepo;
import com.github.group37.roadmap.percistance.models.RoadmapDao;
import com.github.group37.roadmap.percistance.RoadmapRepo;
import com.github.group37.roadmap.percistance.models.RoadmapRecources;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoadmapService {
    public final RoadmapRepo roadmapRepo;
    public final RoadmapRecourcesRepo roadmapRecourcesRepo;
    public final RevisionRecourcesRepo revisionRecourcesRepo;

    public RoadmapService(RoadmapRepo roadmapRepo, RoadmapRecourcesRepo roadmapRecourcesRepo, RevisionRecourcesRepo revisionRecourcesRepo) {
        this.roadmapRepo = roadmapRepo;
        this.roadmapRecourcesRepo = roadmapRecourcesRepo;
        this.revisionRecourcesRepo = revisionRecourcesRepo;
    }

    public Optional<Roadmap> getRoadmap(String username){
        Roadmap roadmap = new Roadmap();
        UUID roadmapId = roadmapRepo.findByUsername(username).orElseThrow(() -> new RuntimeException("not stored in db")).getId();
        roadmapRecourcesRepo.findAllRecourcesUsingRoadmapid(roadmapId).forEach((uuid -> roadmap.addToList(revisionRecourcesRepo.findById(uuid).orElseThrow(() -> new RuntimeException("not stored in db")))));

       return Optional.of(roadmap);

    }



}
