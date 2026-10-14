package org.firstinspires.ftc.teamcode.commands;

import com.bylazar.field.Line;
import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.behaviors.BlockedBehavior;
import com.pedropathing.ivy.behaviors.ConflictBehavior;
import com.pedropathing.ivy.behaviors.EndCondition;
import com.pedropathing.ivy.behaviors.InterruptedBehavior;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.Collections;
import java.util.Set;

public class GunMotor implements Command {
    private DcMotorEx gun;
    private LinearOpMode opMode;
    private byte t = 0;

    public GunMotor(LinearOpMode opMode) {
        this.opMode = opMode;
        gun = opMode.hardwareMap.get(DcMotorEx.class, "gun");
    }

    @Override
    public Set<Object> requirements() {
        return Set.of(gun);
    }

    @Override
    public int priority() {
        return 0;
    }

    @Override
    public InterruptedBehavior interruptedBehavior() {
        return InterruptedBehavior.END;
    }

    @Override
    public ConflictBehavior conflictBehavior() {
        return ConflictBehavior.QUEUE;
    }

    @Override
    public BlockedBehavior blockedBehavior() {
        return BlockedBehavior.QUEUE;
    }

    @Override
    public void start() {

    }

    @Override
    public boolean done() {
        return opMode.isStopRequested();

    }

    @Override
    public void execute() {

        if (opMode.gamepad1.a) {
            if (t == -76) {
                t = 0;
            } else if (t == 0) {
                t = -76;
            }
        }

        if (t == -76) {
            gun.setPower(1);
        } else if (t == 0) {
            gun.setPower(0);
        }

    }

    @Override
    public void end(EndCondition endCondition) {
        gun.setPower(0);
        t = 0;

    }

}
