package org.firstinspires.ftc.teamcode.opmodes;

import com.pedropathing.ivy.Scheduler;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.GunMotor;

@TeleOp
public class OpModes extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Scheduler.reset();
        GunMotor gunMotor = new GunMotor(this);
        waitForStart();
        Scheduler.schedule(gunMotor);
        while (opModeIsActive()){
            Scheduler.execute();
        }

        }
    }


