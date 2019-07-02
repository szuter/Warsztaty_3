package pl.coderslab.model;

public class Exercise {
    private String title;
    private int id;
    private String description;

    public Exercise() {
    }

    public Exercise(int id, String title, String description) {
        this.title = title;
        this.id = id;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Exercise(String title, String description) {
        this.title = title;
        this.description = description;

    }
}
