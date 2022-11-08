package com.example.proyectoandroid;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RotationVectorActivity extends AppCompatActivity {
    private static final String TAG = "SensorsTutorial";
    private SensorManager sensorManager;
    private Sensor rotationVectorSensor;
    private SensorEventListener rvListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotation);
        sensorManager =
                (SensorManager) getSystemService(SENSOR_SERVICE);
        rotationVectorSensor =
                sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
        rvListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] rotationMatrix = new float[16];
                SensorManager.getRotationMatrixFromVector(rotationMatrix, sensorEvent.values);

                float[] remappedRotationMatrix = new float[16];
                SensorManager.remapCoordinateSystem(rotationMatrix, SensorManager.AXIS_X, SensorManager.AXIS_Z, remappedRotationMatrix);

                float[] orientations = new float[3];
                SensorManager.getOrientation(remappedRotationMatrix, orientations);

                for(int i = 0; i < 3; i++) {
                    orientations[i] =
                            (float)(Math.toDegrees(orientations[i]));
                }
                if(orientations[2] > 45) {
                    getWindow().getDecorView().setBackgroundColor(Color.CYAN);
                    Toast.makeText(getApplicationContext(),"rotación hacia la derecha", Toast.LENGTH_LONG).show();

                } else if(orientations[2] < -45) {
                    getWindow().getDecorView().setBackgroundColor(Color.MAGENTA);
                    Toast.makeText(getApplicationContext(),"rotación hacia la izquerda", Toast.LENGTH_LONG).show();

                } else if(Math.abs(orientations[2]) < 10) {
                    getWindow().getDecorView().setBackgroundColor(Color.DKGRAY);
                    Toast.makeText(getApplicationContext(),"no ha habido rotación ", Toast.LENGTH_LONG).show();
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
        sensorManager.registerListener(rvListener, rotationVectorSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(rvListener);
    }
}
