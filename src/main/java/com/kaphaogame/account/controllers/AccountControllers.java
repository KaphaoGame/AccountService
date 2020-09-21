package com.kaphaogame.account.controllers;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.kaphaogame.account.FirebaseInitializer;
import com.kaphaogame.account.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class AccountControllers {

    @Autowired
    FirebaseInitializer db;

    @GetMapping("/getAllAccounts")
    public List<Account> getAllAccounts() throws ExecutionException, InterruptedException {
        List<Account> accountList = new ArrayList<>();
        CollectionReference account = db.getFirestore().collection("Account");
        ApiFuture<QuerySnapshot> querySnapshot = account.get();
        for(DocumentSnapshot documentSnapshot: querySnapshot.get().getDocuments()){
            Account acc = documentSnapshot.toObject(Account.class);
            accountList.add(acc);
        }
        return accountList;
    }

    @PostMapping("/registerAccount")
    public Account registerAccount(Account account) {
        Account accountRegistering = new Account(account.getFirstName(), account.getLastName(),
                account.getEmail(), account.getUserName(), account.getPassword(), account.getDisplayName());
        ApiFuture<DocumentReference> addedDocRef = db.getFirestore().collection("Account").add(accountRegistering);
        return accountRegistering;
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/registerAccount")
//    public @ResponseBody Account registerAccount(@RequestBody Account account){
//        Account accountRegistering = account;
//        ApiFuture<DocumentReference> addedDocRef = db.getFirestore().collection("Account").add(accountRegistering);
//        return account;
//    }
}
