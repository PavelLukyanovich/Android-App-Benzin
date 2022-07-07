package com.example.benzin;

import android.app.DatePickerDialog;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Form {
    protected TextView selectDateText;
    protected TextView literCounter;
    protected TextView currencyCounter;
    protected EditText costFuel;
    protected double costFuelValue;
    protected int counter = 0;
    protected Button refill;
    protected DatePickerDialog.OnDateSetListener setListener;
    protected Button decrementLiter;
    protected Button incrementLiter;
    protected Button incrementByn;
    protected Button decrementByn;
}
