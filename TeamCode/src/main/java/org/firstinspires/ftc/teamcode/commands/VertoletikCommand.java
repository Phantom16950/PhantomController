package org.firstinspires.ftc.teamcode.commands;

import com.bylazar.configurables.annotations.Configurable;
import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.behaviors.BlockedBehavior;
import com.pedropathing.ivy.behaviors.ConflictBehavior;
import com.pedropathing.ivy.behaviors.EndCondition;
import com.pedropathing.ivy.behaviors.InterruptedBehavior;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.utilites.controllers.FeedForwardCoefficients;
import org.firstinspires.ftc.teamcode.utilites.controllers.FeedForwardController;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
@Configurable
public class VertoletikCommand implements Command {

    private DcMotorEx v1;

    private LinearOpMode opMode;
    private FeedForwardCoefficients cf;
    private FeedForwardController cr;

    public static double kt = 0, ks = 0;
    public static int target = 0;




    public VertoletikCommand(LinearOpMode opMode){
        this.opMode = opMode;
        v1 = opMode.hardwareMap.get(DcMotorEx.class, "v1");
    }

    @Override
    public Set<Object> requirements() {
        return Set.of(v1);
    }

    @Override
    public int priority() {
        return 0;
    }

    @Override
    public InterruptedBehavior interruptedBehavior() {
        return null;
    }

    @Override
    public ConflictBehavior conflictBehavior() {
        return null;
    }

    @Override
    public BlockedBehavior blockedBehavior() {
        return null;
    }

    @Override
    public void start() {
        cf = new FeedForwardCoefficients(kt, ks);
        cr = new FeedForwardController(cf, target);

    }

    @Override
    public boolean done() {
        return opMode.isStopRequested();
    }

    @Override
    public void execute() {
        cf.setkS(ks);
        cf.setkT(kt);



    }

    @Override
    public void end(EndCondition endCondition) {

    }
}
