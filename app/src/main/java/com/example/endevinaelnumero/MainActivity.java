package com.example.endevinaelnumero;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int intentos = 0;
    int intentosRecord = 100;
    int numRandom = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random random = new Random();
        numRandom = random.nextInt(11);

        Button button = findViewById(R.id.button);
        EditText campo = findViewById(R.id.campo);
        TextView textoCampo = findViewById(R.id.textView);
        textoCampo.setMovementMethod(new ScrollingMovementMethod());
        TextView textoIntentos = findViewById(R.id.intentos);

        Button buttonRecords = findViewById(R.id.recordsButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence texto = "";
                Editable valor = campo.getText();

                if (!valor.toString().equals("")){
                    intentos++;
                    textoIntentos.setText("Intento "+intentos);
                    int valorInt = Integer.parseInt(valor.toString());
                    if (valorInt < numRandom){
                        texto = "El numero "+ valorInt+ " es más pequeño\n";
                    } else if (valorInt > numRandom) {
                        texto = "El numero "+ valorInt+ " es más grande\n";
                    } else {
                        texto = "CORRECTO! Te ha llevado "+intentos+" intentos\n";
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Has adivinado el número")
                                .setTitle("CORRECTO")
                                .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if (intentos < intentosRecord){
                                            intentosRecord = intentos;
                                        }
                                        intentos = 0;
                                        textoCampo.setText("");
                                        textoIntentos.setText("");
                                        campo.setText("");
                                        Random random = new Random();
                                        numRandom = random.nextInt(11);
                                    }
                                });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                    campo.setText("");

                    textoCampo.append(texto);
                    Toast toast = Toast.makeText(context,texto,Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    textoCampo.append("No has introducido un número\n");
                }
            }
        });

        buttonRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent recordsIntent = new Intent(MainActivity.this, RecordsActivity.class);
                EditText inputName = new EditText(MainActivity.this);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("¿Quieres añadir tu récord?")
                        .setTitle("").setView(inputName).setNegativeButton("NO",new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id) {
                                startActivity(recordsIntent);
                            }})
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                recordsIntent.putExtra("nombre",inputName.getText().toString());
                                recordsIntent.putExtra("intentos",intentosRecord);
                                intentosRecord = 100;
                                startActivity(recordsIntent);
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();


            }
        });


    }

}
