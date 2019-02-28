package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class FillLevelTwoTanks extends Command {

  public FillLevelTwoTanks() {

  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.levelTwoClimb.setTankSolenoidState(false);
  }

  @Override
  protected boolean isFinished() {
    return isCompleted();
  }

  @Override
  protected void end() {
    Robot.levelTwoClimb.setTankSolenoidState(true);
  }

  @Override
  protected void interrupted() {
  }
}
