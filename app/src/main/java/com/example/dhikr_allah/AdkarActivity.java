package com.example.dhikr_allah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class AdkarActivity extends AppCompatActivity {

    private Button btnAdkarSalat, btnAdkarSabah, btnAdkarMasae, btnAdkarNawm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adkar);
        initViews();
        btnAdkarSabah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdkarActivity.this, StandarActivity.class);
                intent.putExtra("time","sabah");
                startActivity(intent);
            }
        });
        btnAdkarMasae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdkarActivity.this, StandarActivity.class);
                intent.putExtra("time","masa");
                startActivity(intent);
            }
        });
        btnAdkarNawm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdkarActivity.this, StandarActivity.class);
                intent.putExtra("time","nawm");
                startActivity(intent);
            }
        });
        btnAdkarSalat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdkarActivity.this, StandarActivity.class);
                intent.putExtra("time","salat");
                startActivity(intent);
            }
        });
    }
    private void initViews(){
        btnAdkarSalat = findViewById(R.id.btnAdkarSalat);
        btnAdkarSabah = findViewById(R.id.btnAdkarSabah);
        btnAdkarMasae = findViewById(R.id.btnAdkarMasae);
        btnAdkarNawm = findViewById(R.id.btnAdkarNawm);
    }
}