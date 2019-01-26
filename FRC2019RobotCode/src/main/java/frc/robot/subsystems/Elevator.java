package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Elevator extends Subsystem {

  private TalonSRX elevatorTalon;

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
    elevatorTalon.configMotionCruiseVelocity(25000, RobotMap.kTimeoutMs);
    elevatorTalon.configMotionAcceleration(10000, RobotMap.kTimeoutMs);
    elevatorTalon.setSelectedSensorPosition(0, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);
  }

  public void driveToPosition(int encoderCount) {
    double targetPos = encoderCount;
    elevatorTalon.set(ControlMode.MotionMagic, targetPos);
  }

  public boolean setpointReached() {
    return elevatorTalon.isMotionProfileFinished();
  }

  @Override
  public void initDefaultCommand() {
    
  }

}