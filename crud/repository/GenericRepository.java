package main.java.com.timon1983.javacore.crud.repository;

import java.util.List;

public interface GenericRepository<T,ID> {

    T getByld(ID id);

    List<T> getAll();

    T save(T t);

    T update(T t);

    void deleteByld(ID id);
}
