package frc.robot.subsystems;


import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.hardware.TalonFX;

public class ClimberSubsystem extends SubsystemBase {
    private final com.ctre.phoenix6.hardware.TalonFX  climberMotor;

    public ClimberSubsystem() {
         climberMotor = new TalonFX(17);
    }

    public void moveUp() {   
        climberMotor.set(0.8);
    }

    public void moveDown(double speed){
        climberMotor.set((0.3*-1));
    }

    public void stop(double Speed) {
        climberMotor.set(0);
    }

}