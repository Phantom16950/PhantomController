package org.firstinspires.ftc.teamcode.commands;

import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.behaviors.BlockedBehavior;
import com.pedropathing.ivy.behaviors.ConflictBehavior;
import com.pedropathing.ivy.behaviors.EndCondition;
import com.pedropathing.ivy.behaviors.InterruptedBehavior;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;

import java.util.Set;

public class GamePad implements Command {
    private DcMotorEx r1, r2, l1, l2;
    private LinearOpMode opMode;
    public GamePad(LinearOpMode opMode) {
        this.opMode = opMode;
        r1 = opMode.hardwareMap.get(DcMotorImplEx.class, "r1"); /* rb */
        r2 = opMode.hardwareMap.get(DcMotorImplEx.class, "r2"); /* rf */
        l1 = opMode.hardwareMap.get(DcMotorImplEx.class, "l1"); /* lf */
        l2 = opMode.hardwareMap.get(DcMotorImplEx.class, "l2"); /* lb */
    }
    @Override
    public Set<Object> requirements() {
        return Set.of(r1, r2, l1, l2);
    }

    @Override
    public int priority() {
        return 0;
    }

    @Override
    public InterruptedBehavior interruptedBehavior() {
        return null;
    }

    @Override
    public ConflictBehavior conflictBehavior() {
        return null;
    }

    @Override
    public BlockedBehavior blockedBehavior() {
        return null;
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
        if (opMode.gamepad1.right_bumper) {
            r1.setPower(1);
        } else {
            r1.setPower(0);
        }
        if (opMode.gamepad1.left_bumper) {
            r2.setPower(1);
        } else {
            r2.setPower(0);
        }
        if (opMode.gamepad1.back) {
            l1.setPower(1);
        } else {
            l1.setPower(0);
        }
        if (opMode.gamepad1.ps) {
            l2.setPower(1);
        } else {
            l2.setPower(0);
        }
        opMode.gamepad1.rumble(1000);
        opMode.sleep(1000);
    }

    @Override
    public void end(EndCondition endCondition) {
        r1.setPower(0);
        r2.setPower(0);
        l1.setPower(0);
        l2.setPower(0);
    }
}
