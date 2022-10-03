package com.example.endevinaelnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
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

        TableLayout tableLayout = findViewById(R.id.tableLayout);

        TableRow tRowTitles = new TableRow(this);
        TextView tnom = new TextView(this);
        TextView tintents = new TextView(this);
        TextView ttemps = new TextView(this);

        tnom.setText("NOM");
        tnom.setGravity(Gravity.LEFT);
        tnom.setPadding(0,10,10,5);
        tnom.setTextSize(24);

        tintents.setText("INTENTS");
        tintents.setGravity(Gravity.CENTER);
        tintents.setPadding(100,5,5,5);
        tintents.setTextSize(24);

        ttemps.setText("TEMPS");
        ttemps.setGravity(Gravity.RIGHT);
        ttemps.setPadding(100,5,5,5);
        ttemps.setTextSize(24);

        tRowTitles.addView(tnom);
        tRowTitles.addView(tintents);
        tRowTitles.addView(ttemps);
        tableLayout.addView(tRowTitles);

        for (Record record :
                records) {
            TableRow tRow = new TableRow(this);
            TextView nom = new TextView(this);
            TextView intents = new TextView(this);
            TextView temps = new TextView(this);

            nom.setText(record.getNombre());
            nom.setGravity(Gravity.LEFT);
            nom.setPadding(0,10,10,5);
            nom.setTextSize(24);

            intents.setText(String.valueOf(record.getIntentos()));
            intents.setGravity(Gravity.CENTER);
            intents.setPadding(100,5,5,5);
            intents.setTextSize(24);

            temps.setText("0"); // CAMBIAR CUANDO TENGA LO DEL TIEMPO
            temps.setGravity(Gravity.RIGHT);
            temps.setPadding(100,5,5,5);
            temps.setTextSize(24);

            tRow.addView(nom);
            tRow.addView(intents);
            tRow.addView(temps);
            tableLayout.addView(tRow);
        }


    }
}