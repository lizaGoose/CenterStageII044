package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MyClass {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(600);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)


                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(38.945723632307676, 38.156578905846143, Math.toRadians(180), Math.toRadians(180), 6.93)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-38, 61.5, 0))
                                .lineToLinearHeading(new Pose2d(-44, 21, Math.toRadians(0))) // senter
                                .waitSeconds(0.3)

                                .lineToLinearHeading(new Pose2d(-60, 12, 0)) // left, senter

                                /*.lineToLinearHeading(new Pose2d(33, 32, 0))

                                .lineToLinearHeading(new Pose2d(49, 40, 0))
                                .lineToLinearHeading(new Pose2d(12, 58, 0))
                                .lineToLinearHeading(new Pose2d(-53, 58, 0))
                                .lineToLinearHeading(new Pose2d(-60, 34, 0))
                                .lineToLinearHeading(new Pose2d(-53, 58, 0))
                                .lineToLinearHeading(new Pose2d(12, 58, 0))
                                .lineToLinearHeading(new Pose2d(49, 32, 0))
                                .lineToLinearHeading(new Pose2d(42, 61, 0)) /*LEFT*/
                                /*.lineToLinearHeading(new Pose2d(21, 24, 0))
                                .lineToLinearHeading(new Pose2d(49, 34, 0))
                                .lineToLinearHeading(new Pose2d(12, 58, 0))
                                .lineToLinearHeading(new Pose2d(-53, 58, 0))
                                .lineToLinearHeading(new Pose2d(-60, 34, 0))
                                .lineToLinearHeading(new Pose2d(-53, 58, 0))
                                .lineToLinearHeading(new Pose2d(12, 58, 0))
                                .lineToLinearHeading(new Pose2d(49, 40, 0))
                                .lineToLinearHeading(new Pose2d(42, 61, 0)) CENTER  */

                                /*.lineToLinearHeading(new Pose2d(11, 35, 0))
                                .lineToLinearHeading(new Pose2d(49, 30, 0))
                                .lineToLinearHeading(new Pose2d(12, 58, 0))
                                .lineToLinearHeading(new Pose2d(-53, 58, 0))
                                .lineToLinearHeading(new Pose2d(-60, 34, 0))
                                .lineToLinearHeading(new Pose2d(-53, 58, 0))
                                .lineToLinearHeading(new Pose2d(12, 58, 0))
                                .lineToLinearHeading(new Pose2d(49, 40, 0))
                                .lineToLinearHeading(new Pose2d(42, 61, 0)) RIGHT */
                                .build()
                );


        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}