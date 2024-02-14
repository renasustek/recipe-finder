package com.github.group37.roadmap.controllers;

import com.github.group37.roadmap.percistance.models.TopicDao;
import com.github.group37.roadmap.service.TopicsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/topics", produces = MediaType.APPLICATION_JSON_VALUE)
public class TopicsController {

    private final TopicsService topicsService;

    public TopicsController(TopicsService topicsService) {
        this.topicsService = topicsService;
    }

    @GetMapping("/{subjectId}")
    public List<TopicDao> getTopicsRelatedToSubject(@PathVariable UUID subjectId){
        return topicsService.getTopicsUsingSubjectId(subjectId);
    }

}
