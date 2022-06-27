package com.example.recyclerviewmvp.model;

import com.example.recyclerviewmvp.utils.PaymentMethod;

public class User {
    private String userName;
    private String phoneNumber;
    private String address;
    private PaymentMethod paymentMethod;
    private String note;

    public User(String userName, String phoneNumber, String address, PaymentMethod paymentMethod, String note) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.paymentMethod = paymentMethod;
        this.note = note;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
