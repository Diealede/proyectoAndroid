package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Configuraciones extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuraciones);
    }
    public void openProximity(View view) {
        startActivity(new Intent(Configuraciones.this, ProximityActivity.class));
    }
    public void openGyroscope(View view) {
        startActivity(new Intent(Configuraciones.this, GyroscopeActivity.class));
    }
    public void openRotationVector(View view) {
        startActivity(new Intent(Configuraciones.this, RotationVectorActivity.class));
    }
}