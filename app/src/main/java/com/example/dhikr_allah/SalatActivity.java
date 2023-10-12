package com.example.dhikr_allah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SalatActivity extends AppCompatActivity {

    private Button btnStart, btnReset;
    private TextView counter;
    private ConstraintLayout parent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salat);
        initViews();
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SalatActivity.this, "اضغط على أي مكان في الشاشة للعد", Toast.LENGTH_SHORT).show();
                btnStart.setVisibility(View.GONE);
                counter.setVisibility(View.VISIBLE);
                btnReset.setVisibility(View.VISIBLE);
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SalatActivity.this, "بدأ العد من جديد", Toast.LENGTH_SHORT).show();
                counter.setText("0");
            }
        });
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter.setText(Integer.valueOf(counter.getText().toString())+1+"");
            }
        });
    }
    private void initViews(){
        btnStart = findViewById(R.id.btnStartSalat);
        btnReset = findViewById(R.id.btnResetSalat);
        counter = findViewById(R.id.salatCounter);
        parent = findViewById(R.id.parent);
    }
}