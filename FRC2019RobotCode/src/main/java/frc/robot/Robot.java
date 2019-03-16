package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.DriveElevatorManual;
import frc.robot.commands.SmartDashboardOutput;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Hatch;
import frc.robot.subsystems.PlanC;


public class Robot extends TimedRobot {

  public static Elevator elevator;
  public static DriveTrain driveTrain;
  public static OI oi;
  public static Hatch hatch;
 public static SmartDashboardOutput dashboardOutput;
  public static boolean manualElevatorControlState;
  public static DriveElevatorManual driveElevatorManual;
  public static PlanC planC;

  @Override
  public void robotInit() {
    elevator = new Elevator();
    hatch = new Hatch();
    oi = new OI();
    driveTrain = new DriveTrain();
    driveElevatorManual = new DriveElevatorManual();
    // dashboardOutput = new SmartDashboardOutput();
    UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture(0);
    camera1.setResolution(5, 1);
    camera1.setFPS(15);
    elevatorOutput();
    hatchOutput();
    driveTrainOutput();
    matchData();
    planC = new PlanC();
  }

  @Override
  public void robotPeriodic() {
    manualElevatorDriveControl();
    elevatorOutput();
    hatchOutput();
    driveTrainOutput();
    matchData();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {

  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {

  }

  public void elevatorOutput() {
    SmartDashboard.putNumber("Current Draw", Robot.elevator.getCurrentDraw());
    SmartDashboard.putNumber("Encoder Value", Robot.elevator.getEncoderValue());
    SmartDashboard.putBoolean("Motion Status", Robot.elevator.getMotionProfileStatus());
  }

  public void hatchOutput() {
    SmartDashboard.putBoolean("Hatch Push", Robot.hatch.getHatchPushSolenoidState());
    SmartDashboard.putBoolean("Hatch Pop", Robot.hatch.getHatchPopSolenoidState());
  }

  public void driveTrainOutput() {
    SmartDashboard.putNumber("Gyro Angle", Robot.driveTrain.getGyroAngle());
  }

  public void matchData() {
    SmartDashboard.putNumber("Time Remaining", DriverStation.getInstance().getMatchTime());
  }

  public void manualElevatorDriveControl() {
    manualElevatorControlState = SmartDashboard.getBoolean("Manual Elevator Control", false);
  }

}