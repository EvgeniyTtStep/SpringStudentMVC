package com.itstep.dao;

import com.itstep.model.Student;

public interface GenericDAO<T, ID> {
    public void save(T t);

    public void update(T t);

    public Student getById(ID id);

    public void remove(ID id);
}
