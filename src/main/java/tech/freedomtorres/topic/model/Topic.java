package tech.freedomtorres.topic.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Topic {
    @Min(1)
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;

    public Topic() {
    }

    public Topic(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
