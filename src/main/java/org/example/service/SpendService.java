package org.example.service;

import org.example.data.Category;
import org.example.db.AccountRepository;
import org.example.db.SpendRepository;
import org.example.db.impl.PostgresAccountRepository;
import org.example.db.impl.PostgresSpendRepository;
import org.example.entity.AccountEntity;
import org.example.entity.SpendEntity;

import javax.swing.*;
import java.util.Arrays;

public class SpendService {

    private SpendRepository spendRepository = new PostgresSpendRepository();
    private AccountRepository accountRepository = new PostgresAccountRepository();

    public void doSpend(AccountEntity account) {
        int index = JOptionPane.showOptionDialog(
                null,
                "Категория",
                "Выберите категорию траты",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
//                Arrays.stream(Category.values()).map(category -> category.getDescription()).toArray(String[]::new),
                Arrays.stream(Category.values()).map(Category::getDescription).toArray(String[]::new),
                Category.BAR.getDescription()
        );

        Category selected = Category.values()[index];

        int spendValue = Integer.parseInt(
                JOptionPane.showInputDialog("Введите размер траты")
        );
        String desc = JOptionPane.showInputDialog("Введите описание траты");

        if(isSpendAcceptedForGivenUser(account, spendValue)) {
            SpendEntity spend = new SpendEntity()
                    .setSpend(spendValue)
                    .setSpendCategory(selected)
                    .setDescription(desc)
                    .setAccount_id(account.getId());

            spendRepository.addSpend(spend);
            account.setValue(account.getValue() - spendValue);
            accountRepository.updateAccount(account);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Невозможно совершить списание",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void showAllSpends(AccountEntity account) {
        Object[][] rows = spendRepository.getAllForAccount(account)
                .stream()
                .map(spend -> new Object[]{
                        spend.getSpendCategory().getDescription(),
                        spend.getSpend(),
                        spend.getDescription()})
                .toArray(Object[][]::new);

//        Object[][] rows = {
//                {"1", "2", "3"},
//                {"3", "4", "5"}
//        };

        Object[] headers = {"Категория", "Размер траты", "Описание траты"};

        JTable table = new JTable(rows, headers);
        JOptionPane.showMessageDialog(null, new JScrollPane(table));
    }

    private boolean isSpendAcceptedForGivenUser(AccountEntity givenUser, int spend) {
        if (spend <= 0) {
            return false;
        }
        if (givenUser.getValue() < spend) {
            return false;
        }
        return true;
    }
}
