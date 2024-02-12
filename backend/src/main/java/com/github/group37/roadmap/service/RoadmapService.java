package com.github.group37.roadmap.service;

import com.github.group37.roadmap.other.Roadmap;
import com.github.group37.roadmap.percistance.RevisionResourcesRepo;
import com.github.group37.roadmap.percistance.RoadmapRepo;
import com.github.group37.roadmap.percistance.RoadmapResourcesRepo;
import com.github.group37.roadmap.percistance.models.RevisionResourceDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Stream;

@Service
public class RoadmapService {
    public final RoadmapRepo roadmapRepo;
    public final RoadmapResourcesRepo roadmapResourcesRepo;
    public final RevisionResourcesRepo revisionResourcesRepo;

    public RoadmapService(
            RoadmapRepo roadmapRepo,
            RoadmapResourcesRepo roadmapResourcesRepo,
            RevisionResourcesRepo revisionResourcesRepo) {
        this.roadmapRepo = roadmapRepo;
        this.roadmapResourcesRepo = roadmapResourcesRepo;
        this.revisionResourcesRepo = revisionResourcesRepo;
    }

    public Optional<Roadmap> getRoadmap(String username) {

        ArrayList<Optional<RevisionResourceDao>> revisionRecources = new ArrayList<>();

        Optional<UUID> roadmapId = roadmapRepo
                .findByUsername(username);

        if (roadmapId.isPresent()){
            Optional<List<UUID>> usersResourcesIds = roadmapResourcesRepo.findAllResourcesUsingRoadmapId(roadmapId.get());
                for (UUID eachuuid : usersResourcesIds.get()) {
                    revisionRecources.add(revisionResourcesRepo.findById(eachuuid));
            }
        } else {
            return Optional.empty();
        }
        Roadmap roadmap = new Roadmap(username, revisionRecources);
        return Optional.of(roadmap);
    }
}
