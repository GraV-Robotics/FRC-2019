package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveElevatorHome;
import frc.robot.commands.DriveElevatorManual;

public class Elevator extends Subsystem {

  private TalonSRX elevatorTalon;
  private String previousElevatorPosition;

  public Elevator(){
    elevatorTalon = new TalonSRX(RobotMap.elevatorMotor);
    elevatorTalon.configFactoryDefault();
    elevatorTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);
    elevatorTalon.setSensorPhase(true);
    elevatorTalon.setInverted(false);
    elevatorTalon.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, RobotMap.kTimeoutMs);
    elevatorTalon.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, RobotMap.kTimeoutMs);
    elevatorTalon.configNominalOutputForward(0, RobotMap.kTimeoutMs);
    elevatorTalon.configNominalOutputReverse(0, RobotMap.kTimeoutMs);
    elevatorTalon.configPeakOutputForward(1, RobotMap.kTimeoutMs);
    elevatorTalon.configPeakOutputReverse(-1, RobotMap.kTimeoutMs);
    elevatorTalon.selectProfileSlot(RobotMap.kSlotIdx, RobotMap.kPIDLoopIdx);
    elevatorTalon.config_kP(RobotMap.kSlotIdx, RobotMap.kP, RobotMap.kTimeoutMs);
    elevatorTalon.config_kI(RobotMap.kSlotIdx, RobotMap.kI, RobotMap.kTimeoutMs);
    elevatorTalon.config_kD(RobotMap.kSlotIdx, RobotMap.kD, RobotMap.kTimeoutMs);
    elevatorTalon.config_kF(RobotMap.kSlotIdx, RobotMap.kF, RobotMap.kTimeoutMs);
    elevatorTalon.configMotionCruiseVelocity(20000, RobotMap.kTimeoutMs);
    elevatorTalon.configMotionAcceleration(30000, RobotMap.kTimeoutMs);
    elevatorTalon.setSelectedSensorPosition(0, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);
  }

  public void setBrakeMode(boolean state) {
    if (state) {
      elevatorTalon.setNeutralMode(NeutralMode.Brake);
    } else {
      elevatorTalon.setNeutralMode(NeutralMode.Coast);
    }
  }

  public void setPeakOutput(double value) {
    elevatorTalon.configPeakOutputForward(value, RobotMap.kTimeoutMs);
    elevatorTalon.configPeakOutputReverse(-value, RobotMap.kTimeoutMs);
  }

  public void setCurrentLimit(int limit, int timeMs) {
    elevatorTalon.configContinuousCurrentLimit(limit, timeMs);
  }

  public double getCurrentDraw(){
    return elevatorTalon.getOutputCurrent();
  }

  public void enableCurrentLimit(boolean state) {
    elevatorTalon.enableCurrentLimit(state);
  }

  public Boolean getMotionProfileStatus(){
    return elevatorTalon.isMotionProfileFinished();
  }

  public void driveElevator(double percent){
    elevatorTalon.set(ControlMode.PercentOutput, Math.abs(percent));
  }

  public double getEncoderValue(){
    return elevatorTalon.getSelectedSensorPosition();
  }

  public void resetEncoder() {
    elevatorTalon.setSelectedSensorPosition(0);
  }

  public void driveToPosition(int encoderCount) {
    elevatorTalon.set(ControlMode.MotionMagic, encoderCount);
  }

  public void setPreviousElevatorPosition(String string) {
    previousElevatorPosition = string;
  }

  public String getPreviousElevatorPosition() {
    return previousElevatorPosition;
  }

  @Override
  public void initDefaultCommand() {
    // setDefaultCommand(new DriveElevatorHome());
    setDefaultCommand(new DriveElevatorManual());
  }

}