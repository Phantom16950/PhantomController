//package org.firstinspires.ftc.teamcode.sample;
//
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.hardware.CRServo;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import java.util.List;
//import org.firstinspires.ftc.robotcore.external.ClassFactory;
//import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
//import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection;
//import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
//import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
//
//
//@Autonomous(name = "krator_VUFORIA", group = "Autonomous")
//public class VuforiaMem extends LinearOpMode {
//    DcMotor leftF, rightF, leftB, rightB, pod;
//    CRServo Serv, Serv2;
//
//    private static final String TFOD_MODEL_ASSET = "RoverRuckus.tflite";
//    private static final String LABEL_GOLD_MINERAL = "Gold Mineral";
//    private static final String LABEL_SILVER_MINERAL = "Silver Mineral";
//
//
//
//
//
//    private static final String VUFORIA_KEY = "ASabM6L/////AAABmQfXjXZhB01us20b4Hn5MIUF9Wqe6LBGwhynTFFppVQ/JW9YB93RXN26AvgeYnWOb6CpOSKUsJ7F0Gs+/iY/rQdfitdutbB00J3wd6AOihkvXriSJB6RYyHPeOnSeJpcieXS+ShHtIdRpSyGAqEs0qETNq8/fCGAIOoxvWjsdU59+dt99V1KkTagLz7SzPU+Ih5pzWAYMcCoHepCQZw2U/J3tt/mySO7aXDhDDYlE3GuoetQLxcmq3i/0E6ol2wBz3cxEr5oudezWc//bb7GgefKb4iDjW4OfBtv1tsROrhkomzzQZsSZizYmOcLMUBJsDOT+mR2YmxsSRCk5y489Q1qktE+Qt/2YMz/KfbjLOUp";
//
//
//    private VuforiaLocalizer vuforia;
//
//
//    private TFObjectDetector tfod;
//
//
//    @Override
//    public void runOpMode() {
//        leftF = hardwareMap.dcMotor.get("lf");
//        leftB = hardwareMap.dcMotor.get("lr");
//        rightF = hardwareMap.dcMotor.get("rf");
//        rightB = hardwareMap.dcMotor.get("rr");
//        Serv = hardwareMap.crservo.get("OBT_1");
//        Serv2 = hardwareMap.crservo.get("OBT_2");
//        pod = hardwareMap.dcMotor.get("pd");
//
//
//        initVuforia();
//        if (ClassFactory.getInstance().canCreateTFObjectDetector()) {
//            initTfod();
//        } else {
//            telemetry.addData("Sorry!", "This device is not compatible with TFOD");  // Тест мобилы.
//        }
//
//
//        telemetry.addData(">", "Press Play to start tracking");
//        telemetry.update();
//
//        waitForStart();
//
//
//
//
//
//        if (opModeIsActive()) {
//
//            if (tfod != null) {
//                tfod.activate();
//            }
//
//            while (opModeIsActive()) {
//                if (tfod != null) {
//
//                    List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
//                    if (updatedRecognitions != null) {
//                        telemetry.addData("# Object Detected", updatedRecognitions.size());
//                        if (updatedRecognitions.size() == 3) {
//                            int goldMineralX = -1;
//                            int silverMineral1X = -1;
//                            int silverMineral2X = -1;
//                            for (Recognition recognition : updatedRecognitions) {
//                                if (recognition.getLabel().equals(LABEL_GOLD_MINERAL)) {
//                                    goldMineralX = (int) recognition.getLeft();
//                                } else if (silverMineral1X == -1) {
//                                    silverMineral1X = (int) recognition.getLeft();
//                                } else {
//                                    silverMineral2X = (int) recognition.getLeft();
//                                }
//                            }
//                            if (goldMineralX != -1 && silverMineral1X != -1 && silverMineral2X != -1) {
//                                if (goldMineralX < silverMineral1X && goldMineralX < silverMineral2X) {
//                                    telemetry.addData("Gold Mineral Position", "Left");
//                                    pod.setPower(1);
//                                    sleep(15000);
//                                    leftF.setPower(0);
//                                    rightB.setPower(0);
//                                    rightF.setPower(0);
//                                    leftB.setPower(0);
//
//                                    pod.setPower(0);
//                                    Serv.setPower(0);
//                                    Serv2.setPower(0);
//                                    sleep(100);
//                                    leftF.setPower(-0.3);
//                                    rightB.setPower(0.3);
//                                    rightF.setPower(-0.3);
//                                    leftB.setPower(0.3);
//                                    sleep(200);
//                                    leftF.setPower(0);
//                                    rightB.setPower(0);
//                                    rightF.setPower(0);
//                                    leftB.setPower(0);
//
//                                    pod.setPower(0);
//                                    Serv.setPower(0);
//                                    Serv2.setPower(0);
//                                    sleep(100);
//                                    leftF.setPower(-0.3);
//                                    rightB.setPower(0.3);
//                                    rightF.setPower(0.3);
//                                    leftB.setPower(-0.3);
//                                    sleep(200);
//                                    leftF.setPower(0);
//                                    rightB.setPower(0);
//                                    rightF.setPower(0);
//                                    leftB.setPower(0);
//
//                                    pod.setPower(0);
//                                    Serv.setPower(0);
//                                    Serv2.setPower(0);
//                                    sleep(100);
//                                    leftF.setPower(0.3);
//                                    rightB.setPower(-0.3);
//                                    rightF.setPower(0.3);
//                                    leftB.setPower(-0.3);
//                                    sleep(600);
//                                    leftF.setPower(0);
//                                    rightB.setPower(0);
//                                    rightF.setPower(0);
//                                    leftB.setPower(0);
//
//                                    pod.setPower(0);
//                                    Serv.setPower(0);
//                                    Serv2.setPower(0);
//                                    sleep(100);// Спуск с крюка
//                                    leftF.setPower(-0.3);
//                                    rightB.setPower(0.3);
//                                    rightF.setPower(0.3);
//                                    leftB.setPower(-0.3);
//                                    sleep(1200);
//                                    leftF.setPower(0);
//                                    rightB.setPower(0);
//                                    rightF.setPower(0);
//                                    leftB.setPower(0);
//
//                                    pod.setPower(0);
//                                    Serv.setPower(0);
//                                    Serv2.setPower(0);
//                                    sleep(100);
//
//                                    telemetry.update();
//                                    leftF.setPower(0);
//                                    rightB.setPower(0);
//                                    rightF.setPower(0);
//                                    leftB.setPower(0);
//
//                                    pod.setPower(0);
//                                    Serv.setPower(0);
//                                    Serv2.setPower(0);
//                                    sleep(10000000);
//
//
//
//                                } else if (goldMineralX > silverMineral1X && goldMineralX > silverMineral2X) {
//                                    telemetry.addData("Gold Mineral Position", "Right");
//                                    pod.setPower(1);
//                                    sleep(1000);
//                                    leftF.setPower(0);
//                                    rightB.setPower(0);
//                                    rightF.setPower(0);
//                                    leftB.setPower(0);
//
//                                    pod.setPower(0);
//                                    Serv.setPower(0);
//                                    Serv2.setPower(0);
//                                    sleep(100);
//                                    leftF.setPower(-0.3);
//                                    rightB.setPower(0.3);
//                                    rightF.setPower(-0.3);
//                                    leftB.setPower(0.3);
//                                    sleep(400);
//                                    leftF.setPower(0);
//                                    rightB.setPower(0);
//                                    rightF.setPower(0);
//                                    leftB.setPower(0);
//
//                                    pod.setPower(0);
//                                    Serv.setPower(0);
//                                    Serv2.setPower(0);
//                                    sleep(100);// Спуск с крюка
//
//
//
//
//
//                                    leftF.setPower(-0.2);
//                                    rightB.setPower(0.2);
//                                    rightF.setPower(0.2);
//                                    leftB.setPower(-0.2);
//                                    sleep(1500);
//                                    leftF.setPower(0);
//                                    rightB.setPower(0);
//                                    rightF.setPower(0);
//                                    leftB.setPower(0);
//
//                                    pod.setPower(0);
//                                    Serv.setPower(0);
//                                    Serv2.setPower(0);
//                                    sleep(100);
//                                    leftF.setPower(0.2);
//                                    rightB.setPower(-0.2);
//                                    rightF.setPower(-0.2);
//                                    leftB.setPower(0.2);
//                                    sleep(600);
//                                    leftF.setPower(0);
//                                    rightB.setPower(0);
//                                    rightF.setPower(0);
//                                    leftB.setPower(0);
//
//                                    pod.setPower(0);
//                                    Serv.setPower(0);
//                                    Serv2.setPower(0);
//                                    sleep(100);
//                                    leftF.setPower(0.8);
//                                    rightB.setPower(-0.8);
//                                    rightF.setPower(0.8);
//                                    leftB.setPower(-0.8);
//                                    sleep(1500);
//                                    leftF.setPower(0);
//                                    rightB.setPower(0);
//                                    rightF.setPower(0);
//                                    leftB.setPower(0);
//
//                                    pod.setPower(0);
//                                    Serv.setPower(0);
//                                    Serv2.setPower(0);
//                                    sleep(100);
//                                    leftF.setPower(-0.3);
//                                    rightB.setPower(-0.3);
//                                    rightF.setPower(-0.3);
//                                    leftB.setPower(-0.3);
//                                    sleep(1600);
//                                    leftF.setPower(0);
//                                    rightB.setPower(0);
//                                    rightF.setPower(0);
//                                    leftB.setPower(0);
//
//                                    pod.setPower(0);
//                                    Serv.setPower(0);
//                                    Serv2.setPower(0);
//                                    sleep(100);
//                                    leftF.setPower(-0.2);
//                                    rightB.setPower(0.2);
//                                    rightF.setPower(0.2);
//                                    leftB.setPower(-0.2);
//                                    sleep(1200);
//                                    leftF.setPower(0);
//                                    rightB.setPower(0);
//                                    rightF.setPower(0);
//                                    leftB.setPower(0);
//
//                                    pod.setPower(0);
//                                    Serv.setPower(0);
//                                    Serv2.setPower(0);
//                                    sleep(100);
//                                    Serv.setPower(1);
//                                    Serv2.setPower(-1);
//                                    sleep(500);
//                                    leftF.setPower(0);
//                                    rightB.setPower(0);
//                                    rightF.setPower(0);
//                                    leftB.setPower(0);
//
//                                    pod.setPower(0);
//                                    Serv.setPower(0);
//                                    Serv2.setPower(0);
//                                    sleep(100);
//                                    leftF.setPower(1);
//                                    rightB.setPower(-1);
//                                    rightF.setPower(-1);
//                                    leftB.setPower(1);
//                                    sleep(1500);
//                                    leftF.setPower(0);
//                                    rightB.setPower(0);
//                                    rightF.setPower(0);
//                                    leftB.setPower(0);
//
//                                    pod.setPower(0);
//                                    Serv.setPower(0);
//                                    Serv2.setPower(0);
//                                    sleep(100);
//
//                                    telemetry.update();
//                                    leftF.setPower(0);
//                                    rightB.setPower(0);
//                                    rightF.setPower(0);
//                                    leftB.setPower(0);
//                                    pod.setPower(0);
//                                    Serv.setPower(0);
//                                    Serv2.setPower(0);
//                                    sleep(10000000);
//
//
//
//                                } else {
//                                    telemetry.addData("Gold Mineral Position", "Center");
//                                    pod.setPower(1);
//                                    sleep(15000);
//                                    leftF.setPower(0);
//                                    rightB.setPower(0);
//                                    rightF.setPower(0);
//                                    leftB.setPower(0);
//                                    pod.setPower(0);
//                                    Serv.setPower(0);
//                                    Serv2.setPower(0);
//                                    sleep(100);
//
//
//
//                                    leftF.setPower(-0.3);
//                                    rightB.setPower(0.3);
//                                    rightF.setPower(-0.3);
//                                    leftB.setPower(0.3);
//                                    sleep(400);
//                                    leftF.setPower(0);
//                                    rightB.setPower(0);
//                                    rightF.setPower(0);
//                                    leftB.setPower(0);
//                                    pod.setPower(0);
//                                    Serv.setPower(0);
//                                    Serv2.setPower(0);
//                                    sleep(50);
//                                    leftF.setPower(-0.3);
//                                    rightB.setPower(0.3);
//                                    rightF.setPower(0.3);
//                                    leftB.setPower(-0.3);
//                                    sleep(300);
//                                    leftF.setPower(0);
//                                    rightB.setPower(0);
//                                    rightF.setPower(0);
//                                    leftB.setPower(0);
//                                    pod.setPower(0);
//                                    Serv.setPower(0);
//                                    Serv2.setPower(0);
//                                    sleep(100);
//                                    leftF.setPower(0.3);
//                                    rightB.setPower(-0.3);
//                                    rightF.setPower(0.3);
//                                    leftB.setPower(-0.3);
//                                    sleep(400);
//                                    leftF.setPower(0);
//                                    rightB.setPower(0);
//                                    rightF.setPower(0);
//                                    leftB.setPower(0);
//                                    pod.setPower(0);
//                                    Serv.setPower(0);
//                                    Serv2.setPower(0);
//                                    sleep(100);   //Спуск с крюка.
//
//
//
//
//                                    leftF.setPower(-0.5);
//                                    rightB.setPower(0.5 );
//                                    rightF.setPower(0.5);
//                                    leftB.setPower(-0.5 );
//                                    sleep(1100);
//                                    telemetry.update();
//                                    leftF.setPower(0);
//                                    rightB.setPower(0);
//                                    rightF.setPower(0);
//                                    leftB.setPower(0);
//                                    pod.setPower(0);
//                                    Serv.setPower(0);
//                                    Serv2.setPower(0);
//                                    sleep(10000000);
//
//
//                                }
//                            }
//
//                        }
//
//                    }
//                }
//            }
//        }
//
//        if (tfod != null) {
//            tfod.shutdown();
//        }
//    }
//
//
//    private void initVuforia() {
//
//        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();
//
//        parameters.vuforiaLicenseKey = VUFORIA_KEY;
//        parameters.cameraDirection = CameraDirection.BACK;
//
//
//        vuforia = ClassFactory.getInstance().createVuforia(parameters);
//
//
//    }
//
//
//    private void initTfod() {
//        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
//                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
//        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
//        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
//        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_GOLD_MINERAL, LABEL_SILVER_MINERAL);
//
//    }
//
//}
