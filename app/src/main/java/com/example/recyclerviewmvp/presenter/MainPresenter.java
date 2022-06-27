package com.example.recyclerviewmvp.presenter;

import android.app.Activity;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatDelegate;

import com.example.recyclerviewmvp.R;
import com.example.recyclerviewmvp.interfaces.MainInterface;
import com.example.recyclerviewmvp.model.DarkMode;
import com.example.recyclerviewmvp.model.Food;
import com.example.recyclerviewmvp.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter {
    private MainInterface mainInterface;

    public MainPresenter(MainInterface mainInterface) {
        this.mainInterface = mainInterface;
    }

    public void setDarkMode(SharedPreferences.Editor editor, DarkMode darkMode) {
        if (darkMode.getDark()) {
            editor.putBoolean(MainActivity.KEY_DARK_MODE, true);
        } else {
            editor.putBoolean(MainActivity.KEY_DARK_MODE, false);
        }
        editor.apply();
    }

    public void getDarkMode(SharedPreferences sharedPreferences) {
        Boolean isDark = sharedPreferences.getBoolean(MainActivity.KEY_DARK_MODE, false);
        if (isDark) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    public void setData() {
        List<Food> foodList = new ArrayList<>();
        foodList.add(new Food("Baoger Bò Phô Mai", "100", R.drawable.baoger_bo_pho_mai));
        foodList.add(new Food("Bún Gà Teriyaki", "150", R.drawable.bun_ga_teriyaki));
        foodList.add(new Food("Bún Vịt Nướng Hoisin", "120", R.drawable.bun_vit_nuong_hoisin));
        foodList.add(new Food("Cơm Bò Steak nấm măng tây", "100", R.drawable.com_bo_steak_nam_mang_tay));
        foodList.add(new Food("Cơm cá thu Nhật Teriyaky", "160", R.drawable.com_ca_thu_nhat_teriyaky));
        foodList.add(new Food("Cơm gà mật ong", "200", R.drawable.com_ga_mat_ong));
        foodList.add(new Food("Gầy bao gà Hàn Quốc", "400", R.drawable.gay_bao_ga_han_quoc));
        foodList.add(new Food("Mỳ chay Đài Loan", "100", R.drawable.my_chay_dai_loan));
        foodList.add(new Food("Pad Thái tôm", "170", R.drawable.pad_thai_tom));
        foodList.add(new Food("Salad caesar", "100", R.drawable.salad_caesar));

        mainInterface.loadData(foodList);
    }
}
