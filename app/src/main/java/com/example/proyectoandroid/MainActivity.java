package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_ProyectoAndroid);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1= (Button) findViewById(R.id.btnIniciarSession);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Bienvenido", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,Inicio.class);
                startActivity(intent);
            }
        });
    }

    public void sendRegistro(View view) {
        Intent intent = new Intent(this, registro.class);
        startActivity(intent);
    }
    }
