package com.hola.liby03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class RegistroUsu extends AppCompatActivity {

    TextView volv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usu);
    }
    //Textview usado como enlase para volver al login
    public void Volver (View view){
        volv = (TextView) findViewById(R.id.txtvolver);
        volv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volv = new Intent(RegistroUsu.this, Login.class);
                startActivity(volv);
            }
        });
    }


}