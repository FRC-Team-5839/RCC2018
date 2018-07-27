package org.usfirst.frc5839.RCC2018Final1.subsystems;

import org.usfirst.frc5839.RCC2018Final1.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Intaker extends Subsystem {

    private final SpeedControllerGroup speedControllerGroup1 = RobotMap.intakerSpeedControllerGroup1;
    private final DoubleSolenoid doubleSolenoid1 = RobotMap.intakerDoubleSolenoid1;

    @Override
    public void initDefaultCommand() {
    }

    @Override
    public void periodic() {
    }
    
    public void cubein() {
    	doubleSolenoid1.set(DoubleSolenoid.Value.kReverse);
    	speedControllerGroup1.set(0.5);
    }
    
    public void cubeout() {
    	doubleSolenoid1.set(DoubleSolenoid.Value.kForward);
    	speedControllerGroup1.set(-0.9);
    }
    
    public void cubestop() {
    	speedControllerGroup1.stopMotor();
    	doubleSolenoid1.set(DoubleSolenoid.Value.kForward);
    }
    
    public void cubeclosein() {
    	speedControllerGroup1.set(0.3);
    	doubleSolenoid1.set(DoubleSolenoid.Value.kForward);
    }
    
    public void intakestop() {
    	speedControllerGroup1.stopMotor();
    }
    
    public void intakeinit() {
    	doubleSolenoid1.set(DoubleSolenoid.Value.kReverse);
    	speedControllerGroup1.stopMotor();
    }

}

