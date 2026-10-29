package org.firstinspires.ftc.teamcode.opmodes;

import com.pedropathing.ivy.Scheduler;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.commands.Base;

@TeleOp
public class BaseOpMode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Scheduler.reset();
        Base unity = new Base(this);
        waitForStart();
        Scheduler.schedule(unity);
        while (opModeIsActive()) {
            Scheduler.execute();
        }
    }
}
