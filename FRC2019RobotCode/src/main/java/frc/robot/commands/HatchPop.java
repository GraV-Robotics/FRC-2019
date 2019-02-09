package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class HatchPop extends InstantCommand {
  /**
   * Add your docs here.
   */
  public HatchPop() {
    super();
    requires(Robot.hatch);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    Robot.hatch.setHatchPop(true);
    Timer.delay(.1);
    Robot.hatch.setHatchPop(false);
  }

}
