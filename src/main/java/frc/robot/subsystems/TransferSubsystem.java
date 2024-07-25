package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TransferSubsystem extends SubsystemBase {
  private final TalonFX transferMotor = new TalonFX(20, "rio");

  public TransferSubsystem() {
  }

  public void setTransfer(double speed) {
    transferMotor.set(speed);
  }

  public void stopTransfer() {
    transferMotor.set(0.0);
  }

  public Command defaultCommand() {
      return run( () -> {
        stopTransfer();
     });
  }

  @Override
  public void periodic() {
    // Called once per scheduler run
  }
}