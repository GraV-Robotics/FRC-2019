package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class HatchPush extends Command {
  public HatchPush() {
    requires(Robot.hatch);
  }
  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.hatch.setHatchPush(true);
  }
  @Override
  protected boolean isFinished() {
    return isCompleted();
  }

  @Override
  protected void end() {
    if (Robot.elevator.getPreviousElevatorPosition() == RobotMap.ELEVATOR_STATES[0]) {
      Robot.hatch.setHatchPush(false);
    } else {
      interrupted();
    }
  }

  @Override
  protected void interrupted() {
    DriverStation.getInstance().reportError("Tried to retract hatch mechanism while elevator was not at home position, or command was canceled.", true);
  }
}
