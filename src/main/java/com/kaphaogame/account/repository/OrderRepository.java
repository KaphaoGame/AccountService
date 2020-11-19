package com.kaphaogame.account.repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.kaphaogame.account.FirebaseInitializer;
import com.kaphaogame.account.models.Order;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public class OrderRepository {
    private FirebaseInitializer db;
    List<Order> orderList;

    public OrderRepository() throws IOException, ExecutionException, InterruptedException {
        orderList = new ArrayList<>();
        db = new FirebaseInitializer();
        CollectionReference orders = db.getFirestore().collection("Orders");
        ApiFuture<QuerySnapshot> querySnapshot = orders.get();
        for(DocumentSnapshot documentSnapshot: querySnapshot.get().getDocuments()){
            Order acc = documentSnapshot.toObject(Order.class);
            orderList.add(acc);
        }
    }

    public List<Order> getAllOrder() {
        return orderList;
    }

    public Order createOrder(Order order) throws ExecutionException, InterruptedException, IOException {
        Order orderRegistering = new Order(order.getOrderNo(), order.getOrderName(), order.getOrderTotalPrice(), order.getOrderAddress()
                                            ,order.getOrderTime(), order.getOrderStatus(), order.getOrderDate(), order.getDeliveryFee());
        ApiFuture<DocumentReference> addedDocRef = db.getFirestore().collection("Orders").add(orderRegistering);
        orderList.add(orderRegistering);
        return orderRegistering;
    }

    public List<Order> getAllOrderByOrderName(String orderName) {
        List<Order> myOrders = new ArrayList<>();
        for (Order order: orderList) {
            if (order.getOrderName().equals(orderName)) {
                myOrders.add(order);
            }
        }
        return myOrders;
    }
}
