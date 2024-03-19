package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;

public class IntakeSubsystem extends SubsystemBase {
    private final CANSparkMax positiveMotor;
    private final CANSparkMax negativeMotor;

    public IntakeSubsystem() {
        positiveMotor = new CANSparkMax(13, com.revrobotics.CANSparkLowLevel.MotorType.kBrushed);
        negativeMotor = new CANSparkMax(14, com.revrobotics.CANSparkLowLevel.MotorType.kBrushed);
    }

    public void intake(double speed) {   
        positiveMotor.set(speed);
        negativeMotor.set(-speed);
    }

    public void stop() {
        positiveMotor.set(0);
        negativeMotor.set(0);
    }
}