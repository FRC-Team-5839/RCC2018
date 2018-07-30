package org.usfirst.frc5839.RCC2018Final1.commands;

import org.usfirst.frc5839.RCC2018Final1.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PIDpos45 extends Command {

    public PIDpos45() {
    	requires(Robot.reverser);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.reverser.getPIDController().setSetpoint(200);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.reverser.PIDposition();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.reverser.isPIDreached();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.reverser.PIDstop();
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
