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
        offBtn = new Button();
        homeBtn = new Button();
        menuBtn = new Button();
        deleteBtn = new Button();
        numberBtn = new Button();
    }

    public void onClickBtn(Button btn){
        if(btn.equals(homeBtn) || btn.equals(menuBtn) || btn.equals(offBtn)){
            baseStation.getSignalFromKeyPad(btn.toString());
        }
    }
}
