package Simplisafe;

import Simplisafe.Class.Detector;
import Simplisafe.Class.Report;
import Simplisafe.Class.Sensor;
import java.util.LinkedList;

public class DataBase {

    // Our generated lists of all types stores on database
    LinkedList<Sensor> sensorList;
    LinkedList<Sensor> cameraList;
    LinkedList<Detector> detectorList;
    LinkedList<Report> reportList;

    //Generates our lists stores on database
    public DataBase() {

        sensorList = new LinkedList<>();
        cameraList = new LinkedList<>();
        detectorList = new LinkedList<>();
        reportList = new LinkedList<>();
    }

    // Generates and stores a report in database
    public void GenerateReport(Object Device, String timeOfInstance, String Description) {
        reportList.add(new Report(Device,timeOfInstance,Description));
    }

    // Returns a list of reports / devices to be displayed
    public LinkedList viewList(String typeOfList) throws Exception {

        if(typeOfList == "Sensor"){
            return sensorList;
        }
        else if(typeOfList == "Camera"){
            return sensorList;
        }
        else if(typeOfList == "Detector"){
            return sensorList;
        }
        else if(typeOfList == "Report"){
            return sensorList;
        }
        throw new Exception("Type of list not found.");

    }


    // Removes a device from the appropriate list
    public void removeDevice(Sensor Device) {
        sensorList.remove(Device);
    }

    // Removes a device from the appropriate list
    public void addDevice(Sensor Device){
        sensorList.add(Device);
    }

    // Removes a device from the appropriate list
    public void removeDevice(Detector Device) {
        detectorList.remove(Device);
    }

    // Removes a device from the appropriate list
    public void addDevice(Detector Device){
        detectorList.add(Device);
    }

}