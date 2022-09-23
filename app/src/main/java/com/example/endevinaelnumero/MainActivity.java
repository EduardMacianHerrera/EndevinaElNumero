package com.example.endevinaelnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
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
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                intentos++;
                CharSequence texto = "";
                Editable valor = campo.getText();

                int valorInt = Integer.parseInt(valor.toString());

                if (valorInt > numRandom){
                    texto = "El numero es más pequeño";
                } else if (valorInt < numRandom) {
                    texto = "El numero es más grande";
                } else {
                    texto = "CORRECTO! Te ha llevado "+intentos+" intentos";
                }

                textoCampo.setText(texto);
                Toast toast = Toast.makeText(context,texto,Toast.LENGTH_LONG);
                toast.show();
            }
        });

    }
}