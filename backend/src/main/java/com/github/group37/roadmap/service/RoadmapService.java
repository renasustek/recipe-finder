package com.github.group37.roadmap.service;

import com.github.group37.roadmap.other.Roadmap;
import com.github.group37.roadmap.percistance.RevisionResourcesRepo;
import com.github.group37.roadmap.percistance.RoadmapRepo;
import com.github.group37.roadmap.percistance.RoadmapResourcesRepo;
import com.github.group37.roadmap.percistance.UserTopicsRepo;
import com.github.group37.roadmap.percistance.models.RevisionResourceDao;
import com.github.group37.roadmap.percistance.models.RoadmapDao;
import com.github.group37.roadmap.percistance.models.RoadmapResources;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoadmapService {
    public final RoadmapRepo roadmapRepo;
    public final RoadmapResourcesRepo roadmapResourcesRepo;
    public final RevisionResourcesRepo revisionResourcesRepo;

    private final UserTopicsRepo userTopicsRepo;

    public RoadmapService(
            RoadmapRepo roadmapRepo,
            RoadmapResourcesRepo roadmapResourcesRepo,
            RevisionResourcesRepo revisionResourcesRepo,
            UserTopicsRepo userTopicsRepo) {
        this.roadmapRepo = roadmapRepo;
        this.roadmapResourcesRepo = roadmapResourcesRepo;
        this.revisionResourcesRepo = revisionResourcesRepo;
        this.userTopicsRepo = userTopicsRepo;
    }

    public List<Roadmap> getRoadmap(String username) {
        List<UUID> allUserRoadmapIds = roadmapRepo.findByUsername(username);
        if (allUserRoadmapIds.isEmpty()) {
            return Collections.emptyList();
        }
        List<Roadmap> AllRoadmaps = new ArrayList<>();

        allUserRoadmapIds.forEach(roadmapId -> {
            ArrayList<Optional<RevisionResourceDao>> revisionResources = new ArrayList<>();

            roadmapResourcesRepo.findAllResourcesUsingRoadmapId(roadmapId).forEach(revisionResourceId -> {
                revisionResources.add(revisionResourcesRepo.findById(revisionResourceId));
            });
            AllRoadmaps.add(new Roadmap(username, revisionResources));
        });

        return AllRoadmaps;
    }

    public Optional<Roadmap> createRoadmap(String username) {
        ArrayList<Optional<RevisionResourceDao>> revisionResourceDaos = new ArrayList<>();

        UUID roadmapId = UUID.randomUUID();
        roadmapRepo.save(new RoadmapDao(roadmapId, username));

        userTopicsRepo.findbyUsername(username).forEach(eachUserTopic -> {
            revisionResourcesRepo
                    .getRevisionResources(eachUserTopic.getTopicId(), eachUserTopic.getLevelOfExpertise())
                    .forEach(eachRevisionResource -> {
                        RoadmapResources save = roadmapResourcesRepo.save(
                                new RoadmapResources(UUID.randomUUID(), roadmapId, eachRevisionResource.getId()));
                        revisionResourceDaos.add(Optional.of(eachRevisionResource));
                    });
        });

        return Optional.of(new Roadmap(username, revisionResourceDaos));
    }
}
