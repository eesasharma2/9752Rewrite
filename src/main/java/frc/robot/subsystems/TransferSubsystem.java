package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TransferSubsystem extends SubsystemBase {
  private final TalonFX transferMotor = new TalonFX(16, "static");

  public TransferSubsystem() {
  }

  public void setTransfer(double speed) {
    transferMotor.set(speed);
  }

  public void stopTransfer() {
    transferMotor.set(0.0);
  }

  @Override
  public void periodic() {
    // Called once per scheduler run
  }
}