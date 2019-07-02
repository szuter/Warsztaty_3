package pl.coderslab.model;

public class Solution {

    private int id;
    private String created;
    private String updated;
    private String description;
    private int user_id;
    private int exercise_id;

    public Solution() {
    }

    public Solution(String description, int user_id, int exercise_id) {
        this.description = description;
        this.user_id = user_id;
        this.exercise_id = exercise_id;
    }

    public int getId() {
        return id;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(int exercise_id) {
        this.exercise_id = exercise_id;
    }

    public String getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "id=" + id +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                ", description='" + description + '\'' +
                ", user_id=" + user_id +
                ", exercise_id=" + exercise_id +
                '}';
    }
}




