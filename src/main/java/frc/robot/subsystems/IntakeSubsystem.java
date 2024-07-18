package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  private final TalonFX intakeMotor = new TalonFX(15, "static");

  public IntakeSubsystem() {
  }

  public void setIntake(double speed) {
    intakeMotor.set(speed);
  }

  @Override
  public void periodic() {
    // Called once per scheduler run
  }
}