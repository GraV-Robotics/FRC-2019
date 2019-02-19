package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class HatchPop extends Command {
  /**
   * Add your docs here.
   */
  public HatchPop() {
    requires(Robot.hatch);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.hatch.setHatchPop(true);
  }

  @Override
  protected boolean isFinished() {
    return isCompleted();
  }

  @Override
  protected void end() {
    Robot.hatch.setHatchPop(false);
  }

}
