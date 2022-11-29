package com.example.galaxyonejava.ui.motion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.galaxyonejava.R;


public class MotionDemoActivity extends AppCompatActivity {

    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion_demo);
        tvTitle =  findViewById(R.id.tvTitlexxx);
        tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MotionDemoActivity.this, "aaa", Toast.LENGTH_SHORT).show();
            }
        });
    }
}