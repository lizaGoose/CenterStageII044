package org.firstinspires.ftc.teamcode.Modules;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot;

public class Intake_mover {
    LinearOpMode linearOpMode;
    HardwareMap hardwareMap;
    Gamepad gamepad2;
    DcMotor vidvizh;
    double error, kp = 0.6;

    public Intake_mover(LinearOpMode linearOpMode) {
        this.linearOpMode = linearOpMode;
        hardwareMap = linearOpMode.hardwareMap;
        gamepad2 = linearOpMode.gamepad2;
        vidvizh = hardwareMap.get(DcMotor.class, "vidvizhenie_zahvata");
        vidvizh.setDirection(DcMotorSimple.Direction.FORWARD);
        vidvizh.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        vidvizh.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void teleop() {
       /* if (gamepad2.right_stick_y == 0){
            if(vidvizh.getCurrentPosition() < 60) {
                vidvizh.setPower(0.8);
            }
        }*/
        vidvizh.setPower(gamepad2.right_stick_y);
        if (vidvizh.getCurrentPosition() > -80 && gamepad2.right_stick_y == 0 && vidvizh.getCurrentPosition() < 0) {
            vidvizh.setPower(0.8);
        }
        if (vidvizh.getCurrentPosition() >= 0 && gamepad2.right_stick_y <= 0) {
            vidvizh.setPower(0);
        }
    }


}
