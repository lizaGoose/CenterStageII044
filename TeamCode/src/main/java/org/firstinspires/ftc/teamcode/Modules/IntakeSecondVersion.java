package org.firstinspires.ftc.teamcode.Modules;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot;

public class IntakeSecondVersion extends Robot {
    CRServo intake;

    Servo mover, perekid1, perekid2, scor;
    Intake intk;
    public boolean PixeIsIn = false;
    Lift lift;

    Gamepad gamepad1;
    DcMotor zahvat,lift1, lift2;;

    double n = 50, k = 0, d = 0, e = 0, t = 0, z = 0, y = 0, a = 0, b = 0, pos2 = 400, pos3 = 200,kp = 0.8, c = 0;
    DigitalChannel lineSensor, lineSensor2;
    DcMotor vidvizh;

    public IntakeSecondVersion(LinearOpMode opMode) {
        super(opMode);
        gamepad1 = opMode.gamepad1;
        zahvat = hardwareMap.get(DcMotor.class, "zahvat");
        zahvat.setDirection(DcMotorSimple.Direction.FORWARD);
        zahvat.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        zahvat.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intake = hardwareMap.get(CRServo.class, "zahvat_perekid");
        lineSensor = hardwareMap.get(DigitalChannel.class, "line_digital");
        lineSensor2 = hardwareMap.get(DigitalChannel.class, "line_digital2");
        lineSensor.setMode(DigitalChannel.Mode.INPUT);
        lineSensor2.setMode(DigitalChannel.Mode.INPUT);
        vidvizh = hardwareMap.get(DcMotor.class, "vidvizhenie_zahvata");
        vidvizh.setDirection(DcMotorSimple.Direction.FORWARD);
        vidvizh.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        vidvizh.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        perekid1 = hardwareMap.get(Servo.class, "perekid1");
        perekid2 = hardwareMap.get(Servo.class, "perekid2");//left
        mover = hardwareMap.get(Servo.class, "skorMover");
        scor = hardwareMap.get(Servo.class, "skorer");
        lift1 = hardwareMap.get(DcMotor.class, "lift1");
        lift1.setDirection(DcMotorSimple.Direction.FORWARD);
        lift1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lift1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //lift

        lift2 = hardwareMap.get(DcMotor.class, "lift2");
        lift2.setDirection(DcMotorSimple.Direction.REVERSE);
        lift2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lift2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lift = new Lift(opMode);
        // intk = new Intake(opMode);
    }

    public void Sensor() {

       /* if(lineSensor2.getState() != true){
            t+=1;
            z = 0;
        }
        if(gamepad2.x){
            z+=1;
        }
        if(t>0 && z == 0){
                intake.setPower(-1);
        }
       else if(z > 0){
           t = 0;
           z+=1;
           if (z < 100) {
               intake.setPower(-1);
               zahvat.setPower(0);
           }
           else {
               zahvat.setPower(0);
              intake.setPower(0);
              n = 0;
              z = 0;
           }
       }*/


        /*if (lineSensor.getState() != true && lineSensor2.getState() != true){
            e+=1;
            if (e < 5) {
                intake.setPower(-1);
            }
            else if ( 6< e && e <12){
                intake.setPower(1);
            }
           else {
                intake.setPower(0);
                zahvat.setPower(0);
                if(vidvizh.getCurrentPosition() < -80){
                    vidvizh.setPower(1);
                }

            }
        }
        if(e > 12){
             if(vidvizh.getCurrentPosition() > -80 || gamepad1.dpad_left) {
                if (lineSensor.getState() != true || lineSensor2.getState() != true) {
                    intake.setPower(-1);
                }
            }
        }
        if (lineSensor2.getState() == true && lineSensor.getState() == true) {
            e = 0;
            n = 0;
            intake.setPower(0);
        }*/
    }

