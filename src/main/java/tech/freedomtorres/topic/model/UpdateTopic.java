package tech.freedomtorres.topic.model;

public class UpdateTopic {
    private String name;
    private String description;

    public UpdateTopic() {
    }

    public UpdateTopic(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
