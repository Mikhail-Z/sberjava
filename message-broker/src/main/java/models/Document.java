package models;

import java.util.UUID;

public class Document {
    private UUID id;
    private String text;

    public Document() {}

    public Document(UUID id, String text) {
        this.id = id;
        this.text = text;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UUID getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
