package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

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
    return Robot.hatch.getHatchPushSolenoidState();
  }

  @Override
  protected void end() {

  }

  @Override
  protected void interrupted() {
  }
}
