package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimelightSubsystem extends SubsystemBase {
  public LimelightSubsystem() {
  }

  public double getTargetOffsetAngleHorizontal() {
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
  }

  public double getTargetOffsetAngleVertical() {
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
  }

  public double getTargetArea() {
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);
  }

  public boolean isTargetVisible() {
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0) == 1;
  }

  @Override
  public void periodic() {
    // Called once per scheduler run
  }
}