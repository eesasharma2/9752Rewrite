package frc.robot;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.LimelightCommand;
import frc.robot.commands.LimelightShotCommand;
import frc.robot.commands.OuttakeCommand;
import frc.robot.commands.ShootingCommand;
import frc.robot.commands.TransferCommand;
import frc.robot.commands.SetArmPositionCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TransferSubsystem;

public class RobotContainer {
  private final ArmSubsystem m_armSubsystem = new ArmSubsystem();
  private final PS4Controller m_controller = new PS4Controller(0);
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final TransferSubsystem transferSubsystem = new TransferSubsystem();
  private final LimelightSubsystem limelightSubsystem = new LimelightSubsystem();
  private final AutonomousCommand autoCommand = new AutonomousCommand(intakeSubsystem, shooterSubsystem,
      transferSubsystem);

  private static final double AMP_POSITION = 2.0;
  private static final double CLIMB_POSITION = 3.0;

  public RobotContainer() {
    configureBindings();
    setDefaultCommands();
  }

  private void configureBindings() {
    new JoystickButton(m_controller, PS4Controller.Button.kCircle.value)
        .onTrue(new SetArmPositionCommand(m_armSubsystem, 1.0));

    new JoystickButton(m_controller, PS4Controller.Button.kCross.value)
        .onTrue(new SetArmPositionCommand(m_armSubsystem, 0.0));

    new JoystickButton(m_controller, PS4Controller.Button.kSquare.value)
        .whileTrue(new IntakeCommand(intakeSubsystem, transferSubsystem));

    new JoystickButton(m_controller, PS4Controller.Button.kTriangle.value)
        .whileTrue(new OuttakeCommand(intakeSubsystem, transferSubsystem));

    new JoystickButton(m_controller, PS4Controller.Button.kR1.value)
        .whileTrue(new LimelightShotCommand(limelightSubsystem, shooterSubsystem, transferSubsystem));

    new JoystickButton(m_controller, PS4Controller.Button.kL1.value)
        .whileTrue(new ShootingCommand(shooterSubsystem, transferSubsystem));

    new JoystickButton(m_controller, PS4Controller.Button.kOptions.value)
        .onTrue(new SetArmPositionCommand(m_armSubsystem, AMP_POSITION));

    new JoystickButton(m_controller, PS4Controller.Button.kShare.value)
        .onTrue(new SetArmPositionCommand(m_armSubsystem, CLIMB_POSITION));
  }

  private void setDefaultCommands() {
    intakeSubsystem.setDefaultCommand(new IntakeCommand(intakeSubsystem, transferSubsystem));
    transferSubsystem.setDefaultCommand(new TransferCommand(transferSubsystem, 0));
    shooterSubsystem.setDefaultCommand(new ShootingCommand(shooterSubsystem, transferSubsystem));
    limelightSubsystem.setDefaultCommand(new LimelightCommand(limelightSubsystem, shooterSubsystem));
  }

  public Command getAutonomousCommand() {
    return autoCommand;
  }

  public Command getTeleopCommand() {
    return new IntakeCommand(intakeSubsystem, transferSubsystem);
  }

  public void teleopPeriodic() {
    throw new UnsupportedOperationException("Unimplemented method 'teleopPeriodic'");
  }
}
