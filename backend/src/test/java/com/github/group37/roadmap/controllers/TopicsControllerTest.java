 package com.github.group37.roadmap.controllers;

 import com.fasterxml.jackson.databind.ObjectMapper;
 import com.github.group37.roadmap.percistance.models.TopicDao;
 import com.github.group37.roadmap.service.TopicsService;
 import org.junit.jupiter.api.DisplayName;
 import org.junit.jupiter.api.Test;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
 import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
 import org.springframework.boot.test.mock.mockito.MockBean;
 import org.springframework.http.MediaType;
 import org.springframework.test.web.servlet.MockMvc;

 import java.util.List;
 import java.util.UUID;

 import static org.mockito.Mockito.when;
 import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
 import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
 import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = TopicsController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
class TopicsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TopicsService topicsService;

    @Autowired
    private ObjectMapper objectMapper;

    private UUID validUuid = UUID.randomUUID();

    private List<TopicDao> revisionResourceDaos = List.of(topics());


    private TopicDao topics(){
        TopicDao topicDao = new TopicDao();
        topicDao.setId(validUuid);
        topicDao.setTopicName("TESTNAME");
        topicDao.setSubject(validUuid);
        return topicDao;
    }

    @DisplayName("GET request, invalid uuid, returns 404")
    @Test
    void when_given_invalid_uuid_return_404_error() throws Exception{
        String invalidTopicId = "invalid-uuid";

        mockMvc.perform(get("/topics/"+ invalidTopicId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
    @DisplayName("GET request, valid uuid, returns list")
    @Test
    void when_given_valid_uuid_return_list() throws Exception{
        when(topicsService.getTopicsUsingSubjectId(validUuid)).thenReturn(revisionResourceDaos);

        mockMvc.perform(get("/topics/"+ validUuid)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].id").value(topics().getId().toString()))
                .andExpect(jsonPath("$[0].topicName").value(topics().getTopicName()));
    }


}