package com.dsp.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dsp.firebasedemo.ui.Utils;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Utils.blackIconStatusBar(Home.this, R.color.light_background);
    }

    public void gotoInsertActivity(View view) {
        startActivity(new Intent(Home.this, MainActivity.class));
    }

    public void gotoViewActivity(View view) {
        startActivity(new Intent(Home.this, ViewUpdate.class));
    }
}