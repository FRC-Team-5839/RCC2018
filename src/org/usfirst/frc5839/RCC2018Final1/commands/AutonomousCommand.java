
package org.usfirst.frc5839.RCC2018Final1.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5839.RCC2018Final1.Robot;

public class AutonomousCommand extends Command {

    public AutonomousCommand() {
    	requires(Robot.reverser);
    	requires(Robot.driveBase);


    }

    @Override
    protected void initialize() {
    	Robot.reverser.lower();
    	
    }
    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}
