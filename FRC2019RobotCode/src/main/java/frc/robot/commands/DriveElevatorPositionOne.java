package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveElevatorPositionOne extends Command {
  public DriveElevatorPositionOne() {
    requires(Robot.elevator);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.elevator.driveToPosition(50000);
  }

  @Override
  protected boolean isFinished() {
    return Robot.elevator.getMotionProfileStatus();
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}