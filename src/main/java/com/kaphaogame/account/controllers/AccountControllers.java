package com.kaphaogame.account.controllers;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.kaphaogame.account.FirebaseInitializer;
import com.kaphaogame.account.models.Account;
import com.kaphaogame.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
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
    public List<Account> getAllAccounts() throws ExecutionException, InterruptedException {
        return accountRepository.getAllAccounts();
    }

    @PostMapping("/registerAccount")
    public Account registerAccount(Account account) {
        return accountRepository.save(account);
    }

}
