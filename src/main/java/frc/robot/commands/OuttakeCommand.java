package frc.robot.commands;

import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.TransferSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class OuttakeCommand extends CommandBase {
  private final IntakeSubsystem intakeSubsystem;
  private final TransferSubsystem transferSubsystem;

  public OuttakeCommand(IntakeSubsystem intakeSubsystem, TransferSubsystem transferSubsystem) {
    this.intakeSubsystem = intakeSubsystem;
    this.transferSubsystem = transferSubsystem;
    addRequirements(intakeSubsystem, transferSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    intakeSubsystem.setIntake(-1.0);
    transferSubsystem.setTransfer(-1.0);
  }

  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.setIntake(0.0);
    transferSubsystem.stopTransfer();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
