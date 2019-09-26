package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DriveElevatorPositionTwo extends Command {
  public DriveElevatorPositionTwo() {
    requires(Robot.elevator);
    // requires(Robot.hatch);
  }

  @Override
  protected void initialize() {
    Robot.elevator.setPreviousElevatorPosition(RobotMap.ELEVATOR_STATES[2]);
    Robot.elevator.setBrakeMode(true);
    Robot.elevator.setCurrentLimit(30,20);
    Robot.elevator.setPeakOutput(1.0);
    Robot.elevator.enableCurrentLimit(true);
  }

  @Override
  protected void execute() {
    // if (isSafeToMove()) {
      Robot.elevator.driveToPosition(RobotMap.elevatorPos2);
    // } else {
    //   Robot.hatch.setHatchPush(true);
    // }

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

  }