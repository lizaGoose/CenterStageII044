package org.firstinspires.ftc.teamcode.opModes.teleop;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Modules.Goose;
import org.firstinspires.ftc.teamcode.Modules.Intake;
import org.firstinspires.ftc.teamcode.Modules.IntakeSecondVersion;
import org.firstinspires.ftc.teamcode.Modules.Intake_mover;
import org.firstinspires.ftc.teamcode.Modules.Lift;
import org.firstinspires.ftc.teamcode.Modules.Scorer;
import org.firstinspires.ftc.teamcode.Modules.SkorMover;
import org.firstinspires.ftc.teamcode.Modules.SpikeScorer;
import org.firstinspires.ftc.teamcode.Modules.V4bMover;
import org.firstinspires.ftc.teamcode.Modules.Virtual4bar;
import org.firstinspires.ftc.teamcode.Modules.Shuter;
import org.firstinspires.ftc.teamcode.Robot1;
@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOp extends LinearOpMode {
    @Override

    public void runOpMode() {

        Robot1 R = new Robot1(this);
        Goose goose = new Goose(this);
        Shuter shuter = new Shuter(this);
        IntakeSecondVersion intake = new IntakeSecondVersion(this);
        //Intake intake_2 = new Intake(this);
        //Intake_mover intmov = new Intake_mover(this);
        Lift lift = new Lift(this);
        Scorer scor = new Scorer(this);
        V4bMover v4bMover = new V4bMover(this);
        Virtual4bar v4b = new Virtual4bar(this);
        SpikeScorer spike = new SpikeScorer(this);
        SkorMover skorMover = new SkorMover(this);

        waitForStart();

        while (!isStopRequested()) {
            goose.teleop();
            intake.teleop();
          //  intmov.teleop();
           // intake_2.teleop();
            lift.teleop();
            scor.teleop();
           // v4bMover.teleop();
          //  v4b.teleop();
            shuter.teleop();
           // spike.teleop();
            //intake.Sensor();
            R.control();
            skorMover.teleop();
        }
    }
}

