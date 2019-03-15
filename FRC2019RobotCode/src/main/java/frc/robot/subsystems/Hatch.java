package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Hatch extends Subsystem {
  
  private Compressor compressor;
  private Solenoid hatchPop;
  private Solenoid hatchPush;

  public boolean InteruptHatch = false;

  public Hatch(){
    compressor = new Compressor();
    compressor.start();
    hatchPop = new Solenoid(RobotMap.hatchPop);
    hatchPush = new Solenoid(RobotMap.hatchPush);
  } 

  public Boolean getHatchPushSolenoidState(){
    return hatchPush.get();
  }

  public Boolean getHatchPopSolenoidState(){
    return hatchPop.get();
  }

  public Boolean getInteruptHatch(){
    return InteruptHatch;
  }

  public void SetInteruptHatch(boolean state){
    InteruptHatch = state;
  }

  public void setHatchPop(boolean state) {
    hatchPop.set(state);
  }

  public void setHatchPush(boolean state) {
    hatchPush.set(state);
  }

  @Override
  public void initDefaultCommand() {
  }
}
