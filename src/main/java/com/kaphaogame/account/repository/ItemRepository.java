package com.kaphaogame.account.repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.kaphaogame.account.FirebaseInitializer;
import com.kaphaogame.account.models.Item;
import com.kaphaogame.account.models.Order;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public class ItemRepository {
    private FirebaseInitializer db;

    public ItemRepository() throws IOException, ExecutionException, InterruptedException {
        db = new FirebaseInitializer();
        CollectionReference orders = db.getFirestore().collection("Orders");
        ApiFuture<QuerySnapshot> querySnapshot = orders.get();
        for(DocumentSnapshot documentSnapshot: querySnapshot.get().getDocuments()){
            Item acc = documentSnapshot.toObject(Item.class);
        }
    }

    public Item createItem(Item item) throws ExecutionException, InterruptedException, IOException {
        Item itemRegistering = new Item(item.getItemNo(), item.getItemName(), item.getItemPrice(), item.getItemQuality());
        ApiFuture<DocumentReference> addedDocRef = db.getFirestore().collection("Items").add(itemRegistering);
        return itemRegistering;
    }
}
