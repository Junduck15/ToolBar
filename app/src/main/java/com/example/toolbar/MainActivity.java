package com.example.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    float degree = 45;
    Toolbar toolbar;
    ConstraintLayout layout;
    ImageView chicken;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        layout = findViewById(R.id.backbg);
        chicken = findViewById(R.id.image);
        setSupportActionBar(toolbar);
        setTitle("Menu List");

        registerForContextMenu(chicken);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(chicken == v){
            getMenuInflater().inflate(R.menu.chickenmenu, menu);
        }
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.chickenmenu){
            Toast.makeText(this, "Chicken Ordered", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==R.id.destroychicken){
            chicken.setImageResource(0);
        }
        if(item.getItemId()==R.id.cookchicken){
            chicken.setImageResource(R.drawable.chickencook);
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menu1){
            changeRed();
        }
        if(item.getItemId()==R.id.menu2){
            changeYellow();
        }
        if(item.getItemId()==R.id.menu3) rotateChicken();
        return super.onOptionsItemSelected(item);
    }

    private void rotateChicken() {
        chicken.setRotation(degree);
        degree+=60;
    }

    private void changeYellow() {
        layout.setBackgroundColor(Color.YELLOW);
    }

    private void changeRed() {
        layout.setBackgroundColor(Color.RED);
    }
}