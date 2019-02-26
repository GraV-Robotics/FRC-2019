package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveWithController extends Command {
  public DriveWithController() {
    requires(Robot.driveTrain);
  }

  @Override
  protected void initialize() {
    Robot.driveTrain.driveBreaks(NeutralMode.Brake);
  }

  @Override
  protected void execute() {
    Robot.driveTrain.arcadeDrive(Robot.oi.driverController.getRawAxis(1), Robot.oi.driverController.getRawAxis(0), 1.0, 1.0);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.driveTrain.stopDrive();
  }

  @Override
  protected void interrupted() {
    Robot.driveTrain.stopDrive();
  }
}
