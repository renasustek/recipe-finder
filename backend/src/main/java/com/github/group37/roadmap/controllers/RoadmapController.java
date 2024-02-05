package com.github.group37.roadmap.controllers;


import com.github.group37.roadmap.errors.RoadMapNotFoundException;
import com.github.group37.roadmap.other.Roadmap;
import com.github.group37.roadmap.percistance.models.RoadmapDao;
import com.github.group37.roadmap.service.RoadmapService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/roadmap", produces = MediaType.APPLICATION_JSON_VALUE)
public class RoadmapController {

    public final RoadmapService roadmapService;

    public RoadmapController(RoadmapService roadmapService) {
        this.roadmapService = roadmapService;
    }


    @GetMapping("/{username}")
    public Roadmap getRoadmap(@PathVariable String username){
        return roadmapService.getRoadmap(username).orElseThrow(() -> new RoadMapNotFoundException());
    }

}
