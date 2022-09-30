package com.example.endevinaelnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class RecordsActivity extends AppCompatActivity {

    static ArrayList<Record> records = new ArrayList<Record>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        Intent intent = getIntent();
        int intentos = intent.getIntExtra("intentos",0);
        String nombre = intent.getStringExtra("nombre");

        if (intentos != 0){
            records.add(new Record(nombre,intentos));
        }

    }
}