package org.firstinspires.ftc.teamcode.utilites.controllers;

public class FeedForwardController {
    FeedForwardCoefficients feeds;
    int target;

    public FeedForwardController(FeedForwardCoefficients feeds, int target){
        this.feeds = feeds;
        this.target = target;

    }

    public void setFeeds (FeedForwardCoefficients feeds){
        this.feeds= feeds;
    }
    public void setTarget (int target){
        this.target = target;
    }

    public double edefg(){
        return feeds.getkT()*target+ feeds.getkS();
    }


}

