package com.example.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // ir a build gradle module a ajustar las nuevas libs

    ViewPager2 vp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp2 = findViewById(R.id.view_pager_2);
        vp2.setAdapter(createMasterAdapter());
    }

    // habilitar el adpatador
    private ViewPageAdapter createMasterAdapter(){
        ViewPageAdapter adapter = new ViewPageAdapter(this);
        return adapter;
    }
}