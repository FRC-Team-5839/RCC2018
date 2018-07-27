

package org.usfirst.frc5839.RCC2018Final1.subsystems;

import org.usfirst.frc5839.RCC2018Final1.RobotMap;
import org.usfirst.frc5839.RCC2018Final1.commands.DriverRobot;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;




public class DriveBase extends Subsystem {
//    private final SpeedController speedController1 = RobotMap.driveBaseSpeedController1;
//    private final SpeedController speedController2 = RobotMap.driveBaseSpeedController2;
//    private final SpeedController speedController3 = RobotMap.driveBaseSpeedController3;
//    private final SpeedControllerGroup speedControllerGroupLeft = RobotMap.driveBaseSpeedControllerGroupLeft;
//    private final SpeedController speedController4 = RobotMap.driveBaseSpeedController4;
//    private final SpeedController speedController5 = RobotMap.driveBaseSpeedController5;
//    private final SpeedController speedController6 = RobotMap.driveBaseSpeedController6;
//    private final SpeedControllerGroup speedControllerGroupRight = RobotMap.driveBaseSpeedControllerGroupRight;
    private final DifferentialDrive differentialDrive1 = RobotMap.driveBaseDifferentialDrive1;


    
    @Override
    public void initDefaultCommand() {
    	setDefaultCommand(new DriverRobot());
    	
    }

    @Override
    public void periodic() {

    }
    
    public void TankDrive(double left, double right) {
    	differentialDrive1.tankDrive(left, right);
    }
    
    public void Stop() {
    	differentialDrive1.stopMotor();
    }
    


}

