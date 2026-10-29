package org.firstinspires.ftc.teamcode.commands;

import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.behaviors.BlockedBehavior;
import com.pedropathing.ivy.behaviors.ConflictBehavior;
import com.pedropathing.ivy.behaviors.EndCondition;
import com.pedropathing.ivy.behaviors.InterruptedBehavior;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import java.util.Set;

public class GamePad implements Command {
    private DcMotorEx lf, lb, rf, rb;
    private LinearOpMode opMode;
    public GamePad(LinearOpMode opMode) {
        this.opMode = opMode;
        lf = opMode.hardwareMap.get(DcMotorImplEx.class, "lf");
        lb = opMode.hardwareMap.get(DcMotorImplEx.class, "lb");
        rf = opMode.hardwareMap.get(DcMotorImplEx.class, "rf");
        rb = opMode.hardwareMap.get(DcMotorImplEx.class, "rb");

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
        double y = -opMode.gamepad1.left_stick_y - opMode.gamepad1.right_stick_y * 0.8; // Remember, Y stick is reversed!
        double x = opMode.gamepad1.left_stick_x + opMode.gamepad1.right_stick_x * 0.8;
        double rx = -opMode.gamepad1.left_trigger + opMode.gamepad1.right_trigger;

        if (opMode.gamepad1.left_bumper) {
            rx = rx - 0.6;
        } else if (opMode.gamepad1.right_bumper) {
            rx = rx + 0.6;
        }
        y = Math.pow(y, 3);
        x = Math.pow(x, 3);
        rx = Math.pow(rx, 3);

        lf.setPower(y + x + rx);
        lb.setPower(y - x + rx);
        rf.setPower(y - x - rx);
        rb.setPower(y + x - rx);
    }

    @Override
    public void end(EndCondition endCondition) {
        lf.setPower(0);
        lb.setPower(0);
        rf.setPower(0);
        rb.setPower(0);
    }
}
