package org.firstinspires.ftc.teamcode.utilites.controllers;

import com.qualcomm.robotcore.util.ElapsedTime;

public class PIDController {
    PIDCoefficients feeds;

    double target;
    double current;
    double error;
    double dt, time, prevTime;
    ElapsedTime timer;
    double p;
    double i;
    double d;
    double intsum;
    double de, prevError;
    public PIDController(PIDCoefficients feeds, double target, double current){
        this.feeds = feeds;
        this.current = current;
        this.target = target;
        timer = new ElapsedTime();



    }
    public void setFeeds(PIDCoefficients feeds){this.feeds=feeds;}
    public void setTarget(double target){this.target = target;}
    public void setCurrent(double current){this.current = current;}
    public double update() {
        error = target - current;
        time = timer.seconds();
        dt = time - prevTime;
        p = feeds.getkP() * error;
        intsum += error *dt;
        i = feeds.getkI() * intsum;
        de = error - prevError;
        d = feeds.getkD() * de / dt;
        prevTime = time;
        prevError = error;
        return p+i+d;
    }



}
