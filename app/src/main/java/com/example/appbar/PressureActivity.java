package com.example.appbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PressureActivity extends AppCompatActivity {

    private static final String TAG = "MyApp";

    private Button btnSaveData;
    private EditText inpSYS, inpDIA, inpPulse;
    private CheckBox tachicardiaChkBx;
    private TextView txtDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);

        init();
    }

    private void init() {
        btnSaveData = findViewById(R.id.buttonSaveData);
        inpDIA = findViewById(R.id.inputDIA);
        inpSYS = findViewById(R.id.inputSYS);
        inpPulse = findViewById(R.id.inputPulse);
        tachicardiaChkBx = findViewById(R.id.tachycardia);
        txtDate = findViewById(R.id.txtDate);

        btnSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал кнопку СОХРАНИТЬ");
                Pressure pressure = new Pressure();
                List<Pressure> list = new ArrayList<>();

                String nSys = inpSYS.getText().toString();
                String nDia = inpDIA.getText().toString();
                String nPulse = inpPulse.getText().toString();

                if (nSys.equals("") || nDia.equals("") || nPulse.equals("")) {
                    Toast.makeText(PressureActivity.this, "Данные введены неверно", Toast.LENGTH_LONG).show();
                } else {
                    pressure.setSys(Integer.parseInt(nSys));
                    pressure.setDia(Integer.parseInt(nDia));
                    if (tachicardiaChkBx.isChecked()) {
                        tachicardiaChkBx.setChecked(false);
                    }
                    pressure.setPulse(Integer.parseInt(nPulse));

                    if (pressure.getPulse() >= 90) {
                        tachicardiaChkBx.setChecked(true);
                    }

                    SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM YYYY HH:mm");
                    String date = sdf.format(Calendar.getInstance().getTime());
                    txtDate.setText(date);
                    pressure.setDateTime(txtDate.getText().toString());
                    list.add(pressure);

                    Toast.makeText(PressureActivity.this, "Данные пациента - \n" + pressure.toString() + "успешно добавлены", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}