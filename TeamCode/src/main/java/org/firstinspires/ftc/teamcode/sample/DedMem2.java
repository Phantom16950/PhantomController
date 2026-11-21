
package org.firstinspires.ftc.teamcode.sample;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;
import org.openftc.easyopencv.OpenCvPipeline;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maryjaneb  on 11/13/2016.
 *
 * nerverest ticks
 * 60 1680
 * 40 1120
 * 20 560
 *
 * monitor: 640 x 480
 *Y
 */
@Autonomous(name= "SIniy_sky", group="Autonomous")
@Disabled
//comment out this line before using
public class DedMem2 extends LinearOpMode {
    DcMotor leftF, rightF, leftB, rightB, Ruka1, Ruka2, Ruka3;
    CRServo Serv, Serv5;
    Servo Serv2, Serv3, Serv4;
    int oborot = 1440;
    int D_O = 1390;
    double speed = 0.3;


    private ElapsedTime runtime = new ElapsedTime();

    //0 means skystone, 1 means yellow stone
//-1 for debug, but we can keep it like this because if it works, it should change to either 0 or 255
    private static int valMid = -1;


    private static float rectHeight = .6f / 8f;
    private static float rectWidth = 1.5f / 8f;

    private static float offsetX = 0f / 8f;//changing this moves the three rects and the three circles left or right, range : (-2, 2) not inclusive
    private static float offsetY = 0f / 8f;//changing this moves the three rects and circles up or down, range: (-4, 4) not inclusive

    private static float[] midPos = {4f / 8f + offsetX, 4f / 8f + offsetY};//0 = col, 1 = row
//moves all rectangles right or left by amount. units are in ratio to monitor

    private final int rows = 640;
    private final int cols = 480;

    OpenCvCamera phoneCam;


