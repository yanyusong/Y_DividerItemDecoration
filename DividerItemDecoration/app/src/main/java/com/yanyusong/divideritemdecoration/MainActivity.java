package com.yanyusong.divideritemdecoration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                startActivity(new Intent(MainActivity.this, LinearLayoutManagerActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(MainActivity.this, GridLayoutManagerActivity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(MainActivity.this, GridLayoutManager1Activity.class));
                break;
            case R.id.button4:
                startActivity(new Intent(MainActivity.this, GridLayoutManager2Activity.class));
                break;
            default:
                break;
        }

    }
}
