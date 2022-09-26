package com.example.endevinaelnumero;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random random = new Random();
        int numRandom = random.nextInt(11);

        Button button = findViewById(R.id.button);
        EditText campo = findViewById(R.id.campo);
        TextView textoCampo = findViewById(R.id.textView);
        textoCampo.setMovementMethod(new ScrollingMovementMethod());
        TextView textoIntentos = findViewById(R.id.intentos);

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

                                    }
                                });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }

                    textoCampo.append(texto);
                    Toast toast = Toast.makeText(context,texto,Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    textoCampo.append("No has introducido un número\n");
                }



            }
        });

    }
}

//class DialogoCorrecto extends DialogFragment {
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        // Use the Builder class for convenient dialog construction
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setMessage("Correcto")
//                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        // START THE GAME!
//                    }
//                })
//                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        // User cancelled the dialog
//                    }
//                });
//        // Create the AlertDialog object and return it
//        return builder.create();
//    }
//}