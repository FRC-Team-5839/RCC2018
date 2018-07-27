package org.usfirst.frc5839.RCC2018Final1.commands;

import org.usfirst.frc5839.RCC2018Final1.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CubeCloseintake extends Command {

    public CubeCloseintake() {
    	requires(Robot.intaker);
    	requires(Robot.reverser);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.reverser.breakdisable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intaker.cubeclosein();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intaker.cubestop();
    	Robot.reverser.breakstop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
