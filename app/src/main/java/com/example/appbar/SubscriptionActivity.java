package com.example.appbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SubscriptionActivity extends AppCompatActivity {

    private Button button_ok, button_clear;
    private TextView success;
    private EditText enter_name, enter_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription);
        init();
    }
    private void init() {
        button_ok = findViewById(R.id.button_ok);
        button_clear = findViewById(R.id.button_clear);
        success = findViewById(R.id.success);
        enter_name = findViewById(R.id.enter_name);
        enter_email = findViewById(R.id.enter_email);

        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String enterName = enter_name.getText().toString();
                final String enterEmail = enter_email.getText().toString();
                success.setText("Подписка на рассылку успешно оформлена для пользователя " + enterName + " на электронный адрес " + enterEmail);
            }
        });
        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enter_name.getText().clear();
                enter_email.getText().clear();
                success.setText("");
            }
        });
    }
}
