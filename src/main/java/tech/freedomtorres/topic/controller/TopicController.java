package tech.freedomtorres.topic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.freedomtorres.topic.models.Topic;

import java.util.List;

@RestController
public class TopicController {

    @GetMapping("/topics")
    public List<Topic> getAllTopics() {
        return List.of(new Topic(1, "Math", "Class where you learn numbers"),
                new Topic(2, "Spanish", ""),
                new Topic(3, "English", ""),
                new Topic(4, "Software development", ""),
                new Topic(5, "Science", ""),
                new Topic(6, "History", "")
        );
    }
}
