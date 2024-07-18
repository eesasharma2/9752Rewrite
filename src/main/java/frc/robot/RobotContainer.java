package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TransferSubsystem;

public class RobotContainer {
  private final ArmSubsystem m_armSubsystem = new ArmSubsystem();
  private final XboxController m_joystick = new XboxController(0);
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final TransferSubsystem transferSubsystem = new TransferSubsystem();
  private final LimelightSubsystem limelightSubsystem = new LimelightSubsystem();
  private final AutonomousCommand autoCommand = new AutonomousCommand(intakeSubsystem, shooterSubsystem,
      transferSubsystem);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    var setArmPosition1 = Commands.run(() -> m_armSubsystem.setPosition(1.0));
    var setArmPosition0 = Commands.run(() -> m_armSubsystem.setPosition(0.0));

    new JoystickButton(m_joystick, XboxController.Button.kB.value)
        .onTrue(setArmPosition1);

    new JoystickButton(m_joystick, XboxController.Button.kA.value)
        .onTrue(setArmPosition0);
  }

  public Command getAutonomousCommand() {
    return autoCommand;
  }

  public Command getTeleopCommand() {
    return new IntakeCommand(intakeSubsystem);
  }

  public void teleopPeriodic() {
    throw new UnsupportedOperationException("Unimplemented method 'teleopPeriodic'");
  }
}
