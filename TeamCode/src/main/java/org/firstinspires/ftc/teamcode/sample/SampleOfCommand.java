package org.firstinspires.ftc.teamcode.sample;

import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.behaviors.BlockedBehavior;
import com.pedropathing.ivy.behaviors.ConflictBehavior;
import com.pedropathing.ivy.behaviors.EndCondition;
import com.pedropathing.ivy.behaviors.InterruptedBehavior;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.Set;

public class SampleOfCommand implements Command {
    private ElapsedTime timer;
    private DcMotorEx lf, rf, lb, rb;

    private HardwareMap hw;
    private Telemetry tm;
    public SampleOfCommand(HardwareMap hw, Telemetry tm) {
        this.tm = tm;
        timer = new ElapsedTime();
        this.hw = hw;
        lf = hw.get(DcMotorEx.class, "lf");
        lb = hw.get(DcMotorEx.class, "lb");
        rf = hw.get(DcMotorEx.class, "rb");
        rb = hw.get(DcMotorEx.class, "rf");

        lf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        lf.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lb.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rf.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rb.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        rf.setDirection(DcMotorSimple.Direction.REVERSE);
        rb.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public Set<Object> requirements() {
        return Set.of(lf, rf, lb, rb);
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
        timer.reset();
        lf.setPower(0.3);
        rf.setPower(0.3);
        lb.setPower(0.3);
        rb.setPower(0.3);

    }

    @Override
    public boolean done() {
        return (timer.milliseconds() >= 1000);
    }

    @Override
    public void execute() {
        tm.addData("time", timer.milliseconds());
        tm.update();
    }

    @Override
    public void end(EndCondition endCondition) {
        lf.setPower(0);
        rf.setPower(0);
        lb.setPower(0);
        rb.setPower(0);
    }
}
