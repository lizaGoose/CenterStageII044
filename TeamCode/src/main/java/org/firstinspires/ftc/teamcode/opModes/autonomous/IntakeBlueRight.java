package org.firstinspires.ftc.teamcode.opModes.autonomous;

        import com.acmerobotics.dashboard.config.Config;
        import com.acmerobotics.roadrunner.geometry.Pose2d;
        import com.acmerobotics.roadrunner.geometry.Vector2d;
        import com.acmerobotics.roadrunner.trajectory.Trajectory;
        import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.hardware.DcMotorSimple;

        import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
        import org.firstinspires.ftc.teamcode.Camera.PropDetection;
        import org.firstinspires.ftc.teamcode.Modules.IntakeSecondVersion;
        import org.firstinspires.ftc.teamcode.Modules.SpikeScorer;

        import org.firstinspires.ftc.teamcode.Robot1;

        import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
        import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
        import org.opencv.core.Mat;
        import org.openftc.easyopencv.OpenCvCamera;
        import org.openftc.easyopencv.OpenCvCameraFactory;
        import org.openftc.easyopencv.OpenCvCameraRotation;
        import org.openftc.easyopencv.OpenCvInternalCamera;

@Config
@Autonomous(group = "drive")
public class IntakeBlueRight extends LinearOpMode {
    Robot1 R;
    IntakeSecondVersion intake;
    SpikeScorer scorer;
    OpenCvCamera cam;
    DcMotor zahvat, vidvizh;

