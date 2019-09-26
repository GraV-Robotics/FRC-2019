package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveElevatorManual extends Command {
  public DriveElevatorManual() {
    requires(Robot.elevator);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.elevator.setBrakeMode(true);
    Robot.elevator.setCurrentLimit(25,20);
    Robot.elevator.enableCurrentLimit(true);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.elevator.driveElevator(((-Robot.oi.manipulatorController.getRawAxis(2)) * 0.50) + ((Robot.oi.manipulatorController.getRawAxis(3)) * 0.50));
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
