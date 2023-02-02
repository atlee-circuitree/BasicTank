package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  
  // Create our motors and other objects...
  CANSparkMax frontLeftMotor;
  CANSparkMax frontRightMotor;
  CANSparkMax rearLeftMotor;
  CANSparkMax rearRightMotor;

  DifferentialDrive robotDrive;

  // Variables for Shuffleboard autonomous control...
  public boolean isTurningShuffle;
  public double speedShuffle;
  public int secondsShuffle;

  public Drivetrain() {

    // Assign our objects to ports...
    frontLeftMotor = new CANSparkMax(Constants.frontLeftDrivePort, MotorType.kBrushless);
    frontRightMotor = new CANSparkMax(Constants.frontRightDrivePort, MotorType.kBrushless);
    rearLeftMotor = new CANSparkMax(Constants.rearLeftDrivePort, MotorType.kBrushless);
    rearRightMotor = new CANSparkMax(Constants.rearRightDrivePort, MotorType.kBrushless);

    // Set the right side inverted...
    frontLeftMotor.setInverted(false);
    frontRightMotor.setInverted(true);
    rearLeftMotor.setInverted(false);
    rearRightMotor.setInverted(true);

    // Set the drive motors to brake mode...
    frontLeftMotor.setIdleMode(IdleMode.kBrake);
    frontRightMotor.setIdleMode(IdleMode.kBrake);
    rearLeftMotor.setIdleMode(IdleMode.kBrake);
    rearRightMotor.setIdleMode(IdleMode.kBrake);

  }

  @Override
  public void periodic() {

    // Here we can update functions and variables periodiclly

    // Send and recieve values using Shuffleboard...
    SmartDashboard.putBoolean("Shuffle Auto - Is Turning?", isTurningShuffle);
    SmartDashboard.putNumber("Shuffle Auto - Speed", speedShuffle);
    SmartDashboard.putNumber("Shuffle Auto - Seconds", secondsShuffle);
    
  }

  // Here is where we can create functions to use in commands

  // Creating a function to drive the drivetrain in teleop...
  public void driveRobotTeleop(double x, double y) {

    robotDrive.arcadeDrive(x, y, true);

  }

  // Creating a function to drive the drivetrain in autonoumus...
  public void driveRobotAutonomous(boolean IsTurning, double power) {

    if (IsTurning = true) {

      frontLeftMotor.set(power);
      frontRightMotor.set(-power);
      rearLeftMotor.set(power);
      rearRightMotor.set(-power);

    } else {

      frontLeftMotor.set(power);
      frontRightMotor.set(power);
      rearLeftMotor.set(power);
      rearRightMotor.set(power);

    }

  }

}
