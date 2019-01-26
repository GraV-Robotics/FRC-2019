package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.DriveElevatorHome;
import frc.robot.commands.DriveElevatorPositionOne;
import frc.robot.commands.DriveElevatorPositionTwo;

public class OI {

  public Joystick driverController = new Joystick(RobotMap.driverController);
  public Joystick manipulatorController = new Joystick(RobotMap.manipulatorController);
  public JoystickButton elevatorHome = new JoystickButton(manipulatorController, 1);
  public JoystickButton elevatorPos1 = new JoystickButton(manipulatorController, 2);
  public JoystickButton elevatorPos2 = new JoystickButton(manipulatorController, 3);

  public OI() {
    elevatorHome.whenPressed(new DriveElevatorHome());
    elevatorPos1.whenPressed(new DriveElevatorPositionOne());
    elevatorPos2.whenPressed(new DriveElevatorPositionTwo());
  }
}