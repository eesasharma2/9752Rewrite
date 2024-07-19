package frc.robot.commands;

import frc.robot.subsystems.TransferSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TransferCommand extends CommandBase {
  private final TransferSubsystem transferSubsystem;
  private final double speed;

  public TransferCommand(TransferSubsystem transferSubsystem, double speed) {
    this.transferSubsystem = transferSubsystem;
    this.speed = speed;
    addRequirements(transferSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    transferSubsystem.setTransfer(speed);
  }

  @Override
  public void end(boolean interrupted) {
    transferSubsystem.stopTransfer();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
