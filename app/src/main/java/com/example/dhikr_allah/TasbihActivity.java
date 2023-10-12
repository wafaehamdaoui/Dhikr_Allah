package com.example.dhikr_allah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TasbihActivity extends AppCompatActivity {

    private Button btnStart, btnReset;
    private TextView counter;
    private ConstraintLayout parent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasbih);
        intViews();
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TasbihActivity.this,"اضغط على أي مكان في الشاشة للعد",Toast.LENGTH_LONG).show();
                btnStart.setVisibility(View.GONE);
                counter.setVisibility(View.VISIBLE);
                btnReset.setVisibility(View.VISIBLE);
            }
        });
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter.setText((Integer.valueOf(counter.getText().toString())+1)+"");
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TasbihActivity.this,"بدأ العد من جديد",Toast.LENGTH_LONG).show();
                counter.setText("0");
            }
        });
    }
    private void intViews(){
        btnStart = findViewById(R.id.btnStartTasbih);
        btnReset = findViewById(R.id.btnResetTasbih);
        counter = findViewById(R.id.tasbihCounter);
        parent = findViewById(R.id.parent);
    }
}