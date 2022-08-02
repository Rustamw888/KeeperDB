package org.example.service;

import org.example.entity.AccountEntity;

public class Application {

    AccountService accountService = new AccountService();
    SpendService spendService = new SpendService();

    public void run() {
        AccountEntity accountEntity = accountService.login();
        accountService.showCurrentBalance(accountEntity);
        spendService.doSpend(accountEntity);
        accountService.showCurrentBalance(accountEntity);
        spendService.showAllSpends(accountEntity);
    }
}
