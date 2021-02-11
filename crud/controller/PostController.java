package main.java.com.timon1983.javacore.crud.controller;

import main.java.com.timon1983.javacore.crud.model.Label;
import main.java.com.timon1983.javacore.crud.model.Post;
import main.java.com.timon1983.javacore.crud.repository.io.JavaIOLableRepositoryImpl;
import main.java.com.timon1983.javacore.crud.repository.io.JavaIOPostRepository;

import java.util.List;

public class PostController {
    private JavaIOPostRepository pr = new JavaIOPostRepository();
    private JavaIOLableRepositoryImpl lr = new JavaIOLableRepositoryImpl();

    public Post checkSave(String content, long created, long updated) {
        List<Label> lables = lr.getAll();
        Post post = new Post(0L, content, created, updated, lables );
        return pr.save(post);
    }


    public Post checkGetByld(long id) {
        return pr.getByld(id);
    }


    public void checkGetAll() {
        List<Post> list = pr.getAll();
        list.stream().forEach(x -> System.out.println(x));
    }


    public Post checkUpdate(long id, String content, long created, long updated) {
        List<Label> lables = lr.getAll();
        Post post = new Post(id,  content, created, updated, lables);
        return pr.update(post);
    }


    public void checkDeleteByld(long id) {
        pr.deleteByld(id);

    }
}
