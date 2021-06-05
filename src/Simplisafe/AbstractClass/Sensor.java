package Simplisafe.AbstractClass;

import Simplisafe.BaseStation;

public class Sensor {

    private boolean status;
    private final BaseStation baseStation;
    private final String sensorType;

    public Sensor(String detectorType){
        this.status = false;
        this.baseStation = new BaseStation();
        this.sensorType = detectorType;
    }

    public void sense(){
        status = true;
        sendSignalToBaseStation();
    }

    public void offDevice(){
        status = false;
    }

    public void sendSignalToBaseStation() {
        baseStation.getSignalFromDevice(sensorType);
    }
}
