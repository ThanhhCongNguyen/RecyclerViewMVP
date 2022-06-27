package com.example.recyclerviewmvp.utils;

import android.content.Context;
import android.widget.Toast;

public class Utility {
    public static void Toast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
