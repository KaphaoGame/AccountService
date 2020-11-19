package com.kaphaogame.account.controllers;

import com.kaphaogame.account.models.Bill;
import com.kaphaogame.account.repository.BillRepository;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{recipientName}")
    public List<Bill> getAllBillByRecipientName(@PathVariable String recipientName) {
        return billRepository.getAllBillByRecipientName(recipientName);
    }
}
