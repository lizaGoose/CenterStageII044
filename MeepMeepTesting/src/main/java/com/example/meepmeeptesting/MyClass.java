package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MyClass {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)


                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(38.945723632307676, 38.156578905846143, Math.toRadians(180), Math.toRadians(180), 6.93)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-38, 61.5, 0))
                                //.lineToLinearHeading(new Pose2d(-44, 21, Math.toRadians(0))) // senter
//                                .lineToLinearHeading(new Pose2d(-33, 32, 0)) // left
                                .lineToLinearHeading(new Pose2d(-56.4, 32, 0)) // right
                                .waitSeconds(0.3)
//                                .lineToLinearHeading(new Pose2d(-45, 32, 0))
//                                 .splineToLinearHeading(new Pose2d(-60, 12, 0), Math.toRadians(-90)) // left, senter
                                 .lineToLinearHeading(new Pose2d(-60, 12, 0))
                                .waitSeconds(0.9)

                                .waitSeconds(0.2)


                                //.splineToConstantHeading(new Vector2d(48, -50), 0)
                                .lineToLinearHeading(new Pose2d(36, 12, 0))
//                                .lineToLinearHeading(new Pose2d(49, 34, 0))
                                //.splineToLinearHeading(new Pose2d(49, 41, 0), Math.toRadians(0)) // left
                                .splineToLinearHeading(new Pose2d(49, 30, 0), Math.toRadians(0)) // right
                                .waitSeconds(0.5)
                                .lineToLinearHeading(new Pose2d(36, 12, 0))
                                .lineToLinearHeading(new Pose2d(-50, 12, 0))
                                .splineToLinearHeading(new Pose2d(-60, 12, 0), Math.toRadians(90))
                                .waitSeconds(0.6)
                                .lineToLinearHeading(new Pose2d(36, 12, 0))
                                .lineToLinearHeading(new Pose2d(49, 34, 0))
                                .waitSeconds(0.5)

                                .lineToLinearHeading(new Pose2d(42, 14, 0))


                                .build()
                );


        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}