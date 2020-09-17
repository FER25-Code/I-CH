package com.test.ich.details;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.test.ich.R;


public class ShoppingProductAdvDetails extends AppCompatActivity {

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_product_adv_details);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }
}
