package org.firstinspires.ftc.teamcode.utilites.controllers;

public class FeedForwardCoefficients {
    private double kT;
    private double kS;

    public FeedForwardCoefficients(double kT, double kS){
        this.kT =kT;
        this.kS = kS;


    }

    public void setkS (double kS){
        this.kS = kS;
    }
    public void setkT (double kT){
        this.kT = kT;
    }

    public double getkT(){
        return kT;
    }

    public double getkS(){
        return kS;
    }




}
