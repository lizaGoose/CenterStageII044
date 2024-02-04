package org.firstinspires.ftc.teamcode.Modules;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot;

public class Wall extends Robot {
    Servo wall;
    public Wall(LinearOpMode opMode) {
        super(opMode);
        wall = hardwareMap.get(Servo.class, "servoWall");
    }
    public  void teleop(){
        if (gamepad1.left_stick_y > 0){

        }
    }
}
