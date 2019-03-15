package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.DriveElevatorHome;
import frc.robot.commands.DriveElevatorPositionOne;
import frc.robot.commands.DriveElevatorPositionTwo;
import frc.robot.commands.HatchPop;
import frc.robot.commands.HatchPush;
import frc.robot.commands.HatchRetract;

public class OI {

  public Joystick driverController = new Joystick(RobotMap.driverController);
  public Joystick manipulatorController = new Joystick(RobotMap.manipulatorController);
  public JoystickButton elevatorHome = new JoystickButton(manipulatorController, 3);
  public JoystickButton elevatorPos1 = new JoystickButton(manipulatorController, 1);
  public JoystickButton elevatorPos2 = new JoystickButton(manipulatorController, 2);
  public JoystickButton hatchPush = new JoystickButton(manipulatorController, 5);
  public JoystickButton hatchRetract = new JoystickButton(manipulatorController, 6);
  public JoystickButton hatchPop = new JoystickButton(manipulatorController, 9);

  public OI() {
    hatchPop.whileHeld(new HatchPop());
    elevatorHome.whenPressed(new DriveElevatorHome());
    elevatorPos1.whenPressed(new DriveElevatorPositionOne());
    elevatorPos2.whenPressed(new DriveElevatorPositionTwo());
    hatchPush.whenPressed(new HatchPush());
    hatchRetract.whenPressed(new HatchRetract());
  }
}