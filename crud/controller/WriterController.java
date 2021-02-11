package main.java.com.timon1983.javacore.crud.controller;

import main.java.com.timon1983.javacore.crud.model.Label;
import main.java.com.timon1983.javacore.crud.model.Post;
import main.java.com.timon1983.javacore.crud.model.Writer;
import main.java.com.timon1983.javacore.crud.repository.io.JavaIOPostRepository;
import main.java.com.timon1983.javacore.crud.repository.io.JavaIOWriterRepository;

import java.util.List;

public class WriterController {
    JavaIOPostRepository pr = new JavaIOPostRepository();
    JavaIOWriterRepository wr = new JavaIOWriterRepository();


    public Writer checkSave(String firstName, String lastName) {
        List<Post> lables = pr.getAll();
        Writer writer = new Writer(0L, firstName,lastName, lables );
        return wr.save(writer);
    }


    public Writer checkGetByld(long id) {
        return wr.getByld(id);
    }


    public void checkGetAll() {
        List<Writer> list = wr.getAll();
        list.stream().forEach(x -> System.out.println(x));
    }


    public Writer checkUpdate(long id, String firstName, String lastName) {
        List<Post> posts = pr.getAll();
        Writer writer = new Writer(id,firstName,lastName, posts);
        return wr.update(writer);
    }


    public void checkDeleteByld(long id) {
        wr.deleteByld(id);

    }
}
