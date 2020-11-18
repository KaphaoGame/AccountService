package com.kaphaogame.account.controllers;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.kaphaogame.account.FirebaseInitializer;
import com.kaphaogame.account.models.Bill;
import com.kaphaogame.account.models.Order;
import com.kaphaogame.account.repository.BillRepository;
import com.kaphaogame.account.repository.OrderRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/bill")
public class BillRestControllers {
    BillRepository billRepository;

    public BillRestControllers(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @GetMapping
    public List<Bill> getAllBill() {
        return billRepository.getAllBill();
    }

    @PostMapping
    public Bill createOrder(Bill bill) {
        return billRepository.createBill(bill);
    }
}
