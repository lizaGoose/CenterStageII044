package org.firstinspires.ftc.teamcode.Modules;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.Robot1;

public class Virtual4bar extends Robot {
    Servo perekid1, perekid2, scor;
    Servo mover;
   // Scorer scor;
    double pr11 = 0.3, pr12 = 0.9;

    double t1 = 0;
    Intake_mover intmov;
    IntakeSecondVersion intake;

    public Virtual4bar(LinearOpMode opMode) {
        super(opMode);
        //scor = new Scorer(opMode);
        perekid1 = hardwareMap.get(Servo.class, "perekid1");
        perekid2 = hardwareMap.get(Servo.class, "perekid2");//left
        intmov = new Intake_mover(opMode);
        mover = hardwareMap.get(Servo.class, "skorMover");
        scor = hardwareMap.get(Servo.class, "skorer");
        intake = new IntakeSecondVersion(opMode);

    }
    public void teleop(){

        if (gamepad2.b) {
         //   scor.scorStart();
            mover.setPosition(0.39);
            perekid2.setPosition(0.02);
            perekid1.setPosition(0.98);

           scor.setPosition(0);
           //scor.scorer.setPosition(0);
        }
        if(gamepad2.x){
           // scor.scorStart();
            perekid2.setPosition(0.98);
            perekid1.setPosition(0.02);
        }
    }
    public void SmartButton(){
        if(intmov.vidvizh.getCurrentPosition() < - 80){
            intmov.vidvizh.setPower(1);
        }
        else {
            intmov.vidvizh.setPower(0);
            if (intake.lineSensor.getState() != true || intake.lineSensor2.getState() != true){
                intake.intake.setPower(-1);
            }
          else {
                perekid2.setPosition(0.69);
                perekid1.setPosition(0.31);
            }
        }
    }
    public void perekidka( double a ){
        perekid1.setPosition(a);
        perekid2.setPosition(1-a);
    }
}
