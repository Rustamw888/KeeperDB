package org.example.db;

import org.example.entity.SpendEntity;

import java.util.List;

public interface SpendRepository {

    List<SpendEntity> getAll();
}