    @Override
    public void runOpMode() throws InterruptedException {

        R = new Robot1(this);
        scorer = new SpikeScorer(this);
        intake = new IntakeSecondVersion(this);
        zahvat = hardwareMap.get(DcMotor.class, "zahvat");
        zahvat.setDirection(DcMotorSimple.Direction.FORWARD);
        zahvat.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        zahvat.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        vidvizh = hardwareMap.get(DcMotor.class, "vidvizhenie_zahvata");
        vidvizh.setDirection(DcMotorSimple.Direction.FORWARD);
        vidvizh.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        vidvizh.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        TrajectorySequence firstCenter = R.drive.trajectorySequenceBuilder(new Pose2d())
                .splineToLinearHeading(new Pose2d(-5, -5, Math.toRadians(0)), Math.toRadians(0))
                .splineToLinearHeading(new Pose2d(-10, -38, Math.toRadians(0)), Math.toRadians(0))
                .waitSeconds(0.3)
                .addDisplacementMarker(() -> {
                    scorer.scor();

                    zahvat.setPower(1);
                })
                .splineToLinearHeading(new Pose2d(-22, -50, 0), 0)
                .waitSeconds(0.9)
                .addDisplacementMarker(() -> {
                    zahvat.setPower(-1);
                })

                //.splineToConstantHeading(new Vector2d(48, -50), 0)
                .splineToLinearHeading(new Pose2d(88, -28.5, 0), Math.toRadians(60))
                .addDisplacementMarker(()->zahvat.setPower(0))
                .build();
        TrajectorySequence secondSenter = R.drive.trajectorySequenceBuilder(firstCenter.end())
                .splineToLinearHeading(new Pose2d(64, -50, 0), 0)
                .addDisplacementMarker(() -> {

                    vidvizh.setTargetPosition(-1000);
                    zahvat.setPower(1);
                })
                .splineToLinearHeading(new Pose2d(0, -51, 0), Math.toRadians(180))
                .waitSeconds(0.9)
                .addDisplacementMarker(() -> {
                    vidvizh.setTargetPosition(0);
                    zahvat.setPower(-1);
                })


                //splineToConstantHeading(new Vector2d(48, -50), 0)

                .splineToLinearHeading(new Pose2d(88, -28.5, 0), Math.toRadians(60))
                .addDisplacementMarker(()->zahvat.setPower(0))

                .build();
        TrajectorySequence firstLeft = R.drive.trajectorySequenceBuilder(new Pose2d())
                .splineToLinearHeading(new Pose2d(-5, -5, Math.toRadians(0)), Math.toRadians(0))
                .splineToLinearHeading(new Pose2d(-1, -29, Math.toRadians(0)), Math.toRadians(0))
                //.lineToLinearHeading(new Pose2d(3, -29, 0))

                .waitSeconds(0.3)
                .addDisplacementMarker(() -> {
                    scorer.scor();

                    zahvat.setPower(1);
                })
                .splineToLinearHeading(new Pose2d(-22, -50, 0), 0)
                .waitSeconds(0.9)
                .addDisplacementMarker(() -> {
                    zahvat.setPower(-1);
                })



                //.splineToConstantHeading(new Vector2d(48, -50), 0)
                .splineToLinearHeading(new Pose2d(88, -28.5, 0), Math.toRadians(55))
                .addDisplacementMarker(()->zahvat.setPower(0))
                .build();
        TrajectorySequence firstRight = R.drive.trajectorySequenceBuilder(new Pose2d())
                .splineToLinearHeading(new Pose2d(-5, -5, Math.toRadians(0)), Math.toRadians(0))
                .splineToLinearHeading(new Pose2d(-20.5, -30, Math.toRadians(0)), Math.toRadians(0))
                //.lineToLinearHeading(new Pose2d(-18.5, -30, 0))
                .waitSeconds(0.3)
                .addDisplacementMarker(() -> {
                    scorer.scor();

                    zahvat.setPower(1);
                })
                .splineToLinearHeading(new Pose2d(-22, -52, 0), 0)
                .waitSeconds(0.7)
                .addDisplacementMarker(() -> {
                    zahvat.setPower(-1);
                })



                //.splineToConstantHeading(new Vector2d(48, -50), 0)
                .splineToLinearHeading(new Pose2d(88, -28.5, 0), Math.toRadians(55))
                .addDisplacementMarker(()->zahvat.setPower(0))
                .build();
        int cameraMonitorViewId = hardwareMap.appContext
                .getResources().getIdentifier("cameraMonitorViewId",
                        "id", hardwareMap.appContext.getPackageName());
        cam = OpenCvCameraFactory.getInstance()
                .createInternalCamera(OpenCvInternalCamera.CameraDirection.BACK, cameraMonitorViewId);
        cam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
        PropDetection detector = new PropDetection(telemetry);
        cam.setPipeline(detector);
        cam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                cam.startStreaming(800, 448, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode) {

            }
        });

        waitForStart();

        if (isStarted()) {

            switch (detector.getLocation()) {
                case LEFT:
                    intake.Autonomous6();
                    R.drive.followTrajectorySequence(firstRight);
                    R.drive.followTrajectorySequence(secondSenter);
                    //scorer.scor();
                    /*R.drive.followTrajectorySequence(UnderFermRunningRight);
                    R.drive.followTrajectorySequence(BackDropRunningRight);*/
                    /*intake.Autonomous2();
                    sleep(1000);
                    intake.Autonomoys7();
                    sleep(1000);
                    intake.Autonomous4();
                    sleep(500);
                    intake.Autonomous5();;
                    sleep(500);
                    intake.Autonomous6();*/
                   // R.drive.followTrajectorySequence(ParkingRight);
                    break;

                case RIGHT:
                    intake.Autonomous6();
                    R.drive.followTrajectorySequence(firstLeft);
                    R.drive.followTrajectorySequence(secondSenter);
                    //scorer.scor();
                    //R.drive.followTrajectorySequence(UnderFermRunningLeft);
                    /*R.drive.followTrajectorySequence(BackDropRunningLeft);*/
                    /*intake.Autonomous2();
                    sleep(1000);
                    intake.Autonomoys3();
                    sleep(1000);
                    intake.Autonomous4();
                    sleep(500);
                    intake.Autonomous5();;
                    sleep(500);
                    intake.Autonomous6();*/
                   // R.drive.followTrajectorySequence(ParkingLeft);

                    break;
                case CENTER:
                    intake.Autonomous6();
                    R.drive.followTrajectorySequence(firstCenter);
                    R.drive.followTrajectorySequence(secondSenter);
                    //scorer.scor();
                    //R.drive.followTrajectorySequence(UnderFermRunning);
                  //  R.drive.followTrajectorySequence(BackDropRunning);
                    /*intake.Autonomous2();
                    sleep(1000);
                    intake.Autonomoys3();
                    sleep(1000);
                    intake.Autonomous4();
                    sleep(500);
                    intake.Autonomous5();;
                    sleep(500);
                    intake.Autonomous6();*/
                  //  R.drive.followTrajectorySequence(Parking);
                    break;
                case NOT_FOUND:
                    break;
            }


        }
        cam.stopStreaming();


        while (!isStopRequested() && opModeIsActive());
    }
}