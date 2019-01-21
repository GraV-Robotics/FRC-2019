
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithController;

public class DriveTrain extends Subsystem {
  private VictorSPX leftmotor1;
  private VictorSPX leftmotor2;
  private VictorSPX rightmotor1;
  private VictorSPX rightmotor2;

  public DriveTrain(){
    leftmotor1 = new VictorSPX(RobotMap.leftmotor1);
    leftmotor2 = new VictorSPX(RobotMap.leftmotor2);
    rightmotor1 = new VictorSPX(RobotMap.rightmotor1);
    rightmotor2 = new VictorSPX(RobotMap.rightmotor2);
  }

  public void tankDrive(double left, double right) {
    leftmotor1.set(ControlMode.PercentOutput, left);
    leftmotor2.set(ControlMode.PercentOutput, left);
    rightmotor1.set(ControlMode.PercentOutput, right);
    rightmotor2.set(ControlMode.PercentOutput, right);
  }

  public void arcadeDrive(double forward, double turn) {
    leftmotor1.set(ControlMode.PercentOutput, (forward + turn) / 2);
    leftmotor2.set(ControlMode.PercentOutput, (forward + turn) / 2);
    rightmotor1.set(ControlMode.PercentOutput, (forward - turn) / 2);
    rightmotor2.set(ControlMode.PercentOutput, (forward - turn) / 2);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveWithController());
  }
}
