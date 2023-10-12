package com.example.dhikr_allah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class IsighfarActivity extends AppCompatActivity {

    private Button btnStart, btnReset;
    private TextView counter;
    private ConstraintLayout parent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isighfar);
        initViews();
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(IsighfarActivity.this, "اضغط على أي مكان في الشاشة للعد", Toast.LENGTH_SHORT).show();
                btnStart.setVisibility(View.GONE);
                btnReset.setVisibility(View.VISIBLE);
                counter.setVisibility(View.VISIBLE);
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(IsighfarActivity.this, "بدأ العد من جديد", Toast.LENGTH_SHORT).show();
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
        btnStart = findViewById(R.id.btnStartIstighfar);
        btnReset = findViewById(R.id.btnResetIstighfar);
        counter = findViewById(R.id.istighfarCounter);
        parent = findViewById(R.id.parent);
    }
}