package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }
    public void openProximity(View view) {
        startActivity(new Intent(Inicio.this, ProximityActivity.class));
    }
    public void openGyroscope(View view) {
        startActivity(new Intent(Inicio.this, GyroscopeActivity.class));
    }
    public void openRotationVector(View view) {
        startActivity(new Intent(Inicio.this, RotationVectorActivity.class));
    }
}