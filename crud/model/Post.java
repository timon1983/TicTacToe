package main.java.com.timon1983.javacore.crud.model;

import java.util.List;

public class Post {
    private long id;
    private String content;
    private long created;
    private long updated;
    private List<Label> lables;

    public Post(long id, String content, long created, long updated, List<Label> lables) {
        this.id = id;
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.lables = lables;
    }

    public long getId() {return id;}

    public String getContent() {return content;}

    public long getCreated() {return created;}

    public long getUpdated() {return updated;}

    public List<Label> getLables() {return lables;}

    public void setId(long id) {this.id = id;}

    public void setContent(String content) {this.content = content;}

    public void setCreated(long created) {this.created = created;}

    public void setUpdated(long updated) {this.updated = updated;}

    public void setLables(List<Label> lables) {this.lables = lables;}

    @Override
    public String toString() {
        return "id=" + id + " , content= " + content + " , created= " + created + " , updated= " + updated +
                " , lables=" + lables;
    }
}
