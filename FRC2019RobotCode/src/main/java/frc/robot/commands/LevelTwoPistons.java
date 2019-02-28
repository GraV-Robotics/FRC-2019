package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LevelTwoPistons extends Command {
  public LevelTwoPistons() {

  }

  @Override
  protected void initialize() {
    if (DriverStation.getInstance().getMatchTime() > 30) {
      interrupted();
    } else {
      System.out.println("Extending Level Two Pistons...");
    }
  }

  @Override
  protected void execute() {
    if (Robot.levelTwoClimb.getTankSolenoidState() == false) {
      Robot.levelTwoClimb.setTankSolenoidState(true);
    } else {
      Robot.levelTwoClimb.setPistonSolenoidState(true);
    }
  }

  @Override
  protected boolean isFinished() {
    return isCompleted();
  }

  @Override
  protected void end() {
    Robot.levelTwoClimb.setPistonSolenoidState(false);
  }

  @Override
  protected void interrupted() {
    DriverStation.getInstance().reportError("Tried To Extend Level Two Pistons before 30 seconds in match!", true);
  }
}
