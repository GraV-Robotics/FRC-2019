package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class PlanC extends Subsystem {

  public Solenoid PlanCSolenoid;

  public PlanC(){
    PlanCSolenoid = new Solenoid(RobotMap.PlanC);
  } 

  public boolean getPlanCState() {
    return PlanCSolenoid.get();
  }

  public void setPlanCSolenoidState(boolean state) {
    PlanCSolenoid.set(state);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
