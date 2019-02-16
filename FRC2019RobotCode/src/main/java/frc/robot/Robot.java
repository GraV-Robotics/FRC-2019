package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.DriveElevatorManual;
import frc.robot.commands.ElevatorReset;
import frc.robot.commands.SmartDashboardOutput;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Hatch;

public class Robot extends TimedRobot {

  public static Elevator elevator;
  public static DriveTrain driveTrain;
  public static OI oi;
  public static Hatch hatch;
  public static SmartDashboardOutput dashboardOutput;
  public static ElevatorReset elevatorReset;
  public static DriveElevatorManual driveElevatorManual;

  @Override
  public void robotInit() {
    elevator = new Elevator();
    oi = new OI();
    driveTrain = new DriveTrain();
    hatch = new Hatch();
    dashboardOutput = new SmartDashboardOutput();
    driveElevatorManual = new DriveElevatorManual();
    UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture(0);
    camera1.setResolution(5, 1);
    camera1.setFPS(15);
    UsbCamera camera2 = CameraServer.getInstance().startAutomaticCapture(1);
    camera2.setResolution(5, 1);
    camera2.setFPS(15);
    CameraServer.getInstance().addAxisCamera("10.58.16.13");
    elevatorReset = new ElevatorReset();
  }

  @Override
  public void robotPeriodic() {
    dashboardOutput.start();
    elevatorReset.start();
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
    elevator.resetEncoder();
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {

  }

}