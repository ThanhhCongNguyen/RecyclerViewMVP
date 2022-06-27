package com.example.recyclerviewmvp.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recyclerviewmvp.databinding.ActivityOrderBinding;
import com.example.recyclerviewmvp.interfaces.UserInterface;
import com.example.recyclerviewmvp.model.User;
import com.example.recyclerviewmvp.presenter.UserPresenter;
import com.example.recyclerviewmvp.utils.PaymentMethod;
import com.example.recyclerviewmvp.utils.Utility;

public class OrderActivity extends AppCompatActivity implements UserInterface {

    private ActivityOrderBinding binding;
    private UserPresenter userPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        userPresenter = new UserPresenter(this);

        binding.orderButton.setOnClickListener(view -> {
            order();
        });


    }

    @Override
    public void notify(User user) {
        Utility.Toast(OrderActivity.this, "Thanks " + user.getUserName());
    }

    private void order() {
        String userName = binding.nameEdittext.getText().toString().trim();
        String phoneNumber = binding.phoneEdittext.getText().toString().trim();
        String address = binding.locationEdittext.getText().toString().trim();
        PaymentMethod paymentMethod;
        if (binding.mobileBanking.isChecked()) {
            paymentMethod = PaymentMethod.MOBILE_BANKING;
        } else if (binding.creditCard.isChecked()) {
            paymentMethod = PaymentMethod.CREDIT_CARD;
        } else {
            paymentMethod = PaymentMethod.DIRECT_PAYMENT;
        }
        String note = binding.noteEdittext.getText().toString().trim();

        User user = new User(userName, phoneNumber, address, paymentMethod, note);
        userPresenter.setDataUser(user, OrderActivity.this);
    }
}