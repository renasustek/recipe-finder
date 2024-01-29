package com.github.group37.roadmap.controllers;


import com.github.group37.roadmap.errors.RoadMapNotFoundException;
import com.github.group37.roadmap.percistance.models.RoadmapDao;
import com.github.group37.roadmap.service.RoadmapService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController

public class RoadmapController {

    public final RoadmapService roadmapService;

    public RoadmapController(RoadmapService roadmapService) {
        this.roadmapService = roadmapService;
    }


    @GetMapping("/{id}")
    public RoadmapDao getRoadmap(@PathVariable UUID userId){
        return roadmapService.getRoadmap(userId).orElseThrow(() -> new RoadMapNotFoundException());
    }

}
