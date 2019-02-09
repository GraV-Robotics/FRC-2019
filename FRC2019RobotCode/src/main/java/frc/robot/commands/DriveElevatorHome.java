package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveElevatorHome extends Command {
  public DriveElevatorHome() {
    requires(Robot.elevator);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.elevator.driveToPosition(10000);
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