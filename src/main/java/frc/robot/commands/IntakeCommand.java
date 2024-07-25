package frc.robot.commands;

import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.TransferSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeCommand extends CommandBase {
  IntakeSubsystem intake;
  TransferSubsystem transfer;

  public IntakeCommand(IntakeSubsystem i, TransferSubsystem t) {
    intake = i;
    transfer = t;
    addRequirements(intake, transfer);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    intake.setIntake(1);
    transfer.setTransfer(1);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
