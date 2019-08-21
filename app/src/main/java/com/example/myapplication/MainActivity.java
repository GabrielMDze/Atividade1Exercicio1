package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText editNota1, editNota2, editNota3;
    private TextView textResultado;
    private CheckBox checkPonderada;
    private double original = 3, divisor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNota1 = findViewById(R.id.nota1);
        editNota2 = findViewById(R.id.nota2);
        editNota3 = findViewById(R.id.nota3);
        textResultado = findViewById(R.id.resultado);
        checkPonderada = findViewById(R.id.checkPonderada);

        checkPonderada.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    divisor = 1 + 2 + 3;
                }else{
                    divisor = original;
                }
            }
        });
    }


    public void media(View view) {
        double nota1 = Double.parseDouble(editNota1.getText().toString());
        double nota2 = Double.parseDouble(editNota2.getText().toString());
        double nota3 = Double.parseDouble(editNota3.getText().toString());

        double media = (nota1 + nota2 + nota3) / divisor;

        DecimalFormat df = new DecimalFormat("#0.0");
        String exibir = "Nota Media " + df.format(media);

        textResultado.setText(exibir);
    }
}
