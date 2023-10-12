package com.example.dhikr_allah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class AdkarActivity extends AppCompatActivity {

    private Button btnAdkarSalat, btnAdkarSabah, btnAdkarMasae, btnAdkarNawm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adkar);
    }
    private void initViews(){
        btnAdkarSalat = findViewById(R.id.btnAdkarSalat);
        btnAdkarSabah = findViewById(R.id.btnAdkarSabah);
        btnAdkarMasae = findViewById(R.id.btnAdkarMasae);
        btnAdkarNawm = findViewById(R.id.btnAdkarNawm);
    }
}