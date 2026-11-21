package org.firstinspires.ftc.teamcode.sample;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
@Disabled
public class TeleOpMode extends LinearOpMode {
    DcMotorEx lf, rf, lb, rb, siska;
    @Override
    public void runOpMode() throws InterruptedException {

        lf = hardwareMap.get(DcMotorEx.class, "lf");
        rf = hardwareMap.get(DcMotorEx.class, "rf");
        lb = hardwareMap.get(DcMotorEx.class, "lb");
        rb = hardwareMap.get(DcMotorEx.class, "rb");
        siska = hardwareMap.get(DcMotorEx.class, "siska");


        lf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        zh.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        siska.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        lf.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rf.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lb.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rb.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        zh.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        siska.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        rf.setDirection(DcMotorSimple.Direction.REVERSE);
        rb.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()){

        if  ((gamepad1.left_stick_y < -0.5)) {
            lb.setPower(0.7);
            lf.setPower(0.7);
            rf.setPower(0.7);
            rb.setPower(0.7);

        } else if ((gamepad1.left_stick_y > 0.5)) {
            lb.setPower(-0.7);
            lf.setPower(-0.7);
            rf.setPower(-0.7);
            rb.setPower(-0.7);

        } else if ((gamepad1.right_trigger_pressed)) {
            lb.setPower(0.7);
            lf.setPower(0.7);
            rf.setPower(-0.7);
            rb.setPower(-0.7);

        } else if ((gamepad1.left_trigger_pressed)) {
            lb.setPower(-0.7);
            lf.setPower(-0.7);
            rf.setPower(0.7);
            rb.setPower(0.7);

        } else if ((gamepad1.left_stick_x < -0.5)) {
            lb.setPower(0.7);
            lf.setPower(-0.7);
            rf.setPower(0.7);
            rb.setPower(-0.7);

        } else if ((gamepad1.left_stick_x > 0.5)) {
            lb.setPower(-0.7);
            lf.setPower(0.7);
            rf.setPower(-0.7);
            rb.setPower(0.7);

        } else if  ((gamepad1.right_stick_y < -0.5)) {
            lb.setPower(0.4);
            lf.setPower(0.4);
            rf.setPower(0.4);
            rb.setPower(0.4);

        } else if ((gamepad1.right_stick_y > 0.5)) {
            lb.setPower(-0.4);
            lf.setPower(-0.4);
            rf.setPower(-0.4);
            rb.setPower(-0.4);

        } else if ((gamepad1.right_stick_x < -0.5)) {
            lb.setPower(0.4);
            lf.setPower(-0.4);
            rf.setPower(0.4);
            rb.setPower(-0.4);
        } else if ((gamepad1.right_stick_x > 0.5)) {
            lb.setPower(-0.4);
            lf.setPower(0.4);
            rf.setPower(-0.4);
            rb.setPower(0.4);
        } else if ((gamepad1.a)){
//            zh.setPower(0.7);
        } else if(gamepad1.b){
            siska.setPower(0.7);
        }
        else {
            lb.setPower(0);
            lf.setPower(0);
            rf.setPower(0);
            rb.setPower(0);
            siska.setPower(0);
        }
        }
        }
}



