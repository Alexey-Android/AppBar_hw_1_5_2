package com.example.appbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HealthSystemActivity extends AppCompatActivity {

    private static final String TAG = "MyApp";

    private Button btnSaveName, btnPressure, btnIndicators;
    private EditText inpName, inpAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthsystem);

        init();

    }

    private void init() {
        btnSaveName = findViewById(R.id.buttonSaveName);
        btnPressure = findViewById(R.id.buttonPressure);
        btnIndicators = findViewById(R.id.buttonIndicators);
        inpName = findViewById(R.id.editName);
        inpAge = findViewById(R.id.editAge);

        btnSaveName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал кнопку СОХРАНИТЬ");
                Patient patient = new Patient();
                String nName = inpName.getText().toString();
                String nAge = inpAge.getText().toString();

                if (nName.equals("") || nAge.equals("")) {
                    Toast.makeText(HealthSystemActivity.this, "Данные введены неверно", Toast.LENGTH_LONG).show();
                } else {
                    patient.setName(nName);
                    patient.setAge(Integer.parseInt(nAge));

                    Toast.makeText(HealthSystemActivity.this, "Данные пациента - \n" + patient.toString() + "успешно добавлены", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал кнопку ЗАПИСАТЬ ПОКАЗАТЕЛИ ДАВЛЕНИЯ");
                Intent intentPressure = new Intent(getApplicationContext(), PressureActivity.class);
                startActivity(intentPressure);
            }
        });

        btnIndicators.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал кнопку ЗАПИСАТЬ ЖИЗНЕННЫЕ ПОКАЗАТЕЛИ");
                Intent intentIndicators = new Intent(getApplicationContext(), IndicatorsActivity.class);
                startActivity(intentIndicators);
            }
        });

    }
}
