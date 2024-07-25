// package frc.robot.commands;

// import frc.robot.subsystems.IntakeSubsystem;
// import frc.robot.subsystems.ShooterSubsystem;
// import frc.robot.subsystems.TransferSubsystem;
// import edu.wpi.first.wpilibj2.command.CommandBase;

// public class AutonomousCommand extends CommandBase {
//   private final IntakeSubsystem intake;
//   private final ShooterSubsystem shooter;
//   private final TransferSubsystem transfer;

//   public AutonomousCommand(IntakeSubsystem intake, ShooterSubsystem shooter, TransferSubsystem transfer) {
//     this.intake = intake;
//     this.shooter = shooter;
//     this.transfer = transfer;
//     addRequirements(intake, shooter, transfer);
//   }

//   @Override
//   public void initialize() {
//   }

//   @Override
//   public void execute() {
//     intake.setIntake(1.0);
//     shooter.setShooterSpeed(3000);
//     transfer.setTransfer(0.5);
//   }

//   @Override
//   public void end(boolean interrupted) {
//     intake.setIntake(0);
//     shooter.stopShooter();
//     transfer.stopTransfer();
//   }

//   @Override
//   public boolean isFinished() {
//     return false;
//   }
// }