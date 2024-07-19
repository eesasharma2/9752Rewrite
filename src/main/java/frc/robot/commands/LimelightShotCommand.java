package frc.robot.commands;

import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TransferSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class LimelightShotCommand extends CommandBase {
  private final LimelightSubsystem limelightSubsystem;
  private final ShooterSubsystem shooterSubsystem;
  private final TransferSubsystem transferSubsystem;

  public LimelightShotCommand(LimelightSubsystem limelightSubsystem, ShooterSubsystem shooterSubsystem,
      TransferSubsystem transferSubsystem) {
    this.limelightSubsystem = limelightSubsystem;
    this.shooterSubsystem = shooterSubsystem;
    this.transferSubsystem = transferSubsystem;
    addRequirements(limelightSubsystem, shooterSubsystem, transferSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    double horizontalOffset = limelightSubsystem.getTargetOffsetAngleHorizontal();
    if (Math.abs(horizontalOffset) < 1.0) {
      shooterSubsystem.setShooterSpeed(1.0);
      transferSubsystem.setTransfer(1.0);
    } else {
      shooterSubsystem.stopShooter();
      transferSubsystem.stopTransfer();
    }
  }

  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.stopShooter();
    transferSubsystem.stopTransfer();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
