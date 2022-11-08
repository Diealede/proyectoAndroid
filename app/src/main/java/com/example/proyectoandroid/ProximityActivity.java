package com.example.proyectoandroid;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class ProximityActivity extends AppCompatActivity {
    private static final String TAG = "SensorsTutorial";
    private SensorManager sensorManager;
    private Sensor proximitySensor;
    private SensorEventListener proximitySensorListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
// Initialize sensor manager
        sensorManager = (SensorManager)
                getSystemService(SENSOR_SERVICE);
// Using proximity sensor
        proximitySensor =
                sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if(proximitySensor == null) {
            Log.e(TAG, "Sensor de proximidad no disponible.");
            finish();
        }
        proximitySensorListener = new SensorEventListener() {

            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                String mensaje ="";

                if(sensorEvent.values[0] < proximitySensor.getMaximumRange()) {
                    getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                    Toast.makeText(getApplicationContext(),"Objeto Cerca", Toast.LENGTH_LONG).show();

                } else {
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                    Toast.makeText(getApplicationContext(),"Objeto lejos", Toast.LENGTH_LONG).show();
                }
            }
            
            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
    }
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(proximitySensorListener, proximitySensor, 2 * 1000 * 1000);
    }
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(proximitySensorListener);
    }
}