    public void resetEncoders() {
        leftB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void vpered(int pos, double speed) {
        leftF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftF.setTargetPosition(-pos);
        rightB.setTargetPosition(pos);
        rightF.setTargetPosition(pos);
        leftB.setTargetPosition(-pos);
        leftF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftF.setPower(speed);
        rightB.setPower(speed);
        rightF.setPower(speed);
        leftB.setPower(speed);
        while (opModeIsActive() && (leftF.isBusy()) && (rightF.isBusy()) && (rightB.isBusy()) && (leftB.isBusy())) {

        }

        // Stop all motion;
        rightB.setPower(0);
        leftB.setPower(0);
        rightF.setPower(0);
        leftF.setPower(0);
        sleep(100);

    }
    public void vpered_dlin(int pos, double speed) {

        leftF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftF.setTargetPosition(-pos);
        rightB.setTargetPosition(pos);
        rightF.setTargetPosition(pos);
        leftB.setTargetPosition(-pos);
        leftF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftF.setPower(speed-0.1);
        rightB.setPower(speed);
        rightF.setPower(speed-0.1);
        leftB.setPower(speed-0.3);
        while (opModeIsActive() && (leftF.isBusy()) && (rightF.isBusy()) && (rightB.isBusy()) && (leftB.isBusy())) {

        }

        // Stop all motion;
        rightB.setPower(0);
        leftB.setPower(0);
        rightF.setPower(0);
        leftF.setPower(0);
        sleep(100);

    }

    public void LB(int pos, double speed) {

        leftF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftF.setTargetPosition(pos);
        rightB.setTargetPosition(-pos);
        leftF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftF.setPower(speed);
        rightB.setPower(speed);

        while (opModeIsActive() && (leftF.isBusy()) && (rightB.isBusy())) {

            telemetry.addData("Path2", "Running at %7d :%7d : %7d :%7d",
                    leftF.getCurrentPosition(),
                    rightB.getCurrentPosition(), rightF.getCurrentPosition(), leftB.getCurrentPosition());
            telemetry.update();
        }

        // Stop all motion;
        rightB.setPower(0);
        leftB.setPower(0);
        rightF.setPower(0);
        leftF.setPower(0);
        sleep(100);
    }

    public void RB(int pos, double speed) {

        leftF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftB.setTargetPosition(pos);
        rightF.setTargetPosition(-pos);
        leftF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightF.setPower(speed);
        leftB.setPower(speed);

        while (opModeIsActive() && (leftB.isBusy()) && (rightF.isBusy())) {

            telemetry.addData("Path2", "Running at %7d :%7d : %7d :%7d",
                    leftF.getCurrentPosition(),
                    rightB.getCurrentPosition(), rightF.getCurrentPosition(), leftB.getCurrentPosition());
            telemetry.update();
        }

        // Stop all motion;
        rightB.setPower(0);
        leftB.setPower(0);
        rightF.setPower(0);
        leftF.setPower(0);
        sleep(100);

    }

    public void LF(int pos, double speed) {

        leftF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftB.setTargetPosition(-pos);
        rightF.setTargetPosition(pos);
        leftF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightF.setPower(speed);
        leftB.setPower(speed);

        while (opModeIsActive() && (leftB.isBusy()) && (rightF.isBusy())) {

            telemetry.addData("Path2", "Running at %7d :%7d : %7d :%7d",
                    leftF.getCurrentPosition(),
                    rightB.getCurrentPosition(), rightF.getCurrentPosition(), leftB.getCurrentPosition());
            telemetry.update();
        }

        // Stop all motion;
        rightB.setPower(0);
        leftB.setPower(0);
        rightF.setPower(0);
        leftF.setPower(0);
        sleep(100);

    }

    public void nazad2() {
        leftF.setPower(-0.3);
        rightB.setPower(0.3);
        rightF.setPower(0.3);
        leftB.setPower(-0.5);
        Ruka1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }


    public void nazad() {
        leftF.setPower(speed);
        rightB.setPower(-speed);
        rightF.setPower(-speed);
        leftB.setPower(speed);
    }

    public void vpravo(int pos, double speed) {

        leftF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftF.setTargetPosition(-pos);
        rightB.setTargetPosition(pos);
        rightF.setTargetPosition(-pos);
        leftB.setTargetPosition(pos);
        leftF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftF.setPower(speed);
        rightB.setPower(speed);
        rightF.setPower(speed);
        leftB.setPower(speed);
        while (opModeIsActive() && (leftF.isBusy()) && (rightF.isBusy()) && (rightB.isBusy()) && (leftB.isBusy())) {

            telemetry.addData("Path2", "Running at %7d :%7d : %7d :%7d",
                    leftF.getCurrentPosition(),
                    rightB.getCurrentPosition(), rightF.getCurrentPosition(), leftB.getCurrentPosition());
            telemetry.update();
        }
        rightB.setPower(0);
        leftB.setPower(0);
        rightF.setPower(0);
        leftF.setPower(0);
        sleep(100);
    }

    public void razvarot(int pos, double speed) {
        leftF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftF.setTargetPosition(pos);
        rightB.setTargetPosition(pos);
        rightF.setTargetPosition(pos);
        leftB.setTargetPosition(pos);
        leftF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftF.setPower(speed);
        rightB.setPower(speed);
        rightF.setPower(speed);
        leftB.setPower(speed);
        while (opModeIsActive() && (leftF.isBusy()) && (rightF.isBusy()) && (rightB.isBusy()) && (leftB.isBusy())) {

            telemetry.addData("Path2", "Running at %7d :%7d : %7d :%7d",
                    leftF.getCurrentPosition(),
                    rightB.getCurrentPosition(), rightF.getCurrentPosition(), leftB.getCurrentPosition());
            telemetry.update();
        }
        rightB.setPower(0);
        leftB.setPower(0);
        rightF.setPower(0);
        leftF.setPower(0);
    }

    public void vpered2() {
        leftF.setPower(-0.3);
        rightB.setPower(0.3);
        rightF.setPower(0.3);
        leftB.setPower(-0.5);
        Ruka1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }


    public void nazad3() {
        leftF.setPower(speed);
        rightB.setPower(-speed);
        rightF.setPower(-speed);
        leftB.setPower(speed);
        Serv.setPower(1);
    }


    public void vpravo2() {
        leftF.setPower(-speed);
        rightB.setPower(speed);
        rightF.setPower(-speed);
        leftB.setPower(speed);
        Ruka1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void vlevo() {
        leftF.setPower(speed);
        rightB.setPower(-speed);
        rightF.setPower(speed);
        leftB.setPower(-speed);
    }

    public void razvarotplus() {
        leftF.setPower(speed);
        rightB.setPower(speed);
        rightF.setPower(speed);
        leftB.setPower(speed);
    }

    public void zaxvat() {
        Serv.setPower(1);
    }

    public void otpust() {
        Serv.setPower(0.2);
    }

    public void razvarotplus3() {
        leftF.setPower(speed);
        rightB.setPower(speed);
        rightF.setPower(speed);
        leftB.setPower(speed);
        Serv.setPower(1);
    }


    public void razvarotminus() {
        leftF.setPower(-speed);
        rightB.setPower(-speed);
        rightF.setPower(-speed);
        leftB.setPower(-speed);
    }

    public void stop_all() {
        rightB.setPower(-0);
        leftB.setPower(0);
        rightF.setPower(-0);
        leftF.setPower(0);
    }

    public void stop_all3() {
        rightB.setPower(-0);
        leftB.setPower(0);
        rightF.setPower(-0);
        leftF.setPower(0);

        Ruka1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }


    @Override
    public void runOpMode() throws InterruptedException {
        leftF = hardwareMap.dcMotor.get("lf");
        leftB = hardwareMap.dcMotor.get("lr");
        rightF = hardwareMap.dcMotor.get("rf");
        rightB = hardwareMap.dcMotor.get("rr");
        Serv = hardwareMap.crservo.get("OBT_1");
        Ruka1 = hardwareMap.dcMotor.get("rk1");
        Ruka2 = hardwareMap.dcMotor.get("rk2");
        Ruka3 = hardwareMap.dcMotor.get("rk3");
        Serv2 = hardwareMap.servo.get("OBT_2");
        Serv3 = hardwareMap.servo.get("OBT_3");
        Serv4 = hardwareMap.servo.get("OBT_4");
        Serv5 = hardwareMap.crservo.get("OBT_5");

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());

        //P.S. if you're using the latest version of easyopencv, you might need to change the next line to the following:
        phoneCam = OpenCvCameraFactory.getInstance().createInternalCamera(OpenCvInternalCamera.CameraDirection.BACK, cameraMonitorViewId);

        phoneCam.openCameraDevice();//open camera
        phoneCam.setPipeline(new StageSwitchingPipeline());//different stages
        phoneCam.startStreaming(rows, cols, OpenCvCameraRotation.UPRIGHT);//display on RC
        waitForStart();
        while (opModeIsActive()) {

            Serv4.setPosition(0.5);
            Serv5.setPower(0);
            sleep(1);
            vpered(1000, 0.5);

            int k = 3;
            int O = 1;
            for (int n = 0; n <= k; opModeIsActive()) {
                if (valMid == 0 && n != 2 && opModeIsActive()) {
                    phoneCam.closeCameraDevice();
                    if (n == 0)
                        vpravo(50, 1);
                    if (n == 0)
                        O = 3;
                    vpered(1000, 1);
                    sleep(400);
                    razvarot((int) (D_O / 2), 0.5);
                    sleep(400);
                    vpered(1000, 1);
                    sleep(400);
                    razvarot((int) (-D_O / 2), 0.5);
                    vpravo(-1000, 0.5);
                } else if (n == 2 && opModeIsActive()) {
                    phoneCam.closeCameraDevice();
                    vpered(-958, 0.5);
                    zaxvat();
                    sleep(400);
                    vpered(-150, 1);
                    vpered(450, 5);
                    stop_all();
                    sleep(200);
                    vpered(-150, 0.5);
                    vpered(720, 0.5);
                    razvarot(D_O, 1);
                    Ruka1.setPower(0.4);
                    Ruka2.setPower(0.6);
                    sleep(400);
                    stop_all();
                    sleep(100);
                    Ruka1.setPower(0);
                    Ruka2.setPower(0);
                    sleep(200);
                    stop_all();
                    sleep(300);
                    vpered_dlin(-4000, 1);
                    otpust();
                    sleep(400);
                    vpered_dlin(3000, 1);
                    vpravo(400, 1);
                    vpered(1800, 1);

                    razvarot(-D_O + 50, 1);
                    vpravo(-1200, 0.5);
                    vpered(-1200, 0.5);
                    razvarot(-700, 0.5);
                    vpered(-700, 0.5);
                    zaxvat();
                    sleep(400);
                    vpered(-50, 1);
                    vpered(300, 0.5);
                    vpered(-200, 1);
                    vpered(1550, 1);
                    stop_all();
                    sleep(300);
                    razvarot((int) (D_O * 1.5), 1);
                    vpered_dlin(-4500, 1);
                    otpust();
                    sleep(200);
                    vpered(1800, 1);
                    stop_all3();
                    sleep(10000);

                } else {

                    vpravo(-510, 0.25);
                    stop_all();
                    sleep(400);
                    n++;

                }
            }
        }
    }

    static class StageSwitchingPipeline extends OpenCvPipeline {
        Mat yCbCrChan2Mat = new Mat();
        Mat thresholdMat = new Mat();
        Mat all = new Mat();
        List<MatOfPoint> contoursList = new ArrayList<>();

        enum Stage {//color difference. greyscale
            detection,//includes outlines
            THRESHOLD,//b&w
            RAW_IMAGE,//displays raw view
        }

        private Stage stageToRenderToViewport = Stage.detection;
        private Stage[] stages = Stage.values();

        @Override
        public void onViewportTapped() {
            /*
             * Note that this method is invoked from the UI thread
             * so whatever we do here, we must do quickly.
             */

            int currentStageNum = stageToRenderToViewport.ordinal();

            int nextStageNum = currentStageNum + 1;

            if (nextStageNum >= stages.length) {
                nextStageNum = 0;
            }

            stageToRenderToViewport = stages[nextStageNum];
        }

        @Override
        public Mat processFrame(Mat input) {
            contoursList.clear();
            /*
             * This pipeline finds the contours of yellow blobs such as the Gold Mineral
             * from the Rover Ruckus game.
             */

            //color diff cb.
            //lower cb = more blue = skystone = white
            //higher cb = less blue = yellow stone = grey
            Imgproc.cvtColor(input, yCbCrChan2Mat, Imgproc.COLOR_RGB2YCrCb);//converts rgb to ycrcb
            Core.extractChannel(yCbCrChan2Mat, yCbCrChan2Mat, 2);//takes cb difference and stores

            //b&w
            Imgproc.threshold(yCbCrChan2Mat, thresholdMat, 102, 255, Imgproc.THRESH_BINARY_INV);

            //outline/contour
            Imgproc.findContours(thresholdMat, contoursList, new Mat(), Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);
            yCbCrChan2Mat.copyTo(all);//copies mat object
            //Imgproc.drawContours(all, contoursList, -1, new Scalar(255, 0, 0), 3, 8);//draws blue contours


            //get values from frame
            double[] pixMid = thresholdMat.get((int) (input.rows() * midPos[1]), (int) (input.cols() * midPos[0]));//gets value at circle
            valMid = (int) pixMid[0];


            //create three points
            Point pointMid = new Point((int) (input.cols() * midPos[0]), (int) (input.rows() * midPos[1]));


            //draw circles on those points
            Imgproc.circle(all, pointMid, 5, new Scalar(255, 0, 0), 1);//draws circle


            //draw 3 rectangles

            Imgproc.rectangle(//3-5
                    all,
                    new Point(
                            input.cols() * (midPos[0] - rectWidth / 2),
                            input.rows() * (midPos[1] - rectHeight / 2)),
                    new Point(
                            input.cols() * (midPos[0] + rectWidth / 2),
                            input.rows() * (midPos[1] + rectHeight / 2)),
                    new Scalar(0, 255, 0), 3);

            switch (stageToRenderToViewport) {
                case THRESHOLD: {
                    return thresholdMat;
                }

                case detection: {
                    return all;
                }

                case RAW_IMAGE: {
                    return input;
                }

                default: {
                    return input;
                }
            }
        }

    }
}