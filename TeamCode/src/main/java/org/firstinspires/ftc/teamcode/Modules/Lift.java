package org.firstinspires.ftc.teamcode.Modules;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.Robot;

public class Lift extends Robot {
    DcMotor lift1, lift2;
    //Virtual4bar v4b;
    double pos1 = 0;

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


    }

    public void teleop() {

            if(lift1.getCurrentPosition() >= pos1) {
                lift1.setPower(-gamepad2.left_stick_y*0.8);
                lift2.setPower(-gamepad2.left_stick_y*0.8);
              if (gamepad2.left_stick_y > 0) {
                    //v4b.perekid1.setPosition(v4b.pr12);
                    //v4b.perekid2.setPosition(1 - v4b.pr12);
                }
            }
            else if (lift1.getCurrentPosition() < pos1 && gamepad2.left_stick_y>0){
                lift1.setPower(0);
                lift2.setPower(0);
            }
            else if (lift1.getCurrentPosition() < pos1 && gamepad2.left_stick_y <=0){
                lift1.setPower(-gamepad2.left_stick_y*0.8);
                lift2.setPower(-gamepad2.left_stick_y*0.8);
            }
            else if (gamepad2.left_trigger > 0){
                double error = 0 - lift1.getCurrentPosition();
                lift1.setPower(error*kp);
            }
        /*telemetry.addData("lift1", lift1.getCurrentPosition());
            telemetry.addData("lift2", lift2.getCurrentPosition());
            telemetry.update();*/
        }
    }
