package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.SparkPIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.RelativeEncoder;

import java.util.function.BooleanSupplier;
import edu.wpi.first.math.controller.BangBangController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.Servo;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.SparkPIDController;

public class ShooterSubsystem extends SubsystemBase {
  private final CANSparkMax leftShooterMotor = new CANSparkMax(0, CANSparkMax.MotorType.kBrushless); // Left motor CAN
                                                                                                     // ID
  private final CANSparkMax rightShooterMotor = new CANSparkMax(1, CANSparkMax.MotorType.kBrushless); // Right motor CAN
                                                                                                      // ID

  private final SparkPIDController leftPIDController = leftShooterMotor.getPIDController();
  private final SparkPIDController rightPIDController = rightShooterMotor.getPIDController();

  public ShooterSubsystem() {
    configurePIDController(leftPIDController);
    configurePIDController(rightPIDController);
  }

  private void configurePIDController(SparkPIDController pidController) {
    pidController.setP(0.1); // Example P value
    pidController.setI(0.0); // Example I value
    pidController.setD(0.0); // Example D value
    // Configure other PID settings as needed
  }

  public void setShooterSpeed(double targetRPM) {
    leftPIDController.setReference(targetRPM, ControlType.kVelocity);
    rightPIDController.setReference(targetRPM, ControlType.kVelocity);
  }

  public void stopShooter() {
    leftShooterMotor.set(0.0);
    rightShooterMotor.set(0.0);
  }

  @Override
  public void periodic() {
    // Called once per scheduler run
  }
}
