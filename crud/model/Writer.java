package main.java.com.timon1983.javacore.crud.model;

import java.util.List;

public class Writer {
    private long id;
    private String firstName;
    private String lastName;
    private List<Post> posts;

    public Writer(long id, String firstName, String lastName, List<Post> posts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.posts = posts;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public List<Post> getPosts() { return posts; }

    public void setId(long id) { this.id = id; }

    public void setFirstName(String firstName) { this.firstName = firstName;}

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setPosts(List<Post> posts) {this.posts = posts;}

    @Override
    public String toString() {
        return "id=" + id + " , firstName= " + firstName +
                " , lastName= " + lastName +
                " , posts= " + posts;
    }
}
