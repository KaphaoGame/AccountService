package com.kaphaogame.account.repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
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

    private List<Account> accountList;


    public AccountRepository() throws ExecutionException, InterruptedException, IOException {;
        accountList = new ArrayList<>();
        db = new FirebaseInitializer();
        CollectionReference account = db.getFirestore().collection("Account");
        ApiFuture<QuerySnapshot> querySnapshot = account.get();
        for(DocumentSnapshot documentSnapshot: querySnapshot.get().getDocuments()){
            Account acc = documentSnapshot.toObject(Account.class);
            accountList.add(acc);
        }
    }

    public List<Account> getAllAccounts() {
        return accountList;
    };

    public Account save(Account account) {
        Account accountRegistering = new Account(account.getFirstName(), account.getLastName(),
                account.getEmail(), account.getUserName(), account.getPassword(), account.getDisplayName());
        ApiFuture<DocumentReference> addedDocRef = db.getFirestore().collection("Account").add(accountRegistering);
        return accountRegistering;
    }

}
