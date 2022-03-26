package com.example.accelerometer;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private TextView textView;
    private SensorManager sensorManager1, sensorManager2;
    private Sensor sensor1;
    private Sensor sensor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text1);
        sensorManager1 = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager2 = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor1 = sensorManager1.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensor2 = sensorManager2.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sensorManager1.registerListener(MainActivity.this,sensor1,sensorManager1.SENSOR_DELAY_UI);
        sensorManager2.registerListener(MainActivity.this,sensor2,sensorManager2.SENSOR_DELAY_UI);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType()==Sensor.TYPE_ACCELEROMETER) {
            textView.setText("\n\n\n\n\n\n\n\n\n\n\n\nACC\n"+event.values[0] + "\n" + event.values[1] + "\n" + event.values[2]);
        }
        if(event.sensor.getType() == Sensor.TYPE_GYROSCOPE){
            textView.setText(event.values[0] + "\n" + event.values[1] + "\n" + event.values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}