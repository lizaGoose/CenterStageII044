package org.firstinspires.ftc.teamcode.Modules;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot;

public class Lift extends Robot {
    DcMotor lift1, lift2;
    //Virtual4bar v4b;
    double pos1 = 0, pos2 = 300, a = 0, b = 0, pos3 = 300, c =0;
    Servo scorer,perekid1, perekid2;

    double kp = 0.4;

    public Lift(LinearOpMode opMode) {
        super(opMode);
        //v4b = new Virtual4bar(opMode);
        lift1 = hardwareMap.get(DcMotor.class, "lift1");
        lift1.setDirection(DcMotorSimple.Direction.FORWARD);
        lift1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lift1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //lift

        lift2 = hardwareMap.get(DcMotor.class, "lift2");
        lift2.setDirection(DcMotorSimple.Direction.REVERSE);
        lift2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lift2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        scorer = hardwareMap.get(Servo.class, "skorer");

        perekid1 = hardwareMap.get(Servo.class, "perekid1");
        perekid2 = hardwareMap.get(Servo.class, "perekid2");
    }

    public void teleop() {

            if(lift1.getCurrentPosition() >= pos1) {
                lift1.setPower(-gamepad2.right_stick_y*0.8);
                lift2.setPower(-gamepad2.right_stick_y*0.8);
              if (gamepad2.left_stick_y > 0) {
                    //v4b.perekid1.setPosition(v4b.pr12);
                    //v4b.perekid2.setPosition(1 - v4b.pr12);
                }
            }
            else if (lift1.getCurrentPosition() < pos1 && gamepad2.right_stick_y>0){
                lift1.setPower(0);
                lift2.setPower(0);
            }
            else if (lift1.getCurrentPosition() < pos1 && gamepad2.right_stick_y <=0){
                lift1.setPower(-gamepad2.right_stick_y*0.8);
                lift2.setPower(-gamepad2.right_stick_y*0.8);
            }
        if (gamepad2.y||gamepad1.y){
            a+=1;

        }
        if (gamepad2.x) {
        b+=1;
        }

        if (gamepad2.b){
            c+=1;
        }
        if (c>0){
            double error = 0 - lift1.getCurrentPosition();
            if (error<0) {
                lift1.setPower(error * kp);
                lift2.setPower(error * kp);
            }
            else {
                c =0;
            }
        }

        if(b>0){
         b+=1;
         if (b < 20) {
             scorer.setPosition(0.8);
         }
         else {
             double error2 = pos3 - lift1.getCurrentPosition();
             if (error2 > 0) {
                 lift1.setPower(error2 * kp);
                 lift2.setPower(error2 * kp);
             } else {
                 perekid2.setPosition(0.55);
                 perekid1.setPosition(0.45);
                 b = 0;
             }
         }
            //}
        }

        /*telemetry.addData("lift1", lift1.getCurrentPosition());
            telemetry.addData("lift2", lift2.getCurrentPosition());
            telemetry.update();*/
        }
    }
