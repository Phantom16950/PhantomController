package org.firstinspires.ftc.teamcode.sample;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous
public class TestOpMode extends LinearOpMode {
    DcMotorEx rf, rb, lb, lf;

    @Override
    public void runOpMode() throws InterruptedException  {
        SampleOfCommand z = new SampleOfCommand(this.hardwareMap, this.telemetry);
        lf = hardwareMap.get(DcMotorEx.class, "lf");
        lb = hardwareMap.get(DcMotorEx.class, "lb");
        rf = hardwareMap.get(DcMotorEx.class, "rb");
        rb = hardwareMap.get(DcMotorEx.class, "rf");

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

        waitForStart();
        if (opModeIsActive()) {
            lb.setPower(0.9);
            rb.setPower(0.9);
            rf.setPower(0.9);
            lf.setPower(0.9);
            sleep(100);
            lb.setPower(-0.9);
            rb.setPower(0.9);
            rf.setPower(0.9);
            lf.setPower(-0.9);
            sleep(100);
            lb.setPower(0.9);
            rb.setPower(0.9);
            rf.setPower(0.9);
            lf.setPower(0.9);
            sleep(100);
            lb.setPower(0);
            rb.setPower(0);
            rf.setPower(0);
            lf.setPower(0);



        }
    }
}