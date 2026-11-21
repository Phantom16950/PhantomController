package org.firstinspires.ftc.teamcode.utilites.controllers;

import com.qualcomm.robotcore.util.ElapsedTime;

public class CalculateRobotVelocity {
    double R;
    double thetra1;
    double thetra2;
    double thetra3;
    double y0;

    public double getX0() {
        return x0;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }

    public double getY0() {
        return y0;
    }

    public void setY0(double y0) {
        this.y0 = y0;
    }

    public double getThetra3() {
        return thetra3;
    }

    public void setThetra3(double thetra3) {
        this.thetra3 = thetra3;
    }

    public double getThetra2() {
        return thetra2;
    }

    public void setThetra2(double thetra2) {
        this.thetra2 = thetra2;
    }

    public double getThetra1() {
        return thetra1;
    }

    public void setThetra1(double thetra1) {
        this.thetra1 = thetra1;
    }

    public double getR() {
        return R;
    }

    public void setR(double r) {
        R = r;
    }

    double x0;
    ElapsedTime ttimmerr = new ElapsedTime();

    private double deltaX() {
        double xR = R / 2 * (thetra1 + thetra2);
        return xR;
    }

    private double deltaY() {
        double yR = R * (x0 / (2 * y0) * (thetra1 - thetra2) + thetra3);
        return yR;
    }

    private double deltaT() {
        double tR = R / (2 * y0) * (thetra2 - thetra1);
        return tR;
    }
    public double getVx() {
        ttimmerr.reset();
        return deltaX()/ttimmerr.nanoseconds();
    }
    public double getVy() {
        ttimmerr.reset();
        return deltaY()/ttimmerr.nanoseconds();
    }
    public double getVt() {
        ttimmerr.reset();
        return deltaT()/ttimmerr.nanoseconds();
    }
}