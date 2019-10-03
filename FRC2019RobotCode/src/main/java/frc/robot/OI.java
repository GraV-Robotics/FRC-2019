package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.DriveElevatorHome;
import frc.robot.commands.DriveElevatorPositionOne;
import frc.robot.commands.DriveElevatorPositionTwo;
import frc.robot.commands.HatchPop;
import frc.robot.commands.PlanCExtend;
import frc.robot.commands.PlanCRetract;

public class OI {

  public Joystick driverController = new Joystick(RobotMap.driverController);
  public Joystick manipulatorController = new Joystick(RobotMap.manipulatorController);
  // public JoystickButton elevatorHome = new JoystickButton(manipulatorController, 8);
  // public JoystickButton elevatorPos1 = new JoystickButton(manipulatorController, 5);
  // public JoystickButton elevatorPos2 = new JoystickButton(manipulatorController, 6);
  public JoystickButton hatchPop1 = new JoystickButton(manipulatorController, 9);
  public JoystickButton hatchPop2 = new JoystickButton(manipulatorController, 10);
  public JoystickButton humanPlayer = new JoystickButton(manipulatorController, 4);
  public JoystickButton planCExtend = new JoystickButton(driverController, 5);
  public JoystickButton planCRetract = new JoystickButton(driverController, 6);

  public OI() {
    hatchPop1.whileHeld(new HatchPop());
    hatchPop2.whileHeld(new HatchPop());
    // elevatorHome.whenPressed(new DriveElevatorHome());
    // elevatorPos1.whenPressed(new DriveElevatorPositionOne());
    // elevatorPos2.whenPressed(new DriveElevatorPositionTwo());
    planCExtend.whenPressed(new PlanCExtend());
    planCRetract.whenPressed(new PlanCRetract());
  }
}