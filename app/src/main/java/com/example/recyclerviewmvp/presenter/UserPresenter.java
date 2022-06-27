package com.example.recyclerviewmvp.presenter;

import android.app.Activity;

import com.example.recyclerviewmvp.interfaces.UserInterface;
import com.example.recyclerviewmvp.model.User;

public class UserPresenter {
    private UserInterface userInterface;

    public UserPresenter(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void setDataUser(User user, Activity activity) {
        userInterface.notify(user);
        activity.finish();
    }
}
