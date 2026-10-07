package org.firstinspires.ftc.teamcode.sample;

import static com.pedropathing.ivy.Scheduler.schedule;
import static com.pedropathing.ivy.commands.Commands.waitMs;
import static com.pedropathing.ivy.groups.Groups.parallel;

import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.Scheduler;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
public class TestCommandOpMode extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Scheduler.reset();
        SampleOfCommand z = new SampleOfCommand(this.hardwareMap, this.telemetry);
        Command rexab = parallel(
                z,
                waitMs(1000)
        );
        waitForStart();
        schedule(z);
        while (opModeIsActive()){
            Scheduler.execute();
        }

    }
}
