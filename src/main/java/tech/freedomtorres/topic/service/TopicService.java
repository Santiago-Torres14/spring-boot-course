package tech.freedomtorres.topic.service;

import org.springframework.stereotype.Service;
import tech.freedomtorres.topic.model.Topic;
import tech.freedomtorres.topic.model.UpdateTopic;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(List.of(new Topic(1, "Math", "Class where you learn numbers"),
            new Topic(2, "Spanish", ""),
            new Topic(3, "English", ""),
            new Topic(4, "Software development", ""),
            new Topic(5, "Science", ""),
            new Topic(6, "History", "")
    ));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(int id) throws
            NoSuchElementException {
        return topics.stream().filter(t -> t.getId() == id).findFirst().get();
    }

    public Topic createTopic(Topic topic) {
        topics.add(topic);

        return topics.get(topics.size() - 1);
    }

    public Topic updateTopic(int id, UpdateTopic topic) throws NoSuchElementException {
        Topic updatedTopic = topics.stream().filter(t -> t.getId() == id).findFirst().orElseThrow();

        if(!topic.getDescription().isBlank()) {
            updatedTopic.setDescription(topic.getDescription());
        }

        if(!topic.getName().isBlank()) {
            updatedTopic.setName(topic.getName());
        }

        topics.forEach(mTopic -> {
            if(mTopic.getId() == id) {
                mTopic.setName(updatedTopic.getName());
                mTopic.setDescription(updatedTopic.getDescription());
            }
        });

        return updatedTopic;
    }

    public Boolean deleteTopic(int id) {
        Topic deletedTopic = topics.stream().filter(t -> t.getId() == id).findFirst().orElseThrow();
        topics = topics.stream().filter(t -> t != deletedTopic).collect(Collectors.toList());
        return true;
    }
}
