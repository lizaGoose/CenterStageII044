package org.firstinspires.ftc.teamcode.Modules;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot;

public class Scorer extends Robot {
    Servo scorer, mover, perekid1, perekid2, scor;
    Virtual4bar v4b;
    double sc1 = 0.35, sc2 = 0.6;
    double t = 10;

    public Scorer(LinearOpMode opMode) {
        super(opMode);
        scorer = hardwareMap.get(Servo.class, "skorer");
        perekid1 = hardwareMap.get(Servo.class, "perekid1");
        perekid2 = hardwareMap.get(Servo.class, "perekid2");//left
        mover = hardwareMap.get(Servo.class, "skorMover");
        scor = hardwareMap.get(Servo.class, "skorer");
        v4b = new Virtual4bar(opMode);
    }
    public void teleop(){
        t+=1;
        if (gamepad2.a) {
            scorer.setPosition(0.5);
        }
        if (gamepad2.y){
            t = 0;
           // t = 10;
            scorer.setPosition(0.01);
        }
        if(t > 5 && t < 10){
            mover.setPosition(0.39);
            perekid2.setPosition(0.98);
            perekid1.setPosition(0.02);
        }

        /*if ( 20 < t && t < 22){
            scorer.setPosition(0.57);
            v4b.perekid2.setPosition(0.12);
            v4b.perekid1.setPosition(0.88);
        }*/
       /* if (gamepad2.left_trigger > 0){
            scorer.setPosition(0.52);
        }*/

    }
    public void scorerka(double a, double b){
        scorer.setPosition(a);
        opMode.sleep(500);
        scorer.setPosition(b);
    }
    public void perekidka(double a){
        v4b.perekid1.setPosition(a);
        v4b.perekid2.setPosition(1 - a);
    }
    public void scorStart(){
        scorer.setPosition(0.57);
    }
}
