package org.example.db.impl;

import org.example.db.AccountEntityRowMapper;
import org.example.db.DataSourceProvider;
import org.example.db.SpendEntityRowMapper;
import org.example.db.SpendRepository;
import org.example.entity.AccountEntity;
import org.example.entity.SpendEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PostgresSpendRepository implements SpendRepository {

    private static final JdbcTemplate template =
            new JdbcTemplate(DataSourceProvider.INSTANCE.getDataSource());

    @Override
    public List<SpendEntity> getAllForAccount(AccountEntity account) {
        return template.query("SELECT * FROM spend WHERE account_id = ?",
                new SpendEntityRowMapper(),
                account.getId());
    }

    @Override
    public void addSpend(SpendEntity spend) {
        template.update("INSERT INTO spend (account_id, spend_category, spend, description) values (?, ?, ?, ?)",
                spend.getAccount_id(),
                spend.getSpendCategory().toString(),
                spend.getSpend(),
                spend.getDescription());
    }
}
