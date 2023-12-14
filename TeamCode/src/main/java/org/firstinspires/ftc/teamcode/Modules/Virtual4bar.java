package org.firstinspires.ftc.teamcode.Modules;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.Robot1;

public class Virtual4bar extends Robot {
    Servo perekid1, perekid2;
    //Scorer scor;
    double pr11 = 0.3, pr12 = 0.9;

    public Virtual4bar(LinearOpMode opMode) {
        super(opMode);
     //   scor = new Scorer(opMode);
        perekid1 = hardwareMap.get(Servo.class, "perekid1");
        perekid2 = hardwareMap.get(Servo.class, "perekid2");//left
    }
    public void teleop(){

        if (gamepad2.dpad_right) {
         //   scor.scorStart();
            perekid2.setPosition(0.69);
           perekid1.setPosition(0.31);


        }
        if(gamepad2.dpad_left){
           // scor.scorStart();
            perekid2.setPosition(0.12);
            perekid1.setPosition(0.88);

        }
    }
    public void perekidka( double a ){
        perekid1.setPosition(a);
        perekid2.setPosition(1-a);
    }
}
