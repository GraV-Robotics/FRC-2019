package frc.robot;

public class RobotMap {
 public static final int leftDrive1 = 1;
 public static final int leftDrive2 = 4;
 public static final int rightDrive1 = 5;
 public static final int rightDrive2 = 6;
 public static final int driverController = 0;
 public static final int manipulatorController = 1;
 public static final int elevatorMotor = 0;
 public static final int kSlotIdx = 0;
 public static final int kPIDLoopIdx = 0;
 public static final int kTimeoutMs = 30;
 public static final double kF = 0.2;
 public static final double kP = 0.1;
 public static final double kI = 0.0;
 public static final double kD = 0.0;
 public static final int kIzone = 0;
 public static final double kPeakOutput = 1.0;
 public static final int elevatorHomePos = 0;
 public static final int elevatorPos1 = 32000;
 public static final int elevatorPos2 = 61000;
 public static final int hatchPush = 0;
 public static final int hatchPop = 1;
 public static final String ELEVATOR_STATES[] = {"HOME", "POS1", "POS2"};
}