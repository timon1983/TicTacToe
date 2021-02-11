package main.java.com.timon1983.javacore.crud.controller;


import main.java.com.timon1983.javacore.crud.model.Label;
import main.java.com.timon1983.javacore.crud.repository.io.JavaIOLableRepositoryImpl;

import java.util.List;

public class LabelController {
    private JavaIOLableRepositoryImpl lr = new JavaIOLableRepositoryImpl();


    public Label checkSave(String name) {
        Label l = new Label(0L, name);
        return lr.save(l);
    }


    public Label checkGetByld(long id) {
        return lr.getByld(id);
    }


    public void checkGetAll() {
        List<Label> list = lr.getAll();
        list.stream().forEach(x -> System.out.println(x));
    }


    public Label checkUpdate(long id, String name) {
        Label l = new Label(id, name);
        return lr.update(l);
    }


    public void checkDeleteByld(long id) {
        lr.deleteByld(id);

    }
}
