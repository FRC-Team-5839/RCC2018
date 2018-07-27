package org.usfirst.frc5839.RCC2018Final1;

import org.usfirst.frc5839.RCC2018Final1.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;


public class OI {

    public JoystickButton joystickButton1;
    public Joystick joystick1;
    public JoystickButton joystickButton2;
    public Joystick joystick2;
    public Joystick joystick3;
    public JoystickButton joystickButton31;
    public JoystickButton joystickButton32;
    public JoystickButton joystickButton33;
    public JoystickButton joystickButton34;
    public JoystickButton joystickButton35;
    public JoystickButton joystickButton36;
    public JoystickButton joystickButton37;
    public JoystickButton joystickButton38;
    public JoystickButton joystickButton39;
    public JoystickButton joystickButton310;
    


    public OI() {

        joystick2 = new Joystick(1);
        
        joystickButton2 = new JoystickButton(joystick2, 1);
        joystickButton2.whileHeld(new AutonomousCommand());
        joystick1 = new Joystick(0);
        
        joystickButton1 = new JoystickButton(joystick1, 1);
        joystickButton1.whileHeld(new AutonomousCommand());
        
        joystick3 = new Joystick(2);
        joystickButton31 = new JoystickButton(joystick3, 1);
        joystickButton32 = new JoystickButton(joystick3, 2);
        joystickButton33 = new JoystickButton(joystick3, 3);
        joystickButton34 = new JoystickButton(joystick3, 4);
        joystickButton35 = new JoystickButton(joystick3, 5);
        joystickButton36 = new JoystickButton(joystick3, 6);
        joystickButton37 = new JoystickButton(joystick3, 7);
        joystickButton38 = new JoystickButton(joystick3, 8);
        joystickButton39 = new JoystickButton(joystick3, 9);
        joystickButton310 = new JoystickButton(joystick3, 10);
        
        joystickButton35.whileHeld(new CubeIntake());
        joystickButton36.whileHeld(new Cubeout());
        joystickButton31.whileHeld(new CubeLower());
        joystickButton34.whileHeld(new CubeLift());
        joystickButton32.whileHeld(new CubeCloseintake());
        joystickButton33.whileHeld(new Lift45andhold());


        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());

    }

    public Joystick getJoystick1() {
        return joystick1;
    }

    public Joystick getJoystick2() {
        return joystick2;
    }
    
    public Joystick getJoystick3() {
    	return joystick3;
    }

}

