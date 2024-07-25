// package frc.robot.subsystems;

// import com.ctre.phoenix6.StatusCode;
// import com.ctre.phoenix6.configs.FeedbackConfigs;
// import com.ctre.phoenix6.configs.MotionMagicConfigs;
// import com.ctre.phoenix6.configs.Slot0Configs;
// import com.ctre.phoenix6.configs.TalonFXConfiguration;
// import com.ctre.phoenix6.controls.MotionMagicVoltage;
// import com.ctre.phoenix6.hardware.TalonFX;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;

// public class ArmSubsystem extends SubsystemBase {
//   private final TalonFX m_fx = new TalonFX(16, "static");
//   private final MotionMagicVoltage m_mmReq = new MotionMagicVoltage(0);

//   public ArmSubsystem() {
//     configureTalonFX();
//   }

//   private void configureTalonFX() {
//     TalonFXConfiguration cfg = new TalonFXConfiguration();

//     /* Configure gear ratio */
//     FeedbackConfigs fdb = cfg.Feedback;
//     fdb.SensorToMechanismRatio = 12.8;

//     /* Configure Motion Magic */
//     MotionMagicConfigs mm = cfg.MotionMagic;
//     mm.MotionMagicCruiseVelocity = 5;
//     mm.MotionMagicAcceleration = 10;
//     mm.MotionMagicJerk = 100;

//     Slot0Configs slot0 = cfg.Slot0;
//     slot0.kS = 0.25;
//     slot0.kV = 0.12;
//     slot0.kA = 0.01;
//     slot0.kP = 60;
//     slot0.kI = 0;
//     slot0.kD = 0.5;

//     StatusCode status = StatusCode.StatusCodeNotInitialized;
//     for (int i = 0; i < 5; ++i) {
//       status = m_fx.getConfigurator().apply(cfg);
//       if (status.isOK())
//         break;
//     }
//     if (!status.isOK()) {
//       System.out.println("Could not configure device. Error: " + status.toString());
//     }
//   }

//   public void setPosition(double position) {
//     m_fx.setControl(m_mmReq.withPosition(position).withSlot(0));
//   }

//   public void update() {
//     System.out.println("Pos: " + m_fx.getPosition());
//     System.out.println("Vel: " + m_fx.getVelocity());
//     System.out.println();
//   }
// }
