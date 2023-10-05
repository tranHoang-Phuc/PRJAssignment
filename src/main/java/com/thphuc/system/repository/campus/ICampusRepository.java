package com.thphuc.system.repository.campus;

import com.thphuc.system.model.Campus;

import java.util.List;

public interface ICampusRepository {
    public List<Campus> getAll();
    public Campus get(int id);
    public void insert(Campus t);
    public void update(Campus t);
    public void delete(int id);
}
