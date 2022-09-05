package tech.freedomtorres.topic.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tech.freedomtorres.topic.model.Topic;
import tech.freedomtorres.topic.model.UpdateTopic;
import tech.freedomtorres.topic.service.TopicService;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    public ResponseEntity<List<Topic>> getAllTopics() {
        return ResponseEntity.ok().body(topicService.getAllTopics());
    }

    @GetMapping("/topics/{id}")
    public ResponseEntity<Topic> getTopic(@PathVariable int id) {
        try {
            Topic topic = topicService.getTopic(id);
            return ResponseEntity.ok().body(topic);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
        }
    }

    @PostMapping("/topics")
    public ResponseEntity<Topic> createTopic(@RequestBody @Valid Topic topic) {
        Topic newTopic = topicService.createTopic(topic);
        return ResponseEntity.ok().body(newTopic);
    }

    @PutMapping("/topics/{id}")
    public ResponseEntity<Topic> updateTopic(@RequestBody UpdateTopic topic, @PathVariable int id) {
        try {
            Topic updatedTopic = topicService.updateTopic(id, topic);
            return ResponseEntity.ok().body(updatedTopic);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
        }
    }

    @DeleteMapping("topics/{id}")
    public ResponseEntity<Boolean> deleteTopic(@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(topicService.deleteTopic(id));
        } catch(NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
        }
    }
}
