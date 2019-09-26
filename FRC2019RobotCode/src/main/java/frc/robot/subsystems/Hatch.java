package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Hatch extends Subsystem {
  
  private Compressor compressor;
  private Solenoid hatchPop;

  public boolean InteruptHatch = false;

  public Hatch(){
    compressor = new Compressor();
    compressor.start();
    hatchPop = new Solenoid(RobotMap.hatchPop);
  }

  public Boolean getHatchPopSolenoidState(){
    return hatchPop.get();
  }


  public void setHatchPop(boolean state) {
    hatchPop.set(state);
  }



  @Override
  public void initDefaultCommand() {
  }
}
