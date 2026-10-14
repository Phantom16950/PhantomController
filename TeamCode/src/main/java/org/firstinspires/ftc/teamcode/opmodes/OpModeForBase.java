package org.firstinspires.ftc.teamcode.opmodes;

import com.pedropathing.ivy.Scheduler;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.GamePad;
@TeleOp
public class OpModeForBase extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Scheduler.reset();
        GamePad fucku = new GamePad(this);
        waitForStart();
        Scheduler.schedule(fucku);
        while (opModeIsActive()) {
            Scheduler.execute();
        }
    }
}