package com.kaphaogame.account.controllers;


import com.kaphaogame.account.models.Account;
import com.kaphaogame.account.models.AccountLaddaBakery;
import com.kaphaogame.account.repository.AccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class AccountControllers {

    AccountRepository accountRepository;

    public AccountControllers(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/getAllAccounts")
    public List<Account> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }

    @PostMapping("/registerAccount")
    public Account registerAccount(Account account) {
        return accountRepository.save(account);
    }

    @PostMapping("/loginAccount")
    public Account loginAccount(String username, String password) throws ExecutionException, InterruptedException {
        List<Account> accounts = this.getAllAccounts();
        for (Account account: accounts) {
            if (account.getUserName().equals(username) && account.getPassword().equals(password)){
                return account;
            }
        }
        return null;
    }

    @PostMapping("/laddaBakery/registerAccount")
    public AccountLaddaBakery registerAccountLaddaBakery(AccountLaddaBakery accountLaddaBakery) {
        return accountRepository.saveLaddaBakery(accountLaddaBakery);
    }

    @PostMapping("/laddaBakery/loginAccount")
    public AccountLaddaBakery loginAccountLaddaBakery(String userName, String password) {
        List<AccountLaddaBakery> accountLaddaBakeries = this.accountRepository.getAllAccountLaddaBakery();
        for (AccountLaddaBakery accountLaddaBakery: accountLaddaBakeries) {
            if (accountLaddaBakery.getUserName().equals(userName) && accountLaddaBakery.getPassword().equals(password)){
                return accountLaddaBakery;
            }
        }
        return null;
    }

}
