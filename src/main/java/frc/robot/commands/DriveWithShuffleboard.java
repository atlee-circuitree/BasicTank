package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveWithShuffleboard extends CommandBase {
 
  // Define basic objects for this command...
  public Drivetrain drivetrain;
  public boolean isTurning;
  public double speed;
  public double time;
  public Timer timer;

  // Assign basic objects and set requirements...
  public DriveWithShuffleboard(Drivetrain DrivetrainSubsystem) {

    drivetrain = DrivetrainSubsystem;

    addRequirements(drivetrain);
 
  }
 
  @Override
  // Code to run ONCE when the command starts
  public void initialize() {

    // Reset and start the timer...
    timer.reset();
    timer.start();
 
    // Get the values from Shuffleboard
    isTurning = SmartDashboard.getBoolean("Shuffle Auto - Is Turning?", false);
    speed = SmartDashboard.getNumber("Shuffle Auto - Speed", 0);
    time = SmartDashboard.getNumber("Shuffle Auto - Seconds", 0);

  }
 
  @Override
  // Code to run continuely while the command is running
  public void execute() {

    // Run the drive motor with given parameters...
    drivetrain.driveRobotAutonomous(isTurning, speed);


  }
 
  @Override
  // Code to run ONCE when the command ends
  public void end(boolean interrupted) {

    // Reset the timer and shut off all motors...
    timer.stop();
    timer.reset();
    drivetrain.driveRobotAutonomous(false, 0);

  }
 
  @Override
  // Check for a custom end condition, if one is needed
  public boolean isFinished() {

    //Check if the timer has passed the given time...
    if (timer.get() >= time) {

      return true;

    } else {

      return false;

    }

  }

}
