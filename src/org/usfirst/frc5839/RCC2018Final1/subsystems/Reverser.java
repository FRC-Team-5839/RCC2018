
package org.usfirst.frc5839.RCC2018Final1.subsystems;

import org.usfirst.frc5839.RCC2018Final1.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Reverser extends PIDSubsystem {

	private final DoubleSolenoid doubleSolenoid1 = RobotMap.reverserDoubleSolenoid1;
    private final WPI_TalonSRX talonSRX1 = RobotMap.reverserTalonSRX1;
    private final DigitalInput reverselimit =  RobotMap.reverserLimitSwitch;
    private final Encoder encoder = RobotMap.reverseEncoder;
    private final double tolerance = 5;
	private int setpos;
    
//    double P = 0.04;
//    double I = 0;
//    double D = 0.3;
//    
//    int integral, previous_error, setpoint = 0;
//	private int error;
//	private double derivative;
//	private double rcw;
//
//
//    public void setSetpoint(int setpoint)
//    {
//        this.setpoint = setpoint;
//    }
//
//    public void PID(){
//        error = setpoint - (-encoder.get()); // Error = Target - Actual
//        this.integral += (error*.02); // Integral is increased by the error*time (which is .02 seconds using normal IterativeRobot)
//        derivative = (error - this.previous_error) / .02;
//        this.rcw = P*error + I*this.integral + D*derivative;
//    }
//
//    public void executePID() {
//    	breakdisable();
//        PID();
//        talonSRX1.set(this.rcw*0.1);
//    }
//    
//    public void PIDstop() {
//    	this.rcw =0;
//    	breakstop();
//    	
//    }
    
    public Reverser() {
		super(0.03, 0, 0);
        getPIDController().setAbsoluteTolerance(5);
        getPIDController().setContinuous(true);
        getPIDController().setOutputRange(-1, 1);
        getPIDController().setInputRange(-9999999, 0);
	}
    
    @Override
    public void initDefaultCommand() {

    }

    @Override
    public void periodic() {
    	if (!reverselimit.get()) {
			encoder.reset();
		}
    	SmartDashboard.putBoolean("reverserLimit", reverselimit.get());
    	SmartDashboard.putNumber("PIDout", getPIDController().get());
    	SmartDashboard.putNumber("input", returnPIDInput());
    	SmartDashboard.putNumber("setpoint", getSetpoint());
        // Put code here to be run every loop

    }
    
    public void lift() {
    	if (encoder.get() >= -700) {
        	if (doubleSolenoid1.get() == DoubleSolenoid.Value.kReverse) {
        		doubleSolenoid1.set(DoubleSolenoid.Value.kForward);
        		talonSRX1.set(0.5);
    		}else {
    			talonSRX1.set(0.5);
    		}
		}else {
			breakstop();
		}

    }
    
    public void lower() {
    	if (isSafe()) {
        	if (doubleSolenoid1.get() == DoubleSolenoid.Value.kReverse) {
        		doubleSolenoid1.set(DoubleSolenoid.Value.kForward);
        		talonSRX1.set(-0.5);
    		}else {
    			talonSRX1.set(-0.5);
    		}
		}else {
			breakstop();
			encoder.reset();
		}

    }
    
    public void breakstop() {
    	talonSRX1.set(0);
//    	getPIDController().disable();
    	doubleSolenoid1.set(DoubleSolenoid.Value.kReverse);
    }

    public void breakdisable() {
    	talonSRX1.set(0);
//    	getPIDController().disable();
    	doubleSolenoid1.set(DoubleSolenoid.Value.kForward);
    }
    
    public void PIDstop() {
    	getPIDController().disable();
    	breakstop();
    	
    }
    
    public void PIDposition() {
    	breakdisable();
//    	getPIDController().setSetpoint(400);
    	getPIDController().enable();
    }

	@Override
	protected double returnPIDInput() {
		return -encoder.get();
	}

	@Override
	protected void usePIDOutput(double output) {
		
    	if (reverselimit.get() && encoder.get() >= -800) {
        	if (doubleSolenoid1.get() == DoubleSolenoid.Value.kReverse) {
        		doubleSolenoid1.set(DoubleSolenoid.Value.kForward);
        		talonSRX1.set(output);
    		}else {
    			talonSRX1.set(output);
    		}
		}else {
			breakstop();
		}
		
	}
	
    public boolean isSafe() {
    	return reverselimit.get() &&  encoder.get()>=-800;
    }
    
    public boolean isPIDreached() {
        	return this.setpos >= -encoder.get()-Math.abs(this.tolerance) && this.setpos <= -encoder.get()+Math.abs(this.tolerance);
    }
    
    
    


}



