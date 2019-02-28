package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class LevelTwoClimb extends Subsystem {

  Solenoid tankSolenoid;
  Solenoid pistonSolenoid;

  public LevelTwoClimb() {
    tankSolenoid = new Solenoid(RobotMap.levelTwoTank);
    pistonSolenoid = new Solenoid(RobotMap.levelTwoPiston);
  }

  public void setTankSolenoidState(boolean state) {
    tankSolenoid.set(state);
  }

  public void setPistonSolenoidState(boolean state) {
    pistonSolenoid.set(state);
  }

  public boolean getTankSolenoidState() {
    return tankSolenoid.get();
  }

  public boolean getPistonSolenoidState() {
    return pistonSolenoid.get();
  }

  @Override
  public void initDefaultCommand() {

  }
}
