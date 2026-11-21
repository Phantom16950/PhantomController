package org.firstinspires.ftc.teamcode.utilites.controllers;

public class PIDCoefficients {
    private double kP, kI, kD;

    public PIDCoefficients(double kD, double kP, double kI) {
        this.kD = kD;
        this.kP = kP;
        this.kI = kI;
    }

    public double getkP() {
        return kP;
    }

    public void setkP(double kP) {
        this.kP = kP;
    }

    public double getkI() {
        return kI;
    }

    public void setkI(double kI) {
        this.kI = kI;
    }

    public double getkD() {
        return kD;
    }

    public void setkD(double kD) {
        this.kD = kD;
    }
}
