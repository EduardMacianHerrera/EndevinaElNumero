package com.example.endevinaelnumero;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecordsActivity extends AppCompatActivity {

    static ArrayList<Record> records = new ArrayList<Record>();
    static ArrayAdapter<Record> adapter;

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

        adapter = new ArrayAdapter<Record>(this, R.layout.list_item,records);

        ListView lv = findViewById(R.id.lista);
        lv.setAdapter(adapter);



    }
}