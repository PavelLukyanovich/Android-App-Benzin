package com.example.benzin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Form form = new Form();
    Statistic statistic = new Statistic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        form.literCounter = findViewById(R.id.literCounter);
        form.currencyCounter = findViewById(R.id.currencyCounter);

        form.selectDateText = findViewById(R.id.selectDateText);


        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        form.selectDateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, form.setListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        form.setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                form.selectDateText.setText(date);
            }
        };
    }

    public void refill(View view) {
        form.refill = findViewById(R.id.refillButton);
        Intent intentAllStatistic = new Intent(MainActivity.this, AllStatistic.class);
        startActivity(intentAllStatistic);

    }

    public void decrementLiter(View view) {
        form.decrementLiter = findViewById(R.id.buttonDecrementLiter);
        form.counter -= 1;
        if (form.counter <= 0)
            form.counter = 0;

        form.literCounter.setText("" + form.counter);
    }

    public void incrementLiter(View view) {
        form.incrementLiter = findViewById(R.id.buttonIncrementLiter) ;
        form.counter += 1;
        form.literCounter.setText("" + form.counter);
    }

    public void decrementCurrency(View view) {
        form.decrementByn = findViewById(R.id.buttonDecrementByn);
        form.counter -= 1;
        if (form.counter <= 0)
        form.counter = 0;

        form.currencyCounter.setText("" + form.counter);
    }

    public void incrementCurrency(View view) {
        form.incrementByn = findViewById(R.id.buttonIncrementByn) ;
        form.counter += 1;
        form.currencyCounter.setText("" + form.counter);
    }

    public void fillCostFuel(View view) {
        form.costFuelValue = form.costFuel.getInputType();
    }
}

