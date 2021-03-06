
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithController;

public class DriveTrain extends Subsystem {

  private TalonSRX leftMotor1;
  private TalonSRX leftMotor2;
  private TalonSRX rightMotor1;
  private TalonSRX rightMotor2;
  private Gyro gyro;

  public DriveTrain(){
    leftMotor1 = new TalonSRX(RobotMap.leftDrive1);
    leftMotor2 = new TalonSRX(RobotMap.leftDrive2);
    rightMotor1 = new TalonSRX(RobotMap.rightDrive1);
    rightMotor2 = new TalonSRX(RobotMap.rightDrive2);
    gyro = new ADXRS450_Gyro();
    gyro.calibrate();
  }

  public void tankDrive(double left, double right, double speedModifier) {
    leftMotor1.set(ControlMode.PercentOutput, left * speedModifier);
    leftMotor2.set(ControlMode.PercentOutput, left * speedModifier);
    rightMotor1.set(ControlMode.PercentOutput, right * speedModifier);
    rightMotor2.set(ControlMode.PercentOutput, right * speedModifier);
  }

  public void arcadeDrive(double forward, double turn, double forwardSpeedModifier, double turningSpeedModifier) {
    leftMotor1.set(ControlMode.PercentOutput, -(forward - (turn) * turningSpeedModifier) * forwardSpeedModifier);
    leftMotor2.set(ControlMode.PercentOutput, -(forward - (turn) * turningSpeedModifier) * forwardSpeedModifier);
    rightMotor1.set(ControlMode.PercentOutput, (forward + (turn) * turningSpeedModifier) * forwardSpeedModifier);
    rightMotor2.set(ControlMode.PercentOutput, (forward + (turn) * turningSpeedModifier) * forwardSpeedModifier);
  }

  public void stopDrive() {
    leftMotor1.set(ControlMode.PercentOutput, 0);
    leftMotor2.set(ControlMode.PercentOutput, 0);
    rightMotor1.set(ControlMode.PercentOutput, 0);
    rightMotor2.set(ControlMode.PercentOutput, 0);
  }

  public void driveBreaks(NeutralMode mode) {
    leftMotor1.setNeutralMode(mode);
    leftMotor2.setNeutralMode(mode);
    rightMotor1.setNeutralMode(mode);
    rightMotor2.setNeutralMode(mode);
  }

  public void calibrateGyro() {
    gyro.calibrate();
  }

  public double getGyroRate() {
    return gyro.getRate();
  }

  public double getGyroAngle() {
    return gyro.getAngle();
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveWithController());
  }
}
