package com.github.group37.roadmap.service;

import com.github.group37.roadmap.other.Roadmap;
import com.github.group37.roadmap.percistance.RevisionResourcesRepo;
import com.github.group37.roadmap.percistance.RoadmapResourcesRepo;
import com.github.group37.roadmap.percistance.models.RevisionResourceDao;
import com.github.group37.roadmap.percistance.models.RoadmapDao;
import com.github.group37.roadmap.percistance.RoadmapRepo;
import com.github.group37.roadmap.percistance.models.RoadmapResources;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoadmapService {
    public final RoadmapRepo roadmapRepo;
    public final RoadmapResourcesRepo roadmapResourcesRepo;
    public final RevisionResourcesRepo revisionResourcesRepo;

    public RoadmapService(RoadmapRepo roadmapRepo, RoadmapResourcesRepo roadmapResourcesRepo, RevisionResourcesRepo revisionResourcesRepo) {
        this.roadmapRepo = roadmapRepo;
        this.roadmapResourcesRepo = roadmapResourcesRepo;
        this.revisionResourcesRepo = revisionResourcesRepo;
    }

    public Optional<Roadmap> getRoadmap(String username){
        Roadmap roadmap = new Roadmap();

        UUID roadmapId = roadmapRepo.findByUsername(username).orElseThrow(() -> new RuntimeException("not stored in db")).getId();

       // List<RoadmapResources> something  = roadmapResourcesRepo.findAllResourcesUsingRoadmapId(UUID.fromString(""));

        List<RoadmapDao> allRoadmapDao = roadmapRepo.findAll();
        List<RoadmapResources> allRoadmapResources = roadmapResourcesRepo.findAll();
        List<RevisionResourceDao> allRevisionResourceDao = revisionResourcesRepo.findAll();
       // roadmapResourcesRepo.findAllResourcesUsingRoadmapId(roadmapId).forEach((uuid -> roadmap.addToList(revisionResourcesRepo.findById(uuid).orElseThrow(() -> new RuntimeException("not stored in db")))));
        System.out.println("shush");
       return Optional.of(roadmap);

    }



}
