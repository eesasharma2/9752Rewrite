// package frc.robot.commands;

// import frc.robot.subsystems.LimelightSubsystem;
// import frc.robot.subsystems.ShooterSubsystem;
// import edu.wpi.first.wpilibj2.command.CommandBase;

// public class LimelightCommand extends CommandBase {
//   private final LimelightSubsystem limelightSubsystem;
//   private final ShooterSubsystem shooterSubsystem;

//   private static final double TARGET_ANGLE_THRESHOLD = 1.0;
//   private static final double ALIGN_SPEED = 0.5;

//   public LimelightCommand(LimelightSubsystem limelightSubsystem, ShooterSubsystem shooterSubsystem) {
//     this.limelightSubsystem = limelightSubsystem;
//     this.shooterSubsystem = shooterSubsystem;
//     addRequirements(limelightSubsystem, shooterSubsystem);
//   }

//   @Override
//   public void initialize() {
//   }

//   @Override
//   public void execute() {
//     if (limelightSubsystem.isTargetVisible()) {
//       double horizontalOffset = limelightSubsystem.getTargetOffsetAngleHorizontal();
//       double verticalOffset = limelightSubsystem.getTargetOffsetAngleVertical();

//       if (Math.abs(horizontalOffset) > TARGET_ANGLE_THRESHOLD) {
//         shooterSubsystem.adjustShooter(horizontalOffset * ALIGN_SPEED);
//       }

//       if (Math.abs(verticalOffset) > TARGET_ANGLE_THRESHOLD) {
//         shooterSubsystem.adjustShooterVertical(verticalOffset * ALIGN_SPEED);
//       }
//     }
//   }

//   @Override
//   public void end(boolean interrupted) {
//     shooterSubsystem.stopShooter();
//   }

//   @Override
//   public boolean isFinished() {
//     return !limelightSubsystem.isTargetVisible() ||
//         Math.abs(limelightSubsystem.getTargetOffsetAngleHorizontal()) < TARGET_ANGLE_THRESHOLD &&
//             Math.abs(limelightSubsystem.getTargetOffsetAngleVertical()) < TARGET_ANGLE_THRESHOLD;
//   }
// }
