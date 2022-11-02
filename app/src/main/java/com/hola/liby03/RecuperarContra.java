package com.hola.liby03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RecuperarContra extends AppCompatActivity {

    TextView vol;
    Button confirma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contra);
    }

    public void VolverLog (View view){
        vol = (TextView) findViewById(R.id.txtvolv);
        vol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vol = new Intent(RecuperarContra.this, Login.class);
                startActivity(vol);
            }
        });
    }

    public void ConfirmaCambio (View view){
        confirma = (Button) findViewById(R.id.btnconfirmar);
        confirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent confirma = new Intent(RecuperarContra.this, Login.class);
                startActivity(confirma);
            }
        });
    }
}