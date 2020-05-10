package com.example.appbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class PhotoViewActivity extends AppCompatActivity {
    private Button back, forward;
    private TextView url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photoview);

        init();
    }

    private void init() {
        back = findViewById(R.id.buttonBack);
        forward = findViewById(R.id.buttonForward);
        url = findViewById(R.id.URL);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PhotoViewActivity.class);
                startActivity(intent);
            }
        });
        Random random = new Random();
        url.setText("http://myfile.org/" + random.nextInt(100));


    }
}
