package org.firstinspires.ftc.teamcode.sample;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;


@TeleOp(name = "Gamepad", group = "TeleOp")
@Disabled
public class DedOpMode extends OpMode {
    DcMotor leftF, rightF, leftB, rightB, Ruka1, Ruka2, Ruka3, Pisun;
    Servo Serv2, Serv3, Serv4;
    CRServo Serv, Serv5;


    @Override
    public void init() {
        leftF = hardwareMap.dcMotor.get("lf");
        leftB = hardwareMap.dcMotor.get("lr");
        rightF = hardwareMap.dcMotor.get("rf");
        rightB = hardwareMap.dcMotor.get("rr");
        Serv = hardwareMap.crservo.get("OBT_1");
        Serv2 = hardwareMap.servo.get("OBT_2");
        Serv3 = hardwareMap.servo.get("OBT_3");
        Serv4 = hardwareMap.servo.get("OBT_4");
        Serv5 = hardwareMap.crservo.get("OBT_5");
        Ruka1 = hardwareMap.dcMotor.get("rk1");
        Ruka2 = hardwareMap.dcMotor.get("rk2");
        Ruka3 = hardwareMap.dcMotor.get("rk3");
        Pisun = hardwareMap.dcMotor.get("pisun");


    }


    @Override

    public void loop() {
        float pwrTrigger = (gamepad1.left_trigger);
        float pwrTrigger2 = (gamepad1.right_trigger);
        float pwrTrigger3 = (float) (gamepad2.left_trigger * 0.66);
        float pwrTrigger4 = (float) (gamepad2.right_trigger * 0.66);
        float StickX = (float) (gamepad1.right_stick_x * 0.3);
        float StickY = (float) (gamepad1.right_stick_y * 0.3);
        float Stick2X = (gamepad1.left_stick_x);
        float Stick2Y = (gamepad1.left_stick_y);

        double power = -1;


        if (gamepad1.x) {
            power = 1;
        }
        if (gamepad1.b) {
            power = -1;
        }
        if (gamepad1.right_bumper) {
            Pisun.setPower(-1);
        } else if (gamepad1.left_bumper) {
            Pisun.setPower(1);
        } else {
            Pisun.setPower(0);
        }
        if (gamepad1.right_bumper) {
            Pisun.setPower(0.5);
        } else if (gamepad1.left_bumper) {
                Pisun.setPower(-0.5);
        } else {
                Pisun.setPower(0);
            }



        if (StickY != 0 || StickX != 0) {
            leftF.setPower(-StickY - StickX);
            rightB.setPower(+StickY + StickX);
            rightF.setPower(+StickY - StickX);
            leftB.setPower(-StickY + StickX);
        } else if (Stick2Y != 0 || Stick2X != 0) {
            leftF.setPower(-Stick2Y - Stick2X);
            rightB.setPower(+Stick2Y + Stick2X);
            rightF.setPower(+Stick2Y - Stick2X);
            leftB.setPower(-Stick2Y + Stick2X);
        } else if (pwrTrigger != 0) {
            leftF.setPower(0.5 * pwrTrigger);
            rightB.setPower(0.5 * pwrTrigger);
            rightF.setPower(0.5 * pwrTrigger);
            leftB.setPower(0.5 * pwrTrigger);
        } else if (pwrTrigger2 != 0) {
            leftF.setPower(-0.5 * pwrTrigger2);
            rightB.setPower(-0.5 * pwrTrigger2);
            rightF.setPower(-0.5 * pwrTrigger2);
            leftB.setPower(-0.5 * pwrTrigger2);
        } else {
            leftF.setPower(0);
            rightB.setPower(0);
            rightF.setPower(0);
            leftB.setPower(0);

        }
        if (gamepad2.b) {
            Ruka1.setPower(0.45);
        } else if (gamepad2.a) {
            Ruka1.setPower(-0.45);
        } else {
            Ruka1.setPower(0);

            if (pwrTrigger3 != 0) {
                Ruka2.setPower(0.5 * pwrTrigger3);
            } else if (0.5 * pwrTrigger4 != 0) {
                Ruka2.setPower(pwrTrigger4);
            } else if (gamepad2.left_bumper) {
                Ruka2.setPower(1);
            } else if (gamepad2.right_bumper) {
                Ruka2.setPower(-1);
            } else {
                Ruka2.setPower(0);
            }
            if (gamepad2.dpad_down) {
                Ruka3.setPower(0.5);
            } else if (gamepad2.dpad_up) {
                Ruka3.setPower(-0.5);
            } else {
                Ruka3.setPower(0);
            }
            if (gamepad1.y) {
                Serv.setPower(1);

            } else if (gamepad1.a) {
                Serv.setPower(-0.9);
            } else {
                Serv.setPower(-0.9);
                if (gamepad2.x) {

                    Serv4.setPosition(0);
                } else {
                    Serv4.setPosition(0.5);
                }

            } if (gamepad1.dpad_right) {
                Serv2.setPosition(0.85);
                Serv3.setPosition(0.85);
            } else if (gamepad2.dpad_right) {
                Serv2.setPosition(0.85);
                Serv3.setPosition(0.85);


            } else if (gamepad1.dpad_left) {
                Serv2.setPosition(0.8);
                Serv3.setPosition(0.8);
            } else if (gamepad2.dpad_left) {
                Serv2.setPosition(0.8);
                Serv3.setPosition(0.8);


            } else {
                Serv2.setPosition(0);
                Serv3.setPosition(0);

            }
        }








                 /*
            } else if (gamepad1.a) {
                pod.setPower(1);
            } else if (gamepad1.y) {
                pod.setPower(-1);
            }else
            if (gamepad1.x) {
                Serv.setPower(1);

            } else if (gamepad1.b) {
                Serv.setPower(-1);

            } else
            if (gamepad1.dpad_up) {
                leftF.setPower(-0.8 * pwrTrigger);
                rightB.setPower(0.8 * pwrTrigger);
                rightF.setPower(0.8 * pwrTrigger);
                leftB.setPower(-0.8 * pwrTrigger);
            } else if (gamepad1.dpad_down) {
                leftF.setPower(0.8 * pwrTrigger);
                rightB.setPower(-0.8 * pwrTrigger);
                rightF.setPower(-0.8 * pwrTrigger);
                leftB.setPower(0.8 * pwrTrigger);
            } else if (gamepad1.dpad_left) {
                leftF.setPower(0.8 * pwrTrigger);
                rightB.setPower(-0.8 * pwrTrigger);
                rightF.setPower(0.8 * pwrTrigger);
                leftB.setPower(-0.8 * pwrTrigger);
            } else if (gamepad1.dpad_right) {
            }


*/
            /*else if (gamepad2.left_bumper) {
                ServT.setPower(1);
            } else if (gamepad2.right_bumper) {
                ServT.setPower(-1);
            } else if (gamepad2.dpad_down) {
                Serv.setPower(1);

            } else if (gamepad2.dpad_up) {
                Serv.setPower(-1);

            } else if (gamepad2.dpad_left) {
                Serv2.setPower(1);
            } else if (gamepad2.dpad_right) {
                Serv2.setPower(-1);
            } else  if  (gamepad2.b) {
                ruka1.setPower(-0.8 * pwrTrigger2);
                ruka2.setPower(0.8 * pwrTrigger2);
            } else  if  (gamepad2.x) {
                ruka1.setPower(0.4 * pwrTrigger2);
                ruka2.setPower(-0.4 * pwrTrigger2);
            } else  if  (gamepad2.dpad_right) {
                ruka3.setPower(0.4 * pwrTrigger2);
            } else  if  (gamepad2.dpad_left) {
                ruka3.setPower(-0.4 * pwrTrigger2);

            } else  if  (gamepad2.left_stick_button) {
                    ruka2.setPower(0);

            }  else   {
                leftF.setPower(0);
                rightB.setPower(0);
                rightF.setPower(0);
                leftB.setPower(0);
                ruka1.setPower(0.0);
                ruka2.setPower(0);
                ruka3.setPower(0);

                pod.setPower(0);
                Serv.setPower(0);
                Serv2.setPower(0);
                ServT.setPower(0);
                /*
             */


    }
}