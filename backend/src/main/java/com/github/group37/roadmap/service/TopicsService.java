package com.github.group37.roadmap.service;

import com.github.group37.roadmap.other.UserTopic;
import com.github.group37.roadmap.other.UserTopicsRequest;
import com.github.group37.roadmap.percistance.TopicsRepo;
import com.github.group37.roadmap.percistance.UserTopicsRepo;
import com.github.group37.roadmap.percistance.models.TopicDao;
import com.github.group37.roadmap.percistance.models.UserTopicsDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TopicsService {

    private final UserTopicsRepo userTopicsRepo;

    private final TopicsRepo topicsRepo;

    public TopicsService(UserTopicsRepo userTopicsRepo, TopicsRepo topicsRepo) {
        this.userTopicsRepo = userTopicsRepo;
        this.topicsRepo = topicsRepo;
    }

    public List<TopicDao> getTopicsUsingSubjectId(UUID subjectId){
        return topicsRepo.findTopicsUsingSubjectId(subjectId);
    }

    public void postUserTopics(UserTopicsRequest userTopicsRequest){
        for (UserTopic eachUserTopic: userTopicsRequest.getUserTopics()){
            userTopicsRepo.save(new UserTopicsDao(eachUserTopic.id(),eachUserTopic.topicId(),eachUserTopic.username(),eachUserTopic.confidenceInTopic()));
        }
    }


}
