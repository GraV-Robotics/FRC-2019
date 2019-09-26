package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class SmartDashboardOutput extends Command {
  public SmartDashboardOutput() {

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    elevatorOutput();
    hatchOutput();
    driveTrainOutput();
  }

  public void elevatorOutput() {
    SmartDashboard.putNumber("Current Draw", Robot.elevator.getCurrentDraw());
    SmartDashboard.putNumber("Encoder Value", Robot.elevator.getEncoderValue());
    SmartDashboard.putBoolean("Motion Status", Robot.elevator.getMotionProfileStatus());
  }

  public void hatchOutput() {
    SmartDashboard.putBoolean("Hatch Pop", Robot.hatch.getHatchPopSolenoidState());
  }

  public void driveTrainOutput() {
    SmartDashboard.putNumber("Gyro Angle", Robot.driveTrain.getGyroAngle());
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