    public void teleop() {
        if (lineSensor2.getState() != true) {
            telemetry.addLine("first is Pressed");
        } else {
            telemetry.addLine("first is not Pressed");
        }
        if (lineSensor.getState() != true) {
            telemetry.addLine("second is Pressed");
        } else {
            telemetry.addLine("second is not Pressed");
        }
        telemetry.addData("mov", vidvizh.getCurrentPosition());
        telemetry.addData("lift", lift1.getCurrentPosition());
        telemetry.update();

       /* if(lineSensor2.getState() != true){
            n +=1;
        }*/

        /*if (gamepad1.y){
            c+=1;
        }
        if (c==0 && gamepad1.right_stick_y==0&& vidvizh.getCurrentPosition() < -200){
            vidvizh.setPower();
        }*/

        if (/*vidvizh.getCurrentPosition() < -80 || */gamepad1.y) {
            d += 1;
            b += 1;

           /* mover.setPosition(0.39);
            perekid2.setPosition(0.53);
            perekid1.setPosition(0.47);
           scor.setPosition(0);*/
        }
        n+=1;
        /*if(n < 50){
            intake.setPower(-1);
        }*/
        if (gamepad2.x){
            n = 0;
            b = 0;
            c+=1;

            a = 0;
            d = 0;
            y = 0;
            k = 0;
            t = 0;
            e = 0;
            mover.setPosition(0.39);

        }

        if (c>0){
            c+=1;
            if (c<50){
                intake.setPower(0);
                zahvat.setPower(0);
            }
        }
        if (gamepad2.b){
            //z +=1;
            b+=1;
        }
        if(gamepad2.y){
            z+=1;
        }
        /*if(c > 0){
         double error2 = vidvizh.getCurrentPosition() + pos3 ;
            if(error2 > 0) {
                vidvizh.setPower(error2*kp);
            }
            else {
                c = 0;
            }
        }*/

       /*  if (z >0){
            z +=1;
            mover.setPosition(0.39);
            if(z<15){
                scor.setPosition(0);
            }
           else{
                if (lift1.getCurrentPosition() >= 0) {
                    lift1.setPower(-1);
                    lift2.setPower(-1);
                } else {
                    z = 0;
                    perekid2.setPosition(0.98);
                    perekid1.setPosition(0.02);
                }
            }*/
        //}
        if (b > 0&&b < 5){
            b+=1;
            mover.setPosition(0.39);
            scor.setPosition(0);
        }
       /* else if(b>5&&b<30){

            perekid2.setPosition(0.55);
            perekid1.setPosition(0.45);
        }*/
        else {
            b=0;
        }
        if (z == 0){
            lift.teleop();

        }
        if (d > 0) {
            SmartButton();
        } else {
            zahvat.setPower(0);
          //  vidvizh.setPower(gamepad1.right_stick_y);

            if (vidvizh.getCurrentPosition() <= 0 && gamepad1.right_stick_y == 0 && vidvizh.getCurrentPosition() > -500){
                vidvizh.setPower(0.4);
            }
            else {
                vidvizh.setPower(gamepad1.right_stick_y);
            }

            if (gamepad2.x) {
             //ниже меньше
                //scor.scorer.setPosition(0);
            }

            if (gamepad2.b) {
                // scor.scorStart();

                perekid2.setPosition(0.98);
                perekid1.setPosition(0.02);

            }

            if (gamepad1.left_bumper) {
                intake.setPower(-1);
                zahvat.setPower(1);
            } else if (gamepad1.right_bumper) {
                intake.setPower(1);
                zahvat.setPower(-1);
            } else {
                intake.setPower(0);
                zahvat.setPower(0);
            }
        }


       /* if(n ==0 && (vidvizh.getCurrentPosition() > -80 || gamepad1.y) && gamepad1.right_stick_y != 0){
            k+=1;
            perekid2.setPosition(0.53);
            perekid1.setPosition(0.47);
            scor.setPosition(0);
        }

      /*  if (gamepad2.x){
            k = 0;
            d = 0;
        }

        if ((k > 0 || d > 0) && n == 0){
            zahvat.setPower(1);
            intake.setPower(-1);
            vidvizh.setPower(0.3);

        }
        else if (n>0) {
            k = 0;
            d = 0;
            Sensor();
           // zahvat.setPower(1);
        }*/
    }

