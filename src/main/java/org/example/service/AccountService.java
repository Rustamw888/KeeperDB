package org.example.service;

import org.example.db.AccountRepository;
import org.example.db.impl.PostgresAccountRepository;
import org.example.entity.AccountEntity;

import javax.swing.*;

public class AccountService {

    private AccountRepository accountRepository = new PostgresAccountRepository();

    public AccountEntity login() {
        String accountName = JOptionPane.showInputDialog("Представьтесь, пожалуйста");
        AccountEntity workAccount = accountRepository.getByName(accountName);
        if (workAccount == null) {
            int balance = Integer.parseInt(JOptionPane.showInputDialog("Введите баланс: "));

            AccountEntity account = new AccountEntity();
            account.setName(accountName);
            account.setValue(balance);

            accountRepository.addAccount(account);
            return accountRepository.getByName(accountName);
        } else {
            return workAccount;
        }
    }

    public void showCurrentBalance(AccountEntity entity) {
        JOptionPane.showMessageDialog(null,
                "Текущий баланс " + entity.getValue(),
                "Баланс",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
