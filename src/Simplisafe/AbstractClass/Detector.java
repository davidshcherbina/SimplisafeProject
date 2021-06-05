package Simplisafe.AbstractClass;

import Simplisafe.BaseStation;

public class Detector {

    private boolean status;
    private final BaseStation baseStation;
    private final String detectorType;

    public Detector(String detectorType){
        this.status = false;
        this.baseStation = new BaseStation();
        this.detectorType = detectorType;
    }

    public void detect(){
        status = true;
        sendSignalToBaseStation();
    }

    public void offDevice(){
        status = false;
    }

    public void sendSignalToBaseStation() {
        baseStation.getSignalFromDevice(detectorType);
    }

}
