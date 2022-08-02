package org.example.db;

import org.example.entity.AccountEntity;
import org.example.entity.SpendEntity;

import java.util.List;

public interface SpendRepository {

    List<SpendEntity> getAllForAccount(AccountEntity account);

    void addSpend(SpendEntity spend);
}