    public void SmartButton() {
        if (lineSensor.getState() != true && lineSensor2.getState() != true) {
            e += 1;
        }

        if (gamepad1.left_bumper || gamepad1.right_bumper){
            a = 0;
            d = 0;
            y = 0;
            k = 0;
            t = 0;
            e = 0;
        }
        if (e == 0 && d != 0) {

            vidvizh.setPower(gamepad1.right_stick_y);

            if (lineSensor.getState() == true && lineSensor2.getState() == true) {
                e = 0;
                scor.setPosition(0);
                mover.setPosition(0.39);
                    perekid2.setPosition(0.98);
                    perekid1.setPosition(0.02);
                intake.setPower(-1);
                zahvat.setPower(1);
            }
            if (lineSensor2.getState() != true) {
                t += 1;
            }
            if (t > 0 && lineSensor.getState() == true) {
                intake.setPower(-1);
            }
            if (t > 0 && lineSensor.getState() != true) {
                k += 1;
           /* if (k < 10) {
                intake.setPower(0.5);
            } else {*/
                intake.setPower(0);

            }

        } else if (e > 0) {
            e += 1;
            zahvat.setPower(0);
            if (e < 15) {
                intake.setPower(1);
            } else if (e > 15 && e < 27) {
                intake.setPower(-1);

            } else {
                if (a == 0) {
                    if (lift1.getCurrentPosition() >= 0){
                        lift1.setPower(-1);
                        lift2.setPower(-1);
                    }
                    if (vidvizh.getCurrentPosition() < -80) {
                        vidvizh.setPower(1);
                        intake.setPower(0);
                    } else {
                        a += 1;

                    }
                }
                if (a != 0) {
                    vidvizh.setPower(gamepad1.right_stick_y);

                    if (lineSensor.getState() != true || lineSensor2.getState() != true) {
                           y+=1;
                          if (y > 5 && y < 100) {
                              // intake.setPower(-1);
                           }
                           else {
                               intake.setPower(0);
                               a = 0;
                               d = 0;
                               y = 0;
                               k = 0;
                               t = 0;
                               e = 0;
                           }
                    } else {
                          /*  y +=1;
                            if (y < 10){
                                intake.setPower(-1);
                            }
                            else {
                                a +=1;

                                scor.setPosition(0);
                                mover.setPosition(0.39);
                                perekid2.setPosition(0.02);
                                perekid1.setPosition(0.98);
                                if(a< 10){
                                    intake.setPower(-1);

                                }
                                else {
                                intake.setPower(0)*/
                       /* y += 1;
                        if (y < 25) {
                            intake.setPower(-1);
                        }*/// else {
                            a += 1;

                          //  scor.setPosition(0);
                           // mover.setPosition(0.39);
                          //  perekid2.setPosition(0.02);
                           // perekid1.setPosition(0.98);
                            if (a < 10) {
                                intake.setPower(-1);

                            } else {
                                intake.setPower(0);
                               // scor.setPosition(0.5);
                                a = 0;
                                d = 0;
                                y = 0;
                                k = 0;
                                t = 0;
                                e = 0;
                            }
                                    /*d = 0;
                                    k = 0;
                                    t = 0;
                                    e = 0;
                                    y = 0;
                                    a = 0;
                                }

                            }*/
                        }
                    }


                }

           /* if(lineSensor.getState() != true && lineSensor2.getState() == true){
                k+=1;
                if(k<10){
                    intake.setPower(-0.5);
                }
                else {
                    intake.setPower(0);
                }
            }

            if (lineSensor.getState() != true && lineSensor2.getState() != true){
                e+=1;
                if (e < 5) {
                    intake.setPower(-0.5);
                }
                else if ( 6< e && e <12){
                    intake.setPower(0.5);
                }
                else {
                    intake.setPower(0);
                    zahvat.setPower(0);
                }
            }
            if ((lineSensor.getState() != true || lineSensor2.getState() != true) && vidvizh.getCurrentPosition() > -80) {
                intake.setPower(-1);
            }
            else{
                perekid2.setPosition(0.02);
                perekid1.setPosition(0.98);
                a = 0;
                d = 0;
            }*/
        }
    }
    public void Autonomous(){

        ElapsedTime time = new  ElapsedTime();
        while (time.milliseconds() < 10000) {

            if (lineSensor2.getState() != true) {
                PixeIsIn = true;
            }
            if (PixeIsIn == false) {
                zahvat.setPower(1);
                intake.setPower(-1);
            }
            if (PixeIsIn == true) {
                while (lineSensor.getState() != true || lineSensor2.getState() != true) {
                    zahvat.setPower(1);
                    intake.setPower(-1);
                }
                zahvat.setPower(0);
                intake.setPower(0);
                scor.setPosition(0.8);
            }
        }
    }
    public void Autonomous2(){
        perekid2.setPosition(0.55);
        perekid1.setPosition(0.45);

    }
    public void Autonomoys3(){
        mover.setPosition(0.73);

    }
    public void Autonomous4(){
        scor.setPosition(0);
    }
    public void Autonomous5(){
        mover.setPosition(0.39);
    }
    public void Autonomous6(){
        perekid2.setPosition(0.98);
        perekid1.setPosition(0.02);
    }
    public void Autonomoys7(){
        mover.setPosition(0.08);
    }
    public void IntakeFromSteak(){
        ElapsedTime t = new ElapsedTime();
        while (t.milliseconds()<200){
            zahvat.setPower(-1);
        }
        zahvat.setPower(0);

    }
    public void Steak(){
        ElapsedTime t = new ElapsedTime();
        if (t.milliseconds() < 300){
            intake.setPower(0);
            zahvat.setPower(0);
        }
        if(lineSensor2.getState() == true){
            intake.setPower(-1);
            zahvat.setPower(1);
        }
        if(t.milliseconds() < 4000 && t.milliseconds() > 300) {
            zahvat.setPower(1);
            intake.setPower(-1);
        }
        scor.setPosition(0.8);
        zahvat.setPower(-1);
        intake.setPower(1);
        opMode.sleep(1500);
       /* while (lineSensor.getState() == true){
            intake.setPower(1);
            zahvat.setPower(0);
        }*/
       /* while (t.milliseconds() < 1000){
            intake.setPower(-1);
            zahvat.setPower(-1);
        }*/
        intake.setPower(0);
        zahvat.setPower(0);
    }
    public void lift(){
        double error2 = 250 - lift1.getCurrentPosition();
        while (error2 > 0) {
            lift1.setPower(error2 * kp);
            lift2.setPower(error2 * kp);
            error2 = 250 - lift1.getCurrentPosition();
        }
            lift1.setPower(0);
            lift2.setPower(0);
    }
    public void lift2(){
        double error2 = 0 - lift1.getCurrentPosition();
        while (error2 < 0) {
            lift1.setPower(error2 * kp);
            lift2.setPower(error2 * kp);
            error2 = 0 - lift1.getCurrentPosition();
        }
        lift1.setPower(0);
        lift2.setPower(0);
    }
    public void intikeWhileRunning(){
        zahvat.setPower(1);
        intake.setPower(-1);
    }
    public void stopIntake(){
        zahvat.setPower(0);
        intake.setPower(0);
    }
}


     /*   if(k<10){

        }
       /* if((gamepad2.left_trigger - gamepad2.right_trigger) > 0){
            k= 11;
        }*/



