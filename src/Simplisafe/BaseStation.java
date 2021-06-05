package Simplisafe;

import java.util.Timer;
import java.util.TimerTask;

public class BaseStation {

    // 6 digit integer
    private int serialNum;

    // system on/off stauts
    private boolean systemStatus;

    // Off, Blue and Solid Red
    private String LEDStatus;
    private String kindOfSignal;

    private CellularAlarmTransmitter cat;
    private BlueLight bLight;
    private SolidRedLight rLight;

    // To check whether user missed alarm.
    static Timer timer;
    static int interval;

    // get singal
    private String keyPadSignal;

    public BaseStation(){
        this.serialNum = 000000;
        this.systemStatus = true;
        this.LEDStatus = "Off";
        this.kindOfSignal = "";
        this.bLight = new BlueLight();
        this.rLight = new SolidRedLight();
        this.cat = new CellularAlarmTransmitter();
    }


    // On/Off when your system is on/off
    public void setSystemStatus(){
        this.systemStatus = !systemStatus;
    }

    // off - System is Unarmed.
    public void turnLEDStatusOff(){
        setLEDStatus("off");
        kindOfSignal("");
    }

    // It has a built in cellular alarm transmitter that will send us your alarm signals
    // when you activate your SimpliSafe alarm monitoring service
    public void activateAlarmTransmitter(){
        cat.sendAlarm();
    }

    // System is Armed, Home or Away.
    public void getSignalFromDevice(String nameOfDevice){
        setLEDStatus("Blue");
        kindOfSignal(nameOfDevice);
        bLight.showBlueLight();

        // if any response within 1 minute, status will be changed.
        timer();
        if(interval == 1) alarmMissed();
    }

    // Alarm missed, this status remains until  the system is disarmed and re-armed.
    public void alarmMissed(){
        setLEDStatus("Solid Red");
        rLight.showSolidRedLight();
    }

    // set LED status
    public void setLEDStatus(String status){
        this.LEDStatus = status;
    }

    // get LED status
    public String showLedStatus(String status){
        return LEDStatus;
    }

    // set kind of signal
    public void kindOfSignal(String signal){
        this.kindOfSignal = signal;
    }

    // 1 minute timer
    public void timer(){
        int delay = 1000;
        int period = 1000;
        interval = 60;
        timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(setInterval());
            }
        }, delay, period);
    }

    private static int setInterval() {
        if (interval == 1)
            timer.cancel();
        return --interval;
    }

    public void getSignalFromKeyPad(String str){
        this.keyPadSignal = str;
    }

}
