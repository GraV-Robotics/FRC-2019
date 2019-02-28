package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DriveElevatorHome extends Command {
  public DriveElevatorHome() {
    requires(Robot.elevator);
    requires(Robot.hatch);
  }

  @Override
  protected void initialize() {
    Robot.elevator.setPreviousElevatorPosition(RobotMap.ELEVATOR_STATES[0]);
    Robot.elevator.setBrakeMode(true);
    Robot.elevator.setCurrentLimit(10);
    Robot.elevator.setPeakOutput(0.65);
    Robot.elevator.enableCurrentLimit(true);
  }

  @Override
  protected void execute() {
    if (isSafeToMove()) {
      Robot.elevator.driveToPosition(RobotMap.elevatorHomePos);
    } else {
      Robot.hatch.setHatchPush(true);
    }
  }

  @Override
  protected boolean isFinished() {
    return isCompleted();
  }

  @Override
  protected void end() {
    
  }

  @Override
  protected void interrupted() {
  }

  public boolean isSafeToMove() {
    return Robot.hatch.getHatchPushSolenoidState();
  }
}