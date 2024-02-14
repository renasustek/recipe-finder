package com.github.group37.roadmap.service;

import com.github.group37.roadmap.percistance.TopicsRepo;
import com.github.group37.roadmap.percistance.UserTopicsRepo;
import org.springframework.stereotype.Service;

@Service
public class TopicsService {

    private final UserTopicsRepo userTopicsRepo;

    private final TopicsRepo topicsRepo;

    public TopicsService(UserTopicsRepo userTopicsRepo, TopicsRepo topicsRepo) {
        this.userTopicsRepo = userTopicsRepo;
        this.topicsRepo = topicsRepo;
    }


}
