package Simplisafe;

import Simplisafe.AbstractClass.Sensor;

public class MotionSensor extends Sensor {

    private static final String sensorType = "MotionSensor";

    public MotionSensor() {
        super(sensorType);
    }
}
