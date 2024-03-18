package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;

public class ShooterSubsystem extends SubsystemBase {
    private final CANSparkMax positiveMotor;
    private final CANSparkMax negativeMotor;

    public ShooterSubsystem() {
        positiveMotor = new CANSparkMax(15, com.revrobotics.CANSparkLowLevel.MotorType.kBrushed);
        negativeMotor = new CANSparkMax(16, com.revrobotics.CANSparkLowLevel.MotorType.kBrushed);
    }

    public void shoot(double speed) {   
        positiveMotor.set(speed);
        negativeMotor.set(-speed);
    }

    public void stop() {
        positiveMotor.set(0);
        negativeMotor.set(0);
    }
}