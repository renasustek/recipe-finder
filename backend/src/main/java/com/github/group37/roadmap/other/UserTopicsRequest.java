package com.github.group37.roadmap.other;

import java.util.List;

public class UserTopicsRequest {

    private List<UserTopic> userTopics; // todo might need to make usertopicdao into a seperate class

    public List<UserTopic> getUserTopics() {
        return userTopics;
    }

    public void setUserTopics(List<UserTopic> userTopics) {
        this.userTopics = userTopics;
    }
}
