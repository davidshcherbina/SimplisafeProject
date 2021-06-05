package Simplisafe;

import java.awt.*;

public class KeyPad {

    private Button offBtn;
    private Button homeBtn;
    private Button menuBtn;
    private Button deleteBtn;
    private Button numberBtn;

    private BaseStation baseStation;

    public KeyPad(){

        baseStation = new BaseStation();
    }

    public void onClickBtn(Button btn){

        baseStation.getSignalFromKeyPad(btn.toString());
    }
}
