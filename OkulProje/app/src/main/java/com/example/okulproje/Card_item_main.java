package com.example.okulproje;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Notification;
import android.os.Bundle;

import java.util.ArrayList;

public class Card_item_main extends AppCompatActivity {


    private ActionBar actionBar;
    private ViewPager viewPager;

    private ArrayList<MyModel>modelArrayList;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_item_main);

        actionBar =getSupportActionBar();

        viewPager =findViewById(R.id.viewPager);
        loadCards();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                String title =modelArrayList.get(position).getTitle();
                actionBar.setTitle(title);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void loadCards() {
        modelArrayList = new ArrayList<>();

        modelArrayList.add(new MyModel("FORD","Ford için en güzel klasik arabalar.","20/01/2022",R.drawable.ford));
        modelArrayList.add(new MyModel("FERRARI","Ferrari için en güzel klasik arabalar.","20/01/2022",R.drawable.ferrari));
        modelArrayList.add(new MyModel("CHEVROLET","Chevrolet için en güzel klasik arabalar.","20/01/2022",R.drawable.chevrolet));
        modelArrayList.add(new MyModel("NISSAN","Nissan için en güzel klasik arabalar.","20/01/2022",R.drawable.cadilac));
        modelArrayList.add(new MyModel("MERCEDES","Mercedes için en güzel klasik arabalar.","20/01/2022",R.drawable.mercedes));
        modelArrayList.add(new MyModel("JAGUAR","Jaguar için en güzel klasik arabalar.","20/01/2022",R.drawable.jaguar));



        myAdapter = new MyAdapter(this,modelArrayList);
        viewPager.setAdapter(myAdapter);
        viewPager.setPadding(100,0,100,0);
    }
}