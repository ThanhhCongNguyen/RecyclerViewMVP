package com.example.recyclerviewmvp.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.recyclerviewmvp.R;
import com.example.recyclerviewmvp.adapter.FoodAdapter;
import com.example.recyclerviewmvp.databinding.ActivityMainBinding;
import com.example.recyclerviewmvp.interfaces.MainInterface;
import com.example.recyclerviewmvp.model.DarkMode;
import com.example.recyclerviewmvp.model.Food;
import com.example.recyclerviewmvp.presenter.MainPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainInterface {

    private final int SPAN_COUNT = 2;
    public static final String NAME_SHARED = "name";
    public static final String KEY_DARK_MODE = "darkMode";

    private ActivityMainBinding binding;
    private FoodAdapter foodAdapter;
    private MainPresenter mainPresenter;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences(NAME_SHARED, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        foodAdapter = new FoodAdapter();
        binding.recyclerview.setAdapter(foodAdapter);
        binding.recyclerview.setLayoutManager(new GridLayoutManager(this, SPAN_COUNT));

        mainPresenter = new MainPresenter(this);
        mainPresenter.setData();
        mainPresenter.getDarkMode(sharedPreferences);

        binding.floatingActionButton.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, OrderActivity.class));
        });


    }

    @Override
    public void loadData(List<Food> foodList) {
        foodAdapter.setFoodList(foodList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        DarkMode darkMode;
        switch (item.getItemId()) {
            case R.id.darkMode:
                darkMode = new DarkMode(true);
                mainPresenter.setDarkMode(editor, darkMode);
                mainPresenter.getDarkMode(sharedPreferences);
                break;
            case R.id.lightMode:
                darkMode = new DarkMode(false);
                mainPresenter.setDarkMode(editor, darkMode);
                mainPresenter.getDarkMode(sharedPreferences);
                break;
        }
        return true;
    }
}