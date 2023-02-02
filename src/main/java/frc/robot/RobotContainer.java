package frc.robot;
 
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Drive;
import frc.robot.commands.DriveWithShuffleboard;
import frc.robot.commands.DriveWithTimers;
import frc.robot.subsystems.Drivetrain;
 
public class RobotContainer {
  
  // Define any controllers used in the program...
  private final XboxController xbox1 = new XboxController(0);
 
  // Define our subsystems to assign to commands...
  private final Drivetrain drivetrain = new Drivetrain();

  // Define our commands to assign to buttons...
  private final Drive driveRobot = new Drive(drivetrain, xbox1);
  
  // Create an autonomous selector on the Shuffleboard...
  SendableChooser<Command> autoSelecter = new SendableChooser<Command>();

  // Inital robot set-up...
  public RobotContainer() {

    // Add autonomous options...
    autoSelecter.setDefaultOption("Nothing", null);
    autoSelecter.addOption("Drive Forward", 
    new DriveWithTimers(drivetrain, false, .3, 5));
    autoSelecter.addOption("Turn Left", 
    new DriveWithTimers(drivetrain, true, .3, 5));

    // Sequential command groups are how you run commands in a row for autonomous
    // You can add a timeout if your command does not have an end condition (ours does, but I added one as an example)
    autoSelecter.addOption("Drive Forward & Turn Left", 
    new SequentialCommandGroup(
    new DriveWithTimers(drivetrain, false, .3, 5).withTimeout(8),
    new DriveWithTimers(drivetrain, true, .3, 5))
    );

    // Uses the variables set in your Shuffleboard
    // This is a way to test different values without editing code
    autoSelecter.addOption("Shuffleboard Auto",
    new DriveWithShuffleboard(drivetrain));

    // Binds commands to buttons...
    configureBindings();

    // Set default commands...
    // Default commands are commands that always run in tele-op
    drivetrain.setDefaultCommand(driveRobot);

  }
 
  private void configureBindings() {

    // Create new buttons and assign them to commands...
    JoystickButton Controller1_A = new JoystickButton(xbox1, XboxController.Button.kA.value);
    JoystickButton Controller1_B = new JoystickButton(xbox1, XboxController.Button.kB.value);

    Controller1_A.onTrue(null); 
    Controller1_B.onTrue(null);
 
  }
 
  // Gets the command you want to run for your autonomous
  public Command getAutonomousCommand() {

    // Returns the selected option...
    return autoSelecter.getSelected();

  }
}
