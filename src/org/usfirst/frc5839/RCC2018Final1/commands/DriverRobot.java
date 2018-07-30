package org.usfirst.frc5839.RCC2018Final1.commands;

import org.usfirst.frc5839.RCC2018Final1.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriverRobot extends Command {

    public DriverRobot() {
    	requires(Robot.driveBase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveBase.TankDrive(Robot.oi.getJoystick1().getRawAxis(4)*0.9, Robot.oi.getJoystick1().getRawAxis(1)*0.9);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
