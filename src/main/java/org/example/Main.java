package org.example;

import org.example.db.AccountRepository;
import org.example.db.impl.PostgresAccountRepository;
import org.example.entity.AccountEntity;

import javax.swing.*;

public class Main {

    static AccountRepository accountRepository = new PostgresAccountRepository();

    public static void main(String[] args) {
        String accountName = JOptionPane.showInputDialog("Представьтесь, пожалуйста");
        AccountEntity workAccount = accountRepository.getByName(accountName);
        if(workAccount == null) {
            int balance = Integer.parseInt(JOptionPane.showInputDialog("Введите баланс: "));

            AccountEntity account = new AccountEntity();
            account.setName(accountName);
            account.setValue(balance);

            accountRepository.addAccount(account);
        }
    }
}
