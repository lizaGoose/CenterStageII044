package org.firstinspires.ftc.teamcode.Modules;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DigitalChannel;

import org.firstinspires.ftc.teamcode.Robot;

public class IntakeSecondVersion extends Robot {
    CRServo intake;
    Intake intk;

    double n = 0, k = 0, d = 0, e = 0, t = 0;
    DigitalChannel lineSensor, lineSensor2;
    public IntakeSecondVersion(LinearOpMode opMode) {
        super(opMode);
        intake = hardwareMap.get(CRServo.class, "zahvat_perekid");
        lineSensor = hardwareMap.get(DigitalChannel.class, "line_digital");
        lineSensor2 = hardwareMap.get(DigitalChannel.class, "line_digital2");
        lineSensor.setMode(DigitalChannel.Mode.INPUT);
        lineSensor2.setMode(DigitalChannel.Mode.INPUT);
      // intk = new Intake(opMode);
    }
    public void teleop(){

     if (lineSensor2.getState() != true){
         telemetry.addData("Digital_Touch", "Is Pressed");
         t+=1;
         if(t<2){
             intake.setPower(-1);
         }
     }
     if(t>0){
         if(lineSensor.getState() == true) {
             intake.setPower(-1);
         }
         else {
             intake.setPower(0);
             t = 0 ;
         }
     }


        if ((gamepad2.left_trigger - gamepad2.right_trigger) < 0) {
            n += 1;
            k+=1;
            intake.setPower(1);
        }
        else if(n ==0){
            intake.setPower(0);
        }
        else {
            n = 0;
        }
     /*   if(k<10){

        }
       /* if((gamepad2.left_trigger - gamepad2.right_trigger) > 0){
            k= 11;
        }*/


    }
}