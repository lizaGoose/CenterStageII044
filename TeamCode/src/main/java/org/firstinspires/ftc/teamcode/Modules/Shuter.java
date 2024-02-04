package org.firstinspires.ftc.teamcode.Modules;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot;

public class Shuter extends Robot {
    Servo shuter, equalizer;
    double taps = 45, n = 0;
    public Shuter(LinearOpMode opMode) {
        super(opMode);
        shuter = hardwareMap.get(Servo.class, "Shuter");
        equalizer = hardwareMap.get(Servo.class, "Shuter_Equalizer");
    }
    public void teleop(){
        taps+=1;
        if (gamepad1.x){
            taps = 0;
        }
        if(taps <=30){
            shuter.setPosition(0);
        }
        else if(30 < taps && taps < 40){
            shuter.setPosition(0.5);
        }
      /*  if (taps % 2 == 0 && taps !=0){
            ;
        }
        else if (taps % 2 != 0) {
            equalizer.setPosition(0.1);
        }*/
    }
}
