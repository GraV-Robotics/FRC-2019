package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Hatch extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  private Compressor compressor;
  private Solenoid hatchPop;
  private Solenoid hatchPush;

  public Hatch(){
    compressor = new Compressor();
    compressor.start();
    hatchPop = new Solenoid(RobotMap.hatchPop);
    hatchPush = new Solenoid(RobotMap.hatchPush);
  } 

  public void setHatchPop(boolean state) {
    hatchPop.set(state);
  }

  public void setHatchPush(boolean state) {
    hatchPush.set(state);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
