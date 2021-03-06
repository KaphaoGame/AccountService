package com.kaphaogame.account.repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.kaphaogame.account.FirebaseInitializer;
import com.kaphaogame.account.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public class AccountRepository{

    private FirebaseInitializer db;

    public AccountRepository() throws IOException {;
        db = new FirebaseInitializer();
    }

    public List<Account> getAllAccounts() throws ExecutionException, InterruptedException {
        List<Account> accountList = new ArrayList<>();
        CollectionReference account = db.getFirestore().collection("Account");
        ApiFuture<QuerySnapshot> querySnapshot = account.get();
        for(DocumentSnapshot documentSnapshot: querySnapshot.get().getDocuments()){
            Account acc = documentSnapshot.toObject(Account.class);
            accountList.add(acc);
        }
        return accountList;
    };

    public Account save(Account account) {
        Account accountRegistering = new Account(account.getFirstName(), account.getLastName(),
                account.getEmail(), account.getUserName(), account.getPassword(), account.getDisplayName());
        ApiFuture<WriteResult> addedDocRef = db.getFirestore().collection("Account").document(accountRegistering.getUserName()).set(accountRegistering);
        return accountRegistering;
    }

    public void deleteAccount(String username) {
        db.getFirestore().collection("Account").document(username).delete();
    }

}
