package frc.robot.commands;

import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TransferSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShootingCommand extends CommandBase {
  private final ShooterSubsystem shooterSubsystem;
  private final TransferSubsystem transferSubsystem;

  public ShootingCommand(ShooterSubsystem shooterSubsystem, TransferSubsystem transferSubsystem) {
    this.shooterSubsystem = shooterSubsystem;
    this.transferSubsystem = transferSubsystem;
    addRequirements(shooterSubsystem, transferSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    shooterSubsystem.setShooterSpeed(1.0);
    transferSubsystem.setTransfer(1.0);
  }

  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.setShooterSpeed(0.0);
    transferSubsystem.stopTransfer();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
