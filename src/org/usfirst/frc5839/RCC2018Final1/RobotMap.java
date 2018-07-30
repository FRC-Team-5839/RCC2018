package org.usfirst.frc5839.RCC2018Final1;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotMap {

	public static SpeedController driveBaseSpeedController1;
	public static SpeedController driveBaseSpeedController2;
	public static SpeedController driveBaseSpeedController3;
	public static SpeedControllerGroup driveBaseSpeedControllerGroupLeft;
	public static SpeedController driveBaseSpeedController4;
	public static SpeedController driveBaseSpeedController5;
	public static SpeedController driveBaseSpeedController6;
	public static SpeedControllerGroup driveBaseSpeedControllerGroupRight;
	public static DifferentialDrive driveBaseDifferentialDrive1;
	public static SpeedController intakerSpeedController1;
	public static SpeedController intakerSpeedController2;
	public static SpeedControllerGroup intakerSpeedControllerGroup1;
	public static DoubleSolenoid intakerDoubleSolenoid1;
	public static DoubleSolenoid reverserDoubleSolenoid1;
	public static WPI_TalonSRX reverserTalonSRX1;
	public static DigitalInput reverserLimitSwitch;
	public static Encoder reverseEncoder;
	public static Encoder rightEncoder;
	public static Encoder leftEncoder;
 


 @SuppressWarnings("deprecation")
public static void init() {
     driveBaseSpeedController1 = new Spark(8);
     LiveWindow.addActuator("DriveBase", "Speed Controller 1", (Spark) driveBaseSpeedController1);
     driveBaseSpeedController1.setInverted(false);
     driveBaseSpeedController2 = new Spark(7);
     LiveWindow.addActuator("DriveBase", "Speed Controller 2", (Spark) driveBaseSpeedController2);
     driveBaseSpeedController2.setInverted(false);
     driveBaseSpeedController3 = new Spark(9);
     LiveWindow.addActuator("DriveBase", "Speed Controller 3", (Spark) driveBaseSpeedController3);
     driveBaseSpeedController3.setInverted(false);
     driveBaseSpeedControllerGroupLeft = new SpeedControllerGroup(driveBaseSpeedController1, driveBaseSpeedController2 , driveBaseSpeedController3 );
     LiveWindow.addActuator("DriveBase", "Speed Controller Group Left", driveBaseSpeedControllerGroupLeft);
     leftEncoder = new Encoder(6, 5);
     
     driveBaseSpeedController4 = new Spark(0);
     LiveWindow.addActuator("DriveBase", "Speed Controller 4", (Spark) driveBaseSpeedController4);
     driveBaseSpeedController4.setInverted(false);
     driveBaseSpeedController5 = new Spark(1);
     LiveWindow.addActuator("DriveBase", "Speed Controller 5", (Spark) driveBaseSpeedController5);
     driveBaseSpeedController5.setInverted(false);
     driveBaseSpeedController6 = new Spark(3);
     LiveWindow.addActuator("DriveBase", "Speed Controller 6", (Spark) driveBaseSpeedController6);
     driveBaseSpeedController6.setInverted(false);
     driveBaseSpeedControllerGroupRight = new SpeedControllerGroup(driveBaseSpeedController4, driveBaseSpeedController5 , driveBaseSpeedController6 );
     LiveWindow.addActuator("DriveBase", "Speed Controller Group Right", driveBaseSpeedControllerGroupRight);
     rightEncoder = new Encoder(4, 3);
     
     driveBaseDifferentialDrive1 = new DifferentialDrive(driveBaseSpeedControllerGroupLeft, driveBaseSpeedControllerGroupRight);
     LiveWindow.addActuator("DriveBase", "Differential Drive 1", driveBaseDifferentialDrive1);
     driveBaseDifferentialDrive1.setSafetyEnabled(true);
     driveBaseDifferentialDrive1.setExpiration(0.1);
     driveBaseDifferentialDrive1.setMaxOutput(1.0);

     intakerSpeedController1 = new Spark(2);
     LiveWindow.addActuator("Intaker", "Speed Controller 1", (Spark) intakerSpeedController1);
     intakerSpeedController1.setInverted(false);
     intakerSpeedController2 = new Spark(6);
     LiveWindow.addActuator("Intaker", "Speed Controller 2", (Spark) intakerSpeedController2);
     intakerSpeedController2.setInverted(true);
     intakerSpeedControllerGroup1 = new SpeedControllerGroup(intakerSpeedController1, intakerSpeedController2  );
     LiveWindow.addActuator("Intaker", "Speed Controller Group 1", intakerSpeedControllerGroup1);
     
     intakerDoubleSolenoid1 = new DoubleSolenoid(20, 4, 6);
     LiveWindow.addActuator("Intaker", "Double Solenoid 1", intakerDoubleSolenoid1);
     
     reverserDoubleSolenoid1 = new DoubleSolenoid(20, 7, 5);
     LiveWindow.addActuator("Reverser", "Double Solenoid 1", reverserDoubleSolenoid1);
     
     reverserTalonSRX1 = new WPI_TalonSRX(1);
     
     reverserLimitSwitch = new DigitalInput(7);
     reverseEncoder = new Encoder(8, 9);//0 - -750
     reverseEncoder.reset();
     
     
     new Thread(() -> {
   	   UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture("cam0", "/dev/video0");
   	   UsbCamera camera2 = CameraServer.getInstance().startAutomaticCapture("cam1", "/dev/video1");	
   	   camera2.setResolution(320, 240);
   	   camera2.setFPS(15);
   	   camera1.setResolution(320, 240);
   	   camera1.setFPS(15);
   	   SmartDashboard.putNumber("LeftEnc", leftEncoder.get());
   	   SmartDashboard.putNumber("RightEnc", rightEncoder.get());
   	   
   	}).start();

 }
}
