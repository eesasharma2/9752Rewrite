package frc.robot;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.TransferCommand;

import frc.robot.commands.LimelightShotCommand;
import frc.robot.commands.OuttakeCommand;
import frc.robot.commands.ShootingCommand;
import frc.robot.commands.TransferCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TransferSubsystem;

public class RobotContainer {
  public IntakeSubsystem intake = new IntakeSubsystem();
  public TransferSubsystem transfer = new TransferSubsystem();
  public ShooterSubsystem shooter = new ShooterSubsystem();

  public CommandPS5Controller base = new CommandPS5Controller(0);

  private static final double AMP_POSITION = 2.0;
  private static final double CLIMB_POSITION = 3.0;

  public RobotContainer() {

    intake.setDefaultCommand(intake.intakeDefaultCommand());
    transfer.setDefaultCommand(transfer.defaultCommand());
    shooter.setDefaultCommand(shooter.defaultCommand());

    configureBindings();
  }

  private void configureBindings() {
    base.R2().whileTrue(new IntakeCommand(intake, transfer));
    base.R1().whileTrue((new TransferCommand(transfer, AMP_POSITION)));
    base.L1().whileTrue(new ShootingCommand(shooter, transfer));
  }



  public Command getAutonomousCommand(){
    return getAutonomousCommand();
  }
}
