package org.example.db;

import org.example.data.Category;
import org.example.entity.AccountEntity;
import org.example.entity.SpendEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class SpendEntityRowMapper implements RowMapper<SpendEntity> {

    @Override
    public SpendEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new SpendEntity()
                .setId(rs.getInt("id"))
                .setAccount_id(rs.getInt("account_id"))
                .setSpendCategory(Category.valueOf(rs.getString("spend_category")))
                .setSpend(rs.getInt("spend"))
                .setDescription(rs.getString("description"));
    }
}
