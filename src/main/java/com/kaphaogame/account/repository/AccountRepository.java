package com.kaphaogame.account.repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.kaphaogame.account.FirebaseInitializer;
import com.kaphaogame.account.models.Account;
import com.kaphaogame.account.models.AccountLaddaBakery;
import org.springframework.stereotype.Repository;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public class AccountRepository{

    private FirebaseInitializer db;

    private List<Account> accountList;
    private List<AccountLaddaBakery> accountLaddaBakeryList;


    public AccountRepository() throws ExecutionException, InterruptedException, IOException {;
        accountList = new ArrayList<>();
        accountLaddaBakeryList = new ArrayList<>();
        db = new FirebaseInitializer();
        CollectionReference account = db.getFirestore().collection("Account");
        ApiFuture<QuerySnapshot> querySnapshot = account.get();
        for(DocumentSnapshot documentSnapshot: querySnapshot.get().getDocuments()){
            Account acc = documentSnapshot.toObject(Account.class);
            accountList.add(acc);
        }
        CollectionReference account2 = db.getFirestore().collection("AccountLaddaBakery");
        ApiFuture<QuerySnapshot> querySnapshot2 = account2.get();
        for(DocumentSnapshot documentSnapshot: querySnapshot2.get().getDocuments()){
            AccountLaddaBakery acc = documentSnapshot.toObject(AccountLaddaBakery.class);
            accountLaddaBakeryList.add(acc);
        }
    }

    public List<Account> getAllAccounts() {
        return accountList;
    };

    public List<AccountLaddaBakery> getAllAccountLaddaBakery() {
        return accountLaddaBakeryList;
    }

    public Account save(Account account) {
        Account accountRegistering = new Account(account.getFirstName(), account.getLastName(),
                account.getEmail(), account.getUserName(), account.getPassword(), account.getDisplayName());
        ApiFuture<DocumentReference> addedDocRef = db.getFirestore().collection("Account").add(accountRegistering);
        return accountRegistering;
    }

    public AccountLaddaBakery saveLaddaBakery(AccountLaddaBakery accountLaddaBakery) {
        AccountLaddaBakery accountRegistering = new AccountLaddaBakery(accountLaddaBakery.getFullName(), accountLaddaBakery.getUserName(),
                                                    accountLaddaBakery.getPassword(), accountLaddaBakery.getEmail(),
                                                    accountLaddaBakery.getTel(), accountLaddaBakery.getAddress(),
                                                    accountLaddaBakery.getMoreDetail());
        ApiFuture<DocumentReference> addedDocRef = db.getFirestore().collection("AccountLaddaBakery").add(accountRegistering);
        accountLaddaBakeryList.add(accountRegistering);
        return accountRegistering;
    }

}
