package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.SparkPIDController;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  private final CANSparkFlex leftShooterMotor = new CANSparkFlex(20, CANSparkFlex.MotorType.kBrushless); // Left motor CAN
  private final CANSparkFlex rightShooterMotor = new CANSparkFlex(21, CANSparkFlex.MotorType.kBrushless); // Right motor CAN

  private final SparkPIDController leftPIDController = leftShooterMotor.getPIDController();
  private final SparkPIDController rightPIDController = rightShooterMotor.getPIDController();

  public ShooterSubsystem() {
    rightShooterMotor.restoreFactoryDefaults();
    leftShooterMotor.restoreFactoryDefaults();

    leftShooterMotor.setInverted(true);

    leftPIDController.setFF(0.002);
    leftPIDController.setP(0.002); // Example P value
    leftPIDController.setI(0.0); // Example I value
    leftPIDController.setD(0.001); // Example D value

    rightPIDController.setFF(0.002);
    rightPIDController.setP(0.002); // Example P value
    rightPIDController.setI(0.0); // Example I value
    rightPIDController.setD(0.001); // Example D value
    // Configure other PID settings as needed

    rightShooterMotor.burnFlash();
    leftShooterMotor.burnFlash();
  }

  public void setShooterSpeed(double targetRPM) {
    leftPIDController.setReference(targetRPM, ControlType.kVelocity);
    rightPIDController.setReference(targetRPM, ControlType.kVelocity);
  }

  public void stopShooter() {
    leftShooterMotor.set(0.0);
    rightShooterMotor.set(0.0);
  }

  public Command defaultCommand() {
      return run( () -> {
        stopShooter();
     });
  }

  @Override
  public void periodic() {
    // Called once per scheduler run
  }

// public void adjustShooter(double d) {
//     // TODO Auto-generated method stub
//     throw new UnsupportedOperationException("Unimplemented method 'adjustShooter'");
// }

// public void adjustShooterVertical(double d) {
//     // TODO Auto-generated method stub
//     throw new UnsupportedOperationException("Unimplemented method 'adjustShooterVertical'");
// }
}
