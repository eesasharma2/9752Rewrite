package frc.robot.commands;

import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SetArmPositionCommand extends CommandBase {
  private final ArmSubsystem armSubsystem;
  private final double position;

  public SetArmPositionCommand(ArmSubsystem armSubsystem, double position) {
    this.armSubsystem = armSubsystem;
    this.position = position;
    addRequirements(armSubsystem);
  }

  @Override
  public void initialize() {
    armSubsystem.setPosition(position);
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
