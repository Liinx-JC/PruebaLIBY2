package com.hola.liby03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class Login extends AppCompatActivity {

    Button regi, ini;
    TextView recupe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    //Metodo para pasar a la siguiente activity despues de presionar el boton de registro
    public void Registro(View view) {
        regi = (Button) findViewById(R.id.regist);
        regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regi = new Intent(Login.this, RegistroUsu.class);
                startActivity(regi);
            }
        });
    }

    //metodo para entrar a la app y mostrar el navigationdrawer
    public void InicioSesion(View view){
        ini = (Button) findViewById(R.id.inicio);
        ini.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view1){
                Intent ini = new Intent(Login.this, NavigationdrawerActivity.class);
                startActivity(ini);
            }
        });
    }

    //metodo donde usamos un textview como link para ir a la activity de recuperar contraseña
    public void Recuperar (View view){
        recupe = (TextView) findViewById(R.id.recuperar);
        recupe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent recupe = new Intent(Login.this, RecuperarContra.class);
                startActivity(recupe);
            }
        });
    }
}