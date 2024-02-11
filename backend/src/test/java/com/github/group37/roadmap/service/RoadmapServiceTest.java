package com.github.group37.roadmap.service;

import com.github.group37.roadmap.percistance.RevisionResourcesRepo;
import com.github.group37.roadmap.percistance.RoadmapRepo;

import com.github.group37.roadmap.percistance.RoadmapResourcesRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;


@ExtendWith(MockitoExtension.class)
class RoadmapServiceTest {
    @Mock
    public RoadmapRepo roadmapRepo;
    @Mock
    public RoadmapResourcesRepo roadmapResourcesRepo;
    @Mock
    public RevisionResourcesRepo revisionResourcesRepo;

    @InjectMocks
    private RoadmapService roadmapService;

    private UUID roadmapId = UUID.randomUUID();

    private String username = "username";

    private List<UUID> generateIds(){
        Random rand = new Random();
        int max=10,min=2;
        int x = rand.nextInt(max - min + 1) + min;
        List<UUID> uuidList = new ArrayList<>();
        for (int y = 0; y < x ; y ++){
            uuidList.add(UUID.randomUUID());
        }
        return uuidList;
    }

    @DisplayName("valid username returns roadmap")
    @Test
    void when_given_valid_username_should_return_roadmap(){
        given(roadmapRepo.findByUsername(username)).willReturn(roadmapId);

        List<UUID> userRecourceIds = generateIds();


    }

}