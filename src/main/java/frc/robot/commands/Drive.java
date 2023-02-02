// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Drive extends CommandBase {
 
  // Define basic objects for this command...
  public XboxController xbox;
  public Drivetrain drivetrain;

  // Assign basic objects and set requirements...
  public Drive(Drivetrain DrivetrainSubsystem, XboxController XboxController) {

    xbox = XboxController;
    drivetrain = DrivetrainSubsystem;
    
    addRequirements(drivetrain);
 
  }
 
  @Override
  // Code to run ONCE when the command starts
  public void initialize() {

  }
 
  @Override
  // Code to run continuely while the command is running
  public void execute() {

  // Use the xbox controller to power the robot...
  drivetrain.driveRobotTeleop(xbox.getLeftX(), xbox.getLeftY());

  }
 
  @Override
  // Code to run ONCE when the command ends
  public void end(boolean interrupted) {

  drivetrain.driveRobotAutonomous(false, 0);

  }
 
  @Override
  // Check for a custom end condition, if one is needed
  public boolean isFinished() {

    return false;

  }
}
