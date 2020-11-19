package com.kaphaogame.account.repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.kaphaogame.account.FirebaseInitializer;
import com.kaphaogame.account.models.Bill;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public class BillRepository {
    private FirebaseInitializer db;
    List<Bill> billList;

    public BillRepository() throws IOException, ExecutionException, InterruptedException {
        billList = new ArrayList<>();
        db = new FirebaseInitializer();
        CollectionReference bills = db.getFirestore().collection("Bills");
        ApiFuture<QuerySnapshot> querySnapshot = bills.get();
        for(DocumentSnapshot documentSnapshot: querySnapshot.get().getDocuments()){
            Bill acc = documentSnapshot.toObject(Bill.class);
            billList.add(acc);
        }
    }

    public List<Bill> getAllBill() {
        return billList;
    }

    public Bill createBill(Bill bill){
        Bill billRegistering = new Bill(bill.getBillNo(), bill.getBillAddress(), bill.getBillStatus(), bill.getBillTotalPrice()
                ,bill.getBillDate(), bill.getBillTime(), bill.getSenderName(), bill.getRecipientName()
                ,bill.getPaymentMethod(), bill.getBillOrderNo());
        ApiFuture<DocumentReference> addedDocRef = db.getFirestore().collection("Bills").add(billRegistering);
        billList.add(billRegistering);
        return billRegistering;
    }

    public List<Bill> getAllBillByRecipientName(String recipientName) {
        List<Bill> bills = new ArrayList<>();
        for (Bill bill: billList) {
            if(bill.getRecipientName().equals(recipientName)){
                bills.add(bill);
            }
        }
        return bills;
    }
}
