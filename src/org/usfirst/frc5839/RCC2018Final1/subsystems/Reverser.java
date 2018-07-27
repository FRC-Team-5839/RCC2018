
package org.usfirst.frc5839.RCC2018Final1.subsystems;

import org.usfirst.frc5839.RCC2018Final1.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Reverser extends PIDSubsystem {

    public Reverser(double p, double i, double d) {
		super(p, i, d);
        getPIDController().setAbsoluteTolerance(5);
        getPIDController().setContinuous(true);
        getPIDController().setOutputRange(-1, 1);
        getPIDController().setInputRange(-800, 15);
		// TODO Auto-generated constructor stub
	}

	private final DoubleSolenoid doubleSolenoid1 = RobotMap.reverserDoubleSolenoid1;
    private final WPI_TalonSRX talonSRX1 = RobotMap.reverserTalonSRX1;
    private final DigitalInput reverselimit =  RobotMap.reverserLimitSwitch;
    private final Encoder encoder = RobotMap.reverseEncoder;


    @Override
    public void initDefaultCommand() {

    }

    @Override
    public void periodic() {
    	if (!reverselimit.get()) {
			encoder.reset();
		}
        // Put code here to be run every loop

    }
    
    public void lift() {
    	if (encoder.get() >= -750) {
        	if (doubleSolenoid1.get() == DoubleSolenoid.Value.kReverse) {
        		doubleSolenoid1.set(DoubleSolenoid.Value.kForward);
        		talonSRX1.set(0.7);
    		}else {
    			talonSRX1.set(0.7);
    		}
		}else {
			breakstop();
		}

    }
    
    public void lower() {
    	if (reverselimit.get()) {
        	if (doubleSolenoid1.get() == DoubleSolenoid.Value.kReverse) {
        		doubleSolenoid1.set(DoubleSolenoid.Value.kForward);
        		talonSRX1.set(-0.7);
    		}else {
    			talonSRX1.set(-0.7);
    		}
		}else {
			breakstop();
			encoder.reset();
		}

    }
    
    public void breakstop() {
    	talonSRX1.stopMotor();
    	doubleSolenoid1.set(DoubleSolenoid.Value.kReverse);
    }

    public void breakdisable() {
    	talonSRX1.stopMotor();
    	doubleSolenoid1.set(DoubleSolenoid.Value.kForward);
    }

	@Override
	protected double returnPIDInput() {
		return encoder.getDistance();
	}

	@Override
	protected void usePIDOutput(double output) {
		
    	if (reverselimit.get() && encoder.get() >= -800) {
        	if (doubleSolenoid1.get() == DoubleSolenoid.Value.kReverse) {
        		doubleSolenoid1.set(DoubleSolenoid.Value.kForward);
        		talonSRX1.set(output);
    		}else {
    			talonSRX1.set(-output);
    		}
		}else {
			breakstop();
		}
		
	}


}

