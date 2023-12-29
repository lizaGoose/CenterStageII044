package org.firstinspires.ftc.teamcode.Modules;

import com.acmerobotics.roadrunner.trajectory.MarkerCallback;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;

import org.firstinspires.ftc.teamcode.Robot;

public class Intake extends Robot{
    DcMotor zahvat;

    DigitalChannel lineSensor;

    double n = 0, k = 0, koef = 1;

    /*public enum State_Intake{
        NOTHING,
        GET_VALUE
    }
    public State_Intake state = State_Intake.NOTHING;*/
    public Intake(LinearOpMode opMode) {
        super(opMode);
        zahvat = hardwareMap.get(DcMotor.class, "zahvat");
        zahvat.setDirection(DcMotorSimple.Direction.FORWARD);
        zahvat.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        zahvat.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lineSensor = hardwareMap.get(DigitalChannel.class, "line_digital");
        lineSensor.setMode(DigitalChannel.Mode.INPUT);
    }
    public int IntakeR(float n) {
        int k = 0;
        while (k < 250000){
            zahvat.setPower(-0.4);
            k += 1;
        }
        zahvat.setPower(0);
        return 0;
    }
    public int Sensor_Auto(){
        int auto_line = 0;

       while (auto_line == 0){
            zahvat.setPower(0.7);
           if (lineSensor.getState() != true){
               auto_line +=1;
           }
        }
           zahvat.setPower(0);
        return 0;
    }
    public int Intake(float n) {
        int k = 0;
        while (k < 250000){
            zahvat.setPower(-0.7);
            k += 1;
        }
        zahvat.setPower(0);
        return 0;
    }
    public int IntakeL(float n) {
        int k = 0;
        while (k < 250000){
            zahvat.setPower(-0.4);
            k += 1;
        }
        zahvat.setPower(0);
        return 0;
    }

    public void teleop() {
        if (lineSensor.getState() == true) {
            telemetry.addData("Digital Touch", "Is Not Pressed");
        } else {
            telemetry.addData("Digital Touch", "Is Pressed");
           // n+=1;
            //k+=1;
        }
        telemetry.addData("n", n);
        telemetry.addData("k", k);
        telemetry.update();

            zahvat.setPower((gamepad2.left_trigger - gamepad2.right_trigger)* koef);

    }
}

