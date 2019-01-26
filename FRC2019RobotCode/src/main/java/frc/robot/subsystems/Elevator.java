package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ElevatorControl;

/**
 * Add your docs here.
 */
public class Elevator extends Subsystem {
  private TalonSRX ElevatorTalon1;

  public Elevator(){
    ElevatorTalon1 = new TalonSRX(RobotMap.elevatortalon);
  }

  public void elevatorControl(double up){
    ElevatorTalon1.set(ControlMode.PercentOutput, up);
  }


  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ElevatorControl());
  }

}

