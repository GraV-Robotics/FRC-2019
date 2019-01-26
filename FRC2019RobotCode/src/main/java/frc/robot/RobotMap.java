/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
 public static int leftmotor1 = 0;
 public static int leftmotor2 = 1;
 public static int rightmotor1 = 2;
 public static int rightmotor2 = 3;
 public static int drivercontroller = 0;
 public static int manipulatorcontroller = 1;
 public static int elevatortalon = 1;
 public static int encoder = 0;
}