package org.example.entity;

import org.example.data.Category;

public class SpendEntity {

    private int id;
    private int account_id;
    private Category spendCategory;
    private int spend;

    private String description;

    public int getId() {
        return id;
    }

    public SpendEntity setId(int id) {
        this.id = id;
        return this;
    }

    public int getAccount_id() {
        return account_id;
    }

    public SpendEntity setAccount_id(int account_id) {
        this.account_id = account_id;
        return this;
    }

    public Category getSpendCategory() {
        return spendCategory;
    }

    public SpendEntity setSpendCategory(Category spendCategory) {
        this.spendCategory = spendCategory;
        return this;
    }

    public int getSpend() {
        return spend;
    }

    public SpendEntity setSpend(int spend) {
        this.spend = spend;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SpendEntity setDescription(String description) {
        this.description = description;
        return this;
    }

}
