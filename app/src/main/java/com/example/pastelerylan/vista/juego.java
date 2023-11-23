import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class juego extends Activity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private TextView xValue, yValue, zValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        xValue = findViewById(R.id.xValue);
        yValue = findViewById(R.id.yValue);
        zValue = findViewById(R.id.zValue);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if (accelerometer != null) {
                sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
            } else {
                // El dispositivo no tiene un acelerómetro.
            }
        } else {
            // El dispositivo no tiene soporte para sensores.
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            // Actualiza los valores en la interfaz de usuario.
            xValue.setText("X: " + x);
            yValue.setText("Y: " + y);
            zValue.setText("Z: " + z);

            // Puedes realizar acciones adicionales basadas en los valores del acelerómetro aquí.
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Este método se llama cuando la precisión de un sensor cambia, no es necesario implementarlo aquí.
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Pausa la lectura del acelerómetro cuando la actividad está en pausa.
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Reanuda la lectura del acelerómetro cuando la actividad se reanuda.
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
}