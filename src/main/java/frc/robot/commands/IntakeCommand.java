package frc.robot.commands;

import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeCommand extends CommandBase {
  private final IntakeSubsystem intakeSubsystem;

  public IntakeCommand(IntakeSubsystem intakeSubsystem) {
    this.intakeSubsystem = intakeSubsystem;
    addRequirements(intakeSubsystem);
  }

  @Override
  public void initialize() {
    // Initialization code
  }

  @Override
  public void execute() {
    intakeSubsystem.setIntake(1.0); // Example speed
  }

  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.setIntake(0.0);
  }

  @Override
  public boolean isFinished() {
    return false; // Adjust based on your needs
  }
}