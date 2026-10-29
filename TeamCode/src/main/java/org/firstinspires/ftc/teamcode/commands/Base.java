package org.firstinspires.ftc.teamcode.commands;

import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.behaviors.BlockedBehavior;
import com.pedropathing.ivy.behaviors.ConflictBehavior;
import com.pedropathing.ivy.behaviors.EndCondition;
import com.pedropathing.ivy.behaviors.InterruptedBehavior;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import java.util.Collections;
import java.util.Set;

public class Base implements Command {
    private DcMotorEx lf, lb, rf, rb;
    private LinearOpMode opMode;
    public Base(LinearOpMode opMode) {
        this.opMode = opMode;
        lf = opMode.hardwareMap.get(DcMotorEx.class, "lf");
        rf = opMode.hardwareMap.get(DcMotorEx.class, "rf");
        lb = opMode.hardwareMap.get(DcMotorEx.class, "lb");
        rb = opMode.hardwareMap.get(DcMotorEx.class, "rb");

        rf.setDirection(DcMotorSimple.Direction.REVERSE);
        rb.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    @Override
    public Set<Object> requirements() {
        return Set.of(lf, lb, rf, rb);
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
        if  (opMode.gamepad1.left_stick_y < -0.5) {
            lb.setPower(0.6);
            lf.setPower(0.6);
            rf.setPower(0.6);
            rb.setPower(0.6);

        } else {
            lb.setPower(0);
            lf.setPower(0);
            rf.setPower(0);
            rb.setPower(0);

        }

        if (opMode.gamepad1.left_stick_y > 0.5) {
            lb.setPower(-0.6);
            lf.setPower(-0.6);
            rf.setPower(-0.6);
            rb.setPower(-0.6);

        } else {
            lb.setPower(0);
            lf.setPower(0);
            rf.setPower(0);
            rb.setPower(0);

        }

        if (opMode.gamepad1.right_trigger_pressed) {
            lb.setPower(0.6);
            lf.setPower(0.6);
            rf.setPower(-0.6);
            rb.setPower(-0.6);

        } else {
            lb.setPower(0);
            lf.setPower(0);
            rf.setPower(0);
            rb.setPower(0);

        }

        if (opMode.gamepad1.left_trigger_pressed) {
            lb.setPower(-0.6);
            lf.setPower(-0.6);
            rf.setPower(0.6);
            rb.setPower(0.6);

        } else {
            lb.setPower(0);
            lf.setPower(0);
            rf.setPower(0);
            rb.setPower(0);

        }

        if (opMode.gamepad1.left_stick_x < -0.5) {
            lb.setPower(0.6);
            lf.setPower(-0.6);
            rf.setPower(0.6);
            rb.setPower(-0.6);

        } else {
            lb.setPower(0);
            lf.setPower(0);
            rf.setPower(0);
            rb.setPower(0);

        }

        if (opMode.gamepad1.left_stick_x > 0.5) {
            lb.setPower(-0.6);
            lf.setPower(0.6);
            rf.setPower(-0.6);
            rb.setPower(0.6);

        } else {
            lb.setPower(0);
            lf.setPower(0);
            rf.setPower(0);
            rb.setPower(0);

        }

        if (opMode.gamepad1.right_stick_y < -0.5) {
            lb.setPower(0.3);
            lf.setPower(0.3);
            rf.setPower(0.3);
            rb.setPower(0.3);

        } else {
            lb.setPower(0);
            lf.setPower(0);
            rf.setPower(0);
            rb.setPower(0);

        }

        if (opMode.gamepad1.right_stick_y > 0.5) {
            lb.setPower(-0.3);
            lf.setPower(-0.3);
            rf.setPower(-0.3);
            rb.setPower(-0.3);

        } else {
            lb.setPower(0);
            lf.setPower(0);
            rf.setPower(0);
            rb.setPower(0);

        }

        if (opMode.gamepad1.right_stick_x < -0.5) {
            lb.setPower(0.3);
            lf.setPower(-0.3);
            rf.setPower(0.3);
            rb.setPower(-0.3);

        } else {
            lb.setPower(0);
            lf.setPower(0);
            rf.setPower(0);
            rb.setPower(0);

        }

        if (opMode.gamepad1.right_stick_x > 0.5) {
            lb.setPower(-0.3);
            lf.setPower(0.3);
            rf.setPower(-0.3);
            rb.setPower(0.3);

        } else {
            lb.setPower(0);
            lf.setPower(0);
            rf.setPower(0);
            rb.setPower(0);

        }
    }

    @Override
    public void end(EndCondition endCondition) {
        lf.setPower(0);
        lb.setPower(0);
        rf.setPower(0);
        rb.setPower(0);
    }
}
